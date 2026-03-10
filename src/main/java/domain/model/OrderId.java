package domain.model;

import java.util.UUID;

public final class OrderId {

	public static final OrderId newId() {
		return new OrderId(UUID.randomUUID());
	}
	
	public static final OrderId fromString(
			final String name) {
		return new OrderId(UUID.fromString(name));
	}
	
	private final UUID id;
	
	private OrderId(
			final UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
}
