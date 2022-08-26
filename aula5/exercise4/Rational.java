package exercise4;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public Rational(int n, int d){
        int[] auxArr = reduct(n, d); 
        this.numerator = auxArr[0];
        this.denominator = auxArr[1];
    }

    private int[] reduct(int n, int d){
        for(int i = 0; i<10; i++){
            if(n%i == 0 && d%i==0){
                n = n/i;
                d = d/i;
            }
            if(i>n || i>d){
                break;
            }
        }
        int[] arr = new int[2];
        arr[0] = n;
        arr[1] = d;

        return arr;
    }

    public Rational sumRational(Rational r){
        int nSum = 0;
        int dSum = 0;
        int thisDenominator = this.numerator;
        int rDenominator = r.denominator;
        int[] divisors1 = new int[20]; 
        if(this.denominator == r.denominator){
            nSum = this.numerator + r.numerator;
            dSum = this.denominator;
        }
        else{//CALCULATE THE MMC
            int i = 2;//DIVISOR FOR THE MCC
            int j = 0;// INDEX FOR THE DIVISORS ARRAY
            while(i<9){
                if(thisDenominator % i == 0 && rDenominator % i == 0){
                    thisDenominator = thisDenominator / i;
                    rDenominator = rDenominator/i;
                    divisors1[j] = i;
                    j++;
                }
                else if(thisDenominator % i == 0 && rDenominator % i != 0){
                    thisDenominator = thisDenominator/i;
                    divisors1[j] = i;
                    j++;
                }
                else if(thisDenominator % i != 0 && rDenominator % i == 0){
                    rDenominator = rDenominator/i;
                    divisors1[j] = i;
                    j++;
                }
                else if(thisDenominator % i != 0 && rDenominator % i != 0){
                    i++;
                }
            }
        }
        Rational sum = new Rational(nSum, dSum);
        return sum;
    }


}
