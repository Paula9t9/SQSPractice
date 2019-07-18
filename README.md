# SQS Publisher/Client

This project is a simple queue sender/receiver that drew heavy inspiration from the [AWS docs.](https://github.com/awsdocs/aws-doc-sdk-examples/blob/master/java/example_code/sqs/src/main/java/aws/example/sqs/SendReceiveMessages.java)

## How to Use

Build an SQS queue in the AWS console, and replace the url in the Client and Publisher classes with your url.

Run main, and after a short delay you should start to see random numbers printing to your console. 

**Bonus:**
If you would like to manipulate the speed with which you send/receive messages, you can manipulate the intervals in 
the main method. These times are measured in milliseconds. 

## Common Issues

#### Region error

Your local system may be defaulting to a different region than your SQS's region. You will have to manually set your 
region when you initialize your SQS client.  

#### Permission errors

Make sure your queue is allowing this app to connect to it. 

#### Profile errors

(Coming Soon)


