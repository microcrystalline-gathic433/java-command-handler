package infrastructure.web;

import application.command.CreateOrderCommand;
import application.handler.CreateOrderCommandHandler;

//@RestController
//@RequestMapping("order")
public class OrderController {

	private final CreateOrderCommandHandler createOrderCommandHandler;
	
	public OrderController(
			final CreateOrderCommandHandler createOrderCommandHandler) {
		this.createOrderCommandHandler = createOrderCommandHandler;
	}
	
	public CreateOrderResponse create(
			final CreateOrderRequest request) {
		
		createOrderCommandHandler.handle(new CreateOrderCommand(
				request.getOrderId(),
				request.getCustomerId(),
				request.getAmount()));
		
		return CreateOrderResponse.ok();
		
	}
	
}
