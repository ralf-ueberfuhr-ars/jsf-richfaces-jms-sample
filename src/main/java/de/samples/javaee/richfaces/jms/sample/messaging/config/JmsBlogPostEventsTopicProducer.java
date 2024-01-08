package de.samples.javaee.richfaces.jms.sample.messaging.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.Topic;

@ApplicationScoped
public class JmsBlogPostEventsTopicProducer {

  @Produces
  @BlogPostEventsTopic
  @Resource(lookup = "jms/BlogPostEventsTopic")
  Topic blogPostEventsTopic;

  @Produces
  @RequestScoped
  @BlogPostEventsTopic
  MessageProducer createBlogPostEventsTopicProducer(Session session) throws JMSException {
    return session.createProducer(blogPostEventsTopic);
  }

}
