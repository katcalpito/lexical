/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicallina;

/**
 *
 * @author Michael Relacion
 */
public class Token {
    
    private String identifier;
    private String tokenclass;

    public Token(String identifier, String tokenclass) {
        this.identifier = identifier;
        this.tokenclass = tokenclass;
    }
    
     public Token(String tokenclass) {
        this.tokenclass = tokenclass;
    }

    public String getName() {
        return identifier;
    }

    public void setName(String name) {
        this.identifier = name;
    }

    public String getPurpose() {
        return tokenclass;
    }

    public void setPurpose(String purpose) {
        this.tokenclass = purpose;
    }
    
    
    
    
    
    
    
    
    
}
