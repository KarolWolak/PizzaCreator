package pizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pizza.Ingredient;
import pizza.Pizza;
import pizza.PizzaOrder;
import pizza.data.IngredientRepository;

import pizza.Ingredient.Type;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class PizzaDesignController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public PizzaDesignController(IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i->ingredients.add(i));

        Type[] types = Ingredient.Type.values();

        for(Type type:types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients,type));
        }
    }

    @ModelAttribute(name="pizzaOrder")
    public PizzaOrder pizzaOrder(){
        return new PizzaOrder();
    }

    @ModelAttribute(name="pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm(){
        return "designForm";
    }

    @PostMapping
    public String addPizza(@ModelAttribute PizzaOrder pizzaOrder, @Valid Pizza pizza, Errors errors){
        if (errors.hasErrors()){
            return "designForm";
        }

        pizza.setPrice();
        pizzaOrder.addPizza(pizza);
        pizzaOrder.setTotalPrice(pizza.getPrice());
        return "redirect:/orders/current";
    }


    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }


}
