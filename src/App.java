import TreeBinary.TreeBinary;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Tree<String> tree = new Tree<String>();
		
//		ArrayList<String> t = new ArrayList<String>();
//		for(int i= 0; i<10;i++){
//			t.add("!"+i);
//		}
//		
//		for(String j: t){
//			System.out.println(j);
//		}
		
		
		TreeBinary<String> node1 = new TreeBinary<String>();
		node1.addRoot("-");
			
		TreeBinary<String> node2 = new TreeBinary<String>("/");
		TreeBinary<String> node3 = new TreeBinary<String>("+");
		TreeBinary<String> node4 = new TreeBinary<String>("*");
		TreeBinary<String> node5 = new TreeBinary<String>("+");
		TreeBinary<String> node6 = new TreeBinary<String>("*");
		TreeBinary<String> node7 = new TreeBinary<String>("6");
		TreeBinary<String> node8 = new TreeBinary<String>("+");
		TreeBinary<String> node9 = new TreeBinary<String>("3");
		TreeBinary<String> node10 = new TreeBinary<String>("-");
		TreeBinary<String> node11 = new TreeBinary<String>("2");
		TreeBinary<String> node12 = new TreeBinary<String>("3");
		TreeBinary<String> node13 = new TreeBinary<String>("-");
		TreeBinary<String> node14 = new TreeBinary<String>("3");
		TreeBinary<String> node15 = new TreeBinary<String>("1");
		TreeBinary<String> node16 = new TreeBinary<String>("9");
		TreeBinary<String> node17 = new TreeBinary<String>("5");
		TreeBinary<String> node18 = new TreeBinary<String>("7");
		TreeBinary<String> node19 = new TreeBinary<String>("4");
		
		
		node1.left(node2);
		node1.right(node3);
		
		node2.left(node4);
		node2.right(node5);
		
		node3.left(node6);
		node3.right(node7);
		
		node4.left(node8);
		node4.right(node9);
		
		node5.left(node10);
		node5.right(node11);
		
		node6.left(node12);
		node6.right(node13);
		
		node8.left(node14);
		node8.right(node15);
		
		node10.left(node16);
		node10.right(node17);
		

		node13.left(node18);
		node13.right(node19);
		
		System.out.println("PosOrder\n");
		node1.posOrder(node1);
		System.out.println("\n----------");
		
		System.out.println("PreOrder\n");
		node1.preOrder(node1);
		System.out.println("\n----------");
		
		System.out.println("InOrder\n");
		node1.inOrder(node1);
		System.out.println("\n----------");
		System.out.println(node1.calculaExpressao(node1));
		
	}
}
