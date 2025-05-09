package me.dongwook.chat.domain.repository;

import me.dongwook.chat.domain.repository.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findTop10BySenderOrReceiverOrderByTIDSDesc(String sender, String receiver);

    /*@Query(
            "select c from chat As c where c.sender = :sender or c.receiver = :receiver order by c.t_id desc limit 10"
    )
    List<Chat> findTop10Chrts(@Param("sender") String sender, @Param("receiver") String receiver);*/
}
