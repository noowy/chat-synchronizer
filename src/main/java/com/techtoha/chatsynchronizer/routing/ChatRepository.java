package com.techtoha.chatsynchronizer.routing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long>
{
    List<Chat> findTargetChatsById(Long id); // change to find chat by natural id and platform
}
