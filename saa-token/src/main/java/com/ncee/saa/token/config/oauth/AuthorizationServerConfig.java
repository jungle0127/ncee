package com.ncee.saa.token.config.oauth;

import com.ncee.saa.core.properties.SAAConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder clientDetailsServiceBuilder = clients.inMemory();
        clientDetailsServiceBuilder.withClient(SAAConstants.DEFAULT_OAUTH_CLIENT_ID)
                .redirectUris("http://www.baidu.com")
                .secret(SAAConstants.DEFAULT_OAUTH_CLIENT_SECRET)
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(5184000)
                .authorizedGrantTypes("refresh_token", "password", "authorization_code")
                .scopes("all", "read", "write");
    }
}
