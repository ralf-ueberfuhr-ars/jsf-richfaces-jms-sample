package de.samples.javaee.richfaces.jms.sample.domain.config;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ApplicationScoped
@ToString
public class BlogPostInitializationConfig {

  private boolean enabled = true;
  private List<BlogPostConfig> blogposts = new LinkedList<>();

  // TODO we could use MicroProfile Config here instead
  {
    blogposts.add(
      BlogPostConfig.builder()
        .title("Welcome!")
        .content("This is a great blog!")
        .build()
    );
  }

}
