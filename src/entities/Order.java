package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    public Order () {}

    public Order (LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double total = 0.0;
        for (OrderItem c : items) {
            total += c.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        Double sum = 0.0;

        sb.append("ORDER SUMMARY:");
        sb.append("\n");
        sb.append("Order moment: " + moment.format(dtf));
        sb.append("\n");
        sb.append("Order status: " + status.toString());
        sb.append("\n");
        sb.append(client);
        sb.append("\n");
        sb.append("Order items:");
        sb.append("\n");

        for (OrderItem item : items) {
            sb.append(item.getProduct().toString() + ", ");
            sb.append("Quantity: " + item.getQuantity() + ", ");
            sb.append("Subtotal: $" + String.format("%.2f", item.subTotal()));
            sb.append("\n");
            sum += item.subTotal();
        }

        sb.append("Total price: $" + String.format("%.2f", sum));

        return sb.toString();
    }
}
