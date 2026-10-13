package bookstore.invoicing;

public class Main {

    public static void main(String[] args) {
        InvoiceService service = new InvoiceService();
        for (int orderId = 1; orderId <= 4; orderId++) {
            service.createInvoice(orderId);
        }
    }
}
