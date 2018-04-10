import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList <String> array =new ArrayList <String>();
		//   Don't forget to import the ArrayList class
		
		//2. Add five Strings to your list
		array.add("john");
		array.add("adam");
		array.add("eve");
		array.add("steve");
		array.add("God");
		
		//3. Print all the Strings using a standard for-loop
		//for(String s : array) {
			//System.out.println(s);
		//}
		//4. Print all the Strings using a for-each loop
		
		//5. Print only the even numbered elements in the list.
	//	for(int i=0; i<array.size();) {
			
			//if(i>5) {
				//System.exit(0);
		//}
			//.out.println(array.get(i));
			//i+=2;
			
	//	}
		//6. Print all the Strings in reverse order.
		
		
	//for(int i=4;i>-1; i--) {
		//System.out.println(array.get(i));
		
//	}
		//7. Print only the Strings that have the letter 'e' in them.
		for(String w : array) {
			if((w.contains("e"))) {
				System.out.println(w);
			}
		}
	}
}