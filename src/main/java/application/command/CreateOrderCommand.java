package application.command;

import java.math.BigDecimal;

public final class CreateOrderCommand {

	private final String orderId;
	private final String customerId;
	private final BigDecimal amount;
	
	public CreateOrderCommand(
			final String orderId,
			final String customerId,
			final BigDecimal amount) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.amount = amount;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
}
