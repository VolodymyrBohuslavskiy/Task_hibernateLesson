package models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String
            name,
            surname,
            tel ,
            email,
            login,
            password;

    public User1(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tel= "+380" + new Random().nextInt(999999);
        this.login = name+surname+tel.substring(8);
        this.password = generatePassword(name,1);
    }
    private static String generatePassword(String s, int kay) {
        byte[] c = s.getBytes();
        byte[] cnew = new byte[c.length];
        for (int i = 0; i < c.length; i++) {
            byte b = c[i];
            int i1 = kay + b;
            cnew[i] = (byte) i1;
        }
        String s1 = new String(cnew);
        return s1;
    }
}
