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
        final int COUNT_A = 5;
        final int COUNT_B = 10;

        Flower flowerB = new Flower();
        flowerB.setPrice(PRICE);
        flowerB.setFlowerType(FlowerType.ROSE);

        flower.setPrice(PRICE);
        flower.setFlowerType(FlowerType.ROSE);

        FlowerBucket flowerBucket = new FlowerBucket();

        FlowerPack flowerPackA = new FlowerPack(flower, COUNT_A);
        FlowerPack flowerPackB = new FlowerPack(flower, COUNT_B);
        FlowerPack flowerPackC = new FlowerPack(flowerB, COUNT_A);

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
