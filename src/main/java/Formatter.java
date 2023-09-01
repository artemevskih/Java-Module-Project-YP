public class Formatter {
    double amount;
    int persons;
    String ending = " ";
    String byPerson = "с человека";

    Formatter(double amount, int persons) {
        this.amount = amount;
        this.persons = persons;
    }

    void printPrice() {
        double perPerson = this.amount / this.persons;

        if (perPerson < 1) {
            ending += "рубля";
        } else if ((perPerson % 100) >= 11 && (perPerson % 100) <= 19) {
            ending += "рублей";
        } else {
            int reminderOfDivision = (int) Math.round(this.amount / this.persons % 10);
            switch (reminderOfDivision) {
                case 1:
                    ending += "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ending += "рубля";
                    break;
                default:
                    ending += "рублей";
                    break;
            }
        }

        System.out.println(String.format("%.2f", perPerson) + ending + " " + byPerson);
    }
}
