package com.demo.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.demo.models.ShipmentDetails;
import com.demo.models.Users;


@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {



	 @Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "shipment_goods");

	    return props;
	  }

	  @Bean
	  public ConsumerFactory<String, ShipmentDetails> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new JsonDeserializer<>(ShipmentDetails.class));
	  }

	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, ShipmentDetails> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, ShipmentDetails> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }

	  
	  @Bean
	  public Map<String, Object> consumerUserConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "users_kafka");

	    return props;
	  }

	  @Bean
	  public ConsumerFactory<String, Users> consumerUserFactory() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new JsonDeserializer<>(Users.class));
	  }

	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, Users> kafkaUserListenerContainer() {
	    ConcurrentKafkaListenerContainerFactory<String, Users> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerUserFactory());

	    return factory;
	  }
	  
	}