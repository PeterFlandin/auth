package edu.projetfinal.gestion_bibliotheque.dto;

import edu.projetfinal.gestion_bibliotheque.entity.Author;
import edu.projetfinal.gestion_bibliotheque.entity.TypeBook;
import jakarta.validation.constraints.Size;

public class BookDto {

	@Size(min = 3, message = "3 lettre minimum et 10 maximum")
	private String title;
	private Author authorObj;
	@Size(min = 3, max = 250, message = "3 lettre minimum et 250 maximum")
	private String summary;

	private TypeBook typeBook;

	public BookDto(@Size(min = 3, message = "3 lettre minimum et 10 maximum") String title, Author authorObj,
			@Size(min = 3, max = 250, message = "3 lettre minimum et 250 maximum") String summary, TypeBook typeBook) {
		super();
		this.title = title;
		this.authorObj = authorObj;
		this.summary = summary;
		this.typeBook = typeBook;
	}

	public Author getAuthorObj() {
		return authorObj;
	}

	public void setAuthorObj(Author authorObj) {
		this.authorObj = authorObj;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public TypeBook getTypeBook() {
		return typeBook;
	}

	public void setTypeBook(TypeBook typeBook) {
		this.typeBook = typeBook;
	}
}
