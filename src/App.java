import java.util.ArrayList;

import Tree.Tree;
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
		node1.addRoot("Root");
			
		TreeBinary<String> node2 = new TreeBinary<String>("A");
		TreeBinary<String> node3 = new TreeBinary<String>("B");
		TreeBinary<String> node4 = new TreeBinary<String>("C");
		TreeBinary<String> node5 = new TreeBinary<String>("D");
		TreeBinary<String> node6 = new TreeBinary<String>("E");			

		
		
		node1.left(node2);
		node1.right(node3);
		node2.left(node4);
		node6.right(node5);
		node3.left(node6);	
		
		System.out.println("PosOrder\n");
		node1.posOrder(node1);
		System.out.println("\n----------");
		
		System.out.println("PreOrder\n");
		node1.preOrder(node1);
		System.out.println("\n----------");
		
		
		System.out.println("Altura: "+node1.height(node5));
		System.out.println("Profundidade: "+node1.depth(node5));
	}
}
