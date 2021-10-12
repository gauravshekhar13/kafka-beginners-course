# kafka-twitter-integration
Kafka Twitter Integration

**Problem Statement**: <br> A user wants to get a tragetted tweet (say bitcoin) from Twitter and do the data mining using elastic search. <br>
Data mining includes how many times a tweet is reshared or liked or commented.<br>

1. Kafka : 7.10.2 with Multicluster + Replication setup(Active <—>Active) using MirrorMaker<br>
2. Kafka Connect for scalable and reliably streaming data between Apache Kafka® and other data systems<br>
3. Kafka Streams for transforming data from Kafka Topic to another topic in Real Time<br>
4. Debezium for Change Data Capture (CDC)- https://lnkd.in/eyHHdZs<br>
5. Kafka Schema Registry for establishing Contracts between Producers and Consumers.<br>
6. Kafka Producer using Twitter (https://lnkd.in/ewhDfdN)<br>
7. Kafka Consumer and storing data in Elastic Search using https://Bonsai.io<br>


![image](https://user-images.githubusercontent.com/26468158/136989560-e3127c2a-ced5-4606-a973-cc2cdce4ab2e.png)
