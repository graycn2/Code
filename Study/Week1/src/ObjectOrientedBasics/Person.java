package ObjectOrientedBasics;

public class Person {
    protected String name;
    protected int age;
    public static int num=0;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        num++;
    }

    public Person() {
    }

    public int getCount(){
        return num;
    }
    public void setName(String name1,String name2) {
        this.name = name1+name2;
    }
}
