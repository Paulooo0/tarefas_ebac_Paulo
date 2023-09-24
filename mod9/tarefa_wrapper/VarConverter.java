public class VarConverter {
    public static void main(String[] args) {
        String input = args[0];
        
        int num = convertArg(input);
        convertInt(num);
        System.out.println("Integer value: " + convertInt(num));
    }
    
    public static int convertArg(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

    public static Integer convertInt(int num) {
        Integer wrappedNum = Integer.valueOf(num);
        return wrappedNum;
    }
}