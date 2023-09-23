public class GradeAverage {
    public static void main(String args[]){
        calcAverage();
    }

    public static double calcAverage() {
        double grade1 = 8.5;
        double grade2 = 7.75;
        double grade3 = 10;
        double grade4 = 9.25;
        
        double average = (grade1+grade2+grade3+grade4)/4;

        System.out.println("Média das notas: " + average);
        return average;
    }
}
