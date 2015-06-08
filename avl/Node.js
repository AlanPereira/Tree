window.onload = main;

function Node(element, parent, left, right, key) {
	this.element = element;
	this.parent = parent;
	this.left = left; 
	this.right=right;
	this.key = key;
	this.fat = 0;
	this.isExternal = function(){
		if(this.left || this.right)
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
		return this.root.element;
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
		//console.log("\n Antes de add->"+tree.root.element+"\npreOrder e Fat root = "+this.root.fat);
		//this.preOrder(tree);


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
		
		//this.atualizaFat(this.root);
		
		// var tree = {
		// 	root : this.root
		// };

		
		this.balanceTree(this.root);

		//console.log("\n Apos de add->"+tree.root.element+"\npreOrder e Fat root = "+this.root.fat);
		//this.preOrder(tree);
//	this.verificarBalanceamento(this.root);

	}

	this.preOrder = function(tree){
		function recOrder(node){
			if(node.parent)
				console.log(node.element+" key: "+node.key+" Fat: "+node.fat+" Seu Pai é : "+node.parent.element+" key "+node.parent.key);
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
				console.log(node.element+" key: "+node.key+" Fat: "+node.fat+" Seu Pai é : "+node.parent.element+" key "+node.parent.key);
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

	this.height = function(no){
			
			 if(!no || no.isExternal()){
				return 0;
			}else{
				var height=0;

				if(no.left){
					height = Math.max(height, this.height(no.left));
				}
				if(no.right){
					height = Math.max(height, this.height(no.right));
				}
				return height+1;
			}	 
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


			//this.atualizaFat(this.root);		
			this.balanceTree(this.root);
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




	this.rotationLeftRight = function(z){
		var aux = z.left;
		z.left = aux.right;
		aux.right = z.left.left;
		z.left.left = aux;
		z.left.parent = aux.parent;
		aux.parent = z.left;
		if(aux.right)
			aux.right.parent = aux;
	}

	this.rotationRightLeft = function(z){
		var aux = z.right;
		z.right = aux.left;
		aux.left = z.right.right;
		z.right.right = aux;
		z.right.parent = aux.parent;
		aux.parent = z.right;
		if(aux.left)
			aux.left.parent = aux;
	}

	this.rotationRight = function (z){
			
			var aux = z;
			z = z.right; 

			//var y = z.right;
			
			aux.right = z.left;

			if(aux.right)
				aux.right.parent = z;
			

			z.left = aux;

			if(aux.parent){
				if(aux.parent.right == aux)
					aux.parent.right = z;
				else
					aux.parent.left = z;
				z.parent = aux.parent;
				aux.parent = z;
			}else{
				z.parent = null;
				this.root = z;
				aux.parent = z;
				
			}

		this.atualizaFat(this.root);

		}

	this.rotationLeft = function(z){
			
			//console.log("rotationLeft  z = "+ z.element);
			var aux = z;
			var z = z.left;
			//console.log("aux = "+aux.element+" z ="+z.element);

			aux.left = z.right;
			
			//z.left = y.right;
			if(aux.left)
				aux.left.parent = aux;

			z.right = aux;
			if(aux.parent){
				if(aux.parent.right == aux)
					aux.parent.right = z;
				else
					aux.parent.left = z;
				z.parent = aux.parent;
				aux.parent = z;
			}else{
				z.parent = null;
				this.root = z;
				aux.parent = z;	
			}


		this.atualizaFat(this.root);

	}

	this.atualizaFat = function (node){

			var alt1 =0, alt2 = 0;
			if(node.right)
				alt1 = this.atualizaFat(node.right);
			if(node.left)
				alt2 = this.atualizaFat(node.left);

			node.fat = alt1 - alt2;

			if(node.parent){
				return this.height(node) +1;
			}
		}



	this.balanceTree = function(node){
		
		this.atualizaFat(this.root);

		if(node.right)
			this.balanceTree(node.right);
		if(node.left)
			this.balanceTree(node.left);

		if(node.fat<-1 || node.fat > 1){
				if(node.fat>0){
					if(node.right.fat < 0)
						this.rotationRightLeft(node);
					this.rotationRight(node);
				}
				else{
					if(node.left.fat > 0)
						this.rotationLeftRight(node);
					this.rotationLeft(node);
				}
			}
	}

	this.root = new Node(null, null, null, null, this.numAleatorio());
}

function desenharcirculosletra(text, altura, largura,dir) {
     var canvas = document.getElementById('tree');
     var context = canvas.getContext('2d');
     
     if(altura>0 && largura == 0)
     	if(dir=="d")
     		largura = 0.5;
     	else
     		largura = -0.5;
     var x = 600 + largura*60;
     var y = 61 +60*altura;

     context.fillStyle = "#0099FF";
     context.beginPath();
     context.arc(x, y, 30, 0, Math.PI*2, false);//Coordenadas X, Coordenadas Y, Raio, Inicio do ângulo, Fim do ângulo , No sentido do relógio / Contra o sentido do relógio
     context.closePath();
     context.fill();//preenche o circulo
     // Adicionar texto
     context.fillStyle = '#FFFFFF';
     context.font = '17px Trebuchet MS';
     context.fillText(text, x-13, y+6); 
 
}


function desenhaTree(node, altura, largura, dir){

		desenharcirculosletra(node.key, altura, largura, dir);
			if(node.right !=null){
				desenhaTree(node.right, altura+1, largura-2, "d");
			}
			if(node.left !=null)
				desenhaTree(node.left, altura+1, largura+2, "e");
		}

function main(){

	var root  = new Tree();
	root.setElement("Root");
	var arrNode = new Array();
	//root.root.key = 0;

	for (var i = 1; i<=5;i++){
		arrNode[i] = new Tree();
		arrNode[i].setElement("node "+i);
		//arrNode[i].root.key = i*20+1;
		root.add(arrNode[i]);
	}
		/*console.log("preOrder");
		root.preOrder(root);
		console.log("\n posOrder");
		root.posOrder(root);
		console.log("\ninOrder");
		root.inOrder(root);
*/

		//console.log("preOrder");
		//root.preOrder(root);
		//console.log("\n\nelement = "+arrNode[1].root.element+" key = "+arrNode[1].root.key);
		//console.log(root.remove(arrNode[1]));
		//console.log("\n\n\npreOrder");
		//root.preOrder(root);


		console.log("\n\nNode root = "+root.getElement()+ " Key = "+root.root.key+" Fat do Node root = "+ root.root.fat);
		//root.balanceTree(root.root);
		//root.atualizaFat(root.root);

		console.log("\n\npreOrder");
		root.preOrder(root);
		//console.log("Altura do root = "+ root.height(root.root)+" Fat do root = "+ root.root.fat+" Novo root "+ root.root.element);
		desenhaTree(root.root, 0, 0);
}

//main();
