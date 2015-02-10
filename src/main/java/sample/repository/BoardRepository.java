package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entity.Board;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
