//window.onload = main;

function Node(element, parent, left, right, key) {
	this.element = element;
	this.parent = parent;
	this.left = left; 
	this.right=right;
	this.key = key;
	this.isExternal = function(){
		if(left || right)
			return false;
		return true;
	}
}


function Tree(){

	this.setElement = function(element){
		this.root.element = element;
	}

	this.numAleatorio =  function(){
		var num = Math.floor(Math.random() * 1000);
			console.log(num);
		return num;
	}

	this.parent = function(){
		var tree = new Tree();
		tree.root.parent = this.root.parent;
		return tree;
	}

	this.isExternal = function(tree){
		if(tree.hasLeft || tree.hasRight)
			return false;
		return true;
	}

	this.hasLeft = function(tree){
		if(tree.root.left == null)
			return false;
		return true;
	}

	this.hasRight = function(tree){
		if(tree.root.right == null)
			return false;
		return true;
	}

	this.isInternal = function(){
		return !isExternal();
	};

	this.isRoot = function(){
		var ok = false;
		if(this.root.parent);
			ok = true;
		return ok;
	}
	/*
	this.isEmpty = function(){
		return if(this.root);
	}*/

	this.getElement = function(){
		return root.element;
	}

	this.getLeft = function(){
		var tree = new Tree();
		tree.root = this.root.left;
		return tree;
	}

	this.getRight = function(){
		var tree = new Tree();
		tree.root = this.root.right;
		return tree;
	}	

	this.add = function(tree){
		var novoNo = tree.root;
		var node = this.root;
		var ant = this.root;
		while(node){
			ant = node;
			if(novoNo.key < node.key){
				node = node.right;
			}else
				node = node.left;
		}
		novoNo.parent = ant;
		if(ant.key > novoNo.key){
			ant.right = novoNo;
		}
		else{
			ant.left = novoNo;
		}
		
		//this.balanceTree();
	}

	this.preOrder = function(tree){
		function recOrder(node){
			if(node.parent)
				console.log(node.element+" key: "+node.key+" Seu Pai é : "+node.parent.element+" key "+node.parent.key);
			if(node.right !=null)
				recOrder(node.right);
			if(node.left !=null)
				recOrder(node.left);
			
		}

		recOrder(tree.root);
	}

	this.posOrder = function(tree){
		function recOrder(node){
			if(node.right !=null)
				recOrder(node.right);
			if(node.left !=null)
				recOrder(node.left);
			if(node.parent)
				console.log(node.element+" key: "+node.key+" Seu Pai é : "+node.parent.element+" key "+node.parent.key);
		}
		recOrder(tree.root);
	}

	this.inOrder = function(tree){
		function recOrder(node){
			if(node.right !=null)
				recOrder(node.right);

			if(node.parent)
				console.log(node.element+" key: "+node.key+" Seu Pai é : "+node.parent.element+" key "+node.parent.key);

			if(node.left !=null)
				recOrder(node.left);
			
		}
		recOrder(tree.root);
	}

	this.depth = function(tree){
		var no = tree.root;
		var i =0;

		no = no.parent;
		while(no){
			no = no.parent;
			i++;
		}
		return i;
	}

	this.height = function(tree){
		function recheight(no){
			if(no)
				return 0;
			else if(isExternal(no)){
				return 1;
			}else{
				var tam = 0, height=0;

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

		return recheight(tree.root); 
	}


	this.size = function(tree){
		
		function recSize(no){

			var total = 1;

			if(no)
				return 0;
			if(no.left)
				total += size(no.left);

			if(no.right)
				total += size(no.right);

			return total;
		}

		return recSize(tree.root);
	}

    this.find = function(){
            return this.find[arguments[0].constructor].apply(this, arguments);
        }     
    //this.find[null] = function(){ return this.root}

    this.find[Number] = function(key, node){
		if(node == null || node.key == key)
			return node;
		if(node.key < key)
			return this.find(key, node.left);
		else 
			return this.find(key, node.right);

 	}

    this.find[Node] = function(no, root){
    	return this.find(no.key, root);
	}




this.removeRec = function(node){
			var no = null;
			var parent = node.parent;

			if(node.left && node.right){
				var key = this.searchNext(node.left);
				console.log("tem dois filhos");

				no = this.find(key, node);
				
				
				no = this.removeRec(no);
				
				no.left = node.left;
				no.right = node.right;
				no.parent = parent;
			}else if(node.left){
				no = node.left;
				console.log("tem um filho da esquerda");
				no.parent = parent;
			}else if(node.right){
				no = node.right;
				console.log("tem um filho da direita");
				no.parent = parent;
			}
			
			if(parent == null){
				this.root = no;
			}else{
				if(parent.left == node){
					parent.left = no;
				}else{
					parent.right = no;
				}
			}

			node.parent = null;
			node.left = null;
			node.right = null;

			return node;
			}

	this.searchNext = function (node){
			var min = node.key, num1 = null, num2 = null;

			if (node.isExternal())
				return min;	
			if(node.left)
				num1 = searchNext(node.left); 
			if(node.right)
				num2 = searchNext(node.right); 
			

			if(left==null)
				return Math.min(min, right);
			if(right == null)
				return Math.min(min, left);

			return Math.min(Math.min(left, right), min);
		}



	this.remove = function(subTree){
		this.removeRec(subTree.root);
	}




	/*

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
	public void replace(E e, TreeBinary<E> subTree){
		BTNode no = find(subTree.getRoot(), getRoot());
		if(!(no ==null)){
			no.setElement(e);
		}
	}
*/
	this.root = new Node(null, null, null, null, this.numAleatorio());
}

function main(){

	var root  = new Tree();
	root.setElement("Root");
	var arrNode = new Array();

	for (var i = 1; i<=30;i++){
		arrNode[i] = new Tree();
		arrNode[i].setElement("node "+i);
		root.add(arrNode[i]);
	}
		/*console.log("preOrder");
		root.preOrder(root);
		console.log("\n posOrder");
		root.posOrder(root);
		console.log("\ninOrder");
		root.inOrder(root);
*/

		console.log("preOrder");
		root.preOrder(root);
		console.log("\n\nelement = "+arrNode[1].root.element+" key = "+arrNode[1].root.key);
		console.log(root.remove(arrNode[1]));
		console.log("\n\n\npreOrder");
		root.preOrder(root);

}

main();
