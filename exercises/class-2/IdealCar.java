public class IdealCar{
    private float speed;

    public void setSpeed(float s){
        if(s <= 200) speed = s;
        else speed = 0;
    }

    public void gas(float s){
        if((speed+s)<=200) speed +=s;
        else speed = 200;
    }
}