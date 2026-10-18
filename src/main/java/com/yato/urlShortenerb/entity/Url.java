package com.yato.urlShortenerb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true,nullable = false)
    private String shortCode;

    @Column(nullable = false,columnDefinition = "text")
    private String longUrl;

    private Long clickCount=0L;

    private LocalDateTime crtAt= LocalDateTime.now();

    private LocalDateTime expiry;

    public Url() {
    }

    public Url(Long id, User user, String shortCode, String longUrl, Long clickCount, LocalDateTime crtAt, LocalDateTime expiry) {
        this.id = id;
        this.user = user;
        this.shortCode = shortCode;
        this.longUrl = longUrl;
        this.clickCount = clickCount != null ? clickCount : 0L;
        this.crtAt = crtAt != null ? crtAt : LocalDateTime.now();
        this.expiry = expiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getCrtAt() {
        return crtAt;
    }

    public void setCrtAt(LocalDateTime crtAt) {
        this.crtAt = crtAt;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id) && Objects.equals(shortCode, url.shortCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortCode);
    }

    @Override
    public String toString() {
        return "Url(id=" + id + ", shortCode=" + shortCode + ", longUrl=" + longUrl + ")";
    }
}
