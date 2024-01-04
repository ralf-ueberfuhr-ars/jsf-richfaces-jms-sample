package de.samples.javaee.richfaces.jms.sample.domain;

import de.samples.javaee.richfaces.jms.sample.domain.config.BlogPostConfigMapper;
import de.samples.javaee.richfaces.jms.sample.domain.config.BlogPostInitializationConfig;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
@Log
public class BlogPostInitializer {

  private final BlogPostService service;
  private final BlogPostInitializationConfig config;
  private final BlogPostConfigMapper mapper;

  void initBlogPosts(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
    log.log(Level.INFO, "Initializing blogposts with config: {0}", new Object[]{config});
    if (service.count() == 0 && config.isEnabled()) {
      config.getBlogposts()
        .stream()
        .map(this.mapper::map)
        .forEach(service::create);
    }

  }

}
