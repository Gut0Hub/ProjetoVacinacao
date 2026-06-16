import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/sistema_vacinacao";
    static String usuario = "root";
    static String senha = "123456";

    static ArrayList<String> pacientesTemporarios = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            int opcao;

            do {
                System.out.println("\n===== SISTEMA DE VACINAÇÃO =====");
                System.out.println("1 - Cadastrar paciente");
                System.out.println("2 - Listar pacientes");
                System.out.println("3 - Cadastrar vacina");
                System.out.println("4 - Registrar vacinação");
                System.out.println("5 - Listar vacinações");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarPaciente(conexao, scanner);
                        break;
                    case 2:
                        listarPacientes(conexao);
                        break;
                    case 3:
                        cadastrarVacina(conexao, scanner);
                        break;
                    case 4:
                        registrarVacinacao(conexao, scanner);
                        break;
                    case 5:
                        listarVacinacoes(conexao);
                        break;
                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } while (opcao != 0);

            conexao.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarPaciente(Connection conexao, Scanner scanner) throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Região de moradia: ");
        String regiao = scanner.nextLine();

        System.out.print("Escolaridade: ");
        String escolaridade = scanner.nextLine();

        System.out.print("Teve doença? (true/false): ");
        boolean teveDoenca = scanner.nextBoolean();
        scanner.nextLine();

        pacientesTemporarios.add(nome);

        String sql = "INSERT INTO paciente(nome, idade, endereco, telefone, regiao, escolaridade, teve_doenca) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, idade);
        stmt.setString(3, endereco);
        stmt.setString(4, telefone);
        stmt.setString(5, regiao);
        stmt.setString(6, escolaridade);
        stmt.setBoolean(7, teveDoenca);

        stmt.executeUpdate();

        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println("Paciente também armazenado temporariamente no ArrayList.");
    }

    public static void listarPacientes(Connection conexao) throws SQLException {
        String sql = "SELECT * FROM paciente";
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n===== PACIENTES CADASTRADOS =====");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Idade: " + rs.getInt("idade"));
            System.out.println("Endereço: " + rs.getString("endereco"));
            System.out.println("Telefone: " + rs.getString("telefone"));
            System.out.println("Região: " + rs.getString("regiao"));
            System.out.println("Escolaridade: " + rs.getString("escolaridade"));
            System.out.println("Teve doença: " + rs.getBoolean("teve_doenca"));
            System.out.println("--------------------------------");
        }
    }

    public static void cadastrarVacina(Connection conexao, Scanner scanner) throws SQLException {
        System.out.print("Nome/tipo da vacina: ");
        String nome = scanner.nextLine();

        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();

        System.out.print("Quantidade de doses: ");
        int quantidadeDoses = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO vacina(nome, fabricante, quantidade_doses) VALUES (?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, fabricante);
        stmt.setInt(3, quantidadeDoses);

        stmt.executeUpdate();

        System.out.println("Vacina cadastrada com sucesso!");
    }

    public static void registrarVacinacao(Connection conexao, Scanner scanner) throws SQLException {
        System.out.print("ID do paciente: ");
        int pacienteId = scanner.nextInt();

        System.out.print("ID da vacina: ");
        int vacinaId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data da aplicação (AAAA-MM-DD): ");
        String dataAplicacao = scanner.nextLine();

        System.out.print("Dose aplicada: ");
        int dose = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO vacinacao(paciente_id, vacina_id, data_aplicacao, dose) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, pacienteId);
        stmt.setInt(2, vacinaId);
        stmt.setString(3, dataAplicacao);
        stmt.setInt(4, dose);

        stmt.executeUpdate();

        System.out.println("Vacinação registrada com sucesso!");
    }

    public static void listarVacinacoes(Connection conexao) throws SQLException {
        String sql = """
                SELECT p.nome AS paciente, v.nome AS vacina, vac.data_aplicacao, vac.dose
                FROM vacinacao vac
                INNER JOIN paciente p ON vac.paciente_id = p.id
                INNER JOIN vacina v ON vac.vacina_id = v.id
                """;

        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n===== VACINAÇÕES REGISTRADAS =====");

        while (rs.next()) {
            System.out.println("Paciente: " + rs.getString("paciente"));
            System.out.println("Vacina: " + rs.getString("vacina"));
            System.out.println("Data: " + rs.getString("data_aplicacao"));
            System.out.println("Dose: " + rs.getInt("dose"));
            System.out.println("--------------------------------");
        }
    }
}