package application.handler;

import application.command.CreateOrderCommand;
import application.event.EventPublisher;
import domain.model.CustomerId;
import domain.model.Order;
import domain.model.OrderId;
import domain.port.OrderRepository;

public class CreateOrderCommandHandler {

	private final OrderRepository orderRepository;
	private final EventPublisher eventPublisher;
	
	public CreateOrderCommandHandler(
			final OrderRepository orderRepository,
			final EventPublisher eventPublisher) {
		
		this.orderRepository = orderRepository;
		this.eventPublisher = eventPublisher;
	}
	
	public void handle(
			final CreateOrderCommand command) {
		Order order = Order.create(
				OrderId.fromString(command.getOrderId()), 
				CustomerId.fromString(command.getCustomerId()),
				command.getAmount());
		orderRepository.save(order);
		eventPublisher.publish(order.pullDomainEvents());
	}
	
}
