package de.samples.javaee.richfaces.jms.sample.domain;

import de.samples.javaee.richfaces.jms.sample.domain.interceptors.PublishEvent;
import de.samples.javaee.richfaces.jms.sample.domain.interceptors.Validated;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Validated
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

  @PublishEvent(BlogPostCreatedEvent.class)
  @Validated
  @Override
  public void create(@Valid @NotNull BlogPost blogPost) {
    blogPost.setTimestamp(LocalDateTime.now());
    this.sink.create(blogPost);
  }

}
