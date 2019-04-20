package practice2;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {
    private BigDecimal tax;

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = calculateSubtotal(products, items);
        BigDecimal discountTotal = calculateDiscountTotal(products, items);
        BigDecimal taxTotal = calculateTaxTotal(subTotal.subtract(discountTotal), tax);
        BigDecimal grandTotal = subTotal.subtract(discountTotal)
                                        .add(taxTotal);

        return grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    private OrderItem findOrderItemByProduct(List<OrderItem> items, Product product) {
        OrderItem curItem = null;

        for (OrderItem item : items) {
            if (item.getCode() == product.getCode()) {
                curItem = item;
                break;
            }
        }
        return curItem;
    }

    private BigDecimal calculateSubtotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = new BigDecimal(0);

        for (Product product : products) {
            OrderItem item = findOrderItemByProduct(items, product);
            BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(item.getCount()));
            subTotal = subTotal.add(itemTotal);
        }
        return subTotal;
    }

    private BigDecimal calculateDiscountTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal single = null;
        OrderItem curItem = null;

        for (Product product : products) {
            curItem = findOrderItemByProduct(items, product);

            single = product.getPrice()
                            .multiply(product.getDiscountRate())
                            .multiply(new BigDecimal(curItem.getCount()));
            total = total.add(single);
        }
        return total;
    }

    private BigDecimal calculateTaxTotal(BigDecimal total, BigDecimal tax) {
        return total.multiply(tax);
    }
}
