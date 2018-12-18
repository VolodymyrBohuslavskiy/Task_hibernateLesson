//package models;
//
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//
//
//@Getter
//@Setter
//@EqualsAndHashCode
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//
//@ToString(exclude = {"user"})//Виключаємо з методу поле User;
//public class Passport {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//
//    private int pas_id;
//    String seria, number;
//
//    @OneToOne(
//            fetch = FetchType.LAZY,//Синхронізація
//            cascade = CascadeType.ALL)//тип дій з БД
//            User user;
//
//    public Passport(String seria, String number) {
//        this.seria = seria;
//        this.number = number;
//    }
//
//    public Passport(String seria, String number, User user) {
//        this.seria = seria;
//        this.number = number;
//        this.user = user;
//    }
//}
