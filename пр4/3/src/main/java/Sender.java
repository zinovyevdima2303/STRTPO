import javax.jms.*;
import javax.naming.InitialContext;

public class Sender {
    public static void main(String[] args) throws Exception
    {
        InitialContext context = new InitialContext();
        Queue queue = (Queue) context.lookup("queue/queue0");
        QueueConnectionFactory conFactory = (QueueConnectionFactory) context.lookup ("queue/connectionFactory");
        QueueConnection queConn = conFactory.createQueueConnection();
        QueueSession queSession = queConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);
        QueueSender queSender = queSession.createSender(queue);
        queSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage message = queSession.createTextMessage("3 практика");
        queSender.send(message);

        System.out.println("Сообщение: " + message.getText());
        queConn.close();
    }
}
