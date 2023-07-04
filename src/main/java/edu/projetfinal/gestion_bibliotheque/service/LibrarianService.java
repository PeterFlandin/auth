package edu.projetfinal.gestion_bibliotheque.service;

import edu.projetfinal.gestion_bibliotheque.dto.AuthorDto;
import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForLibrarianCrud;
import edu.projetfinal.gestion_bibliotheque.dto.TypeOfBookDto;
import edu.projetfinal.gestion_bibliotheque.entity.Author;
import edu.projetfinal.gestion_bibliotheque.entity.Book;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import edu.projetfinal.gestion_bibliotheque.entity.TypeBook;

import java.util.List;

public interface LibrarianService {

    //-----------------------------CRUD BOOK-----------------------------------------------------

    void addBook(BookDto bookDto);
    List<BookDto> readAllBook();
    void updateBook(Book book);
    BookDto ReadBook(Integer Id);
    void deleteBook(Integer Id);

    //--------------------------------CRUD AUTHOR-----------------------------------------------------

    void addAuthor(AuthorDto authorDto);

    void deleteAuthor(Integer Id);

    void updateAuthor(Author author);

    AuthorDto readAuthor(Integer Id);

    List<AuthorDto> readAllAuthor();

    ///--------------------------------CRUD TYPE OF BOOK-----------------------------------------------------

    void addTypeBook(TypeOfBookDto typeOfBookDto);

    void updateTypeBook(TypeBook typeBook);

    void deleteTypeOfBookDto(Integer Id);

    List<TypeOfBookDto> readAllTypeOfBook();

    ///--------------------------------CRUD SUBSCRIBER-----------------------------------------------------

    TypeOfBookDto readTypeOfBook(Integer Id);

    void addSubscriber(SubscriberDtoForLibrarianCrud subscriberDto);

     void deleteSubscriber(Integer Id);

     List<SubscriberDtoForLibrarianCrud> readAllSubscriber();

     void updateSubscriber(Subscriber subscriber);

     SubscriberDtoForLibrarianCrud readSubscriber(Integer Id);
}
