
docker kafka

docker run  -d --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.1.100:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.100:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -t wurstmeister/kafka


 
 ###### 生产消息
 ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mykafka
 
 ##### 消费
  ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic DEMO-TOPIC-01 --from-beginning
  
  