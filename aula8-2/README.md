# Overcharging Methods

## Different Signatures
In this case, the signature of a method is represented by the number of parameters and by the type of the parameters.

```java
public class Date{
    private int day, month, year;

    public void changeDate(int d){
        this.day = d;
    }

    public void changeDate(int d, int m){
        this.day = d;
        this.month = m;
    }

    public void changeDate(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }
}
```
```java
    Date d = new Date();
    d.changeDate(31);
    d.changeDate(31,12);
    d.changeDate(31,12,1969);
```