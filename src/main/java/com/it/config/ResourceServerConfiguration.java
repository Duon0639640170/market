package com.it.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	private static final String RESOURCE_ID = "resource_id";
	
	@Value("${security.oauth2.resource.token-info-uri}")
	private String checkTokenEndpointUrl;
	
	@Value("${security.oauth2.client.access-token-uri}")
	private String accessTokenUri;
	
	@Value("${security.oauth2.client.client-id:clientId}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret:clientSecret}")
    private String clientSecret;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.and()
		.authorizeRequests()
		.anyRequest()
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());;
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		final RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
		tokenService.setClientId(clientId);
		tokenService.setClientSecret(clientSecret);
		return tokenService;
	}
	
	/** Configuration for Using OAuth2RestTemplate for Call Service To Service **/
	public OAuth2RestTemplate oAuth2RestTemplate() {
		ClientCredentialsResourceDetails resourceDetail = new ClientCredentialsResourceDetails();
		resourceDetail.setAccessTokenUri(accessTokenUri);
		resourceDetail.setClientId(clientId);
		resourceDetail.setClientSecret(clientSecret);
		
		ClientCredentialsAccessTokenProvider provider = new ClientCredentialsAccessTokenProvider();
		final OAuth2AccessToken accessToken = provider.obtainAccessToken(resourceDetail, new DefaultAccessTokenRequest());
	
		return new OAuth2RestTemplate(resourceDetail, new DefaultOAuth2ClientContext(accessToken));
	}
	
	

}
