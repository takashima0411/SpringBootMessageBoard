package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
