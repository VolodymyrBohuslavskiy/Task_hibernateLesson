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
//@ToString(exclude = {"passport"})//Виключаємо з методу поле passport;
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//    String name, surname;
//
//    @OneToOne(
//            mappedBy = "user",//Тільки з одної сторони, додає колонку з ід юзера, означає що поле user мапується на поле user в обєкті passport (типу Passport)
//            fetch = FetchType.LAZY,//підтягування
//            cascade = CascadeType.ALL)//тип дій з БД)
//
//            Passport passport;
//
//    public User(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    public User(String name, String surname, Passport passport) {
//        this.name = name;
//        this.surname = surname;
//        this.passport = passport;
//    }
//}
//
//
//
//
//
//
//
