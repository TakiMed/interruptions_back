package com.example.predavanjademo.config;
import com.example.predavanjademo.services.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
// prilikom kompjaliranja aplikacije skeniraj sve @configration klase
public class CustomerConfiguration {

    // @Bean(name = "CS") CS->####
    // kad se doda bean springBootyApp prilikom podizanja skenira sve @Config. i kad nadje @Bean
    // to znaci da SpringBeanContainer uzima ovaj objekat i vodi racuna o njegovom zivotnom ciklusu i mozemo da ga koristimo i
    // ubrizgavamo ne korsteci new() niti kontruktor klase CustomerService
    @Bean
    @Primary
    public CustomerService customerService(){
        CustomerService customerService = new CustomerService();
        customerService.setName("CS-01");
        customerService.setType("CS-TYPE-01");

        return customerService;
    }
    // SpringBeanContainer
    // customerService-> ####


    @Bean(name = "CS2")
    public CustomerService customerServiceTwo(){
        CustomerService customerService = new CustomerService();
        customerService.setName("CS-02");
        customerService.setType("CS-TYPE-02");

        return customerService;
    }

    //CT2 -> 002


}
