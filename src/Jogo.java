import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		String palavracorreta = "android";
		Scanner s = new Scanner(System.in);
		String chute;
		
		StringBuffer palavraTemp = trocaLetras(palavracorreta);
		
		System.out.println("Palavra: " + palavraTemp +"\nDigite uma letra:");
		chute = s.nextLine();
	}
	
	public static StringBuffer trocaLetras(String palavra){
		StringBuffer trocada = new StringBuffer();
		
		for (int i = 0; i < palavra.length(); i++) {
			trocada.insert(i, "*");
		}
		
		return trocada;
	}
	
	public static boolean procuraLetra(String palavra, String chute){
		int count = 0;
		
		for (int i = 0; i < palavra.length(); i++) {
			if (chute.equals(palavra.charAt(i))) {
				count++;
			}
		}
		
		if (count > 0) {
			return true;
		}
		else{
			return false;
		}
	}
}
