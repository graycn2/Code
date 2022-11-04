package Hero;

public class Main {
    public static void main(String[] args) {
        HeroBeen h1=new HeroBeen(1,new Gun(80));
        HeroBeen h2=new HeroBeen(2,new Knife(40));
        h1.ballter(h2,150);
    }
}
