package com.example.konkukhealth.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pk")
    private Long pk;

    @Column(unique = true)
    private String id;
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_info_post", joinColumns = @JoinColumn(name = "user_pk"))
    @Column(name = "post")
    private List<Long> post;

    @ElementCollection
    @CollectionTable(name = "user_info_gym", joinColumns = @JoinColumn(name = "user_pk"))
    @Column(name = "gym")
    private List<Long> gym;

    @ElementCollection
    @CollectionTable(name = "user_info_friend", joinColumns = @JoinColumn(name = "user_pk"))
    @Column(name = "friend")
    private List<Long> friend;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getPost() {
        return post;
    }

    public void setPost(List<Long> post) {
        this.post = post;
    }

    public List<Long> getGym() {
        return gym;
    }

    public void setGym(List<Long> gym) {
        this.gym = gym;
    }

    public List<Long> getFriend() {
        return friend;
    }

    public void setFriend(List<Long> friend) {
        this.friend = friend;
    }
}
