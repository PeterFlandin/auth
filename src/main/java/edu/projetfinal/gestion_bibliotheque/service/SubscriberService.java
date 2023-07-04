package edu.projetfinal.gestion_bibliotheque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.projetfinal.gestion_bibliotheque.dto.AuthorDto;
import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForSubscriberCrud;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;

@Service
public interface SubscriberService {

	// all Subscribers
	List<SubscriberDtoForSubscriberCrud> readAllSubscribers();

	
	 ///--------------------------------CRUD PROFIL-----------------------------------------------------
	
	// find subscriber by id
	SubscriberDtoForSubscriberCrud profilConsultation(Integer Id);

	// update profil
	void profilModification(Subscriber subscriber);

	
	 ///--------------------------------CRUD BOOK-----------------------------------------------------

	// all books
    List<BookDto> booksConsultation();

	BookDto ReadBook(Integer Id);

	// en cours
    // find by author
    // List <BookDto> filterByAuthor(Integer Id);
    
	
	 ///--------------------------------CRUD LOAN-----------------------------------------------------

	//	+ reservationConsultation( )

    //	+ bookReservation(Book book)

}
