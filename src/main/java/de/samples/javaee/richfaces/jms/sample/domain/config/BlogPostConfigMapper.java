package de.samples.javaee.richfaces.jms.sample.domain.config;

import de.samples.javaee.richfaces.jms.sample.domain.BlogPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface BlogPostConfigMapper {

  BlogPost map(BlogPostConfig source);

}
