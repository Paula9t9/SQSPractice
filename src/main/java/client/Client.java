package client;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;

import java.util.List;
import java.util.TimerTask;

public class Client extends TimerTask {

    private static AmazonSQS sqs;
    private static String url;


    // Used Amazon docs and example for reference:
    // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-sqs-messages.html
    public static void receiveMessages(){
        sqs = AmazonSQSClientBuilder.defaultClient();
        url = "https://sqs.us-east-2.amazonaws.com/239791658647/randomNumberQueue";

        List<Message> messages = sqs.receiveMessage(url).getMessages();

        // print message and delete from the queue
        for (Message m : messages) {
            System.out.println(m.getBody());
            sqs.deleteMessage(url, m.getReceiptHandle());
        }
    }


    //Allows us to run our method in a task scheduler.
    @Override
    public void run() {
        receiveMessages();
    }
}
