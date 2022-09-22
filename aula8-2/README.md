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

# `this`

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

# Static class members: `static`

## Non-static attributes

Each instance of the class will have a distinct copy of this attribute

`Cellphone.java`

```java
public class Cellphone{
    private int total;

    public Cellphone(){
        this.total = this.total+1;
    }

    public void increment(){
        this.total = this.total+1;
    }

    public int getTotal(){
        return this.total;
    }
}
```
`UseNonStaticCellphone.java`
```java
    Cellphone a = new Cellphone();
    Cellphone b = new Cellphone();
    a.increment();
    b.increment();

    System.out.println(a.getTotal());// 2
    System.out.println(b.getTotal());// 2
```

## Static attributes

Stay common for all objects that had been instantiated for this class, being so called "class attributes"
- It is not possible to use `this` to access a static member. Instead, it is supposed to use the Class' name.
<br>

Classes can possess static methods which can be invocated without needing the class to be instantiated.
- Static methods usually are used to access static attibutes.


`StaticCellphone.java`
```java
public class StaticCellphone {
    private static int total;
    private int serial;

    public StaticCellphone(int s){
        this.serial = s;
        StaticCellphone.total = StaticCellphone.total+1;
    }

    public static int getTotal() {
        return StaticCellphone.total;
    }

    public int getSerial(){
        return this.serial;
    }
}
```

``
```java
    System.out.println(StaticCellphone.getTotal());//0
    StaticCellphone c = new StaticCellphone(123);
    StaticCellphone d = new StaticCellphone(456);

    System.out.println(StaticCellphone.getTotal());//2
    System.out.println(d.getSerial());//456
```
