package aula12.Contactos;

import java.time.LocalDate;

public class Contact {
    private static int nextId = 1;

    private int id;
    private String name;
    private int phoneNumber;
    private String email;
    private LocalDate birthDate;

    public Contact(String name, int phoneNumber, String email, String birthDateStr) {
        this.id = nextId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDateStr);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public LocalDate getBirthDate() { return birthDate; }

    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return id + " - " + name + " | " + phoneNumber + " | " + email + " | " + birthDate;
    }

    public String toFileString() {
        return name + ";" + phoneNumber + ";" + email + ";" + birthDate;
    }
}
