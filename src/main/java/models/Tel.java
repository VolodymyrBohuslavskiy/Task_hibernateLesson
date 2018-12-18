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
public class Tel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String code, number;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Contact contact;

    public Tel(String code, String number) {
        this.code = code;
        this.number = number;
    }

    public Tel(String code, String number, Contact contact) {
        this.code = code;
        this.number = number;
        this.contact = contact;
    }
}
