package pizza;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "You need to choose a size")
    @Enumerated(EnumType.STRING)
    private PizzaSize pizzaSize;

    private double price;

    private final Date createdAt = new Date();

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "You need to choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();


    public void setPrice() {

        double totalPrice = getPizzaSize().getPrice();

        for (Ingredient ing : ingredients) {
            totalPrice += ing.getType().getPrice();
        }

        this.price = totalPrice;

    }


    public enum PizzaSize {

        SMALL(8), LARGE(12);

        private final double price;

        private double getPrice() {
            return price;
        }

        PizzaSize(double price) {
            this.price = price;
        }
    }
}
