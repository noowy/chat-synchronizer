package com.techtoha.chatsynchronizer.domain.vk;

import lombok.Data;

@Data
public class VkPhotoSource implements Comparable<VkPhotoSource>
{

    private String url;

    private Integer width;

    private Integer height;

    @Override
    public int compareTo(VkPhotoSource oth)
    {
        return this.getWidth() - oth.getWidth();
    }
}
