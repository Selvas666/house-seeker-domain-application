package pl.kala.houseseekerdomain.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import pl.kala.houseseekerdomain.IntegrationSpecificationConfiguration

class HouseControllerIT extends IntegrationSpecificationConfiguration{

    @Autowired
    ApplicationContext applicationContext;

    def"context loads" () {
        when:""
        then:""
        printf ("%s",applicationContext.getApplicationName())
    }
}
