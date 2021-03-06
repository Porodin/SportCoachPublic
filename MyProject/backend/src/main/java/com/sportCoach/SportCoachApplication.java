package com.sportCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import javax.servlet.Filter;

@SpringBootApplication
public class SportCoachApplication { //extends WebSecurityConfigurerAdapter{
	/*@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.parentAuthenticationManager(authenticationManagerBean());
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.csrf().disable()
				.antMatcher("/**").authorizeRequests()
				.antMatchers("/login/**", "/logout/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/login")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.permitAll();

	}

	 */
	public static void main(String[] args) {
		SpringApplication.run(SportCoachApplication.class, args);
	}
}
	/*
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(-200);
		return bean;
	}
	@Bean
	public Filter fbTokenVerificationFilter(){
		FacebookAuthenticationFilter facebookAuthenticationFilter = new FacebookAuthenticationFilter();
		return facebookAuthenticationFilter;
	}
	@Bean
	public AuthenticationProvider fbAuthenticationProvider(){
		OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(),
				facebook().getClientId());
		tokenServices.setRestTemplate(facebookTemplate);
		FacebookAuthenticationProvider fbAuthenticationProvider = new FacebookAuthenticationProvider(tokenServices);
		return fbAuthenticationProvider;
	}
	@Bean
	@ConfigurationProperties("facebook.client")
	public AuthorizationCodeResourceDetails facebook() {
		return new AuthorizationCodeResourceDetails();
	}
	@Bean
	@ConfigurationProperties("facebook.resource")
	public ResourceServerProperties facebookResource() {
		return new ResourceServerProperties();
	}
}

	 */

