package de.samples.javaee.richfaces.jms.sample.messaging.config;

import jakarta.jms.*;

import java.io.Serializable;

@SuppressWarnings("unused")
public interface MessageFactory {

  /**
   * Creates a {@code BytesMessage} object. A {@code BytesMessage} object is used to send a message containing a stream of
   * uninterpreted bytes.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code BytesMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createBytesMessage()
   */
  BytesMessage createBytesMessage() throws JMSException;

  /**
   * Creates a {@code MapMessage} object. A {@code MapMessage} object is used to send a self-defining set of name-value
   * pairs, where names are {@code String} objects and values are primitive values in the Java programming language.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code MapMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createMapMessage()
   */
  MapMessage createMapMessage() throws JMSException;

  /**
   * Creates a {@code Message} object. The {@code Message} interface is the root interface of all Jakarta Messaging messages. A
   * {@code Message} object holds all the standard message header information. It can be sent when a message containing
   * only header information is sufficient.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code Message} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createMessage()
   */
  Message createMessage() throws JMSException;

  /**
   * Creates an {@code ObjectMessage} object. An {@code ObjectMessage} object is used to send a message that contains a
   * serializable Java object.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code ObjectMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createObjectMessage()
   */
  ObjectMessage createObjectMessage() throws JMSException;

  /**
   * Creates an initialized {@code ObjectMessage} object. An {@code ObjectMessage} object is used to send a message that
   * contains a serializable Java object.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @param object the object to use to initialize this message
   * @return A {@code ObjectMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createObjectMessage(Serializable)
   */
  ObjectMessage createObjectMessage(Serializable object) throws JMSException;

  /**
   * Creates a {@code StreamMessage} object. A {@code StreamMessage} object is used to send a self-defining stream of
   * primitive values in the Java programming language.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code StreamMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createStreamMessage()
   */
  StreamMessage createStreamMessage() throws JMSException;

  /**
   * Creates a {@code TextMessage} object. A {@code TextMessage} object is used to send a message containing a
   * {@code String} object.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @return A {@code TextMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createTextMessage()
   */
  TextMessage createTextMessage() throws JMSException;

  /**
   * Creates an initialized {@code TextMessage} object. A {@code TextMessage} object is used to send a message containing
   * a {@code String}.
   *
   * <p>
   * The message object returned may be sent using any {@code Session} or {@code JMSContext}. It is not restricted to
   * being sent using the {@code JMSContext} used to create it.
   *
   * <p>
   * The message object returned may be optimised for use with the Jakarta Messaging provider used to create it. However it can be sent
   * using any Jakarta Messaging provider, not just the Jakarta Messaging provider used to create it.
   *
   * @param text the string used to initialize this message
   * @return A {@code TextMessage} object.
   * @throws JMSException if the Jakarta Messaging provider fails to create this message due to some internal error.
   * @see Session#createTextMessage(String)
   */
  TextMessage createTextMessage(String text) throws JMSException;

}
