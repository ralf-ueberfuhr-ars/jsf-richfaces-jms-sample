package de.samples.javaee.richfaces.jms.sample.domain;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Singleton
@Log
public class BlogPostEventLogger {

  void logBlogPostCreated(@Observes BlogPostCreatedEvent evt) {
    log.log(Level.INFO, "BlogPost created: {0}", new Object[]{evt.blogPost()});
  }

}
