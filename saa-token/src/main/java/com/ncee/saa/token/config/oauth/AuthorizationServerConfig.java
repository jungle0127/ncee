package com.ncee.saa.token.config.oauth;

import com.ncee.saa.core.properties.SAAConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@Order(101)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        InMemoryClientDetailsServiceBuilder clientDetailsServiceBuilder = clients.inMemory();
        clientDetailsServiceBuilder.withClient(SAAConstants.DEFAULT_OAUTH_CLIENT_ID)
                .secret(this.passwordEncoder.encode(SAAConstants.DEFAULT_OAUTH_CLIENT_SECRET))
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(5184000)
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("all", "read", "write");
    }
}
