public class PrimeiraClasse {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("Olá " + args[0]);
        } else if (args.length > 1) {
            System.out.println("Muitos argumentos");
        } else {
            System.out.println("Nome não encontrado, digite `java PrimeiraClasse seu_nome`");
        }
    }
}
