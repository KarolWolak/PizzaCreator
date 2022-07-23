package pizza;

import lombok.Data;

import javax.persistence.*;
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

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 1, message = "Name is required")
    private String name;

    @Size(min = 1, message = "You need to choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();


    public void setPrice() {

        double totalPrice = getPizzaSize().getPrice();

        for (Ingredient ing : ingredients) {
            totalPrice += ing.getPrice();
        }

        this.price = totalPrice;

    }


    public enum PizzaSize {

        SMALL(8), LARGE(12);

        private double price;

        private double getPrice() {
            return price;
        }

        PizzaSize(double price) {
            this.price = price;
        }
    }
}
