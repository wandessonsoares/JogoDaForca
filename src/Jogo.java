import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		String palavracorreta = "android";
		Scanner s = new Scanner(System.in);
		String chute;
		int chances = 3;
		int acertos = 0;
		
		StringBuffer palavraTemp = trocaLetras(palavracorreta);
		
		while(true){
			System.out.println("Palavra: " + palavraTemp +"\nDigite uma letra:");
			chute = s.nextLine();
			
			
			if (temLetra(palavracorreta, chute)) {
				palavraTemp = colocaLetraCerta(palavracorreta, palavraTemp, chute);
				acertos++;
				
				if(acertos == (palavracorreta.length()-1)){
					System.out.println("Parabéns! Você acertou!");
					break;
				}
			}
			else{
				chances--;
				System.out.println("A palavra não tem essa letra! Tente novamente... (chances: " + chances + ")");
				
				if(chances < 1){
					System.out.println("Você perdeu! A palavra certa era: " + palavracorreta);
					break;
				}
			}
			
		}
		
		System.out.println("Fim do jogo.");
	}
	
	public static StringBuffer trocaLetras(String palavra){
		StringBuffer trocada = new StringBuffer();
		
		for (int i = 0; i < palavra.length(); i++) {
			trocada.insert(i, "*");
		}
		
		return trocada;
	}
	
	public static boolean temLetra(String palavra, String chute){
		int count = 0;
		
		for (int i = 0; i < palavra.length(); i++) {
			if (chute.equals(String.valueOf(palavra.charAt(i)))) {
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
	
	public static StringBuffer colocaLetraCerta(String palavracorreta, StringBuffer palavraTemp, String letra){		
		for (int i = 0; i < palavracorreta.length(); i++) {
			if(letra.equals(String.valueOf(palavracorreta.charAt(i)))){
				palavraTemp.deleteCharAt(i);
				palavraTemp.insert(i, letra);
			}
		}
		
		return palavraTemp;
	}
}
