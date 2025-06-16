package aula06.Exercício2;

import java.util.*;
import java.util.stream.Collectors;

public class ContactManager {
    private List<Contacto> contactos = new ArrayList<>();  //Lista que guarda os contactos, cada um tem pessoa, telefone e email associado 

    public void inserirContacto(Contacto contacto) {
        contactos.add(contacto);  //adicionar contactos à lista 
    }

    public List<Contacto> procurarPorNomeOuNumero(String termo) {
        return contactos.stream()  //Procura contactos com base no nome ou número de telefone
                .filter(c -> c.getPessoa().getNome().equalsIgnoreCase(termo) || 
                             (c.getTelefone() != null && c.getTelefone().equals(termo)))
                .collect(Collectors.toList());
    }

    public Contacto procurarPorId(int id) {  //Procura contacto com id específico
        return contactos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public boolean apagarContacto(int id) {  //recebe um id e remove da lsita o contatco que lhe corresponde 
        return contactos.removeIf(c -> c.getId() == id);
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }
}
