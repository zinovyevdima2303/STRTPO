import javax.jms.*;
import javax.naming.InitialContext;

public class Receiver {
    public static void main(String[] args) throws Exception
    {
        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/queue0");
        QueueConnectionFactory conFactory = (QueueConnectionFactory) context.lookup ("queue/connectionFactory");
        QueueConnection queConn = conFactory.createQueueConnection();
        QueueSession queSession = queConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        QueueReceiver queReceiver = queSession.createReceiver(queue);
        queConn.start();
        TextMessage message = (TextMessage) queReceiver.receive();

        System.out.println("Сообщение: " + message.getText());
        queConn.close();
    }
}
