package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testStore() {
        final int PRICE = 100;
        final int countA = 5;
        final int countB = 10;

        Flower flower2 = new Flower();
        flower2.setPrice(PRICE);
        flower2.setFlowerType(FlowerType.ROSE);

        flower.setPrice(PRICE);
        flower.setFlowerType(FlowerType.ROSE);

        FlowerBucket flowerBucket = new FlowerBucket();

        FlowerPack flowerPackA = new FlowerPack(flower, countA);
        FlowerPack flowerPackB = new FlowerPack(flower, countB);
        FlowerPack flowerPackC = new FlowerPack(flower2, countA);

        ArrayList<FlowerPack> arrA = new ArrayList<FlowerPack>();
        ArrayList<FlowerPack> arrB = new ArrayList<FlowerPack>();

        Store store = new Store(arrA);

        flowerBucket.add(flowerPackA);

        arrA.add(flowerPackA);
        arrA.add(flowerPackB);
        arrB.add(flowerPackA);

        ArrayList<FlowerPack> res = store.search(flowerPackC);

        Assertions.assertEquals(res, arrB);
    }
}
