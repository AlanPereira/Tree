package Tree;
import java.util.ArrayList;
import java.util.List;


public class Tree <E>{

	private Node root;

	public Tree<E> parent(){
		Tree<E> tree = new Tree<E>();
		if(!this.root.equals(null)){
			tree.setRoot(this.getRoot().getParent());
		}
		return tree;

	}

	private Node find(Node no, Node root){
		if(root.equals(no))
			return no;
		else if(root.getChildren().isEmpty()){
			return null;
		}else {
			int i =0;
			boolean ok = true;
			Node n;
			do{
				n = find(no, root.getChildren().get(i));
				if((no.equals(n))){
					ok = false;
				}
				i++;
			}while(ok && root.getChildren().size()<i);

			return n;
		}
	}

	private Node find(E e, Node no){

		if(no.getElement().equals(e)){
			return no;
		}else if(no.getChildren().isEmpty()){
			return null;
		}else {
			int i =0;
			boolean ok =true;
			Node n;
			do{
				n = find(e, no.getChildren().get(i));
				if(!(n==null)){
					ok = false;
				}
				i++;
			}while(ok && no.getChildren().size()<i);

			return n;
		}
	}

	public Tree<E> find(E e){
		Node node = find(e, getRoot());
		if(!node.equals(null)){
			Tree<E> t = new Tree<E>();
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

		if(!this.root.equals(null)){
			if(this.root.getParent().equals(null))
				return true;
		}
		return false;
	}

	public void setElement(E e){
		this.root.setElement(e);
	}

	@SuppressWarnings("unchecked")
	public E getElement(){
		return (E) this.root.getElement();
	}

	public void add(E e){
		Node node = new Node(e);
		if(isEmpty()){
			setRoot(node);
		}else{
			node.setParent(getRoot());
			getRoot().addChildren(node);
		}
	}

	public void add(Tree<E> subTree){
		if(isEmpty()){
			setRoot(subTree.getRoot());
		}else{
			subTree.getRoot().setParent(getRoot());
			getRoot().addChildren(subTree.getRoot());
		}

	}

	public boolean remove(E e){
		boolean ok = false;
		Node node = find(e, this.root);
		if(node != null){
			node.setElement(null);
			ok = true;
		}
		return ok;
	}

	public boolean remove(Tree<E> subTree){
		boolean ok = false;
		Node node = find(subTree.getRoot(), this.root);
		if(node != null){
			if(getRoot().equals(node)){
				this.root = null;
			}else{
				node.getParent().getChildren().remove(node);
				node.setParent(null);
				node.setChildren(null);
				node= null;
			}
			ok = true;
		}
		return ok;
	}

	public boolean isEmpty(){
		if(this.root == null)
			return true;
		return false;
	}

	public void destroy(){
		this.root = null;
	}

	protected Node getRoot() {
		return root;
	}

	protected void setRoot(Node root) {
		this.root = root;
	}


	private int size(Node no){
		if(no.equals(null)){
			return 0;
		}
		else if(no.getChildren().isEmpty()){
			return 1;
		}else{
			int i = 0, size =1;
			Node n;
			do{
				n = no.getChildren().get(i);
				size = size + size(n);
				i++;
			}while(no.getChildren().size()<i);

			return size;
		}
	}

	public int getSize() {
		return size(getRoot());
	}

	public void replace(E e, Tree<E> subTree){
		Node no = find(subTree.getRoot(), getRoot());
		if(!no.equals(null)){
			no.setElement(e);
		}
	}

	private void preOrder(Node no){
		if(no.equals(null)){
			return ;
		}
		else if(no.getChildren().isEmpty()){
			System.out.println(no.getElement());
		}else{
			int i = 0;
			Node n;
			System.out.println(no.getElement());
			do{
				n = no.getChildren().get(i);
				i++;
				preOrder(n);

			}while(no.getChildren().size()>i);
		}
	}

	public void preOrder(){
		preOrder(this.root);
	}

	private void posOrder(Node no){
		if(no.equals(null)){
			return ;
		}
		else if(no.getChildren().isEmpty()){
			System.out.println(no.getElement());
		}else{
			int i = 0;
			Node n;
			do{
				n = no.getChildren().get(i);
				posOrder(n);
				i++;
			}while(no.getChildren().size()>i);
			System.out.println(no.getElement());
		}
	}

	public void posOrder(){
		posOrder(this.root);
	}

	public int depth(Tree<E> subTree){//profundidade


		Node no = subTree.getRoot();
		int i =0;

		no = no.getParent();
		while(no!=null){
			no = no.getParent();
			i++;
		}
		return i;		

	}

	private int height(Node no){
		if(no.equals(null))
			return 0;
		else if(no.getChildren().isEmpty()){
			return 1;
		}else{
			int i = 0, tam = 0, height=0;
			Node n;
			do{
				n = no.getChildren().get(i);
				tam = height(n);
				if(height<tam){
					height = tam;
				}
				i++;
			}while(no.getChildren().size()<i);

			return height+1;
		}	
	}

	public int height(Tree<E> subtree){
		return height(subtree.getRoot())-1;
	}
}
