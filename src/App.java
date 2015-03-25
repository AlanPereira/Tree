import java.util.ArrayList;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> t = new ArrayList<String>();
		for(int i= 0; i<10;i++){
			t.add("!"+i);
		}
		
		for(String j: t){
			System.out.println(j);
		}
	}

}
