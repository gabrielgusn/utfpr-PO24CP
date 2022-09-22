# Overcharging Methods

## Different Signaturesg
In this case, the signature of a method is represented by the number of parameters and by the type of the parameters.
 
`Date.java` 
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
`UseDate.java > main` 
```java
    Date d = new Date();
    d.changeDate(31);
    d.changeDate(31,12);
    d.changeDate(31,12,1969);
```

# This
## Explicit Constructor Invocation
`Rectangle.java`
```java
public class Rectangle{
    private int x,y;
    private int width, height;

    public Rectangle(){
        this(0,0,1,1);
    }
    public Rectangle(int width, int height){
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
```