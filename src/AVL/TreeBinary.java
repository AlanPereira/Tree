package AVL;



public class TreeBinary <E>{

	private BTNode root;


	public TreeBinary(E e){
		BTNode node = new BTNode(e);
		setRoot(node);
	}
	public TreeBinary(){

	}

	protected BTNode getRoot() {
		return root;
	}

	protected void setRoot(BTNode root) {
		this.root = root;
	}

	public TreeBinary<E> parent(){
		TreeBinary<E> tree = new TreeBinary<E>();
		if(!this.root.equals(null)){
			tree.setRoot(this.getRoot().getParent());
		}
		return tree;

	}

	private boolean isExternal(BTNode no){
		if(!(hasLeft(no) || hasRight(no)))
			return true;
		return false;
	}


	public boolean isExternal(TreeBinary<E> root){
		return isExternal(root.getRoot());
	}

	public boolean isInternal(TreeBinary<E> root){
		return !this.isExternal(root);
	}

	public boolean isRoot(){

		if(!(this.root == null)){
			if(this.root.getParent()==null)
				return true;
		}
		return false;
	}

	public boolean isEmpty(){
		if(this.root == null)
			return true;
		return false;
	}

	public void setElement(E e){
		this.root.setElement(e);
	}

	@SuppressWarnings("unchecked")
	public E getElement(){
		return (E) this.root.getElement();
	}

	public boolean addRoot(E e){
		if(isEmpty()){
			BTNode node = new BTNode(e);
			setRoot(node);
			return true;
		}
		return false;

	}

	public void left(E e){
		BTNode node = new BTNode(e);
		if(isEmpty()){
			setRoot(node);
		}else{
			node.setParent(getRoot());
			getRoot().setLeft(node);
		}
	}

	public void right(E e){
		BTNode node = new BTNode(e);
		if(isEmpty()){
			setRoot(node);
		}else{
			node.setParent(getRoot());
			getRoot().setRight(node);
		}
	}

	public void left(TreeBinary<E> subTree){
		if(isEmpty()){
			setRoot(subTree.getRoot());
		}else{
			subTree.getRoot().setParent(getRoot());
			getRoot().setLeft(subTree.getRoot());
		}
	}

	public void right(TreeBinary<E> subTree){
		if(isEmpty()){
			setRoot(subTree.getRoot());
		}else{
			subTree.getRoot().setParent(getRoot());
			getRoot().setRight(subTree.getRoot());
		}
	}


	private boolean hasLeft(BTNode node){
		if(node.getLeft() == null)
			return false;
		return true;	
	}

	public boolean hasLeft(TreeBinary<E> subTree){
		return hasLeft(subTree.getRoot());
	}


	private boolean hasRight(BTNode node){
		if(node.getRight()==null)
			return false;
		return true;
	}

	public boolean hasRight(TreeBinary<E> subTree){
		return hasRight(subTree.getRoot());
	}


	private BTNode find(BTNode no, BTNode root){
		BTNode node = null; 
		if(root.equals(no))
			return no;
		if(hasLeft(root))
			node = find(no, root.getLeft());
		if(hasRight(root) && (node == null))
			node =  find(no, root.getRight());
		return node;
	}

	private BTNode find(E e, BTNode no){
		BTNode node = null; 
		if(no.getElement().equals(e))
			return no;
		if(hasLeft(no))
			node =  find(e, no.getLeft());
		if(hasRight(no) && (node == null))
			node =  find(e, no.getRight());
		return node;
	}

	public TreeBinary<E> find(E e){
		BTNode node = find(e, getRoot());
		if(!(node == null)){
			TreeBinary<E> t = new TreeBinary<E>();
			t.setRoot(node);
			return t;
		}
		return null;
	}

	public boolean remove(E e){
		boolean ok = false;
		BTNode node = find(e, this.root);
		if(node != null){
			node.setElement(null);
			ok = true;
		}
		return ok;
	}

	public boolean remove(TreeBinary<E> subTree){
		boolean ok = false;
		BTNode node = find(subTree.getRoot(), this.root);
		if(node != null){
			if(!(hasLeft(node) && hasRight(node))){
				if(hasLeft(node)){
					node.getParent().setLeft(node.getLeft());	

				}else
					node.getParent().setRight(node.getRight());
				node= null;
				ok = true;
			}
		}
		return ok;
	}


	public void replace(E e, TreeBinary<E> subTree){
		BTNode no = find(subTree.getRoot(), getRoot());
		if(!(no ==null)){
			no.setElement(e);
		}
	}



	private void preOrder(BTNode no){
		if(no == null){
			return ;
		}

		System.out.print(no.getElement()+" ");

		if(hasLeft(no))
			preOrder(no.getLeft());
		if(hasRight(no))
			preOrder(no.getRight());
	}

	public void preOrder(TreeBinary<E> subTree){
		preOrder(subTree.getRoot());
	}


	private void posOrder(BTNode no){
		if(no == null){
			return ;
		}

		if(hasLeft(no))
			posOrder(no.getLeft());

		if(hasRight(no))
			posOrder(no.getRight());

		System.out.print(no.getElement()+" ");
	}



	public void posOrder(TreeBinary<E> subTree){
		posOrder(subTree.getRoot());
	}


	private void inOrder(BTNode no){
		if(no == null){
			return ;
		}

		if(hasLeft(no)){
			System.out.print("(");
			inOrder(no.getLeft());
		}

		System.out.print(no.getElement());

		if(hasRight(no)){
			inOrder(no.getRight());
			System.out.print(")");
		}
	}

	public void inOrder(TreeBinary<E> subTree){
		inOrder(subTree.getRoot());
	}


	public int depth(TreeBinary<E> subTree){//profundidade

		BTNode no = subTree.getRoot();
		int i =0;

		no = no.getParent();
		while(no!=null){
			no = no.getParent();
			i++;
		}
		return i;		

	}

	private int height(BTNode no){
		if(no.equals(null))
			return 0;
		else if(isExternal(no)){
			return 1;
		}else{
			int tam = 0, height=0;

			if(hasLeft(no)){
				tam = height(no.getLeft());
				if(height<tam){
					height = tam;
				}
			}
			if(hasRight(no)){
				tam = height(no.getRight());
				if(height<tam){
					height = tam;
				}
			}
			return height+1;
		}	
	}

	public int height(TreeBinary<E> subtree){
		return height(subtree.getRoot())-1;
	}


	private int size(BTNode no){
		int total = 1;

		if(no.equals(null)){
			return 0;
		}

		if(hasLeft(no))
			total += size(no.getLeft());

		if(hasRight(no))
			total += size(no.getRight());

		return total;
	}

	public int getSize(TreeBinary<E> subTree) {
		return size(subTree.getRoot());
	}


	private double calculaExpressao(BTNode node){
		double x=0, y = 0;
		if(!isExternal(node)){
			x = calculaExpressao(node.getLeft());
			y = calculaExpressao(node.getRight());

			switch(((String)node.getElement()).charAt(0)){
			case '+':
				x = x+y;
				break;
			case '-':
				x = x-y;
				break;
			case '*':
				x = x*y;
				break;
			case '/':
				x = x/y;
				break;
			}
			return x;
		}else{
			return Double.parseDouble(((String) node.getElement()));
		}
	}

	public double calculaExpressao(TreeBinary<E> node){
		return calculaExpressao(node.getRoot());
	}
}



