package kr.mollang.JpaInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

}
