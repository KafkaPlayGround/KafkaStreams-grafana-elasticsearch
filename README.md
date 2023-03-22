# KafkaStreams-grafana-elasticsearch
 KafkaStreams, Grafana, KafkaConnect With ElasticSearch 실습해보는 프로젝트


![image](https://user-images.githubusercontent.com/40031858/226338575-405c44cd-db2c-4f5c-8abf-92e75b43f372.png)

---

## ElasticSearch 7.17 , Kibana 설치

- https://www.elastic.co/kr/downloads/past-releases/elasticsearch-7-17-8
- https://www.elastic.co/kr/downloads/past-releases/kibana-7-17-8

ElasticSearch 접속 - http://localhost:9200/

Kibana 접속 - http://localhost:5601/

이후에는 이것을 설치해야함

kafka-to-elasticsearch connector 설치

- https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch

kafka-to-ealsticsearch의 설정 옵션

- https://docs.confluent.io/kafka-connectors/elasticsearch/current/configuration_options.html#connector


![image](https://user-images.githubusercontent.com/40031858/226899341-e6a9cffe-a67d-4014-a4f9-0133ed7af35a.png)

---

## 모의 트래픽 발생시키기

https://jmeter.apache.org/download_jmeter.cgi

![image](https://user-images.githubusercontent.com/40031858/226903963-a5175d91-f232-411b-af87-43d2cae731f2.png)
