/**
 * Classe que modela a criptográfia e a descriptográfia de uma mensagem 
 * fornecida pelo usuário.
 */

package cifradehill;

import java.util.ArrayList;
import java.util.Scanner; 
/** 
 * @author Geovânio José & José João Mário
 */
public class CriptografiaMatriz {
    private ArrayList array;
    private String frase;//Frase que deverá ser ciptografada
    private int vetor[]; //Vetor de números inteiro que correspondem a letras da frase 
    private int tamanhoVetor;//Corresponde ao tamanho da frase
    private int[] vetorComResultados; //É o produto do vetor pela matriz fornecida pelo usuario 
    private final int [][] matriz;//Representa a matriz que será fornecida pelo usuário
    private final int[][] matrizInversa;//Matriz inversa da que foi fornecida pelo usuário
    private int detInverso;
    public static CriptografiaMatriz instancia;
    
    /**
     * Construtor da Classe.  
     */
    public CriptografiaMatriz(){
        array = new ArrayList();
        matriz =new int [2][2];
        matrizInversa= new int [2][2];
        frase=null;
        tamanhoVetor=0;
        detInverso=0;
    }
    
    /**Esse método Método que utiliza a Classe Scanner para leitura dos números que 
     * o usuário fornecerá para a cria uma matriz 2x2. Acondição de ser uma matriz
     * invertivel não é testada nesse método.
     * @return uma matriz
     */
    public int[][] matriz() { 
        for(int linha=0; linha < 2; linha++){
            for(int coluna=0; coluna < 2; coluna++){
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite o valor["+linha+"]["+coluna+"] para a matriz:");
                matriz[linha][coluna] = sc.nextInt();
            }  
        }
        return matriz;
    }

    public void TestarMatriz()throws MatrizNaoInvertivelException{
        if((matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0])==0){
            throw new MatrizNaoInvertivelException("A matriz passada não é invertível, ou seja, não há como efetuar a descriptográfia.\n"); 
        } 
    }
    
    /**Método que utiliza a Classe Scanner para leitura dos dados passados pelo
     * teclado, ou seja, a frase forncida pelo usuário que deverá ser criptografada.
     * O método possui retorno do tipo void (não é retornado nenhuma informação).
     */
    public void CodificarFrase(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a frase:");
        frase = (sc.nextLine()); 
        char[] frase1 = frase.toCharArray(); //transforma a frase em um vetor de caracteres
        vetor = new int[frase1.length]; 
        for(int i = 0; i<frase1.length; i++){
        //cada letra do vetor de caractere será associada a um número no vetor de inteiro  
        switch (frase1[i]) { 
            case 'a':
                vetor[i] = 1;
                break;
            case 'b':
                vetor[i] = 2;
                break;
            case 'c':
                vetor[i] = 3;
                break;
            case 'd':
                vetor[i] = 4;
                break;
            case 'e':
                vetor[i] = 5;
                break;
            case 'f':
                vetor[i] = 6;
                break;
            case 'g':
                vetor[i] = 7;
                break;
            case 'h':
                vetor[i] = 8;
                break;
            case 'i':
                vetor[i] = 9;
                break;
            case 'j':
                vetor[i] = 10;
                break;
            case 'k':
                vetor[i] = 11;
                break;
            case 'l':
                vetor[i] = 12;
                break;
            case 'm':
                vetor[i] = 13;
                break;
            case 'n':
                vetor[i] = 14;
                break;
            case 'o':
                vetor[i] = 15;
                break;
            case 'p':
                vetor[i] = 16;
                break;
            case 'q':
                vetor[i] = 17;
                break;
            case 'r':
                vetor[i] = 18;
                break;
            case 's':
                vetor[i] = 19;
                break;
            case 't':
                vetor[i] = 20;
                break;
            case 'u':
                vetor[i] = 21;
                break;
            case 'v':
                vetor[i] = 22;
                break;
            case 'w':
                vetor[i] = 23;
                break;
            case 'x':
                vetor[i] = 24;
                break;
            case 'y':
                vetor[i] = 25;
                break;
            case 'z':
                vetor[i] = 0;
                break;
            case ' ':
                vetor[i] = 26;
                break;
            case '?':
                vetor[i] = 27;    
            default:
                break;
            }
        }
    }
    
    /**Esse método utiliza um vetor de inteiros criado pela codificação
     * da frase. Será criada uma matrizResultado 2x1 que receberá o resultado da 
     * multiplicação dos pares de números do vetor e pela matriz passada pelo usuário.
     * Depois, convertemos cada matrizResultado em seu equivalente alfabético.
     */
    public void criptografar(){
        int matrizResultado [] [] = new int [2] [1];
        int tamanho = vetor.length;
    //analisa se o tamanho da frase é par
        if((tamanho)%2 == 0){ 
            vetorComResultados = new int[tamanho];
        for(int i = 0; i<tamanho ; i=i+2){ 
    //A multiplicação do vetor pela matriz fornecida pelo usuario 
            matrizResultado[0][0] = (matriz[0][0] * vetor[i]) + (matriz[0][1] * vetor[i+1]); 
            matrizResultado[1][0] = (matriz[1][0] * vetor[i]) + (matriz[1][1] * vetor[i+1]); 
    //anasila se o valor do indice é maior d que 27 e faz a conversão pelo resto da divisão por 28
        if(matrizResultado[0][0] > 27){
           matrizResultado[0][0] = matrizResultado[0][0] % 28; 
        }if(matrizResultado[0][0] < 0 && matrizResultado[0][0] > -29){
            matrizResultado[0][0] = matrizResultado[0][0] + 28;
        }
        if(matrizResultado[0][0] < -27){
            matrizResultado[0][0] = 28 - (Math.abs(matrizResultado[0][0])%28);
        }   
        if(matrizResultado[1][0] > 27){
            matrizResultado[1][0] = matrizResultado[1][0] % 28; 
        }if(matrizResultado[1][0] < 0 && matrizResultado[1][0] > -29){
            matrizResultado[1][0] = matrizResultado[1][0] + 28; 
        }if(matrizResultado[1][0] < -27){
            matrizResultado[1][0] = 28 - (Math.abs(matrizResultado[1][0])%28);
        }
        array.add((matrizResultado[0][0]));
        array.add((matrizResultado[1][0]));
        vetorComResultados[i] = matrizResultado[0][0];
        vetorComResultados[i+1] = matrizResultado[1][0];
    /**É efetuada a conversão dos vetores cifrados em seus correspondentes 
    *  alfabéticos. Como está sendo usado pares vetores, analisamos se o tamanho
    *  da frase é par, pois caso contrario será incrementado uma unidade ao tamanho
    *  do vetor.
    */
    if(tamanho - 2 == i){
        for(int j = 0; j<2;j++){
         switch (matrizResultado[j][0]) {
             case 1:
                 System.out.print("a");
                 break;
             case 2:
                 System.out.print("b");
                 break;
             case 3:
                 System.out.print("c");
                 break;
             case 4:
                 System.out.print("d");
                 break;
             case 5:
                 System.out.print("e");
                 break;
             case 6:
                 System.out.print("f");
                 break;
             case 7:
                 System.out.print("g");
                 break;
             case 8:
                 System.out.print("h");
                 break;
             case 9:
                 System.out.print("i");
                 break;
             case 10:
                 System.out.print("j");
                 break;
             case 11:
                 System.out.print("k");
                 break;
             case 12:
                 System.out.print("l");
                 break;
             case 13:
                 System.out.print("m");
                 break;
             case 14:
                 System.out.print("n");
                 break;
             case 15:
                 System.out.print("o");
                 break;
             case 16:
                 System.out.print("p");
                 break;
             case 17:
                 System.out.print("q");
                 break;
             case 18:
                 System.out.print("r");
                 break;
             case 19:
                 System.out.print("s");
                 break;
             case 20:
                 System.out.print("t");
                 break;
             case 21:
                 System.out.print("u");
                 break;
             case 22:
                 System.out.print("v");
                 break;
             case 23:
                 System.out.print("w");
                 break;
             case 24:
                 System.out.print("x");
                 break;
             case 25:
                 System.out.print("y");
                 break;
             case 0:
                 System.out.print("z");
                 break;
             case 26:
                 System.out.print(" ");
                 break;
             case 27:
                 System.out.print("?");
                 break;
             default:
                 break;
                }
            }
        }
    }  
    }else{
        int vetor1[] = new int[vetor.length+1];
        vetorComResultados = new int[vetor1.length];
        for(int i = 0; i<vetor1.length; i++){
            if(i < vetor.length){
                 vetor1[i] = vetor[i];
            }else{
                vetor1[i] = vetor[i-1];
            }
        }for(int l = 0; l<(vetor1.length) ; l=l+2){
            matrizResultado[0][0] = (matriz[0][0] * vetor1[l]) + (matriz[0][1] * vetor1[l+1]); 
            matrizResultado[1][0] = (matriz[1][0] * vetor1[l]) + (matriz[1][1] * vetor1[l+1]); 
            if(matrizResultado[0][0] > 27){
                matrizResultado[0][0] = matrizResultado[0][0] % 28; 
            }if(matrizResultado[0][0] < 0 && matrizResultado[0][0] > -29){
                matrizResultado[0][0] = matrizResultado[0][0] + 28;
            }if(matrizResultado[0][0] < -27){
                matrizResultado[0][0] = 28 - (Math.abs(matrizResultado[0][0])%28);
            }if(matrizResultado[1][0] > 27){
                matrizResultado[1][0] = matrizResultado[1][0] % 28; 
            }if(matrizResultado[1][0] < 0 && matrizResultado[1][0] > -29){
                matrizResultado[1][0] = matrizResultado[1][0] + 28; 
            }if(matrizResultado[1][0] < -27){
            matrizResultado[1][0] = 28 - (Math.abs(matrizResultado[1][0])%28);
            }
        array.add((matrizResultado[0][0]));
        array.add(matrizResultado[1][0]);
        vetorComResultados[l] = matrizResultado[0][0];
        vetorComResultados[l+1] = matrizResultado[1][0];
        
    if(vetor1.length - 2 == l){
        for(int j = 0; j<2;j++){
            switch (matrizResultado[j][0]) {
             case 1:
                 System.out.print("a");
                 break;
             case 2:
                 System.out.print("b");
                 break;
             case 3:
                 System.out.print("c");
                 break;
             case 4:
                 System.out.print("d");
                 break;
             case 5:
                 System.out.print("e");
                 break;
             case 6:
                 System.out.print("f");
                 break;
             case 7:
                 System.out.print("g");
                 break;
             case 8:
                 System.out.print("h");
                 break;
             case 9:
                 System.out.print("i");
                 break;
             case 10:
                 System.out.print("j");
                 break;
             case 11:
                 System.out.print("k");
                 break;
             case 12:
                 System.out.print("l");
                 break;
             case 13:
                 System.out.print("m");
                 break;
             case 14:
                 System.out.print("n");
                 break;
             case 15:
                 System.out.print("o");
                 break;
             case 16:
                 System.out.print("p");
                 break;
             case 17:
                 System.out.print("q");
                 break;
             case 18:
                 System.out.print("r");
                 break;
             case 19:
                 System.out.print("s");
                 break;
             case 20:
                 System.out.print("t");
                 break;
             case 21:
                 System.out.print("u");
                 break;
             case 22:
                 System.out.print("v");
                 break;
             case 23:
                 System.out.print("w");
                 break;
             case 24:
                 System.out.print("x");
                 break;
             case 25:
                 System.out.print("y");
                 break;
             case 0:
                 System.out.print("z");
                 break;
             case 26:
                 System.out.print(" ");
                 break;
             case 27:
                 System.out.print("?");
                 break;
             default:
                 break;
                }
           }
        }else{
        for(int j = 0; j<2;j++){
            switch (matrizResultado[j][0]) {
                case 1:
                    System.out.print("a");
                    break;
                case 2:
                    System.out.print("b");
                    break;
                case 3:
                    System.out.print("c");
                    break;
                case 4:
                    System.out.print("d");
                    break;
                case 5:
                    System.out.print("e");
                    break;
                case 6:
                    System.out.print("f");
                    break;
                case 7:
                    System.out.print("g");
                    break;
                case 8:
                    System.out.print("h");
                    break;
                case 9:
                    System.out.print("i");
                    break;
                case 10:
                    System.out.print("j");
                    break;
                case 11:
                    System.out.print("k");
                    break;
                case 12:
                    System.out.print("l");
                    break;
                case 13:
                    System.out.print("m");
                    break;
                case 14:
                    System.out.print("n");
                    break;
                case 15:
                    System.out.print("o");
                    break;
                case 16:
                    System.out.print("p");
                    break;
                case 17:
                    System.out.print("q");
                    break;
                case 18:
                    System.out.print("r");
                    break;
                case 19:
                    System.out.print("s");
                    break;
                case 20:
                    System.out.print("t");
                    break;
                case 21:
                    System.out.print("u");
                    break;
                case 22:
                    System.out.print("v");
                    break;
                case 23:
                    System.out.print("w");
                    break;
                case 24:
                    System.out.print("x");
                    break;
                case 25:
                    System.out.print("y");
                    break;
                case 0:
                    System.out.print("z");
                    break;
                case 26:
                    System.out.print(" ");
                    break;
                case 27:
                    System.out.print("?");
                break;    
                default:
                    break;
                }
            }
        }
    }            
}
}

    /**
     *
     * @return a matriz inversa (caso possível) da qual o usuário forneceu
     */
    public int [][] matrizinversa(){
        int asd;  
        int det =  (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        if(det<0){
            asd = 28 + det;
        }else{
            asd = 28 - det;
        }for(int q = 0; q<9999; q++){
            int x = q;
            int mult = asd * x;
            if(mult % 28 ==1){
               detInverso = q;
            break;
            }
        }
        matrizInversa[0][0] = (matriz[1][1])*detInverso;
        matrizInversa[0][1] = -(matriz[0][1])*detInverso;
        matrizInversa[1][0] = -(matriz[1][0])*detInverso;
        matrizInversa[1][1] = (matriz[0][0])*detInverso;
    
    for(int linha=0; linha < matrizInversa.length; linha++){
            for(int coluna=0; coluna < matrizInversa[0].length; coluna++){               
                if((matrizInversa[linha][coluna]) > 28){
                    matrizInversa[linha][coluna] = matrizInversa[linha][coluna] % 28;
                }else if(matrizInversa[linha][coluna] < 0){
                    matrizInversa[linha][coluna] = matrizInversa[linha][coluna] % 28;
                    matrizInversa[linha][coluna] = 28 - Math.abs(matrizInversa[linha][coluna]);
                }   
            }
       }return matrizInversa;
    }
    
    /**Esse método fornece a funcionalidade inversa do método criptografar, pois
     * é proveitoso qu aja uma forma de recuperar a informação. O pocesso consiste
     * em utilizar a matriz inversa da matriz que foi fornecida pelo usuario. 
     */
    public void descriptografar(){
    int[][] matrizresultado = new int[2][1];
     if(vetorComResultados.length % 2 ==0){
    for(int linha=0; linha < vetorComResultados.length; linha = linha + 2){
            matrizresultado[0][0] =  matrizInversa[0][0] * vetorComResultados[linha] + matrizInversa[0][1]* vetorComResultados[linha +1];
            matrizresultado[1][0] =  ((matrizInversa[1][0]*vetorComResultados[linha]) + (matrizInversa[1][1] * vetorComResultados[linha+1]));
        if(matrizresultado[0][0] > 27){
        matrizresultado[0][0] = matrizresultado[0][0] % 28;
        }if(matrizresultado[1][0] > 27){
        matrizresultado[1][0] = matrizresultado[1][0] % 28; 
       
    }
     for(int j = 0; j<2;j++){
                switch (matrizresultado[j][0]) {
                    case 1:
                        System.out.println("a");
                        break;
                    case 2:
                        System.out.println("b");
                        break;
                    case 3:
                        System.out.println("c");
                        break;
                    case 4:
                        System.out.println("d");
                        break;
                    case 5:
                        System.out.println("e");
                        break;
                    case 6:
                        System.out.println("f");
                        break;
                    case 7:
                        System.out.println("g");
                        break;
                    case 8:
                        System.out.println("h");
                        break;
                    case 9:
                        System.out.println("i");
                        break;
                    case 10:
                        System.out.println("j");
                        break;
                    case 11:
                        System.out.println("k");
                        break;
                    case 12:
                        System.out.println("l");
                        break;
                    case 13:
                        System.out.println("m");
                        break;
                    case 14:
                        System.out.println("n");
                        break;
                    case 15:
                        System.out.println("o");
                        break;
                    case 16:
                        System.out.println("p");
                        break;
                    case 17:
                        System.out.println("q");
                        break;
                    case 18:
                        System.out.println("r");
                        break;
                    case 19:
                        System.out.println("s");
                        break;
                    case 20:
                        System.out.println("t");
                        break;
                    case 21:
                        System.out.println("u");
                        break;
                    case 22:
                        System.out.println("v");
                        break;
                    case 23:
                        System.out.println("w");
                        break;
                    case 24:
                        System.out.println("x");
                        break;
                    case 25:
                        System.out.println("y");
                        break;
                    case 0:
                        System.out.println("z");
                        break;
                    case 26:
                        System.out.println(" ");
                        break;
                    case 27:
                        System.out.println("?");
                        break;
                    default:
                        break;
                    }
                }
            }
        }else{
            int vetor1[] = new int[vetorComResultados.length-1];
            for(int linha=0; linha < vetor1.length; linha = linha + 2){
             
            matrizresultado[0][0] =  matrizInversa[0][0] * vetorComResultados[linha] + matrizInversa[0][1]* vetorComResultados[linha +1];
            matrizresultado[1][0] =  ((matrizInversa[1][0]*vetorComResultados[linha]) + (matrizInversa[1][1] * vetorComResultados[linha+1]));
           
            if(matrizresultado[0][0] > 27){
                matrizresultado[0][0] = matrizresultado[0][0] % 28;
            }if(matrizresultado[1][0] > 27){
                 matrizresultado[1][0] = matrizresultado[1][0] % 28; 
            }
            for(int j = 0; j<2;j++){
                switch (matrizresultado[j][0]) {
                    case 1:
                        System.out.println("a");
                        break;
                    case 2:
                        System.out.println("b");
                        break;
                    case 3:
                        System.out.println("c");
                        break;
                    case 4:
                        System.out.println("d");
                        break;
                    case 5:
                        System.out.println("e");
                        break;
                    case 6:
                        System.out.println("f");
                        break;
                    case 7:
                        System.out.println("g");
                        break;
                    case 8:
                        System.out.println("h");
                        break;
                    case 9:
                        System.out.println("i");
                        break;
                    case 10:
                        System.out.println("j");
                        break;
                    case 11:
                        System.out.println("k");
                        break;
                    case 12:
                        System.out.println("l");
                        break;
                    case 13:
                        System.out.println("m");
                        break;
                    case 14:
                        System.out.println("n");
                        break;
                    case 15:
                        System.out.println("o");
                        break;
                    case 16:
                        System.out.println("p");
                        break;
                    case 17:
                        System.out.println("q");
                        break;
                    case 18:
                        System.out.println("r");
                        break;
                    case 19:
                        System.out.println("s");
                        break;
                    case 20:
                        System.out.println("t");
                        break;
                    case 21:
                        System.out.println("u");
                        break;
                    case 22:
                        System.out.println("v");
                        break;
                    case 23:
                        System.out.println("w");
                        break;
                    case 24:
                        System.out.println("x");
                        break;
                    case 25:
                        System.out.println("y");
                        break;
                    case 0:
                        System.out.println("z");
                        break;
                    case 26:
                        System.out.println(" ");
                        break;
                    case 27:
                        System.out.println("?");
                        break;
                    default:
                        break;
                    }
                } 
            }
        }
    }
    
    public static CriptografiaMatriz getInstance(){
        if (instancia == null){
            instancia = new CriptografiaMatriz();
        }
        return instancia;
    }
}