package Hero;

import java.util.Scanner;

public class HeroBeen {
    private String name;
    private int life;
    private int level;
    private Arms arms;
    public HeroBeen() {
        this.life=100;
        this.level=1;
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入英雄的名字：");
        this.name=scan.nextLine();
        print();

    }

    public Arms getArms() {
        return arms;
    }

    public void setArms(Arms arms) {
        this.arms = arms;
    }

    public HeroBeen(int i,Arms arms) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入英雄的名字：");
        this.name=scan.nextLine();
        if(i==1) {
            System.out.println("普通英雄成功创建：");
            this.life=100;
        }
        if(i==2) {
            System.out.println("高级英雄成功创建：");
            this.life=200;
        }
        this.level=1;
        this.arms=arms;
        print();
    }

    public void ballter(HeroBeen hero){
        hero.life-=100;
        System.out.println(hero.name+"受攻击，生命值减少100");
        System.out.println("英雄信息更新：");
        hero.print();

    }

    public void ballter(HeroBeen hero,int n){
        hero.life-=n;
        System.out.println(hero.name+"受攻击，生命值减少100");
        System.out.println("英雄信息更新：");
        hero.print();
    }




    public void print() {
        System.out.println("HeroBeen[" +
                "name:'" + name + '\'' +
                ", life:" + life +
                ", level:" + level +
                ']');
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void show(String name){
        System.out.println("英雄"+"生命值："+getLife()+" 等级："+getLevel());
    }
}
