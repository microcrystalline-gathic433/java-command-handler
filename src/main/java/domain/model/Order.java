package domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.event.DomainEvent;
import domain.event.OrderCreated;

public final class Order {

	public static Order create(
			final OrderId id,
			final CustomerId customerId,
			final BigDecimal amount) {
		ensureAmount(amount);
		return new Order(id, customerId, amount);
	}
	
	private static void ensureAmount(
			final BigDecimal amount) {
		if(amount.signum() == -1) {
			String msg = "Amount must be positive";
			throw new IllegalArgumentException(msg);
		}
	}

	private final OrderId id;
	private final CustomerId customerId;
	private final BigDecimal amount;
	private final OrderStatus status;
	private final List<DomainEvent> events;
	
	private Order(
			final OrderId id,
			final CustomerId customerId,
			final BigDecimal amount) {
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
		this.status = OrderStatus.CREATED;
		this.events = new ArrayList<>();
		this.events.add(new OrderCreated(
				id.getId().toString(),
				customerId.getId().toString(),
				amount));
	}
	
	public List<DomainEvent> pullDomainEvents() {
		List<DomainEvent> events = List.copyOf(this.events);
		this.events.clear();
		return events;
	}
	
	public OrderId getId() {
		return id;
	}
	
	public CustomerId getCustomerId() {
		return customerId;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
}
