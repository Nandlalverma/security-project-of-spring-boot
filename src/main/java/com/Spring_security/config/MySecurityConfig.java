package com.Spring_security.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Spring_security.Services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)  // access the user only admin 
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	    @Override
     	protected void configure(HttpSecurity http) throws Exception{
     		
			/*
			 * http 
			 * .authorizeHttpRequests() 
			 * .anyRequest() 
			 * .authenticated() 
			 * .and()
			 * .httpBasic();
			 * 
			 */
	    	
			/*
			 * http .authorizeHttpRequests()
			 *  //
			 *.antMatchers("/home","/login","/register").permitAll()
			 * //
			 * .antMatchers("/public/**").permitAll()
			 * .antMatchers("/public/**").hasRole("NORMAL") // only normal can access
			 * .antMatchers("/users/**").hasRole("ADMIN") // Only for admin .anyRequest()
			 * .authenticated() 
			 * .and() 
			 * .httpBasic();
			 */
	    	
			
	    	
	    	/*
			 * http 
             *.authorizeHttpRequests()
			 * //.antMatchers("/public/**").hasRole("NORMAL")
			 * //.antMatchers("/users/**").hasRole("ADMIN") 
			 * .anyRequest() 
			 * .authenticated()
			 * .and() .httpBasic();
			 */
	    	
	    	
	    	
	    	http 
	    	  .csrf().disable() .authorizeHttpRequests()  //new post or add poeration will be perform
			  .antMatchers("/signin").permitAll() // signin page will be permit 
	    	  .antMatchers("/public/**").hasRole("NORMAL")
			  .antMatchers("/users/**").hasRole("ADMIN") 
			  .anyRequest() 
			  .authenticated()
			  .and()
			  //.httpBasic();
	    	  .formLogin()  // form base authontication
	          .loginPage("/signin")
	    	  .loginProcessingUrl("/dologin")
	    	  .defaultSuccessUrl("/users/");
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    // role high level overview 
	    // authority - premission 
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	    	
	    //	auth.inMemoryAuthentication().withUser("nand").password("abc").roles("NORMAL");
	    //auth.inMemoryAuthentication().withUser("roshani").password("xyz").roles("ADMIN");
	    
	    
	    	
	    	//auth.inMemoryAuthentication().withUser("nand").password(this.passwordEncoder().encode("abc")).roles("NORMAL");
	    	//auth.inMemoryAuthentication().withUser("roshani").password(this.passwordEncoder().encode("xyz")).roles("ADMIN");
	    
	    	
	    	
	    	auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	    	
	    }
	    
	    
		/*
		 * @Bean public PasswordEncoder passwordEncoder() { return
		 * NoOpPasswordEncoder.getInstance(); }
		 */
	    
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	    	return  new BCryptPasswordEncoder();
	    }
	    
}
