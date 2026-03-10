package domain.event;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderCreated extends DomainEvent {

	private final String orderId;
	private final String customerId;
	private final BigDecimal amount;
	private final Instant createdAt;
	
	public OrderCreated(
			final String orderId, 
			final String customerId, 
			final BigDecimal amount) {
		
		this.orderId = orderId;
		this.customerId = customerId;
		this.amount = amount;
		this.createdAt = Instant.now();
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
	
	public Instant getCreatedAt() {
		return createdAt;
	}

}
