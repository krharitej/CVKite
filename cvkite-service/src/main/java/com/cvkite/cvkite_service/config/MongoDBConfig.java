package com.cvkite.cvkite_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/*configuring mongodb to update the user details
*  -annotations automatically update the following:
*  createdAt and updatedAt fields in user data class
*  because of @CreatedDate and @ModifiedDate */
@Configuration
@EnableMongoAuditing
public class MongoDBConfig {
}
