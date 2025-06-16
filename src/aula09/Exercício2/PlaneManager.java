package aula09.Exercício2;
import java.util.*;

public class PlaneManager {
    private Map<String, Plane> frota;

    public PlaneManager() {
        frota = new HashMap<>();
    }

    public void addPlane(Plane plane) {
        frota.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        frota.remove(id);
    }

    public Plane searchPlane(String id) {
        return frota.get(id);
    }

    public List<CommercialPlane> getCommercialPlanes() {
        List<CommercialPlane> list = new ArrayList<>();
        for (Plane p : frota.values()) {
            if (p instanceof CommercialPlane) {
                list.add((CommercialPlane) p);
            }
        }
        return list;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> list = new ArrayList<>();
        for (Plane p : frota.values()) {
            if (p instanceof MilitaryPlane) {
                list.add((MilitaryPlane) p);
            }
        }
        return list;
    }

    public void printAllPlanes() {
        for (Plane p : frota.values()) {
            System.out.println(p);
        }
    }

    public Plane getFastestPlane() {
        return frota.values().stream()
                .max(Comparator.comparingInt(p -> p.getMaxVelocidade()))
                .orElse(null);
    }
}
