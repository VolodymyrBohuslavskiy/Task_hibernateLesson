
import models.Contact;
import models.Email;
import models.Tel;
import models.User1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class main {
    private static Configuration configuration = new Configuration().configure()
            .addAnnotatedClass(Contact.class)
            .addAnnotatedClass(Tel.class)
            .addAnnotatedClass(Email.class)
            .addAnnotatedClass(User1.class);
    private static SessionFactory sessionFactory = configuration.buildSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static void main(String[] args) {
        session.beginTransaction();
//        Contact contact=new Contact("Stuart", "Little");
//
//        ArrayList<Tel> tels = new ArrayList<>();
//        tels.add(new Tel("1234567890", "0987654321",contact));
//
//
//        ArrayList<Email> emails = new ArrayList<>();
//        emails.add(new Email("йцукенгшщз", "їхзщшгнекуцй",contact));
//
//        tels.forEach(session::save);
//        emails.forEach(session::save);
//        ArrayList<User1> users=new ArrayList<>();
//        users.add(new User1("Jery","segdhrj","wesrdhtfgnb"));
//        users.add(new User1("Tod","sehdjrtf","sgdhrfvsedgv"));
//        users.add(new User1("Rod","esghdjrtf","sdfntrjbfvd"));
//        users.add(new User1("Robert","eshrjtfk","assgdhr"));
//        users.add(new User1("Ned","esgdjrt","asgedhr"));
//        users.add(new User1("Homer","asfgedhytky","sehrdjthd"));
//        users.add(new User1("Bart","sedrhtfjhgrd","sedhrt"));
//        users.add(new User1("Lissa","sgdfg","segdhrtfdrg"));
//        users.add(new User1("Magge","wegrhty","sedghrff"));
//        users.add(new User1("March","wegv","sfdghf"));
//        users.add(new User1("Nick","wfegf","sgdrhftdfgs"));
//        users.add(new User1("Apu","wevwkvbkw","sedhrtyjfh"));
//        users.add(new User1("Mangula","wevwebvw","segdhfghdg"));
//        users.add(new User1("Oleg","vewevw","sdghfjfgbcv"));
//        users.add(new User1("Roman","vwewsvwe","asfgdhftdg"));
//        users.add(new User1("Zack","vweewd","sfgdhrftfhdg"));
//        users.add(new User1("Grand","vwewdvw","asfdgfh"));
//        users.add(new User1("Tory","vwsed","sadgfhdgv"));
//        users.add(new User1("Adam","vwseesdv","sedgfhgsd"));
//        users.add(new User1("James","sdvsed","awesgdhrgd"));
//        users.add(new User1("Dog","1wegwe","sedhrtfhdrg"));
//
//        users.forEach(user1 -> addUser1(user1.getName(),user1.getSurname(),user1.getEmail()));


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }

    // 1_______________________________________________________________________
    private static void findAll() {
        List<Contact> contacts = session.createQuery("select u from Contact u", Contact.class).list();
        contacts.forEach(contact -> System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getTels() + " " + contact.getEmails()));
    }

    private static void findOne(int id) {
        List<Contact> contacts = session.createQuery("select u from Contact u", Contact.class).list();
        for (Contact contact : contacts) {
            if (contact.getId() == id) System.out.print(contact);
        }
    }

    private static void findByName(String name) {
        List<Contact> contacts = session.createQuery("select u from Contact u", Contact.class).list();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) System.out.print(contact);
        }

    }

    private static void updateNameWhereId(int id, String newName) {
        Contact contact = session.find(Contact.class, id);
        contact.setName(newName);
    }

    private static void delete(int id) {
        Contact contact = session.find(Contact.class, id);
        session.remove(contact);
    }

//2______________________________________________________________________

    private static void addUser1(String name, String surname, String email) {
        User1 user1 = new User1(name, surname, email);
        session.save(user1);
    }

    private static List<User1> seeAllUsers(char a) {
        List<User1> user1s = session.createQuery("select u from User1 u", User1.class).list();
        if (a == 'p') user1s.forEach(System.out::println);
        return user1s;
    }

    private static void delleteByName(String name) {
        List<User1> user1s = seeAllUsers('0');
        for (User1 user1 : user1s) {
            if (user1.getName().equals(name)) session.remove(user1);
        }
    }

    private static void seeByName(String name) {
        List<User1> allUsers = seeAllUsers('9');
        for (User1 allUser : allUsers) {
            if (allUser.getName().equals(name)) System.out.println(allUser);
        }
    }

    private static void delleteById(int id) {
        session.remove(session.find(User1.class, id));
    }
}