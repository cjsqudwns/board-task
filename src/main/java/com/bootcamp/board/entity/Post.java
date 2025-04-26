package com.bootcamp.board.entity;

import com.bootcamp.board.entity.constant.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Entity
public class Post extends AuditingFields {

    @ToString.Exclude
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private final Set<PostComment> postComments = new LinkedHashSet<>();
    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", columnDefinition = "VARCHAR(50)")
    private CategoryType categoryType;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    protected Post() {
    }

    private Post(String title, String content, CategoryType categoryType, User user) {
        this.title = title;
        this.content = content;
        this.categoryType = categoryType;
        this.user = user;
    }

    public static Post of(String title, String content, CategoryType categoryType, User user) {
        return new Post(title, content, categoryType, user);
    }
}