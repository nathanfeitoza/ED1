/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursinho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author root
 */
public final class Validacoes {
    
    public boolean validarNumero(String num)
    {
        boolean num_valido = true;
        try{
             Long.parseLong(num);
        }catch(NumberFormatException e){
            num_valido = false;
        }

        return num_valido;
    }

}
