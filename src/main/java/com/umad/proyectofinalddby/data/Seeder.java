package com.umad.proyectofinalddby.data;

import com.umad.proyectofinalddby.dataContext.DataContext;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author deban
 */
public class Seeder {

    private final Session session;
    private Transaction transaction;

    public Seeder() {
        session = DataContext.getOpenSession();
    }

    public void Seed() {
        try {
            // Begin a transaction
            transaction = session.beginTransaction();

            //HQL
            if (session.createQuery("from Director", Director.class).list().isEmpty()) {
                AddNewDirector("Woody", "Allen");
                AddNewDirector("Guillermo", "del Toro");
                AddNewDirector("Alfonso", "Cuarón");
            }
            if (session.createQuery("from Genre", Genre.class).list().isEmpty()) {
                AddNewGenre("Horror");
                AddNewGenre("Action");
                AddNewGenre("Science Fiction");
            }
            if (session.createQuery("from Movie", Movie.class).list().isEmpty()) {
                Director director = (Director) session.createQuery("from Director where id = :id", Director.class)
                        .setParameter("id", "1")
                        .uniqueResult();
                Genre genre = (Genre) session.createQuery("from Genre where id = :id", Genre.class)
                        .setParameter("id", "1")
                        .uniqueResult();
                AddNewMovie("Pinocho", director, genre, "2003", "120", "6");
                AddNewMovie("Avengers", director, genre, "2005", "124", "3");
            }
            if (session.createQuery("from Rent", Rent.class).list().isEmpty()) {
                Movie movie = (Movie) session.createQuery("from Movie where id = :id", Movie.class)
                        .setParameter("id", "1")
                        .uniqueResult();
                AddNewRent(movie);
            }
            if (session.createQuery("from Person", Person.class).list().isEmpty()) {
                AddNewPerson("Francisco", "Reyes", 30, 1234567890);
                AddNewPerson("Josué", "Salazar", 28, 123565784);
            }

            if (session.createQuery("from Client", Client.class).list().isEmpty()) {
                AddNewClient("juan@gmail.com", "2 Pte #1000 Col Hogar", "Francisco", "Reyes", 30, 1234567890);
            }
            if (session.createQuery("from Employee", Employee.class).list().isEmpty()) {
                AddNewEmployee("Cajero", "josue1234", "josue@gmail.com", "Josué", "Salazar", 30, 1234567890);
            }

            // Commit the transaction
            transaction.commit();

        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    private void AddNewDirector(String firstName, String lastName) {
        Director director = new Director();
        director.setFirstName(firstName);
        director.setLastName(lastName);

        session.persist(director);
    }

    private void AddNewGenre(String description) {
        Genre genre = new Genre();
        genre.setDescription(description);

        session.persist(genre);
    }

    private void AddNewMovie(String title, Director director, Genre genre, String releaseYear, String duration, String quantityAvailable) {
        Movie movie = new Movie();

        movie.setTittle(title);
        movie.setReleaseYear(0);
        movie.setDuration(0);
        movie.setQuantityAvailable(0);
        movie.setDirector(director);
        movie.setGenre(genre);

    }

    private void AddNewRent(Movie movie) {
        Rent rent = new Rent();

        rent.setMovie(movie);
        //rent.setRentDay(rentDay);
        //rent.setReturnDay(returnDay);

    }

    private void AddNewPerson(String name, String lastName, int age, int phoneNumber) {
        Person person = new Person();

        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);
        person.setPhoneNumber(phoneNumber);

    }

    private void AddNewClient(String email, String address, String name, String lastName, int age, int phoneNumber) {
        Client client = new Client();

        client.setEmail(email);
        client.setAddress(address);
        client.setName(name);
        client.setLastName(lastName);
        client.setAge(age);
        client.setPhoneNumber(phoneNumber);

    }

    private void AddNewEmployee(String jobPosition, String password, String email, String name, String lastName, int age, int phoneNumber) {
        Employee employee = new Employee();

        employee.setJobPosition(jobPosition);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setPhoneNumber(phoneNumber);
    }
}
