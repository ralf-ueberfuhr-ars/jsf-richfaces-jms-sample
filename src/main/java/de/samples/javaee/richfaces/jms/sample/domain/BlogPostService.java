package de.samples.javaee.richfaces.jms.sample.domain;

import de.samples.javaee.richfaces.jms.sample.domain.interceptors.PublishEvent;
import de.samples.javaee.richfaces.jms.sample.domain.interceptors.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Validated
public interface BlogPostService {
  long count();

  Stream<BlogPost> findAll();

  Optional<BlogPost> findById(UUID id);

  @PublishEvent(BlogPostCreatedEvent.class)
  void create(@Valid @NotNull BlogPost blogPost);
}
