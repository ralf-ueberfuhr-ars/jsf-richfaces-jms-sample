package de.samples.javaee.richfaces.jms.sample.domain.config;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class BlogPostConfig {

  private String title;
  private String content;
  private boolean initial;

}
