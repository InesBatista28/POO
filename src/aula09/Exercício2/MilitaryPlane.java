package aula09.Exercício2;

public class MilitaryPlane extends Plane {
    private int numMunicoes;
    
    public MilitaryPlane(String id, String fabricante, String modelo, int anoProducao, int maxPassageiros, int maxVelocidade, int numMunicoes) {
        super(id, fabricante, modelo, anoProducao, maxPassageiros, maxVelocidade);
        this.numMunicoes = numMunicoes;
    }

    public int getNumMunicoes() {
        return numMunicoes;
    }

    public void setNumMunicoes(int numMunicoes) {
        this.numMunicoes = numMunicoes;
    }

    @Override
    public String getPlaneType() {
        return "Militar";
    }

    @Override
    public String toString() {
        return super.toString() + "MilitaryPlane [numMunicoes=" + numMunicoes + ", getPlaneType()=" + getPlaneType() + "]";
    }  
}

