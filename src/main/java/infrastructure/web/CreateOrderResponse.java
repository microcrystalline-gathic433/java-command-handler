package infrastructure.web;

public class CreateOrderResponse {

	public static CreateOrderResponse ok() {
		return new CreateOrderResponse("Request Success");
	}
	
	private final String message;
	
	private CreateOrderResponse(
			final String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
