package com.techtoha.chatsynchronizer.routing;

import com.techtoha.chatsynchronizer.domain.MessengerPlatform;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Chat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String sourceId;

    @NotBlank
    @NotNull
    private MessengerPlatform platform;

    @NotBlank
    @NotNull
    private String secret;

    @ManyToMany
    @JoinTable(
            name = "routing",
            joinColumns = @JoinColumn(name = "sourceId"),
            inverseJoinColumns = @JoinColumn(name = "targetId")
    )
    private List<Chat> targetChats;

    @ManyToMany
    @JoinTable(
            name = "routing",
            joinColumns = @JoinColumn(name = "targetId"),
            inverseJoinColumns = @JoinColumn(name = "sourceId")
    )
    private List<Chat> sourceChats;
}
