import java.util.Random;

// package exercise2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber(double r, double i){
        this.real = r;
        this.imaginary = i;
    }

    // public void initializeNumber(){
    // }
    public void printNumber(){
        if(this.imaginary>=0){
            System.out.printf("%.2f + %.2fi\n", real, imaginary);
        } 
        else{
            System.out.printf("%.2f - %.2fi\n", real, imaginary*(-1));
        }
    }

    public boolean isEqual(ComplexNumber n){
        if(n.real == this.real){
            if(n.imaginary == this.imaginary){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public ComplexNumber sumComplex(ComplexNumber n){
        double rSum = (this.real + n.real);
        double iSum = (this.imaginary + n.imaginary);
        ComplexNumber sumNumber = new ComplexNumber(rSum, iSum);
        return sumNumber;
    }

    public ComplexNumber subtractComplex(ComplexNumber n){
        double rSubs = (this.real - n.real);
        double iSubs = (this.imaginary - n.imaginary);
        ComplexNumber substraction = new ComplexNumber(rSubs, iSubs);
        return substraction;
    }

    public ComplexNumber multiplyComplex(ComplexNumber n){
        double rMult = ((this.real*n.real) - (this.imaginary*n.imaginary));
        double iMult = ((this.real*n.imaginary) + (this.imaginary*n.real));
        ComplexNumber product = new ComplexNumber(rMult, iMult);
        return product;
    }

    //errado
    public ComplexNumber divideComplex(ComplexNumber n){
        double a = this.real;
        double b = this.imaginary;
        double c = n.real;
        double d = n.imaginary;
        double rDiv = ((a*c) + (b*d))/((c*c) + (d*d));
        double iDiv = ((b*c) - (a*d))/((c*c) + (d*d));
        ComplexNumber division = new ComplexNumber(rDiv, iDiv);
        return division;
    }

}

class DemoComplexNumber{
    public static void main(String[] args){
        Random r = new Random();
        ComplexNumber cNum1 = new ComplexNumber(r.nextInt(10), r.nextInt(10)+1);
        ComplexNumber cNum2 = new ComplexNumber(r.nextInt(10)+1,r.nextInt(10)+1);
        ComplexNumber sum = cNum1.sumComplex(cNum2);
        ComplexNumber substraction = cNum1.subtractComplex(cNum2);
        ComplexNumber product = cNum1.multiplyComplex(cNum2);
        ComplexNumber division = cNum1.divideComplex(cNum2);

        cNum1.printNumber();
        cNum2.printNumber();
        sum.printNumber();
        substraction.printNumber();
        product.printNumber();
        division.printNumber();

    }
}
