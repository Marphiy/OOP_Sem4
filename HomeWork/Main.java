package Sem4.HomeWork;

// Есть классы: GoldenApple -> Apple -> Fruit
// Orange -> Fruit
// Есть класс Box. Нужно:
// 1. Организовать его так, чтобы он мог хранить только фрукты какого-то типа
// 2. Реализовать методы добавления фрукта, пересыпания в другую коробку, получение сумарного веса
// Ограничения:
// В коробку с апельсинами нельзя добавить яблоки
// В коробку с золотыми яблоками нельзя добавить апельсины и яблоки
// Пересыпать из коробки с золотыми яблоками в коробку с яблоками можно!

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>("Яблоки_1");
        Box<Apple> appleBox2 = new Box<>("Яблоки_2");
        Box<Orange> orangeBox1 = new Box<>("Апельсины_1");
        Box<Orange> orangeBox2 = new Box<>("Апельсины_2");
        Box<GoldenApple> goldenAppleBox1 = new Box<>("Золотые_Яблоки_1");

        appleBox1.add(new Apple(0.22));
        appleBox1.add(new Apple(0.13));
        appleBox1.add(new GoldenApple(0.26));
        appleBox2.add(new GoldenApple(0.1));
        appleBox2.add(new Apple(0.27));
        orangeBox2.add(new Orange(0.11));
        orangeBox2.add(new Orange(0.31));
        goldenAppleBox1.add(new GoldenApple(0.22));
        goldenAppleBox1.add(new GoldenApple(0.31));
        // goldenAppleBox1.add(new Apple(0.22)); НЕ РАБОТАЕТ
        // appleBox1.add(new Orange(0.6)); НЕ РАБОТАЕТ
        // orangeBox2.add(new Apple(0.7)); НЕ РАБОТАЕТ

        printWeight(appleBox1);
        printWeight(appleBox2);

        appleBox1.moveTo(appleBox2);
        printWeight(appleBox1);
        printWeight(appleBox2);

        appleBox2.moveTo(appleBox1);
        printWeight(appleBox1);
        printWeight(appleBox2);

        // orangeBox.moveTo(appleBox1); НЕ РАБОТАЕТ
        // appleBox2.moveTo(goldenAppleBox1); НЕ РАБОТАЕТ
        System.out.println("--------------------");
        printWeight(orangeBox1);
        printWeight(orangeBox2);
        orangeBox2.moveTo(orangeBox1);
        printWeight(orangeBox1);
        printWeight(orangeBox2);

        System.out.println("--------------------");
        printWeight(goldenAppleBox1);
        printWeight(appleBox1);
        goldenAppleBox1.moveTo(appleBox1);
        printWeight(goldenAppleBox1);
        printWeight(appleBox1);

    }

    public static void printWeight(Box<? extends Fruit> box) {
        System.out.printf("Масса коробки \"%s\" составляет %sкг\n",
                box.getName(), box.getWeight());
    }

}
