package exercise4;

public class Rational {
    private int numerator;
    private int denominator;


    public Rational(int n, int d){
        for(int i = 0; i<10; i++){
            if(n%i == 0 && d%i==0){
                n = n/i;
                d = d/i;
            }
            if(i>n || i>d){
                break;
            }
        }
        this.numerator = n;
        this.denominator = d;
    }

    
}
