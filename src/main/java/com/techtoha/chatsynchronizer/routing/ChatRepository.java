package com.techtoha.chatsynchronizer.routing;

import com.techtoha.chatsynchronizer.domain.MessengerPlatform;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long>
{
    Optional<Chat> findChatBySourceIdAndPlatform(String sourceId, MessengerPlatform platform);
}
