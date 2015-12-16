package transform;

import java.util.Iterator;
import objects.Clause;
import objects.Instance3SAT;
import objects.InstanceSAT;
import objects.Literal;

public abstract class To3SAT {

	public static Instance3SAT to3SAT(InstanceSAT SAT) {
		Instance3SAT sat3 = new Instance3SAT(SAT.getLiterals());
		int maxVar = SAT.getLiterals().size();

		// Para el conjunto de clausulas de SAT
		for (Clause i : SAT.getClauses()) {
			Clause clause = i;
			// n = literals
			int n = clause.getLiterals().size();

			// Para el conjunto de literales de esa clausula
			switch (n) {

			case 3:
				// {x1 x2 x3} => {x1 x2 x3}
				sat3.addClause(clause);
				break;

			case 2:
				// {x1 x2} => {x1 x2 v1} {x1 x2 -v1}
				int fresh = ++maxVar;
				addClausePlus(sat3, clause, "v" + fresh);
				addClausePlus(sat3, clause, "!v" + fresh);
				sat3.toString();
				break;

			case 1:
				// {x} => {x v1 v2} {x -v1 v2} {x v1 -v2} {x -v1 -v2}
				int fresh1 = ++maxVar;
				int fresh2 = ++maxVar;
				addClausePlus(sat3, clause, "v" + fresh1, "v" + fresh2);
				addClausePlus(sat3, clause, "!v" + fresh1, "v" + fresh2);
				addClausePlus(sat3, clause, "v" + fresh1, "!v" + fresh2);
				addClausePlus(sat3, clause, "!v" + fresh1, "!v" + fresh2);
				break;

			default:
				// {x1 ... xn}, n > 3 =>
				// {x1 x2 v1} {-v1, v2 x3} {-v2, v3, x4} ... {-vn-4 vn-3 xn-2}
				// {-vn-3 xn-1 xn}
				Iterator<Literal> j = clause.getLiterals().iterator();
				//
				// // add the first clause
				Clause currClause = new Clause();
				currClause.addLiteral((Literal) j.next());
				currClause.addLiteral((Literal) j.next());
				Literal copyLiteral;
				copyLiteral = new Literal("v" + ++maxVar, false);
				currClause.addLiteral(copyLiteral);
				sat3.addClause(currClause);

				// add n-4 middle clauses
				for (int k = 0; k < n - 4; k++) {
					currClause = new Clause();
					copyLiteral = new Literal("v" + maxVar, true);
					currClause.addLiteral(copyLiteral);
					copyLiteral = new Literal("v" + ++maxVar, false);
					currClause.addLiteral(copyLiteral);
					currClause.addLiteral((Literal) j.next());
					sat3.addClause(currClause);
				}

				// add the last clause
				currClause = new Clause();
				copyLiteral = new Literal("v" + maxVar, true);
				currClause.addLiteral(copyLiteral);
				currClause.addLiteral((Literal) j.next());
				currClause.addLiteral((Literal) j.next());
				sat3.addClause(currClause);
				break;
			}
		}

		assert maxVar == sat3.numVariables();
		return sat3;
	}

	private static void addClausePlus(Instance3SAT SAT3, Clause clause, String lit) {
		Clause copy = new Clause(clause);
		Literal copyLiteral;
		if (lit.contains("!")) {
			copyLiteral = new Literal(lit.substring(1), true);
		} else {
			copyLiteral = new Literal(lit, false);
		}
		copy.addLiteral(copyLiteral);
		SAT3.addClause(copy);
	}

	private static void addClausePlus(Instance3SAT SAT3, Clause clause, String lit, String lit2) {
		Clause copy = new Clause(clause);
		Literal copyLiteral;

		if (lit.contains("!")) {
			copyLiteral = new Literal(lit.substring(1), true);
		} else {
			copyLiteral = new Literal(lit, false);
		}
		copy.addLiteral(copyLiteral);

		if (lit2.contains("!")) {
			copyLiteral = new Literal(lit2.substring(1), true);
		} else {
			copyLiteral = new Literal(lit2, false);
		}
		copy.addLiteral(copyLiteral);

		SAT3.addClause(copy);
	}

}