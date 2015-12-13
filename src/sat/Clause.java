package sat;

import java.util.ArrayList;

public class Clause {
	private ArrayList<Literal> literalsSet;
	
	/** CONSTRUCTOR */
	public Clause() {
		this.literalsSet = new ArrayList<Literal>();
	}
	
	/** METHODS */
	public String toString () {
		String str = "{";
		for (int i = 0; i < literalsSet.size(); i++) {
			str += literalsSet.get(i).toString();
			if (i != this.literalsSet.size()-1) { str += ", "; }
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
