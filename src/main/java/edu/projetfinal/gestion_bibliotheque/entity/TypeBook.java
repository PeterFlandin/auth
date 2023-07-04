package edu.projetfinal.gestion_bibliotheque.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_book")
public class TypeBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_type_book")
	private Integer id_typeBook;

	@Column(name = "type", unique = true, nullable = false)
	private String type;

	public TypeBook() {

	}

	public TypeBook(Integer id_typeBook, String type) {
		super();
		this.id_typeBook = id_typeBook;
		this.type = type;
	}

	public Integer getId_typeBook() {
		return id_typeBook;
	}

	public void setId_typeBook(Integer id_typeBook) {
		this.id_typeBook = id_typeBook;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_typeBook, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeBook other = (TypeBook) obj;
		return Objects.equals(id_typeBook, other.id_typeBook) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "TypeBook [id_typeBook=" + id_typeBook + ", type=" + type + "]";
	}

}