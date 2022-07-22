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
                ingredientRepository.save(new Ingredient("SAUS", "Sausage", Type.MEAT, 2d));
                ingredientRepository.save(new Ingredient("CHIC", "Chicken", Type.MEAT, 2d));
                ingredientRepository.save(new Ingredient("TOMA", "Tomato", Type.VEGGIE, 1d));
                ingredientRepository.save(new Ingredient("CORN", "Corn", Type.VEGGIE, 1d));
                ingredientRepository.save(new Ingredient("SALS", "Salsa sauce", Type.SAUCE, 0.5));
                ingredientRepository.save(new Ingredient("SPIC", "Spicy sauce", Type.SAUCE, 0.5));
                ingredientRepository.save(new Ingredient("MOZZ", "Mozzarella cheese", Type.CHEESE, 1.5));
                ingredientRepository.save(new Ingredient("CHED", "Cheddar cheese", Type.CHEESE, 1.5));
            }

        };
    }
}
