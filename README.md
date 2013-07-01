PushNotificationQueue
=====================

Implemented a push notification service which handles both IOS and Android push notifications.
It is a fully implemented rest service which ensures redundancy by using ApacheMQ and JMSClient.

Install & Run:

mvn clean install
cd services
nohup mvn jetty:run &
