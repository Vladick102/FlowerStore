package flower.store;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    public Flower(Flower flower) {
        flowerType = flower.flowerType;
        sepalLength = flower.sepalLength;
        price = flower.price;
        color = flower.color;
    }

    public boolean match(Flower f) {
        return this.price == f.getPrice() && this.flowerType.equals(f.getFlowerType())
                && this.getSepalLength() == f.getSepalLength();
    }
}
