package sat;

import java.util.ArrayList;

public class Clause {
	private ArrayList<Literals> literalsSet;
	
	/** METHODS */
	public String toString () {
		String str = "(";
		for (int i = 0; i < literalsSet.size() -1; i++) {
			str += literalsSet.get(i).toString() + " v ";
		}
		str += literalsSet.get(literalsSet.size()).toString() + ")";
		return str;
	}
	
	/** GETTERS and SETTERS */
	public ArrayList<Literals> getLiteralsSet() {
		return literalsSet;
	}

	public void setLiteralsSet(ArrayList<Literals> literalsSet) {
		this.literalsSet = literalsSet;
	}
	

}
