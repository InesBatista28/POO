package aula04.Exercício3;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        this.kms += distance; //simula uma viagem: aumenta a quilometragem do carro com a distância percorrida
    }

    public String toString() {
        return make + " " + model + ", " + year + ", kms: " + kms;
    }
}

public class SimpleCarDemo {
    static void listCars(Car[] cars) {
        System.out.println("Carros Registados: ");
        for (Car car : cars) {  //percorre todos os car do array car 
            System.out.println(car);
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car("Renault", "Megane Sport Tourer", 2015, 35356);
        cars[1] = new Car ("Toyota", "Camry", 2010, 32456);
        cars[2] = new Car("Mercedes", "Vito", 2008, 273891);

        listCars(cars);

        // Adicionar 10 viagens geradas aleatoriamente
        for (int i=0; i<10; i++) {
            int j = (int)Math.round(Math.random()*2); // escolhe um dos 3 carros
            int kms = (int)Math.round(Math.random()*1000); // viagem até 1000 kms
            System.out.printf("Carro %d viajou %d quilómetros.\n", j, kms);
            
             cars[j].drive(kms);
        }

        listCars(cars);
    }
}