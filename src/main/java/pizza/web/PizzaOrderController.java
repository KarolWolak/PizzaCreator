package pizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pizza.PizzaOrder;
import pizza.data.OrderRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class PizzaOrderController {

    private OrderRepository orderRepository;

    @Autowired
    public PizzaOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String orderCompleted(@Valid PizzaOrder pizzaOrder, Errors errors, SessionStatus status) {

        if (errors.hasErrors()) {
            return "orderForm";
        } else {
            orderRepository.save(pizzaOrder);
            status.setComplete();
            return "orderCompletedSummary";
        }
    }


}
