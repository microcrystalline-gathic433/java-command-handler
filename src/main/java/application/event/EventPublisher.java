package application.event;

import java.util.List;

import domain.event.DomainEvent;

public interface EventPublisher {

	void publish(List<DomainEvent> events);
	
}
