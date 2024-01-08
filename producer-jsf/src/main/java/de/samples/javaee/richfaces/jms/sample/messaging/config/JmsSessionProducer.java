package de.samples.javaee.richfaces.jms.sample.messaging.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import lombok.experimental.Delegate;

@ApplicationScoped
public class JmsSessionProducer {

  @Produces
  @Resource(lookup = "jms/ActiveMQConnectionFactory")
  ConnectionFactory connectionFactory;

  @Produces
  @RequestScoped
  Connection createJmsConnection() throws JMSException {
    return connectionFactory.createConnection();
  }

  void disposeConnection(@Disposes Connection connection) throws JMSException {
    connection.close();
  }

  @Produces
  @RequestScoped
  Session createJmsSession(Connection connection) throws JMSException {
    return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
  }

  void disposeSession(@Disposes Session session) throws JMSException {
    session.close();
  }

  @Produces
  @RequestScoped
  MessageFactory createMapMessage(Session session) {
    return new MessageFactoryImpl(session);
  }

  private record MessageFactoryImpl(
    @Delegate(types = MessageFactory.class) Session session
  ) implements MessageFactory {
  }

}
