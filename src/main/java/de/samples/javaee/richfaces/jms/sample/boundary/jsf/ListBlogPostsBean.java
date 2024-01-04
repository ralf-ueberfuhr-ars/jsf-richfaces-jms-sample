package de.samples.javaee.richfaces.jms.sample.boundary.jsf;

import de.samples.javaee.richfaces.jms.sample.domain.BlogPost;
import de.samples.javaee.richfaces.jms.sample.domain.BlogPostService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@ApplicationScoped
@Named("listBlogPostsBean")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ListBlogPostsBean {

  private final BlogPostService service;

  public Collection<BlogPost> getBlogPosts() {
    return service.findAll()
      .collect(Collectors.toList());
  }


}
