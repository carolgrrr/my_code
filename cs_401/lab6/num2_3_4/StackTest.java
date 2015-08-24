import java.util.*;

public class StackTest
{
	
	public static void main (String[] args)
	{

		Scanner sc = new Scanner(System.in);
		String infixString = "";
		String postfixString = "";

		CS401StackLinkedListImpl<String> operatorStack = new CS401StackLinkedListImpl<String>();
		CS401StackLinkedListImpl<String> tempStack = new CS401StackLinkedListImpl<String>();

		System.out.print("\nEnter your infix expression (or -1 to quit): ");
		infixString = sc.nextLine();

		while(!infixString.equals("-1"))
		{
			postfixString = infixToPostfix(infixString);
			System.out.println("Postfix expression: " + postfixString);
			System.out.println("Expression evaluated: " + postfixEvaluation(postfixString));
			System.out.print("\nEnter your infix expression (or -1 to quit): ");
			infixString = sc.nextLine();
		}
	}

	public static String infixToPostfix(String infix)
	{
		CS401StackLinkedListImpl<String> operators = new CS401StackLinkedListImpl<String>();
		String postfix = "";

		while(infix.length()>0)
		{
			if(infix.charAt(0) == ' ')
			{
				infix = infix.substring(1);
			}

			else if(infix.charAt(0) == '+' || infix.charAt(0) == '-' || infix.charAt(0) == '*' || infix.charAt(0) == '/')
			{
				if(operators.getHead() == null)
				{
					String s = Character.toString(infix.charAt(0));
					operators.push(s);
					infix = infix.substring(1);
				}
				else if(operators.getHead().equals("*") || operators.getHead().equals("/"))
				{
					postfix += operators.pop();
					postfix += " ";
				}
				else if((operators.getHead().equals("+") || operators.getHead().equals("-")) && (infix.charAt(0) == '+' || infix.charAt(0) == '-'))
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
		while(operators.getHead()!=null)
		{
			postfix += operators.pop();
			if (operators.getHead()!=null)
			 postfix += " ";
		}
		return postfix;
	}

	public static double postfixEvaluation(String pf)
	{
		double temp1 = 0;
		double temp2 = 0;
		double result = 0;

		CS401StackLinkedListImpl<String> operandStack = new CS401StackLinkedListImpl<String>();

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