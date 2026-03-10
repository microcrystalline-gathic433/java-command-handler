package domain.port;

import java.util.Optional;

import domain.model.Order;
import domain.model.OrderId;

public interface OrderRepository {

	Optional<Order> findById(OrderId id);
	
	void save(Order order);
	
}
