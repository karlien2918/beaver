package com.example.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class KafkaConfig {

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
	public NewTopic paymentEventsTopic() {
		return TopicBuilder.name("payment-events")
				.partitions(3)           // 원하는 파티션 수 명시
				.replicas(1)            // 복제본 수 명시
				.build();
	}
}
