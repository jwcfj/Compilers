package compilers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class RPNStacker {
	public static void main(String[] args) {
		   Deque<String> stack = new ArrayDeque<String>();
		   Scanner scanner;
		   String letra_atual;
		   Integer num_direita,num_esquerda;
		try {
			scanner = new Scanner(new FileReader("/Users/JoséWilsonFerreira/Downloads/Calc1.stk")).useDelimiter("\\n");
			while (scanner.hasNext()) {
				letra_atual= scanner.next();
				if (letra_atual.equals("*")) {
					num_direita=Integer.parseInt(stack.pop());
					num_esquerda=Integer.parseInt(stack.pop());
					String result = Integer.toString(num_esquerda*num_direita);
					stack.push(result);
				}
				else if (letra_atual.equals('/')) {
					num_direita=Integer.parseInt(stack.pop());
					num_esquerda=Integer.parseInt(stack.pop());
					String result = Integer.toString(num_esquerda/num_direita);
					stack.push(result);
				}
				else if (letra_atual.equals("+")) {
					num_direita=Integer.parseInt(stack.pop());
					num_esquerda=Integer.parseInt(stack.pop());
					String result = Integer.toString(num_esquerda+num_direita);
					stack.push(result);
				}
				else if (letra_atual.equals("-")) {
					num_direita=Integer.parseInt(stack.pop());
					num_esquerda=Integer.parseInt(stack.pop());
					String result = Integer.toString(num_esquerda-num_direita);
					stack.push(result);
				}
				else{
					stack.push(letra_atual);
				}   
	        }
			System.out.println(stack.pop());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
