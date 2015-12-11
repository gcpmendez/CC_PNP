package SAT;

public class Literals {
	private String literal;
	private boolean negado;
	
	
	
	
	
	public String toString () {
		String str = "";
		if ( this.negado == true ) {
			str += "¬" + literal;
		} else {
			str += literal;
		}
		return str;
	}
}
