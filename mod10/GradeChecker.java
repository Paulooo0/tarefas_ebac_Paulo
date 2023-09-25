import java.util.Scanner;

public class GradeChecker {
    public static void main(String[] args){
        checkGrade(getMean(getGrade()));
    }

    public static Double[] getGrade(){
        Double grade1 = 0d;
        do {
            Scanner s1 = new Scanner(System.in);
            System.out.println("Digite a nota 1: ");
            grade1 = s1.nextDouble();
            if (grade1 < 0 || grade1 > 10) {
                System.out.println("Nota inválida, apenas números entre 0 e 10");
            }
        } while (grade1 < 0 || grade1 > 10);

        Double grade2 = 0d;
        do {
            Scanner s2 = new Scanner(System.in);
            System.out.println("Digite a nota 2: ");
            grade2 = s2.nextDouble();
            if (grade2 < 0 || grade2 > 10) {
                System.out.println("Nota inválida, apenas números entre 0 e 10");
            }
        } while (grade2 < 0 || grade2 > 10);

        Double grade3 = 0d;
        do {
            Scanner s3 = new Scanner(System.in);
            System.out.println("Digite a nota 3: ");
            grade3 = s3.nextDouble();
            if (grade3 < 0 || grade3 > 10) {
                System.out.println("Nota inválida, apenas números entre 0 e 10");
            }
        } while (grade3 < 0 || grade3 > 10);

        Double grade4 = 0d;
        do {
            Scanner s4 = new Scanner(System.in);
            System.out.println("Digite a nota 4: ");
            grade4 = s4.nextDouble();
            if (grade4 < 0 || grade4 > 10) {
                System.out.println("Nota inválida, apenas números entre 0 e 10");
            }
        } while (grade4 < 0 || grade4 > 10);

        Double[] grades = {grade1, grade2, grade3, grade4};

        return grades;
    }

    public static Double getMean(Double grades[]){
        Double result = (grades[0] + grades[1] + grades[2] + grades[3]) / 4;
        return result;
    }

    public static void checkGrade(Double result){
        System.out.println("Média: " + result);
        if (result >= 7){
            System.out.println("Aprovado");
        } else if (result >= 5){
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }
}
