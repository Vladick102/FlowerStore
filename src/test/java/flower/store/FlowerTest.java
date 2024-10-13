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
        final int COUNT1 = 5;
        final int COUNT2 = 10;

        Flower flower2 = new Flower();
        flower2.setPrice(PRICE);
        flower2.setFlowerType(FlowerType.ROSE);

        flower.setPrice(PRICE);
        flower.setFlowerType(FlowerType.ROSE);

        FlowerBucket flowerBucket = new FlowerBucket();

        FlowerPack flowerPack1 = new FlowerPack(flower, COUNT1);
        FlowerPack flowerPack2 = new FlowerPack(flower, COUNT2);
        FlowerPack flowerPack3 = new FlowerPack(flower2, COUNT1);

        ArrayList<FlowerPack> arr1 = new ArrayList<FlowerPack>();
        ArrayList<FlowerPack> arr2 = new ArrayList<FlowerPack>();

        Store store = new Store(arr1);

        flowerBucket.add(flowerPack1);

        arr1.add(flowerPack1);
        arr1.add(flowerPack2);
        arr2.add(flowerPack1);

        ArrayList<FlowerPack> res = store.search(flowerPack3);

        Assertions.assertEquals(res, arr2);
    }
}
