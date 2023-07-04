package edu.projetfinal.gestion_bibliotheque.service.implementation;

import edu.projetfinal.gestion_bibliotheque.dto.BookDto;
import edu.projetfinal.gestion_bibliotheque.dto.SubscriberDtoForSubscriberCrud;
import edu.projetfinal.gestion_bibliotheque.entity.Book;
import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import edu.projetfinal.gestion_bibliotheque.repository.BookRepository;
import edu.projetfinal.gestion_bibliotheque.repository.SubscriberRepository;
import edu.projetfinal.gestion_bibliotheque.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public List<SubscriberDtoForSubscriberCrud> readAllSubscribers() {
		return subscriberRepository.findAll().stream()
				.map(subscriber -> new SubscriberDtoForSubscriberCrud(subscriber.getFirstname(),
						subscriber.getLastname(), subscriber.getEmail(), subscriber.getAddress(),
						subscriber.getPassword(), subscriber.getLogin()))
				.collect(Collectors.toList());
	};

	@Override
	public SubscriberDtoForSubscriberCrud profilConsultation(Integer Id) {
		Optional<Subscriber> optionalSubscriber = subscriberRepository.findById(Id);
		if (optionalSubscriber.isPresent()) {
			Subscriber subscriber = optionalSubscriber.get();
			return new SubscriberDtoForSubscriberCrud(subscriber.getFirstname(), subscriber.getLastname(),
					subscriber.getEmail(), subscriber.getAddress(), subscriber.getPassword(), subscriber.getLogin());
		} else {
			return null;
		}
	}

	@Override
	public void profilModification(Subscriber subscriber) {
		if (subscriber != null) {
			Subscriber existingSubscriber = subscriberRepository.findById(subscriber.getId_subscriber()).orElse(null);
			if (existingSubscriber != null) {
				existingSubscriber.setDateStartSanction(subscriber.getDateStartSanction());
				existingSubscriber.setDateEndSanction(subscriber.getDateEndSanction());
				existingSubscriber.setNumberOffences(subscriber.getNumberOffences());
				existingSubscriber.setFirstname(subscriber.getFirstname());
				existingSubscriber.setLogin(subscriber.getLogin());
				existingSubscriber.setLastname(subscriber.getLastname());
				existingSubscriber.setEmail(subscriber.getEmail());
				existingSubscriber.setAddress(subscriber.getAddress());
				existingSubscriber.setPassword(subscriber.getPassword());

				subscriberRepository.save(existingSubscriber);
			}
		}
	}

	@Override
	public List<BookDto> booksConsultation() {
		return bookRepository.findAll().stream()
				.map(book -> new BookDto(book.getTitle(), book.getAuthorObj(), book.getSummary(), book.getTypeBook()))
				.collect(Collectors.toList());
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


// en cours, fonction recherche par nom d'auteur
//	@Override
//	public List<BookDto> filterByAuthor(Integer Id) {
//		Optional<Book> optionalBook = bookRepository.findById(Id);
//		if(optionalBook.isPresent()) {
//			Book book = optionalBook.get();
//			return new BookDto(book.)
//		}
//	};

}
