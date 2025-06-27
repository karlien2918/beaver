package com.example.infrakafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

	// Spring Boot의 기본 KafkaProperties를 사용하거나
	// Config Server에서 직접 주입받아 사용

	@Bean
	public ProducerFactory<String, String> producerFactory(KafkaProperties kafkaProperties) {
		return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory(KafkaProperties kafkaProperties) {
		return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
	}

	@Bean
	@RefreshScope
	public NewTopic exampleTopic(@Value("${app.kafka.topic.name:example-topic}") String topicName,
			@Value("${app.kafka.topic.partitions:3}") int partitions,
			@Value("${app.kafka.topic.replicas:3}") int replicas) {
		return TopicBuilder.name(topicName)
				.partitions(partitions)
				.replicas(replicas)
				.build();
	}


}
