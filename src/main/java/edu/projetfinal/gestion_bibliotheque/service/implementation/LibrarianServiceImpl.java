package edu.projetfinal.gestion_bibliotheque.service.implementation;

import edu.projetfinal.gestion_bibliotheque.dto.AuthorDto;
import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForLibrarianCrud;
import edu.projetfinal.gestion_bibliotheque.dto.TypeOfBookDto;
import edu.projetfinal.gestion_bibliotheque.entity.Author;
import edu.projetfinal.gestion_bibliotheque.entity.Book;
import edu.projetfinal.gestion_bibliotheque.entity.Loan;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import edu.projetfinal.gestion_bibliotheque.entity.TypeBook;
import edu.projetfinal.gestion_bibliotheque.repository.AuthorRepository;
import edu.projetfinal.gestion_bibliotheque.repository.BookRepository;
import edu.projetfinal.gestion_bibliotheque.repository.LoanRepository;
import edu.projetfinal.gestion_bibliotheque.repository.SubscriberRepository;
import edu.projetfinal.gestion_bibliotheque.repository.TypeofBookRepository;
import edu.projetfinal.gestion_bibliotheque.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TypeofBookRepository typeofBookRepository;
    
    @Autowired
    private LoanRepository loanRepository;

    //-----------------------------CRUD BOOK-----------------------------------------------------
    @Override
    public void addBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setSummary(bookDto.getSummary());
        book.setTypeBook(bookDto.getTypeBook());
        book.setAuthorObj(bookDto.getAuthorObj());
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> readAllBook() {
        return bookRepository
                .findAll().stream()
                .map(b-> new BookDto(b.getTitle(), b.getAuthorObj() , b.getSummary(), b.getTypeBook()))
                .collect(Collectors.toList());
    };


    @Override
    public void updateBook(Book book) {
        if (book.getId_book() != null) {
            Book existingBook = bookRepository.findById(book.getId()).orElse(null);
            if (existingBook != null) {
                existingBook.setTitle(book.getTitle());
                existingBook.setSummary(book.getSummary());
                existingBook.setAuthorObj(book.getAuthorObj());
                existingBook.setTypeBook(book.getTypeBook());

                bookRepository.save(existingBook);
            }
        }
    }

    @Override
    public BookDto ReadBook(Integer Id) {
        Optional<Book> optionalBook = bookRepository.findById(Id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return new BookDto(book.getTitle(), book.getAuthorObj(),book.getSummary(), book.getTypeBook());
        } else {
            return null;
        }
    }
    @Override
    public void deleteBook(Integer Id) {
      bookRepository.deleteById(Id);
    }


    //------------------------------CRUD AUTHOR-----------------------------------------------------

    @Override
    public void addAuthor(AuthorDto authorDto) {
        Author author = new Author();
     author.setFirstname(authorDto.getFirstName());
        authorRepository.save(author);
    }
    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public AuthorDto readAuthor(Integer Id) {
        Optional<Author> optionalAuthor = authorRepository.findById(Id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            return new AuthorDto( author.getFirstname());
        } else {
            return null;
        }
    }

    @Override
    public void deleteAuthor(Integer Id) {
        authorRepository.deleteById(Id);
    }

    @Override
    public List<AuthorDto> readAllAuthor() {
        return authorRepository
              .findAll().stream()
              .map(a-> new AuthorDto( a.getFirstname()))
              .collect(Collectors.toList());
    }


    //-------------------------------CRUD TYPE OF BOOK-----------------------------------------------------

@Override
    public void addTypeBook(TypeOfBookDto typeOfBookDto) {
        TypeBook typeBook = new TypeBook();
        typeBook.setType(typeOfBookDto.getType());

        typeofBookRepository.save(typeBook);
    }

    @Override
    public void updateTypeBook(TypeBook typeBook) {
        typeofBookRepository.save(typeBook);
    }

  @Override
    public void deleteTypeOfBookDto(Integer Id) {
        typeofBookRepository.deleteById(Id);
    }

@Override
    public List<TypeOfBookDto> readAllTypeOfBook() {
        return typeofBookRepository
              .findAll().stream()
              .map(t-> new TypeOfBookDto(t.getType()))
              .collect(Collectors.toList());
    }

    @Override
    public TypeOfBookDto readTypeOfBook(Integer Id) {
        Optional<TypeBook> optionalTypeBook = typeofBookRepository.findById(Id);
        if (optionalTypeBook.isPresent()) {
            TypeBook typeBook = optionalTypeBook.get();
            return new TypeOfBookDto(typeBook.getType());
        } else {
            return null;
        }
    }

  //------------------------------------CRUD SUBSCRIBER-----------------------------------------------------

     @Override
     public void addSubscriber(SubscriberDtoForLibrarianCrud subscriberDto) {
        Subscriber subscriber = new Subscriber();
         subscriber.setFirstname(subscriberDto.getFirstname());
         subscriber.setLastname(subscriberDto.getLastname());
         subscriber.setEmail(subscriberDto.getEmail());
         subscriber.setLogin(subscriberDto.getLogin());
         subscriber.setPassword(subscriberDto.getPassword());
         subscriberRepository.save(subscriber);
     }

    @Override
    public void deleteSubscriber(Integer Id) {
        subscriberRepository.deleteById(Id);
    }

    @Override
    public List<SubscriberDtoForLibrarianCrud> readAllSubscriber() {
        return subscriberRepository
             .findAll().stream()
             .map(s-> new SubscriberDtoForLibrarianCrud(s.getFirstname(), s.getLastname(), s.getEmail(), s.getAddress()))
             .collect(Collectors.toList());
    }

    @Override
    public void updateSubscriber(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }

    @Override
    public SubscriberDtoForLibrarianCrud readSubscriber(Integer Id) {
        Optional<Subscriber> optionalSubscriber = subscriberRepository.findById(Id);
        if (optionalSubscriber.isPresent()) {
            Subscriber subscriber = optionalSubscriber.get();
            return new SubscriberDtoForLibrarianCrud(subscriber.getFirstname(), subscriber.getLastname(), subscriber.getEmail(), subscriber.getAddress(), subscriber.getPassword(), subscriber.getLogin());
        } else {
            return null;
        }
    }

}


