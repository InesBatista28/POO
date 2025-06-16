package aula10.Ex2;
import java.util.List;

public class SimpleGradeCalculator implements IGradeCalculator{
    @Override  //garante a sobrescrição de um método válido
    public double calculate(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
