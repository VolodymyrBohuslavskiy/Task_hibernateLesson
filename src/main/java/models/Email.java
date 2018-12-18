package models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@ToString(exclude = {"contact"})
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String domen, title;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Contact contact;

    public Email(String domen, String title) {
        this.domen = domen;
        this.title = title;
    }

    public Email(String domen, String title, Contact contact) {
        this.domen = domen;
        this.title = title;
        this.contact = contact;
    }
}
