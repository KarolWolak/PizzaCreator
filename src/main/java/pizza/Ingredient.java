package pizza;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;
    private Double price;

    public enum Type {
        CHEESE, VEGGIE, MEAT, SAUCE;
    }

}
