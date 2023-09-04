package ra.model.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    @Column(nullable = false, columnDefinition = "varchar(255")
    private String startHeraders;
    @Column(nullable = false, columnDefinition = "varchar(50")
    private String nameBlog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartHeraders() {
        return startHeraders;
    }

    public void setStartHeraders(String startHeraders) {
        this.startHeraders = startHeraders;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public Blog(Long id, String content, String startHeraders, String nameBlog) {
        this.id = id;
        this.content = content;
        this.startHeraders = startHeraders;
        this.nameBlog = nameBlog;
    }

    public Blog() {
    }

}
