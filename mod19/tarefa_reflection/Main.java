@Tabela(name = "Tabela")
public class Main {
    public static void main(String[] args) {
        Class<?> mainClass = Main.class;
        Tabela tabelaAnnotation = mainClass.getAnnotation(Tabela.class);
        String tabelaName = tabelaAnnotation.name();

        System.out.println("Nome da tabela: " + tabelaName);
    }
}