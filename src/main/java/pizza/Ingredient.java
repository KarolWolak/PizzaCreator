package pizza;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        CHEESE(1.5), VEGGIE(1), MEAT(2), SAUCE(0.5);

        private double price;

        private Type(double price){
            this.price=price;
        }

        public double getPrice(){
            return price;
        }
    }

}
