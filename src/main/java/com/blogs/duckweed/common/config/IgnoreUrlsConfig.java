package com.blogs.duckweed.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingfan
 * 用于配置不需要保护的资源路径
 */
@EnableConfigurationProperties({IgnoreUrlsConfig.class})
@ConfigurationProperties(prefix = "authorize.ignored")
public class IgnoreUrlsConfig {
    @Getter
    @Setter
    private List<String> urls = new ArrayList<>();

}
