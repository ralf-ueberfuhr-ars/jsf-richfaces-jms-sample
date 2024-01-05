package de.samples.javaee.jms.consumer;

import jakarta.ejb.MessageDriven;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.logging.Level;

@MessageDriven(name = "BlogPostEventHandlerMDB")
@Log
public class BlogPostEventsConsumer implements MessageListener {

  @SneakyThrows
  @Override
  public void onMessage(Message message) {
    logger.log(Level.INFO, "Blog Post Event received: {0}", message);
    if(message instanceof MapMessage mm) {
      logger.log(Level.INFO, mm.getStringProperty("event-type"));
      logger.log(Level.INFO, mm.getString("title"));
    }
  }

}
