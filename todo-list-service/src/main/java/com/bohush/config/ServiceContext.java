package com.bohush.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Root application context configuration.
 *
 * @author Raman_Bohush
 */
@Configuration
@ComponentScan(basePackages = {"com.bohush.service"})
public class ServiceContext {
}
