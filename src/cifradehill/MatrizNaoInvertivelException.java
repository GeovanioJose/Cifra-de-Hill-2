/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradehill;

/**
 *
 * @author Geovânio José da Silva & José João Mario Araújo
 */
public class MatrizNaoInvertivelException extends Exception{
    public MatrizNaoInvertivelException(){
        super("");
    }
    public MatrizNaoInvertivelException(String message){
        super(message);
    }
}
