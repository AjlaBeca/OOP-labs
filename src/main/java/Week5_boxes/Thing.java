package Week5_boxes;
import java.util.Objects;
public class Thing {
    private String name;
    private int weight;
    public Thing(String name, int weight){
        if(weight<0){
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.name=name;
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object object){
        if(object==null){
            return false;
        }
        if(this.getClass()!=object.getClass()){
            return false;
        }
        Thing compared=(Thing) object;
        if(this.name==null || !this.name.equals(compared.getName())){
            return false;
        }

        if(this.weight!=compared.getWeight()){
            return false;
        }

        return true;
    }

}
