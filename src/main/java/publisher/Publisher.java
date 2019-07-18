package publisher;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.AmazonSQSClient;

import java.util.TimerTask;


public class Publisher extends TimerTask {

    private static AmazonSQS sqs;
    private static String url;



    //TODO: Make it send a random number
    public static void sendMessage(){
        sqs = AmazonSQSClientBuilder.defaultClient();
        url = "https://sqs.us-east-2.amazonaws.com/239791658647/randomNumberQueue";
        int random = (int) Math.floor(Math.random() * 100);
        String messageString = "Here is your random number: " + random;

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(messageString)
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }


    //Allows us to run our method in a task scheduler.
    @Override
    public void run() {
        sendMessage();
    }
}
