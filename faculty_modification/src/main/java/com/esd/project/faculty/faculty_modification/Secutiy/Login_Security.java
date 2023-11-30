/*package com.esd.project.faculty.faculty_modification.Secutiy;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class Login_Security {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
       // jdbcUserDetailsManager.setUsersByUsernameQuery(
             //   "select username , password, employee_id  from users where username = ?  "
      //  );
       // return jdbcUserDetailsManager;
    }
}*/
