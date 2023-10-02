import javax.swing.JOptionPane;
import dao.ClientMapDAO;
import dao.IClientDAO;
import domain.Client;

public class App {
    protected static IClientDAO iClientDAO;

    public static void main(String[] args) {
        iClientDAO = new ClientMapDAO();

        String option = JOptionPane.showInputDialog(null,
        "Digite 1 para cadastro, 2 para consultar, 3 para exclusao, 4 para alteracao, 5 para sair",
        "Cadastro",
        JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)) {
            if ("".equals(option)) {
                leaveApp();
            }
            option = JOptionPane.showInputDialog(null,
                "Opcao invalida, digite 1 para cadastro, 2 para consultar, 3 para exclusao, 4 para alteracao, 5 para sair",
                "Green dinner",
                JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(option)) {
            if (isExitOption(option)) {
                leaveApp();
            } else if (isRegisterOption(option)) {
                String data = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente separados por ponto e virgula: nome,CPF,telefone,rua,numero,cidade,estado",
                    "Green dinner",
                    JOptionPane.INFORMATION_MESSAGE);
                insert(data);
            } else if (isConsult(option)) {
                String data = JOptionPane.showInputDialog(null,
                    "Digite o CPF do cliente",
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
                findByCpf(data);
            } else if (isDelete(option)) {
                String data = JOptionPane.showInputDialog(null,
                    "Digite o CPF do cliente",
                    "Exclusao",
                    JOptionPane.INFORMATION_MESSAGE);
                delete(data);
            } else if (isChange(option)) {
                String data = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente separados por ponto e virgula: nome;CPF;telefone;rua;numero;cidade;estado",
                    "Alteracao",
                    JOptionPane.INFORMATION_MESSAGE);
                change(data);
            }

            option = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusao, 4 para alteracao, 5 para sair",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private static boolean isRegisterOption(String option) {
        return "1".equals(option) ? true : false;
    }
    
    private static boolean isConsult(String option) {
        return "2".equals(option) ? true : false;
    }
    
    private static boolean isDelete(String option) {
        return "3".equals(option) ? true : false;
    }

    private static boolean isChange(String option) {
        return "4".equals(option) ? true : false;
    }
    
    private static boolean isExitOption(String option) {
        return "5".equals(option) ? true : false;
    }
    
    private static void insert(String data) {
        if (data == null || data.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Dados invalidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] separatedData = data.split(",");
        if (separatedData.length < 7) {
            JOptionPane.showMessageDialog(null,
                "Dados inválidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Client client = new Client(separatedData[0], separatedData[1], separatedData[2], separatedData[3], separatedData[4], separatedData[5], separatedData[6]);
        if (client.getName()    == null ||
            client.getCpf()     == null ||
            client.getTel()     == null ||
            client.getAddress() == null ||
            client.getNumber()  == null ||
            client.getCity()    == null ||
            client.getState()   == null) {
            JOptionPane.showMessageDialog(null,
                "Dados invalidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }

        Boolean isRegistered = iClientDAO.insert(client);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null,
            "Cliente adicionado com sucesso",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
            "Cliente já existe",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private static void findByCpf(String data) {
    Client client = iClientDAO.findByCpf(Long.parseLong(data));
    if (client != null) {
        JOptionPane.showMessageDialog(null,
            "Cliente encontrado\n" + client.toString(),
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
            "Cliente nao encontrado",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private static void delete(String data) {
        Long cpf = Long.parseLong(data);

        iClientDAO.delete(cpf); 
        if (iClientDAO.findByCpf(cpf) == null) {
            JOptionPane.showMessageDialog(null,
            "Cliente deletado com sucesso",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
            "Cliente nao encontrado",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void change(String data) {
        if (data == null || data.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Dados invalidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] separatedData = data.split(",");
        if (separatedData.length < 7) {
            JOptionPane.showMessageDialog(null,
                "Dados inválidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Client client = iClientDAO.findByCpf(Long.parseLong(separatedData[1]));
    
        client.setName(separatedData[0]);
        client.setCpf(Long.parseLong(separatedData[1]));
        client.setTel(Long.parseLong(separatedData[2]));
        client.setAddress(separatedData[3]);
        client.setNumber(Integer.parseInt(separatedData[4]));
        client.setCity(separatedData[5]);
        client.setState(separatedData[6]);
        
        if (client.getName()    == null ||
            client.getCpf()     == null ||
            client.getTel()     == null ||
            client.getAddress() == null ||
            client.getNumber()  == null ||
            client.getCity()    == null ||
            client.getState()   == null) {
            JOptionPane.showMessageDialog(null,
                "Dados invalidos",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }

        iClientDAO.change(client);
        JOptionPane.showMessageDialog(null,
            "Cliente alterado com sucesso",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private static void leaveApp() {
        JOptionPane.showMessageDialog(null,
        "Ate logo",
        "Sair",
        JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        return ("1".equals(option) ||
                "2".equals(option) ||
                "3".equals(option) ||
                "4".equals(option) ||
                "5".equals(option)) ? true : false;
    }
}
