import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProducer {
    public static void main(String[] args) throws Exception {
        //创建链接工厂
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://192.168.25.135:61616");
        //获取链接
        Connection connection = connectionFactory.createConnection();
        //启动链接
        connection.start();
        //获取session(
        // 参数1是是否启动事务 一般默认是不开启事务 转而使用消息确认模式来提高mq的响应效率
        // 参数2为消息确认模式 自动模式即自动获得消息处理后的返回信息，
        // 如果接受了返回信息则表示正确生产了消息
        // 如果没有返回消息则表示没有可能消息没有被正常生产，connection会重新再生产一次消息)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列对象 参数为队列名称，消费者凭借名称来选择消费哪个队列，获得其中的信息；
        Queue queue = session.createQueue("test-queue");
        //创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //确定队列类型 和 队列内容
        TextMessage message = session.createTextMessage("这是一个文本消息队列");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();


    }
}
