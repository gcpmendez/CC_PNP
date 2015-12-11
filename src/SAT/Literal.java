package SAT;

public class Literal {
	private String name;
	private boolean negated;
	
	
	public String toString () {
		String str = "";
		if ( this.negated == true ) {
			str += "�" + name;
		} else {
			str += name;
		}
		return str;
	}
}
