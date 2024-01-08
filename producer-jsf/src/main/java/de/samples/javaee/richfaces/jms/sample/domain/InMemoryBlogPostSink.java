package de.samples.javaee.richfaces.jms.sample.domain;

import de.samples.javaee.richfaces.jms.sample.domain.extensions.ConditionalOnMissingBean;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
@ConditionalOnMissingBean(BlogPostSink.class)
public class InMemoryBlogPostSink implements BlogPostSink {

  private final Map<UUID, BlogPost> blogPosts = new HashMap<>();

  @Override
  public long count() {
    return this.blogPosts.size();
  }

  @Override
  public void create(BlogPost post) {
    final var id = UUID.randomUUID();
    post.setId(id);
    this.blogPosts.put(id, post);

  }

  @Override
  public Stream<BlogPost> findAll() {
    return blogPosts.values().stream();
  }

  @Override
  public Optional<BlogPost> findById(UUID id) {
    return Optional.ofNullable(
      this.blogPosts.get(id)
    );
  }
}
