public class Main {
    public static void main(String[] args){
        Dog dog = new Dog();

        dog.setBreed("labrador");
        dog.setSex("masculino");
        dog.setAge(5);
        dog.setColor("preto");

        System.out.println("Raça: " + dog.getBreed() +
        "\nSexo: " + dog.getSex() +
        "\nIdade: " + dog.getAge() +
        "\nCor: " + dog.getColor());
    }
}
