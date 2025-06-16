package aula08.Exercício1;

public class TesterEmpresa {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Aluga Rápido", 1234-567, "contato@alugarapido.com");
        
        Veiculo veiculo1 = new Taxi("AA-11-AA", "Toyota", "Corolla", 150, 7812, 50, 98765);
        Veiculo veiculo2 = new AutomovelLigeiro("BB-22-BB", "Honda", "Civic", 180, 5264, 300);
        Veiculo veiculo3 = new PesadoMercadorias("CC-33-CC", "Volvo", "FH16", 500, 4563, 8000, 20000);
        Veiculo veiculo4 = new PesadoPassageiros("DD-44-DD", "Mercedes", "Tourismo", 350, 1235, 10000, 55);
        AutomovelLigeiroEletrico veiculo5 = new AutomovelLigeiroEletrico("EE-55-EE", "Tesla", "Model S", 670, 4598, 500);
        
        empresa.adicionarVeiculos(veiculo1);
        empresa.adicionarVeiculos(veiculo2);
        empresa.adicionarVeiculos(veiculo3);
        empresa.adicionarVeiculos(veiculo4);
        empresa.adicionarVeiculos(veiculo5);
        
        System.out.println(empresa);
        System.out.println(veiculo1);
        System.out.println(veiculo2);
        System.out.println(veiculo3);
        System.out.println(veiculo4);
        
        System.out.println("Distância total do veiculo4: " + veiculo4.distanciaTotal());
        System.out.println("Nome da empresa: " + empresa.getNome());
        
        // Teste de quilometragem
        veiculo1.trajeto(600);
        System.out.println("Último trajeto do veiculo1: " + veiculo1.ultimoTrajeto());
        veiculo1.trajeto(247);
        System.out.println("Distância total do veiculo1: " + veiculo1.distanciaTotal());
        
        // Teste com veículo elétrico
        veiculo5.trajeto(200);
        System.out.println(veiculo5);
        
        veiculo5.carregar(100);
        System.out.println(veiculo5);
    }
}
