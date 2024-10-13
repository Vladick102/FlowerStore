package flower.store;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Store {
    private static ArrayList<FlowerPack> inventory;

    public Store(ArrayList<FlowerPack> lst) {
        inventory = lst;
    }

    public static void append(FlowerPack pack) {
        inventory.add(0, pack);
    }

    public ArrayList<FlowerPack> search(FlowerPack pack) {
        ArrayList<FlowerPack> matched = new ArrayList<FlowerPack>();
        for (FlowerPack p : inventory) {
            if (p.match(pack)) {
                matched.add(p);
            }
        }
        return matched;
    }
}
