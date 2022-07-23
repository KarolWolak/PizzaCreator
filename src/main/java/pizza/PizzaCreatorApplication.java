package pizza;

import pizza.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pizza.Ingredient.Type;

@SpringBootApplication
public class PizzaCreatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaCreatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                ingredientRepository.save(new Ingredient("Sausage", Type.MEAT, 2d));
                ingredientRepository.save(new Ingredient("Chicken", Type.MEAT, 2d));
                ingredientRepository.save(new Ingredient("Tomato", Type.VEGGIE, 1d));
                ingredientRepository.save(new Ingredient("Corn", Type.VEGGIE, 1d));
                ingredientRepository.save(new Ingredient("Salsa sauce", Type.SAUCE, 0.5));
                ingredientRepository.save(new Ingredient("Spicy sauce", Type.SAUCE, 0.5));
                ingredientRepository.save(new Ingredient("Mozzarella cheese", Type.CHEESE, 1.5));
                ingredientRepository.save(new Ingredient("Cheddar cheese", Type.CHEESE, 1.5));
            }

        };
    }
}
