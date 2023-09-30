public class Cadastro {
    public static void main(String[] args) {
        PessoaFisica pessFisica = new PessoaFisica();
        pessFisica.setName("Paulo");
        pessFisica.setCpf(12312312399l);
        System.out.println("\nPessoa Fisica");
        System.out.println(pessFisica.getName());
        System.out.println("CPF: " + pessFisica.getCpf());

        PessoaJuridica pessJuridica = new PessoaJuridica();
        pessJuridica.setName("Paulo LTDA");
        pessJuridica.setCnpj(12123123000199l);
        System.out.println("\nPessoa Juridica");
        System.out.println(pessJuridica.getName());
        System.out.println("CNPJ: " + pessJuridica.getCnpj());
    }
}
