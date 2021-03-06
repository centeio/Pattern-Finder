package parser;

import main.Visitor;

public class Assignment extends Statement implements IStatement {
	private TypeReference type;
	private IExpression lhs;
    private IExpression rhs;
    
    public String toString(String prefix) {
    	String str = prefix + nodetype;
    			
    	if(type!= null) {
    		str += "\n" + prefix + " Type:";
    		str += "\n" + type.toString(prefix + "  ");
    	}
    	
    	if(lhs != null) {
    		str += "\n" + prefix + " lhs:";
    		str += "\n" + lhs.toString(prefix + "  ");
    	}
    	
    	if(rhs != null) {
    		str += "\n" + prefix + " rhs:"; 
    		str += "\n" + rhs.toString(prefix + "  ");
    	}
    	
    	return str;
    }
    
    public TypeReference getType() {
		return type;
	}

	public IExpression getLhs() {
		return lhs;
	}

	public IExpression getRhs() {
		return rhs;
	}

	@Override
    public String getLabel() { return label; }
    
    
    @Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	
}
