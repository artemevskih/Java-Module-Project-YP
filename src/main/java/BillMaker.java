public class BillMaker {
    String products;
    double amount;
    int numberOfPersons;

    BillMaker(String products, double amount, int numberOfPersons) {
        this.products = products;
        this.amount = amount;
        this.numberOfPersons = numberOfPersons;
    }

    void makeBill() {
        Formatter formatter = new Formatter(this.amount, this.numberOfPersons);

        System.out.println(this.products);
        System.out.println("Обшая сумма = " + String.format("%.2f", this.amount));
        formatter.printPrice();
    }
}
