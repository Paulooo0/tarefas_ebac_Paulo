/**
 * The Dog class represents a dog and has properties such as breed, sex, age, and color.
 * <br></br>
 * A classe Dog representa um cachorro e possui propriedades como raça, sexo, idade e cor.
 * <ul>
 * <li>@author Paulo H. Nunes</li>
 * <li>@version 1.0</li>
 * <li>@since 1.0</li>
 */

public class Dog {
    private String breed;
    private String sex;
    private int age;
    private String color;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}