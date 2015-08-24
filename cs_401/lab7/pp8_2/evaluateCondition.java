import java.util.*;
import java.lang.*;

public class evaluateCondition
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\nPlease enter a condition, or $ to quit: ");
		String condition = sc.nextLine();

		while(!condition.equals("$"))
		{
			String conditionPostfix = infixToPostfix(condition);
			String conditionNumbers = "";
			ArrayList<String> symbolTable = new ArrayList<String>();
			ArrayList<Integer> values = new ArrayList<Integer>();

			int symbolCount = 0;

			for(int i = 0; i < conditionPostfix.length(); i++)
			{
				if(conditionPostfix.charAt(i) != '+' && conditionPostfix.charAt(i) != '-' && conditionPostfix.charAt(i) != '*' && conditionPostfix.charAt(i) != '/' && conditionPostfix.charAt(i) != ' ')
				{
					if(!symbolTable.contains(Character.toString(conditionPostfix.charAt(i))))
					{
						symbolTable.add(symbolCount, Character.toString(conditionPostfix.charAt(i)));
						symbolCount++;
					}		
				}
			}

			for(int i = 0; i < symbolTable.size(); i++)
			{
				System.out.print("Please enter a value: ");
				int val = sc.nextInt();
				values.add(i, val);
			}

			char conditionChars[] = conditionPostfix.toCharArray();
			int tempInt, symbolIndex;

			for(int i = 0; i < conditionPostfix.length(); i++)
			{
				if(symbolTable.contains(Character.toString(conditionPostfix.charAt(i))))
				{
					conditionChars[i] = ((char)('0' + values.get(symbolTable.indexOf(Character.toString(conditionPostfix.charAt(i))))));
				}
				else
					conditionChars[i] = conditionPostfix.charAt(i);
				conditionNumbers += conditionChars[i];
			}

			double eval = postfixEvaluation(conditionNumbers);
			System.out.println("\nThe value of the condition is " + eval);

			condition = "$";

		}
	}


	public static String infixToPostfix(String infix)
	{
		Stack<String> operators = new Stack<String>();
		String postfix = "";

		while(infix.length()>0)
		{
			if(infix.charAt(0) == ' ')
			{
				infix = infix.substring(1);
			}

			else if(infix.charAt(0) == '+' || infix.charAt(0) == '-' || infix.charAt(0) == '*' || infix.charAt(0) == '/')
			{
				if(operators.empty() == true)
				{
					String s = Character.toString(infix.charAt(0));
					operators.push(s);
					infix = infix.substring(1);
				}
				else if(operators.peek().equals("*") || operators.peek().equals("/"))
				{
					postfix += operators.pop();
					postfix += " ";
				}
				else if((operators.peek().equals("+") || operators.peek().equals("-")) && (infix.charAt(0) == '+' || infix.charAt(0) == '-'))
				{
					postfix += operators.pop();
					postfix += " ";
				}					
				else
				{
					String s = Character.toString(infix.charAt(0));
					operators.push(s);
					infix = infix.substring(1);
				}
			}
			else
			{
				postfix += infix.charAt(0);
				postfix += " ";
				infix = infix.substring(1);
			}
		}
		while(operators.empty() == false)
		{
			postfix += operators.pop();
			if (operators.empty() == false)
			 postfix += " ";
		}
		return postfix;
	}

	public static double postfixEvaluation(String pf)
	{
		double temp1 = 0;
		double temp2 = 0;
		double result = 0;

		Stack<String> operandStack = new Stack<String>();

		for (int i = 0; i < pf.length(); i++)
		{
			if(pf.charAt(i) != ' ')
			{
				if (pf.charAt(i) != '+' && pf.charAt(i) != '-' && pf.charAt(i) != '*' && pf.charAt(i) != '/')
				{
					operandStack.push(Character.toString(pf.charAt(i)));
				}
				else
				{
					if (pf.charAt(i) == '+')
					{
						temp2 = Double.parseDouble(operandStack.pop());
						temp1 = Double.parseDouble(operandStack.pop());
						result = temp1 + temp2;
						operandStack.push(Double.toString(result));
					}
					else if (pf.charAt(i) == '-')
					{
						temp2 = Double.parseDouble(operandStack.pop());
						temp1 = Double.parseDouble(operandStack.pop());
						result = temp1 - temp2;
						operandStack.push(Double.toString(result));
					}
					else if (pf.charAt(i) == '*')
					{
						temp2 = Double.parseDouble(operandStack.pop());
						temp1 = Double.parseDouble(operandStack.pop());
						result = temp1 * temp2;
						operandStack.push(Double.toString(result));
					}
					else if (pf.charAt(i) == '/')
					{
						temp2 = Double.parseDouble(operandStack.pop());
						temp1 = Double.parseDouble(operandStack.pop());
						result = temp1 / temp2;
						operandStack.push(Double.toString(result));
					}					
				}
			}
		}
		result = Double.parseDouble(operandStack.pop());
		return result;

	}
}