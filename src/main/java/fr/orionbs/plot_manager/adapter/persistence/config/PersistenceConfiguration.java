package fr.orionbs.plot_manager.adapter.persistence.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    /*@Bean
    public DataSource dataSource(PersistenceProperties persistenceProperties) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + persistenceProperties.getHost() + ":" + persistenceProperties.getPort().toString() + "/" + persistenceProperties.getDatabase() + "");
        dataSourceBuilder.username(persistenceProperties.getUsername());
        dataSourceBuilder.password(persistenceProperties.getPassword());
        return dataSourceBuilder.build();
    }*/

}
