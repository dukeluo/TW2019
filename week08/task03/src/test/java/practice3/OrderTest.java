package practice3;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jxzhong on 2017/8/29.
 */
public class OrderTest {
    @Test
    public void calculate() throws Exception {
        //Given
        List<OrderLineItem> orderLineItemList = asList(new OrderLineItem(100),
                new OrderLineItem(50),
                new OrderLineItem(30));
        List<BigDecimal> discounts = asList(new BigDecimal(10),
                new BigDecimal(5),
                new BigDecimal(3));
        Order order = new Order(orderLineItemList, discounts);

        //When
        BigDecimal total = order.calculate();
        BigDecimal expectedTotal = new BigDecimal(178.2);

        //Then
        assertThat(total.setScale(2, BigDecimal.ROUND_HALF_UP),
                is(expectedTotal.setScale(2, BigDecimal.ROUND_HALF_UP)));
    }


}