package Sem4.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private String name;
    private List<T> box;

    public Box(String name) {
        this.name = name;
        box = new ArrayList<>();
    }

    public <H extends T> void add(H fruit) {
        box.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (Fruit fruit : box) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public String getName() {
        return name;
    }

    public void moveTo(Box<? super T> inBox) {
        for (T fruit : box) {
            inBox.add(fruit);
            // box.remove(fruit); Не понимаю, почему не работает!
        }
        box.removeAll(box);
        System.out.println("--------------------");
        System.out.printf("Перекладываем содержимое коробки \"%s\" в коробку \"%s\"\n",
                this.getName(), inBox.getName());
    }
}
