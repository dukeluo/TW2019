package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal calculate() {
        return new PriceCaculator(this).calculate();
    }

    List<OrderLineItem> getOrderLineItemList() {
        return orderLineItemList;
    }

    List<BigDecimal> getDiscounts() {
        return discounts;
    }

    BigDecimal getTax() {
        return tax;
    }
}
