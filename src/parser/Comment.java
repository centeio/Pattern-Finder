package parser;

import main.Visitor;

public class Comment extends BasicNode {
	String type;
	String content;
	String position;
	
	public String toString(String prefix) {
		return prefix + nodetype;
	}
	
	public String getType() { return type; }
	public String getContent() { return content; }
	public String getPosition() { return position; }
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
