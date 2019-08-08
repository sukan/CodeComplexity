package DAO_SERVICE.recursion_complexity;

import java.io.IOException;

public class CalculateRecursionComplexity {

	static String clName = ""; // stores class name
	static String methName = ""; // stores method name

	static int brcArray = 0; // count will be incremented by 1 when it is "{" and reduced by 1 "}"
	static int startVal = 0; // Recursion methods starting point
	static int endVal = 0; // Recursion methods end point
	static boolean isRecursion = false; // method is recursion or not

	public static void countRec(String[] stArray) throws IOException {
		String[] brcnt;

//		String[] stArray = { "public class FibonacciMain {", "public static long fibonacci(long number) {",
//				"if ((number == 0) || (number == 1))", " return number;", "else",
//				" return fibonacci(number - 1) + fibonacci(number - 2);", "}",
//				"public static void main(String args[ ]) {", "for (int count = 0; count <= 10; count++)",
//				"System.out.println(\"Fibonacci of \" + count + \" is \" + fibonacci(count));", " }", "}" };

		for (int l = 0; l < stArray.length; l++) {

			
			
				// checking for if/else/switch where you have "{"
				if (stArray[l].contains("{") && brcArray >= 2 && methName != "") {
					brcArray += 1;
				}
			
			
			// checking for method
			if (stArray[l].contains("{") && stArray[l].contains("(") && stArray[l].contains(")")
					&& (stArray[l].contains("long") || stArray[l].contains("void") || stArray[l].contains("int")
							|| stArray[l].contains("double"))
					|| stArray[l].contains("String")) {
				//System.out.println("Line1 :" + stArray[l] + l);
				brcnt = stArray[l].split("\\{");
				brcnt = brcnt[0].split("\\(");
				//System.out.println("Length : " + brcnt.length);
				brcnt = brcnt[0].split("\\s");

				//System.out.println("Length1 :" + brcnt.length);
				methName = brcnt[brcnt.length - 1];
				System.out.println("Method name : " + methName);
				System.out.println("method found");
				
				brcArray += 1;
				startVal = l;
				System.out.println("Strating.... " + startVal);
				//System.out.println("method brc : " + brcArray);
			}

			// checking for class
			if (stArray[l].contains("{") && stArray[l].contains("class")) {
				
				brcArray += 1;
				System.out.println("class " + brcArray);
			}

			
				
			// ending blocks
			if (stArray[l].contains("}")) {
				brcArray -= 1;
				endVal = l;
				System.out.println("Ending.... " + endVal);
				//System.out.println("B : " + brcArray + "line no :" + l);
				// when the method is closed
				// before going to a new method
				if (brcArray == 1) {
					methName = "";
					isRecursion = false;
				}
			}

			// normal statement
			if (!stArray[l].contains("{")) {
				System.out.println("Line2 :" + stArray[l] + " line" + l);
				brcnt = stArray[l].split("\\(");
				brcnt = brcnt[0].split("\\s");

				System.out.println("Length 2 : " + brcnt.length);
				for (String n : brcnt) {
					// System.out.println("n:" +n);
					// System.out.println("Method name1 : " + methName);

					// checking for recursion availability
					if (n.equals(methName) && methName != "") {
						System.out.println("State : " + isRecursion);
						System.out.println("This is a recursion : " + methName);
						isRecursion = true;
						
					}
					
					

				}

				if(isRecursion) {
					System.out.println("Because it is a recursion");
					System.out.println("start point : " + startVal + " "+endVal);
					// System.out.println("This is a recursion");
					for (int p = startVal; p < endVal; p++) {
						// invoking the specific complexity calculation method
						// size.calculation(stArray[l]);
						System.out.println("Hello");
					}
				}

			}

		}
	}

	
	
}
