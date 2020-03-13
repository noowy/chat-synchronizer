package com.techtoha.chatsynchronizer.domain.vk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.web.SortDefault;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

@Data
public class VkPhoto
{

    private Long id;

    @JsonProperty("sizes")
    private SortedSet<VkPhotoSource> sources;

    public VkPhotoSource getHighestResPhoto()
    {
        // Collections.sort(sources);
        return sources.last();
    }
}
