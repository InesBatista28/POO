package aula06.Exercício2;
import aula06.Exercício1.Pessoa;

public class Contacto {
    public static int counterId = 1;
    private int id;
    private Pessoa pessoa;
    private String telefone;
    private String email;

    public Contacto (Pessoa pessoa, String telefone, String email) {
        if ((telefone == null || telefone.isEmpty()) && (email == null || email.isEmpty())) {
            throw new IllegalArgumentException("Deve fornecer pelo menos telefone ou email.");
        }
        if (telefone != null && !telefone.isEmpty() && !telefone.matches("9\\d{8}")) {
            throw new IllegalArgumentException("Número inválido. Deve conter 9 dígitos começando por 9.");
        }
        if (email != null && !email.isEmpty() && (!email.contains("@") || !email.matches(".*\\.(pt|com|org|net|edu)$"))) {
            throw new IllegalArgumentException("Email inválido.");
        }

        this.id = counterId++;
        this.pessoa = pessoa;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public static int getCounterId() {
        return counterId;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.isEmpty() && !telefone.matches("9\\d{8}")) {
            throw new IllegalArgumentException("Número inválido. Deve conter 9 dígitos começando por 9.");
        }
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && (!email.contains("@") || !email.matches(".*\\.(pt|com|org|net|edu)$"))) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto [id=" + id + ", pessoa=" + pessoa + ", telefone=" + telefone + ", email=" + email + "]";
    }
}
