package sat;

import java.util.ArrayList;

public class Clause {
	private ArrayList<Literal> literalsSet;
	
	/** CONSTRUCTOR */
	public Clause() {
		this.literalsSet = new ArrayList<Literal>();
	}
	
	/** METHODS */
	@Override
	public String toString () {
		String str = "{";
		String delim = "";
		for (Literal i: literalsSet) {
			str += delim + i.toString();
		    delim = ",";
		}
		return (str + "}");
	}
	
	/** GETTERS and SETTERS */
	public ArrayList<Literal> getLiteralsSet() {
		return literalsSet;
	}

	public void setLiteralsSet(ArrayList<Literal> literalsSet) {
		this.literalsSet = literalsSet;
	}
	

}
