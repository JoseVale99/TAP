
package alimentos;

public class Alimentos {
    
    private String alimento;
    private int tipo;
    
    public Alimentos(String alimento, int tipo){
    this.alimento=alimento;
    this.tipo=tipo;
    
    }
    public int GetTipo(){
    
    return tipo;
    }
    public String GetAlimento(){
    
    return alimento;
    }
    
    @Override
    public String toString(){
    return alimento;
    }
    public boolean equals(Alimentos ali){
    return alimento.equals(ali.alimento)&& tipo== ali.tipo;
    }
}

