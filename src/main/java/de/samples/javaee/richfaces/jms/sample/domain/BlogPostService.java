package de.samples.javaee.richfaces.jms.sample.domain;

import de.samples.javaee.richfaces.jms.sample.domain.interceptors.PublishEvent;
import de.samples.javaee.richfaces.jms.sample.domain.interceptors.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/*
 * We use this to make the type proxyable. (default constructor!)
 * In Java, Annotations are not inherited from
 * interfaces as a restriction of multiple inheritance. So we have to repeat
 * the annotations at class level!
 */
@SuppressWarnings("unused")
public interface BlogPostService {

  long count();

  Stream<BlogPost> findAll();

  Optional<BlogPost> findById(UUID id);

  @PublishEvent(BlogPostCreatedEvent.class)
  @Validated
  void create(@Valid @NotNull BlogPost blogPost);
}
