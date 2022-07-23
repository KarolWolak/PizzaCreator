package pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar placedAt = Calendar.getInstance();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    @NotBlank(message = "This field can not be empty")
    private String deliveryCity;

    @NotBlank(message = "This field can not be empty")
    private String deliveryState;

    @NotBlank(message = "This field can not be empty")
    private String deliveryZipCode;

    @NotBlank(message = "This field can not be empty")
    private String deliveryStreet;

    @NotBlank(message = "This field can not be empty")
    private String clientName;

    @NotBlank(message = "This field can not be empty")
    private String buildingNumber;

    @CreditCardNumber(message = "Invalid credit card number")
    private String CCNumber;

    @Pattern(regexp = "(0[1-9]||1[0-2])/([2-9][0-9])", message = "Please enter valid format: MM/YY")
    private String CCExpiration;

    @Pattern(regexp = "\\d{3}", message = "Invalid CVV")
    private String CCCVV;

    private double totalPrice = 0;

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void setTotalPrice(double pizzaPrice) {
        totalPrice += pizzaPrice;
    }

    public String getDeliveryTime() {

        int hours = placedAt.get(Calendar.HOUR_OF_DAY);

        if (hours == 23) {
            hours = 0;
        } else {
            hours += 1;
        }

        int minutes = placedAt.get(Calendar.MINUTE);


        return String.format("%s:%s", hours < 10 ? "0" + hours : hours,
                minutes < 10 ? "0" + minutes : minutes);

    }

}
