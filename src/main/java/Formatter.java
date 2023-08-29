public class Formatter {
    double amount;
    int persons;
    String ending = " ";

    Formatter(double amount, int persons) {
        this.amount = amount;
        this.persons = persons;
    }

    void printPrice() {
        double perPerson = amount / persons;

        if (perPerson < 1) {
            ending += "рубля с человека";
        } else if (perPerson >= 5 && perPerson <= 20) {
            ending += "рублей с человека";
        } else {
            int reminderOfDivision = (int) Math.round(amount / persons % 10);
            switch (reminderOfDivision) {
                case 1:
                    ending += "рубль с человека";
                    break;
                case 2:
                case 3:
                case 4:
                    ending += "рубля с человека";
                    break;
                default:
                    ending += "рублей с человека";
                    break;
            }
        }

        System.out.println(String.format("%.2f", perPerson) + ending);
    }
}
