
import java.util.*;

public class calculate {
	
	/*
	 * TO SOLVE THE EXPRESSION IN THE CALCULATOR AN ALGORITHM CALLED SHUNTING YARD ALGORITHM HAS BEEN USED 
	 */
	public static double evaluate(String expression) {

		char[] exp = expression.toCharArray();				//Converting the whole string to an array of char 

		Stack<Double> values = new Stack<>();				//All the number in the expression will be stored to in this stack

		Stack<Character> operations = new Stack<>();		//all the operators in the expression will be stored in this stack


		for(int i = 0; i<exp.length;i++) 
		{													//5 + (5/5*5 + cos(0))

			if(Character.isDigit(exp[i])) 						//if the exp at index i is a number
			{					
				StringBuilder str = new StringBuilder();		//StringBuffer object created to keep appending the numbers into the this str 

				//Pushing the numbers into the values stack  
				while(i < exp.length && Character.isDigit(exp[i])) {	//the number in the expression might contain more than 1 digit so the i will keep incrementing until exp[i] != digit
					str.append(exp[i]);								
					i++;
				}
				values.push(Double.parseDouble(str.toString()));	//Push the values to the values stack after parsing the string to double
		
				i--;											//decrementing i as the for loop is also incrementing i, the value is set back to the orignal because the the program will miss some parts of the expression if i is not decrementing 
			}

			//if the exp[i] is the open bracket it is pushed to the operation stack
			else if(exp[i] == '(') {
				operations.push(exp[i]);
			}

			else if(exp[i] == ')') {					//Now the whole brace is going to be calculated until the the operation stack does not have opening bracking at the top

				while(operations.peek() != '(') {		
					values.push(operate(operations.pop(), values.pop(), values.pop()));		//operate method used to perform the caclulation parameter(operation at the top of the stack, 1st value on the values stack, 2nd value in the stack)  
				}
				operations.pop();						//The open bracket is popped out of the operations stack because the expression inside is solved and pushed back into the values stack
			}

			else if(exp[i] == '+' ||exp[i] == '-' || exp[i] == '*' || exp[i] == '/' || exp[i] == '^' || exp[i] == '%' || exp[i] == '!')
			{
				while(!operations.isEmpty() && checkPriority(exp[i], operations.peek()))				//Comparing the char at exp[i] and the one on the top of the operations stack and the operations stack should not be empty because there should be smth to compare with
				{

					values.push(operate(operations.pop(), values.pop(), values.pop()));				//performing the operate method and pushing the results back into the stack
					
				}
				operations.push(exp[i]);														//The operator will be pushed to the operation stack if it is empty or does does not have greater/same priority than the one on the top of the operations stack																				//pi and percentage will not be part of the while loop and and will directly pushed to the operators stack
				if(exp[i] == '%')
				{

					values.push(operate(operations.pop(), values.pop(),0));					//As the percentage operator only deals with the one values from the stack so the other value is set to 0 and the result is pushed to the values stack

				}
				else if(exp[i] == '!')
				{
					values.push(operate(operations.pop(), values.pop(), 0));				//Same as the percentage and pi, the factorial also deals with only one value from the stack so the other value is set to 0.
				}
			}
			
			else if(Character.isAlphabetic(exp[i]))			//If the there is a special function in the expression
			{
				StringBuilder funcType = new StringBuilder();	//StringBuffer is used to get the function type (sin, cos, tan, log)
				StringBuilder function = new StringBuilder();	//StringBuffer used to get the function (from open to clos bracket) of the functype
				
				//Appending the funcType to get the which function is in the expression
				while(i<=exp.length && Character.isAlphabetic(exp[i]))
				{
					funcType.append(exp[i]);
					i++;
				}
				
				//Appending the function to get which function is with the funcType
				while(i<=exp.length && exp[i] != ')')
				{
					function.append(exp[i]);
					i++;
				}
				
				function.append(exp[i]);			//Adding the last close bracket into the stringBuffer object (now we have the full function)
				double evalFunc = evaluate(function.toString());		//Recursion takes place and the function is evaluated 
				values.push(specialFunc(funcType.toString(), evalFunc));	// then using the user defined method the function result is returned from the method and oushed to the values stack. 
			}

		}
		
		//Final values and operator left in the operator will be solved

		while(!operations.isEmpty())															//perform the operate method to the remaining values and operators in their stacks 
		{	

			values.push(operate(operations.pop(), values.pop(), values.pop()));

		}

		return values.pop();					//returns the final result as it is always stored in the values stack so the result is popped out of the stack

	}


	//METHOD TO CHECK WHETHER THE SELECTED operator1 HAS MORE PRIORITY THAN operator 2
	public static Boolean checkPriority(char operator1, char operator2)
	{																									
		Boolean priority = false;

		if(operator2 == '^') 						//The power operator has the most priority than any other operator
		{
			priority = true;
		}
		else if((operator2 =='*'&& operator1 == '/') || (operator2 =='/'&& operator1 == '*') ) 	//* and / have same priority
		{
			priority = true;
		}
		else if((operator2 =='+' && operator1 == '-') || (operator2 =='-'&& operator1 == '+')) 	//+ and - have same priority
		{
			priority = true;
		}
		else if((operator2 =='*' && operator1 == '+') || (operator2 =='*' && operator1 == '-'))	//* has more priority than + and -
		{
			priority = true;
		}
		else if((operator2 =='/' && operator1 == '+') || (operator2 =='/' && operator1 == '-'))	// / has more priority than + and -
		{
			priority = true;
		}
		else 
		{
			priority = false;
		}


		return priority;			//returns true if the operator2 (operations.peek()) is greater/equal than operator1 (exp[i] operator in hand (index i))
	}
	
	//METHOD USED TO CALCULATE THE SPECIAL FUNCTION THAT TAKE IN funcType (sin, cos, tan) AND FUNCTION (inside the parentheses of the funcType)
	public static double specialFunc(String funcType, double function)
	{	
		double result = 0;									//initially the value of the result is 0
		if(funcType.equals("sin"))							//if the funcType is sin then the sin buit-in method is called from Math class and set to result
		{
			result = Math.sin(function);
		}
		else if(funcType.equals("cos"))						//if the funcType is cos then the cos buit-in method is called from Math class and set to result
		{
			result =  Math.cos(function);
		}
		else if(funcType.equals("tan"))						//if the funcType is tan then the tan buit-in method is called from Math class and set to result
		{
			result = Math.tan(function);
		}
		else if(funcType.equals("log"))						//if the funcType is log then the log10 buit-in method is called from Math class and set to result
		{
			result = Math.log10(function);
		}
		return result;									//result will be set according to the conditions above and is returned to be used in the evaluate().
	}
	

	//METHOD USED TO CHECK THE OPERATION FROM THE EXPRESSION AND TAKE THE FIRST 2 VALUES FROM THE STACK values AS 'a' AND 'b' and perform the 
	//b is the first value popped out of the stack and a is the second one popped out of the stack
	public static double operate(char operation, double b, double a) {
		double result = 0;

		if(operation == '+') 
		{
			result = a + b;
		}
		else if(operation == '-')
		{
			result = a-b;
		}
		else if(operation == '*') 
		{
			result = a*b;	
		}
		else if(operation == '/') 
		{
			if(b == 0 )				//if the number is divided by 0 then the result will be 0
			{
				result = 00;
			}
			else 
			{
				result = a/b;
			}
		}
		else if(operation == '^') 		//Powers
		{
			result = Math.pow(a, b);	//calling a buit-in method from Math class to perform the power on the values
		}
		else if(operation == '%')
		{
			result = b/100;
		}
		else if(operation == '!')
		{
			result = 1;					//result will be set to 1 because in factorial 0 is not included else the final answer will be 0
			for(long i = 1; i<=b;i++)		
			{
				result = result *i;		//result will be equal to the multiplication between all the values from 1 to the values of b.
			}
		}

		return result;					//returns the result for any operation performed to be added into the values stack in evaluate method
	}
	

	
	
	
	{
		
	}

}



