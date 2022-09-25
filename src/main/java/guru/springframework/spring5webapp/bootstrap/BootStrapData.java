package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository,
                         AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "33339992");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        */

        Address address1 = new Address("city1", "state1", "12345");
        Publisher publisher1 = new Publisher("publisher1", address1);
        address1.getPublishers().add(publisher1);

        Address address2 = new Address("city2", "state2", "54321");
        Publisher publisher2 = new Publisher("publisher2", address2);
        address2.getPublishers().add(publisher2);

        addressRepository.saveAll(Arrays.asList(address1, address2));
        publisherRepository.saveAll(Arrays.asList(publisher1, publisher2));

        System.out.println("Started in Bootstrap");
        //System.out.println("Number of Books: " + bookRepository.count());
        publisherRepository.findAll().forEach(BootStrapData::printPublishers);
    }

    private static void printPublishers(Publisher publisher) {
        System.out.println(publisher.toString());
    }
}
