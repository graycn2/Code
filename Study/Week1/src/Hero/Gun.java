package Hero;

public class Gun implements Arms{
    private int hurt;

    public Gun(int hurt) {
        this.hurt = hurt;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public Gun() {
    }

    @Override
    public void attack(HeroBeen heroBeen) {
        heroBeen.setLife(heroBeen.getLife()-getHurt());
    }
}
