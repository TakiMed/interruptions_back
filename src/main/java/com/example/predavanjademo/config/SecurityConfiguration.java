package com.example.predavanjademo.config;
import com.example.predavanjademo.security.components.UnauthorizedEntryPointHandler;
import com.example.predavanjademo.security.jwt.JwtConfigurer;
import com.example.predavanjademo.security.jwt.JwtTokenProvider;
import com.example.predavanjademo.security.components.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorize
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // handlo-ovanje gresaka na nivou security modul-a
    @Autowired
    private UnauthorizedEntryPointHandler authenticationEntryPoint;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .csrf().disable()
                    // .sessionManagement(SessionCreationPolicy.STATELESS)
                .headers().frameOptions().disable()
                    .and()
                    .authorizeRequests() // zahtjevi na koje treba primijeniti pravilo
                    .antMatchers("/api/**").permitAll()
                //    .antMatchers("/api/users/all").hasRole("ADMIN") //samo rola admin moze da pristupi ovoj
               //     .antMatchers(HttpMethod.GET,"/api/interruptions/**").permitAll() // dozvoli svima get
               //     .antMatchers(HttpMethod.POST, "").hasAnyRole("ADMIN", "MANAGER");
                //    .anyRequest().authenticated();
                        // .antMatchers("api/users/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
                    //     .anyRequest().authenticated()
                .and()
                    .apply(jwtConfigurer());
    }

    public JwtConfigurer jwtConfigurer() { return new JwtConfigurer(jwtTokenProvider); }

    @Bean
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception
    {
        return super.authenticationManagerBean();
    }

}

