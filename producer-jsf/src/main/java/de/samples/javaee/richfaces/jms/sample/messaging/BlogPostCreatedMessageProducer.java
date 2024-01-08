package de.samples.javaee.richfaces.jms.sample.messaging;

import de.samples.javaee.richfaces.jms.sample.domain.BlogPostCreatedEvent;
import de.samples.javaee.richfaces.jms.sample.messaging.config.BlogPostEventsTopic;
import de.samples.javaee.richfaces.jms.sample.messaging.config.MessageFactory;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import lombok.RequiredArgsConstructor;

import java.time.format.DateTimeFormatter;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostCreatedMessageProducer {

  @BlogPostEventsTopic
  private final MessageProducer sender;
  private final MessageFactory messageFactory;

  // We listen to both synchronous and asynchronous event publishings.
  void sendBlogPostCreated(@ObservesAsync BlogPostCreatedEvent evt) throws JMSException {
    final var post = evt.blogPost();
    if (post.isInitial()) {
      return;
    }
    final var message = messageFactory.createMapMessage();
    message.setStringProperty(
      "produced-by",
      "jms-jsf-sample-app"
    );
    message.setStringProperty(
      "event-type",
      "CREATED"
    );
    message.setString(
      "id",
      evt.blogPost().getId().toString()
    );
    message.setString(
      "title",
      evt.blogPost().getTitle()
    );
    message.setString(
      "timestamp",
      DateTimeFormatter
        .ISO_LOCAL_DATE_TIME
        .format(evt.blogPost().getTimestamp())
    );
    sender.send(message);
  }

}
