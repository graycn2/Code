package Hero;

public class Knife implements Arms{
    private int hurt;

    public int getHurt() {
        return hurt;
    }

    public Knife() {
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public Knife(int hurt) {
        this.hurt = hurt;
    }

    @Override
    public void attack(HeroBeen heroBeen) {
        heroBeen.setLife(heroBeen.getLife()-getHurt());
    }
}
