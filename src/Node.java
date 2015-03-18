import java.util.ArrayList;

public class Node {

	private Node parent;
	private Object element;
	private ArrayList<Node> children;
	
	public Node(){
		setChildren(new ArrayList<Node>());
	}
	
	public Node(Object e){
		setChildren(new ArrayList<Node>());
		setElement(e);
	}
	
	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}	
	
}
