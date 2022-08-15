package pizza.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pizza.PizzaOrder;

@Repository
public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
}
