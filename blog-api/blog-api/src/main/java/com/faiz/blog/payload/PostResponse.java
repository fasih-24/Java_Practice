package com.faiz.blog.payload;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private List<PostDto> content;
    private int pageSize;
    private int pageNo;
    private int totalElements;
    private int totalPages;
    private boolean last;
}
