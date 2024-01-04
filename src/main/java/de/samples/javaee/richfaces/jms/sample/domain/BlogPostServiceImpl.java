package de.samples.javaee.richfaces.jms.sample.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostServiceImpl implements BlogPostService {

  private final BlogPostSink sink;

  @Override
  public long count() {
    return sink.count();
  }

  @Override
  public Stream<BlogPost> findAll() {
    return sink.findAll();
  }

  @Override
  public Optional<BlogPost> findById(UUID id) {
    return sink.findById(id);
  }

  @Override
  public void create(BlogPost blogPost) {
    blogPost.setTimestamp(LocalDateTime.now());
    this.sink.create(blogPost);
  }

}
