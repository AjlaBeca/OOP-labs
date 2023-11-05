package Week5_boxes;
import java.util.ArrayList;
import java.util.List;
public class MaxWeightBox extends Box{
        private int maxWeight;
        private int currentWeight=0;
        private List<Thing> things;

        public MaxWeightBox(int maxWeight){
            this.maxWeight=maxWeight;
            this.things = new ArrayList<>();
        }

    @Override
    public void add(Thing thing) {
        if (thing != null && currentWeight  + thing.getWeight() <= maxWeight) {
            things.add(thing);
            currentWeight+=thing.getWeight();
        }
    }
    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing item : things) {
            if (item.equals(thing)) {
                return true;
            }
        }
        return false;
    }
    }
