/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodo.Framework;

/**
 *
 * @author falaf
 */
public class PasswordConverterToString {
    //Convertendo Char[] para String
    public static String passwordToString(char[] password){
        String pass = "";
        for(int cha = 0; cha < password.length; cha++){
            pass = pass + password[cha];
        }
        System.out.println(pass);
        return pass;
    }
}
