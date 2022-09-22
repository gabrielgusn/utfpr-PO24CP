public class NonStaticCellphone{
    private int total; 
    
    public NonStaticCellphone(){
        this.total = this.total+1;
    }

    public void increment(){
        this.total = this.total+1;
    }
    
    public int getTotal(){
        return this.total;
    }
}