package aula09.Exercício2;

public class CommercialPlane extends Plane {
    private int numTripulantes;

    public CommercialPlane (String id, String fabricante, String modelo, int anoProducao, int maxPassageiros, int maxVelocidade, int numTripulantes) {
        super(id, fabricante, modelo, anoProducao, maxPassageiros, maxVelocidade);
        this.numTripulantes = numTripulantes;
    }

    public int getNumTripulantes() {
        return numTripulantes;
    }

    public void setNumTripulantes(int numTripulantes) {
        this.numTripulantes = numTripulantes;
    }

    public String getPlaneType() {
        return "Comercial";
    }

    @Override
    public String toString() {
        return super.toString() + "CommercialPlane [numTripulantes=" + numTripulantes + ", getPlaneType()=" + getPlaneType() + "]";
    } 
}
