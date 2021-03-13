package main;

public class Stack
{
    private String[] elemento;
    private int      tamanhoInicial;
    private int      ultimo = -1; 
    
    // Classe Construtora Padrao
    public Stack()
    {
        this.elemento       = new String [10];
        this.tamanhoInicial = 10;
    }
    
    public Stack (int tamanho) throws Exception
    {
        if (tamanho<=0)
            throw new Exception ("O Tamanho deve ser maior que 0!");
            
        this.elemento       = new String [tamanho];
        this.tamanhoInicial = tamanho;
    }
    
    public int getQuantidade ()
    {
        return this.ultimo+1;
    }
    
    private void redimensioneSe (float fator)
    {
        String[] novo = new String [Math.round(this.elemento.length*fator)];
        
        for(int i=0; i<=this.ultimo; i++)
            novo[i] = this.elemento[i];

        this.elemento = novo;
    }
    
    public void guardeUmItem (String valor) throws Exception //Push
    {
        if (valor==null)
            throw new Exception ("Não é possivel andar! Retorne!");
        
        if (this.ultimo+1==this.elemento.length) // cheia
            this.redimensioneSe (2.0F);
            
        this.ultimo++;
        this.elemento[this.ultimo] = valor;
    }

    public String recupereUmItem () throws Exception //Top
    {
        if (this.ultimo==-1)
            throw new Exception ("Vazio!");
            
        return this.elemento[this.ultimo];
    }
    
    public void removaUmItem () throws Exception //Pop
    {
        if (this.ultimo==-1)
            throw new Exception ("Não há mais elementos para destacar");
            
        this.elemento[this.ultimo] = null;
        this.ultimo--;
        
        if (this.elemento.length>this.tamanhoInicial &&
            this.ultimo+1<=Math.round(this.elemento.length*0.25F))
            this.redimensioneSe (0.5F);
    }
    
    public boolean isVazia ()
    {
        return this.ultimo==-1;
    }
    
    public boolean isCheia ()
    {
        return this.ultimo==this.elemento.length-1;
    }
    
    @Override
    public String toString ()
    {
        String ret;
        
        if (this.ultimo==0)
            ret="1 elemento";
        else
            ret=(this.ultimo+1)+" elementos";
            
        if (this.ultimo!=-1)
            ret += ", sendo o ultimo "+this.elemento[this.ultimo];
        
        return ret;
    }
}