public class VarConverter {
    public static void main(String[] args) {
        String input = args[0];
        
        int num = convertArg(input);
        convertInt(num);

        if (args.length == 1) {
            System.out.println("Valor do Integer: " + convertInt(num));
        } else {
            System.out.print("Formato invalido: ");
            for (String arg : args) {
                System.out.print(arg + " ");
            }
            System.out.println("\nDigite apenas um valor");
        }
        
    }
    
    public static int convertArg(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Não é um numero: " + input);
            throw e;
        }
    }

    public static Integer convertInt(int num) {
        Integer wrappedNum = Integer.valueOf(num);
        return wrappedNum;
    }
}