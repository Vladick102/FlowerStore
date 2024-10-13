package flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack {
    private Flower flower;
    private int count;

    public double getPrice() {
        return flower.getPrice() * count;
    }

    public FlowerPack(Flower flower1, int count1) {
        flower = new Flower(flower1);
        count = count1;
    }

    public boolean match(FlowerPack fp) {
        return this.count == fp.count && this.flower.match(fp.flower);
    }

    @Override
    public String toString() {
        return "FlowerPack" + " " + this.getPrice() + " " + this.count;
    }
}
