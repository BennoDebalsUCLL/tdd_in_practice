package bookstore.invoicing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// the database
public class Db {

    public static final Db INSTANCE = new Db();

    // order id -> { customer type, lines }
    // a line is { type, title, quantity, unit price }
    public Map<Integer, Object[]> orders = new HashMap<>();

    // order id -> invoice total
    public Map<Integer, Double> invoices = new HashMap<>();

    private Db() {
        orders.put(1, new Object[] {"REGULAR", lines(
                new String[] {"BOOK", "Refactoring", "2", "47.50"},
                new String[] {"STATIONERY", "Notebook A5", "1", "6.95"})});
        orders.put(2, new Object[] {"GOLD", lines(
                new String[] {"BOOK", "Clean Code", "1", "35.00"},
                new String[] {"BOOK", "Domain-Driven Design", "3", "54.99"})});
        orders.put(3, new Object[] {"STUDENT", lines(
                new String[] {"BOOK", "Head First Java", "12", "29.95"},
                new String[] {"STATIONERY", "Highlighter", "2", "1.20"})});
        orders.put(4, new Object[] {"REGULAR", lines(
                new String[] {"BOOK", "The Pragmatic Programmer", "1", "12.95"})});
    }

    private static List<String[]> lines(String[]... lines) {
        List<String[]> result = new ArrayList<>();
        for (String[] l : lines) {
            result.add(l);
        }
        return result;
    }
}
