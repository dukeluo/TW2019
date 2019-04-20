package practice3;

import java.math.BigDecimal;

public class PriceCaculator {
    private Order order;

    public PriceCaculator(Order order) {
        this.order = order;
    }

    public BigDecimal calculate() {
        BigDecimal result = new BigDecimal(0);
        BigDecimal tax = null;

        // Total up line items
        for (OrderLineItem lineItem : order.getOrderLineItemList()) {
            result = result.add(lineItem.getPrice());
        }

        // Subtract discounts
        for (BigDecimal discount : order.getDiscounts()) {
            result = result.subtract(discount);
        }

        // calculate tax
        tax = result.multiply(order.getTax());

        // calculate GrandTotal
        result = result.add(tax);

        return result;
    }
}
