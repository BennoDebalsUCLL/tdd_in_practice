package bookstore.invoicing;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

// Invoice service. Works fine, do not touch! (JV, 2019)
public class InvoiceService {

    @SuppressWarnings("unchecked")
    public void createInvoice(int orderId) {
        Object[] o = Db.INSTANCE.orders.get(orderId);
        if (o == null) {
            System.out.println("ERROR: order " + orderId + " not found");
            return;
        }
        String ct = (String) o[0];
        List<String[]> lines = (List<String[]>) o[1];

        // calculate totals
        double b = 0;
        double s = 0;
        for (String[] l : lines) {
            int qty = Integer.parseInt(l[2]);
            double price = Double.parseDouble(l[3]);
            if (l[0].equals("BOOK")) {
                b = b + qty * price;
            } else {
                s = s + qty * price;
            }
        }

        // discount
        double d = 0;
        if (ct.equals("GOLD")) {
            d = (b + s) * 0.05;
        } else if (ct.equals("STUDENT")) {
            d = b * 0.10;
        }

        // vat
        double vat = b * 0.06 + s * 0.21;

        // handling fee, free on sundays
        double fee = 1.50;
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            fee = 0;
        }

        double total = b + s - d + vat + fee;
        total = (int) (total * 100) / 100.0; // round to cents

        Db.INSTANCE.invoices.put(orderId, total);
        System.out.println("Invoice for order " + orderId + ": " + total);
    }
}
