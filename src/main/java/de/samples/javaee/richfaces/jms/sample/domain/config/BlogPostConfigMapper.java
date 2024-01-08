package de.samples.javaee.richfaces.jms.sample.domain.config;

import de.samples.javaee.richfaces.jms.sample.domain.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface BlogPostConfigMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "timestamp", ignore = true)
  BlogPost map(BlogPostConfig source);

}
