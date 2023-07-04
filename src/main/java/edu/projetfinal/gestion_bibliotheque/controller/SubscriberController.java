package edu.projetfinal.gestion_bibliotheque.controller;

import java.util.List;

import edu.projetfinal.gestion_bibliotheque.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForSubscriberCrud;
import edu.projetfinal.gestion_bibliotheque.entity.Book;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import edu.projetfinal.gestion_bibliotheque.service.SubscriberService;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

	@Autowired
	SubscriberService subscriberService;

	@Autowired
	LibrarianService librarianService;

	
	@GetMapping("/subscribers")
	@ResponseStatus(HttpStatus.OK)
	public List<SubscriberDtoForSubscriberCrud> getAllSubscribers() {
		return subscriberService.readAllSubscribers();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public SubscriberDtoForSubscriberCrud getProfil(@PathVariable("id") Integer id) {
		return subscriberService.profilConsultation(id);
	}

	@PutMapping("/put/{id}")
	public void updateProfil(@PathVariable("id") Integer id, @RequestBody Subscriber subscriber) {
		subscriber.setId_subscriber(id);
		subscriberService.profilModification(subscriber);
	}

	@GetMapping("/books")
	@ResponseStatus(HttpStatus.OK)
	public List<BookDto> getAllBook() {
		return subscriberService.booksConsultation();
	}


	@GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook(@PathVariable("id") Integer id) {
        return subscriberService.ReadBook(id);
    }


//	+  makeReservation()
//	+  getReservation()

}
