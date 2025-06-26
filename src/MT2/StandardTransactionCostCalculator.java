//Inês Batista 124877

package MT2;

public class StandardTransactionCostCalculator implements ITransactionCostCalculator {
    public double calculateTransactionCost(Transaction t) {
        double baseRate = 50.0;
        double custo = t.getHorasTrabalho() * baseRate;

        int diaSemana = t.getDataHora().getDayOfWeek().getValue(); 

        if (diaSemana == 6 || diaSemana == 7) {
            custo *= 2;
        }
        if (diaSemana == 4) {
            custo *= 0.9;
        }

        return custo;
    }
}



