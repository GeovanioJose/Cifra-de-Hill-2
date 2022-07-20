/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradehill;

import UI_Console.Console;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Geovânio José da Silva & José João Mario Araújo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int escolha=-1;
        int escolha2;
        Console Tela=new Console();
        Scanner Scan = new Scanner(System.in); 
       
        while(escolha!=0){
            escolha = Tela.TelaPrincipal();
            switch(escolha){
            case 1:{
                //Esse laço faz com que na sugunda chamada do método seja informado
                //se o usuário deseja reutilizar a matriz ou deseja inserir uma nova
                for(int i=0;i<2;i++){ 
                    if(i==0){
                        CriptografiaMatriz.getInstance().matriz();
                        try {
                            CriptografiaMatriz.getInstance().TestarMatriz();
                        } catch (MatrizNaoInvertivelException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "A matriz fornecida não é invertível! logo não poderá ser feita a descriptografia.", ex);
                        }
                        CriptografiaMatriz.getInstance().CodificarFrase();
                        CriptografiaMatriz.getInstance().criptografar();
                        System.out.println("");
                        break;
                    }else{
                        System.out.println("===== VOCÊ DESEJA REUTILIZAR A MATRIZ FORNECIDA? =====");
                        System.out.println("== 1 -- SIM \n== 2 -- NÃO\n");
                        escolha2 = Scan.nextInt();
                        if(escolha2 == 1){
                            CriptografiaMatriz.getInstance().CodificarFrase();
                            CriptografiaMatriz.getInstance().criptografar();
                            System.out.println("");
                        }else{
                            CriptografiaMatriz.getInstance().matriz();
                            try {
                               CriptografiaMatriz.getInstance().TestarMatriz();
                            } catch (MatrizNaoInvertivelException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "A matriz fornecida não é invertível! logo não poderá ser feita a descriptografia.", ex);
                            }
                            CriptografiaMatriz.getInstance().CodificarFrase();
                            CriptografiaMatriz.getInstance().criptografar(); 
                            System.out.println("");
                        }
                    }
                }
                break;
            } 
            case 2:{
                System.out.println("===== VOCÊ DESEJA REUTILIZAR A MATRIZ FORNECIDA? =====");
                System.out.println("== 1 -- SIM \n== 2 -- NÃO\n");
                int escolha3;
                escolha3 = Scan.nextInt();
                if(escolha3==1){
                    CriptografiaMatriz.getInstance().CodificarFrase();
                    CriptografiaMatriz.getInstance().matrizinversa();
                    CriptografiaMatriz.getInstance().descriptografar();
                    System.out.println("");                   
                }else{
                    CriptografiaMatriz.getInstance().matriz();
                    try {
                        CriptografiaMatriz.getInstance().TestarMatriz();
                    } catch (MatrizNaoInvertivelException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CriptografiaMatriz.getInstance().CodificarFrase();
                    CriptografiaMatriz.getInstance().matrizinversa();
                    CriptografiaMatriz.getInstance().descriptografar();
                    System.out.println("");      
                    }
                break;
                }
            case 3:{
                System.out.println("==========PROJETO CIFRA DE HILL===============");
                System.out.println("");
                System.out.println("=============Álgebra Linear===================\n");
                System.out.println("== Desenvolvido pelos alunos do Curso de BCC =\n");
                System.out.println("-- Geovânio José da Silva");
                System.out.println("-- José João Mario Araújo de Andrade\n");
                System.out.println("== Professor Orientador ==");
                System.out.println("       Murilo Chavedar     \n");
                System.out.println("                  2016.2                 ");
                System.out.println("==============================================\n");
                break;    
                }
            case 4:{
                System.out.println("======================     PROJETO CIFRA DE HILL    ===================");
                System.out.println("======================          Versão 1.0          ===================");
                System.out.println("");
                System.out.println("Criada por Lester S. Hill em 1929, a Cifra de Hill e um tipo de cifra de\n" +
                "substituição, em bloco, baseada em álgebra linear e aritmética modular, que\n" +
                "não é vulnerável à análise de frequência das letras do alfabeto, porém pode\n" + 
                "ser quebrada utilizando recursos da própria álgebra linear.\n");
                System.out.println("==============================================\n");
                break;
            }
            case 0:{
                System.out.println("========== VOCê DESEJA REALMENTE SAIR ? ======");
                System.out.println("== 1 -- SIM \n== 2 -- NÃO\n");
                System.out.println("==============================================");
                int escolha4;
                escolha4 = Scan.nextInt();
                if(escolha4==1){
                    System.out.print("Obrigado por usar o Projeto Cifra de Hill!\n");
                    break;
                }else{
                    Tela.TelaPrincipal();
                }
                }       
            }
        }
    }
}


