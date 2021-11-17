package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Pocetak u bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("N4M publishing");
        publisher.setCity("Rijeka");
        publisher.setState("HR");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: "+ publisherRepository.count());

        Author eric = new Author("Eric", "Pavko");
        Book spring = new Book("Nesto o springu", "9844264");
        eric.getBooks().add(spring);
        spring.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(spring);

        Author john = new Author("John", "Cena");
        Book iot = new Book("Nesto o iot", "5147863");
        john.getBooks().add(iot);
        iot.getAuthors().add(john);
        authorRepository.save(john);
        bookRepository.save(iot);


        System.out.println("Broj knjiga je: " + bookRepository.count());
    }
}
