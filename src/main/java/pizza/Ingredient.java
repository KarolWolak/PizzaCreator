package pizza;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

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
    private final String name;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        CHEESE(1.5), VEGGIE(1), MEAT(2), SAUCE(0.5);

        private final double price;

        private Type(double price){
            this.price=price;
        }

        public double getPrice(){
            return price;
        }
    }

}
