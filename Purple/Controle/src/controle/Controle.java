/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Scanner;

public class Controle {
    //oi tudo bem?
    public static void main(String[] args){
            Scanner scanner= new Scanner(System.in);
            double somaDasNotas = 0;
            double nota = 0;
            int numeroDeNotas = 0;
    //passando aqui para te avisar
            do {
                nota = scanner.nextDouble();
    //que essa matéria é bem legal
                if (nota <= 10 && nota >= 0) {
                    somaDasNotas += nota;
                    numeroDeNotas++;
                }
            } while(nota != -1);
    //porque vai te fazer pensar um pouco
    scanner.close();
    System.out.printf("A média é %.2f", somaDasNotas / numeroDeNotas);
    }
    //pode ser um pouco dificíl no começo
}
    //mas depois de pegar o jeito é muito legal
