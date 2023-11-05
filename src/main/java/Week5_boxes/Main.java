package Week5_boxes;

public class Main {

        public static void main(String[] args) {

            //items
            Thing item1= new Thing("Saludo", 5);
            Thing item2=new Thing("Pirkka", 5);
            Thing item3=new Thing("Kopi Luwak", 5);


            MaxWeightBox coffeeBox=new MaxWeightBox(10);
            //adding items to MaxWeightBox
            coffeeBox.add(item1);
            coffeeBox.add(item2);
            coffeeBox.add(item3);

            //checking if items are in MaXxWeightBox
            System.out.println(coffeeBox.isInTheBox(item1));
            System.out.println(coffeeBox.isInTheBox(item2));
            System.out.println(coffeeBox.isInTheBox(item3));
            System.out.println();

            OneThingBox box = new OneThingBox();
            //adding items to OneThingBox
            box.add(item1);
            box.add(item2);

            //checking if items are in OneThingBox
            System.out.println(box.isInTheBox(item1));
            System.out.println(box.isInTheBox(item2));
            System.out.println();

            BlackHoleBox blackhole =new BlackHoleBox();
            //adding items to BlackHoleBox
            blackhole.add(item1);
            blackhole.add(item2);

            //checking if items are in BlackHoleBox
            System.out.println(blackhole.isInTheBox(item1));
            System.out.println(blackhole.isInTheBox(item2));
            System.out.println();

            // upcasting
            Box box1 = new MaxWeightBox(10);
            Box box2 = new OneThingBox();
            Box box3 = new BlackHoleBox();

            //downcasting
            if (box1 instanceof MaxWeightBox) {
                MaxWeightBox maxWeightBox = (MaxWeightBox) box1;
            }

            if (box2 instanceof OneThingBox) {
                OneThingBox oneThingBox = (OneThingBox) box2;
            }

            if (box3 instanceof BlackHoleBox) {
                BlackHoleBox blackHoleBox = (BlackHoleBox) box3;
            }

            // we cannot upcast/downcast Thing to Box, as Thing is not a child class of Box
        }
}

