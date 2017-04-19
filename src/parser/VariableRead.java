package parser;

public class VariableRead extends Expression {
	private Reference var;
	
	public String toString(String prefix) {
		String str = prefix + "VariableRead"; 
		
		if(var != null)
			str += "\n" + var.toString(prefix + " ");
		
		return str;
	}
	
	public Reference getVar() { return var; }
}