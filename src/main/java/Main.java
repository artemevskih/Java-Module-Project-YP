
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = 0;
        int indexOfProduct = 1;
        String listOfProducts = "Добавленные товары:\n";
        double amount = 0;
        boolean success = false;

        System.out.println("На скольких человек необходимо разделить счёт?");

        while (!success) {
            try {
                numberOfPeople = scanner.nextInt();

                if (numberOfPeople >= 1) {
                    success = true;
                } else {
                    System.err.println("Введите корректное значение");
                    System.out.println("На скольких человек необходимо разделить счёт?");
                    System.out.println("(Ожидается целое число большее или равное 1)");
                    success = false;
                }
            } catch (Exception e) {
                System.err.println("Введите корректное значение");
                System.out.println("На скольких человек необходимо разделить счёт?");
                System.out.println("(Ожидается целое число большее или равное 1)");
                scanner.next();
            }
        }

        while (true) {
            if (numberOfPeople == 1) {
                System.out.println("Делить счёт незачем");
                break;
            } else if (numberOfPeople > 1) {
                System.out.println("Количество человек " + numberOfPeople);

                while (true) {
                    Product product = new Product();
                    System.out.println("Чтобы завершить работу приложения введите \"Завершить\"");
                    System.out.println("Введите название товара");

                    product.name = scanner.next();

                    if (product.name.equalsIgnoreCase("Завершить")) {
                        System.out.println("Работа калькулятора завершена");
                        break;
                    } else {
                        System.out.println("Введите стоимость товара");
                        success = false;

                        while (!success) {
                            try {
                                product.price = scanner.nextDouble();
                                success = true;
                            } catch (Exception e) {
                                System.err.println("Введите корректное значение");
                                scanner.next();
                            }
                        }
                    }

                    System.out.println("Товар \""+ product.name + "\" успешно добавлен\n");

                    listOfProducts += indexOfProduct + ". " + product.name + " - " + String.format("%.2f", product.price) + "\n";
                    amount += Math.floor(product.price * 100) / 100;
                    indexOfProduct++;
                }

                BillMaker billMaker = new BillMaker(listOfProducts, amount, numberOfPeople);
                billMaker.makeBill();

                break;
            }
        }
    }
}