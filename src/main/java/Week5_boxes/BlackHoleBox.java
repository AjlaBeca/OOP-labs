package Week5_boxes;

public class BlackHoleBox extends Box{
    public BlackHoleBox(){}

    @Override
    public void add(Thing thing) {
        // Anything can be added to a black-hole box.
    }

    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
