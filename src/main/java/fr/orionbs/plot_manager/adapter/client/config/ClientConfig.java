package fr.orionbs.plot_manager.adapter.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "fr.orionbs.plot_manager.adapter.client")
public class ClientConfig {
}
