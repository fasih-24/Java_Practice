package com.faiz.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comnts")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmnt_id")
    private String id;
    @Column(name = "commen_name")
    private String name;
    @Column(name = "comment_email")
    private String email;
    @Column(name = "comment_body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false) // here the ID is from comments table foreign key (key of post table)
    private Post post;

}
