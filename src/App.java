import java.util.ArrayList;


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
		
		
		Tree<String> node1 = new Tree<String>();
		node1.add("Root");
		
		Tree<String> node2 = new Tree<String>();
		node2.add("A");
		Tree<String> node3 = new Tree<String>();
		node3.add("B");
		Tree<String> node4 = new Tree<String>();
		node4.add("C");
		
		Tree<String> node5 = new Tree<String>();
		node5.add("D");
		
		Tree<String> node6 = new Tree<String>();
		node6.add("E");
		
			
		
		node1.add(node2);
		node1.add(node3);
		node1.add(node4);
		node2.add(node5);
		node2.add(node6);	
		
		System.out.println("PosOrder\n");
		node1.posOrder();
		System.out.println("\n----------");
		
		System.out.println("PreOrder\n");
		node1.preOrder();
		System.out.println("\n----------");
		
		
		System.out.println("Altura: "+node1.height(node3));
		System.out.println("Profundidade: "+node1.depth(node3));
	}
}
