package fr.da2i.flooz.repositories;

import fr.da2i.flooz.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}
