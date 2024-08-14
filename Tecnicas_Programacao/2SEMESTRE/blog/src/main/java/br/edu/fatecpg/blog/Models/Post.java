package br.edu.fatecpg.blog.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String content;

  @OneToMany(
    mappedBy = "post",
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
  )
  private List<Comment> comments = new ArrayList<>();

  public Post() {}

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(Comment comments) {
    comments.setPost(this);
    this.comments.add(comments);
  }

  @Override
  public String toString() {
    return (
      "Post [id=" +
      id +
      ", title=" +
      title +
      ", content=" +
      content +
      ", comments=" +
      comments +
      "]"
    );
  }
}
