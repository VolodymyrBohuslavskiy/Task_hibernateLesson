package models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@ToString(exclude = {"tels", "emails"})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name, surname;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy ="contact")
    List<Tel> tels=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy ="contact")
    List<Email> emails=new ArrayList<>();


    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
