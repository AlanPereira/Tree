import java.util.ArrayList;
import java.util.List;


public class Tree <E>{

	private Node root;

	public Tree(){
		setRoot(new Node());
		
	}	
	
	public Tree<E> parent(){
		Tree<E> tree = new Tree<E>();
		tree.setRoot(this.getRoot().getParent());
		
		return tree;
		
	}
	
	private Node find(E e, Node no){
		Node n;
		if(no.getElement().equals(e)){
			return no;
		}else if(!no.getChildren().isEmpty()){
			return null;
		}else {
			int i =0;boolean ok =false;
			do{
				n = find(e, no.getChildren().get(i));
				if(!(n==null)){
					ok = true;
				}
				i++;
			}while(ok || no.getChildren().size()<i);
			
			return n;
		}
	}
	
	private E find(Node no){
		return null;
	}

	public Tree<E> find(E e){
		Node node = find(e, getRoot());
		if(!node.equals(null)){
			Tree<E> t =new Tree<E>();
			t.setRoot(node);
			return t;
		}
		return null;
	}
	
	public List<Tree<E>> children (){
		ArrayList<Tree<E>> list = new ArrayList<Tree<E>>();
		for(Node node:this.getRoot().getChildren()){
			Tree<E> e = new Tree<E>();
			e.setRoot(node);
			list.add(e);
		}
		return list;
	}
	
	public boolean isExternal(){
		return this.getRoot().getChildren().isEmpty();
	}
	
	public boolean isInternal(){
		return !this.isExternal();
	}
	
	public boolean isRoot(){
				
		if(null==this.getRoot().getParent()){
			return true;
		}
		return false;
	}
		
	public void add(E element, Tree<E> e){
		
		//
		
	}

	public boolean add(E e){
		boolean ok =true;
		return ok;
	}

	public boolean remove(E e){
		boolean ok = false;
		
		return ok;
	}

	
	public E remove(int i){
		
		return null;
	} 

	public void destroy(){
		
	}

	protected Node getRoot() {
		return root;
	}

	protected void setRoot(Node root) {
		this.root = root;
	}

	
}
