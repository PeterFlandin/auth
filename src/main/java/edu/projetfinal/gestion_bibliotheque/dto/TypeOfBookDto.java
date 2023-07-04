package edu.projetfinal.gestion_bibliotheque.dto;

public class TypeOfBookDto {

    private String type;

    public TypeOfBookDto(String type) {
        this.type = type;
    }

    public TypeOfBookDto() {
    }

    @Override
    public String toString() {
        return "TypeOfBookDto{" +
                "type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
