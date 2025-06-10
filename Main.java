import static kleave.util.*;

public class Main {
    public static void main(String[] args) {
        int n = ask("Enter number of elements: ", Integer.class);
        sopln(str("The entered number is $1", n));
    }
}
