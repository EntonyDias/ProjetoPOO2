/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlee;

public class SwitchSemBreak {

    public static void main(String[] args) {
        String faixa = "preto";
        
        System.out.println(" Digite qual a cor da sua faixa: ");
        
        switch (faixa.toLowerCase()) {
            case "preta":
                System.out.println("Sei fazer o 'Bassai-Dai/Jion/Kanku-Dai'");
            case "marrom":
                System.out.println("Sei fazer o 'Tekki Shodan'");
            case "roxa":
                System.out.println("Sei fazer o 'Heian Godan'");
            case "verde":
                System.out.println("Sei fazer o 'Heian Yodan'");
            case "laranja":
                System.out.println("Sei fazer o 'Heian Sandan'");
            case "vermelha":
                System.out.println("Sei fazer o 'Heian Nidan'");
            case "amarela":
                System.out.println("Sei fazer o 'Heian Shodan'");
            default:
                System.out.println("Não sei nada");
        }
    }
}