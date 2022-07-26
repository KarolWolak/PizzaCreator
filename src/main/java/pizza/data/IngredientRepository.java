package pizza.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pizza.Ingredient;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
