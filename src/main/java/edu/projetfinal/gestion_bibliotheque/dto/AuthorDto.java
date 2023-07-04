package edu.projetfinal.gestion_bibliotheque.dto;

public class AuthorDto {

    private String firstName;

    public AuthorDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public AuthorDto( String firstName) {
        this.firstName = firstName;
    }
}
