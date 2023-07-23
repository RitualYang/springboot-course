package com.wty.model;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author peter
 * @date 2022/10/15 16:37
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "list")
public class GirlFriendConfig {

    private List<Girlfriend> girlfriendList;

    private Map<Integer, List<Girlfriend>> maps;

}
