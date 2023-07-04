package edu.projetfinal.gestion_bibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.projetfinal.gestion_bibliotheque.dto.AuthorDto;
import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForLibrarianCrud;
import edu.projetfinal.gestion_bibliotheque.dto.TypeOfBookDto;
import edu.projetfinal.gestion_bibliotheque.entity.Author;
import edu.projetfinal.gestion_bibliotheque.entity.Book;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import edu.projetfinal.gestion_bibliotheque.entity.TypeBook;
import edu.projetfinal.gestion_bibliotheque.service.LibrarianService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    //-------------------------------------------BOOK---------------------------------------------------------
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody BookDto request) {
        librarianService.addBook(request);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {
        return librarianService.readAllBook();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getOneBook(@PathVariable("id") Integer id) {
        return librarianService.ReadBook(id);
    }
    
    @PutMapping("/books/{id}")
    public void updateBooks(@PathVariable("id") Integer id, @RequestBody Book book) {
       book.setId_book(id);
        librarianService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") Integer id) {
        librarianService.deleteBook(id);
    }

    //--------------------------------------------TYPE OF BOOK ---------------------------------------------------------

    @PostMapping("/typeofbook/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void postTypeOfBook(@RequestBody TypeOfBookDto typeOfBookDto) {
        librarianService.addTypeBook(typeOfBookDto);
    }

    @GetMapping("/typeofbook")
    @ResponseStatus(HttpStatus.OK)
    public List<TypeOfBookDto> getAllTypeOfBook() {
        return librarianService.readAllTypeOfBook();
    }

    @GetMapping("/typeofbook/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TypeOfBookDto getTypeOfBook(@PathVariable("id") Integer id) {
        return librarianService.readTypeOfBook(id);
    }
 
    @PutMapping("/typeofbook/{id}")
    public void updateTypeOfBook(@PathVariable("id") Integer id, @RequestBody TypeBook typeBook) {
       typeBook.setId_typeBook(id);
        librarianService.updateTypeBook(typeBook);
    }

    @DeleteMapping("/typeofbook/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTypeOfBook(@PathVariable("id") Integer id) {
        librarianService.deleteTypeOfBookDto(id);
    }

    //--------------------------------------------BOOK AUTHOR---------------------------------------------------------

    @PostMapping("/bookauthor/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void postBookAuthor(@RequestBody AuthorDto authorDto) {
        librarianService.addAuthor(authorDto);
    }

    @GetMapping("/bookauthor")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> getAllBookAuthor() {
        return librarianService.readAllAuthor();
    }
    @GetMapping("/bookauthor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getBookAuthor(@PathVariable("id") Integer id) {
        return librarianService.readAuthor(id);
    }

    @PutMapping("/bookauthor/{id}")
    public void updateBookAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
       author.setId_author(id);
       librarianService.updateAuthor(author);
    }

    @DeleteMapping("/bookauthor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookAuthor(@PathVariable("id") Integer id) {
        librarianService.deleteAuthor(id);
    }

  ///--------------------------------CRUD SUBSCRIBER-----------------------------------------------------

    @PostMapping("/addSubscriber")
	@ResponseStatus(HttpStatus.CREATED)
	public void addSubscriber(@Valid @RequestBody SubscriberDtoForLibrarianCrud request){
    	librarianService.addSubscriber(request);
	}
    
    @DeleteMapping("/deleteSubscriber/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSubscriber(@PathVariable("id") Integer id) {
    	librarianService.deleteSubscriber(id);
	}

	@GetMapping("/consultSubscribers")
	@ResponseStatus(HttpStatus.OK)
	public List<SubscriberDtoForLibrarianCrud> getSubscribers(){
		return librarianService.readAllSubscriber();
	}


    @PutMapping("/updateSubscriber/{id}")
    public void updateSubscriber(@PathVariable("id") Integer id, @RequestBody Subscriber subscriber) {
       subscriber.setId_subscriber(id);
        librarianService.updateSubscriber(subscriber);
    }

    //SubscriberDtoForLibrarianCrud readSubscriber(Integer Id);
    @GetMapping("/readSubscriber/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubscriberDtoForLibrarianCrud getSubscriber(@PathVariable("id") Integer id){
        return librarianService.readSubscriber(id);
    }

}