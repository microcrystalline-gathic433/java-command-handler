package domain.model;

import java.util.UUID;

public final class CustomerId {

	public static final CustomerId newId() {
		return new CustomerId(UUID.randomUUID());
	}

	public static final CustomerId fromString(
			final String name) {
		return new CustomerId(UUID.fromString(name));
	}

	private final UUID id;

	private CustomerId(final UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
