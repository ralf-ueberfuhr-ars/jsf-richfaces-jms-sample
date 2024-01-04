package de.samples.javaee.richfaces.jms.sample.boundary.jsf;

import de.samples.javaee.richfaces.jms.sample.domain.BlogPost;
import de.samples.javaee.richfaces.jms.sample.domain.BlogPostService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequestScoped
@Named("createBlogPostBean")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CreateBlogPostBean {

  private final BlogPostService service;

  @Getter
  private BlogPost newBlogPost = BlogPost.builder().build();

  public String action() {
    service.create(this.newBlogPost);
    this.newBlogPost = BlogPost.builder().build();
    return null;
  }

}
