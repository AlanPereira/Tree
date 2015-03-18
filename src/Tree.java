
public class Tree <E>{

	private Node root;
	private int size;

	public Tree(){
		setRoot(new Node());
		size = 0;
	}

	public int getSize() {
		return size;
	}
	
	public void add(E e, Node pai){}//Será necessario? por default ele é sempre um parent
	
	public void addParent (E e) {
		Node novoNo = new Node(e);
		if(novoNo !=null)
			getRoot().getChildren().add(novoNo);
	}
	
	public void addParent (Tree subtree) {
		
	}

	public boolean empty(){
		if(getRoot() == null){
			return true;
		}
		return false;
	}

	public boolean add(E e){
		boolean ok =true;
		return ok;
	}

	public void add(int i, E e){
	
	}

	public boolean remove(E e){
		boolean ok = false;
		
		return ok;
	}

	/*
	public E remove(int i){
		
		return p;
	} */
	
	
	/*
	public E find(int i){
		
	}*/

	/*
	public int numOrdem(E e){
	
	}*/

	public void destroy(){
		
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
//	public Object getSubtree(Node node){
//		return Tree().setRoot(this);
//	}
}
