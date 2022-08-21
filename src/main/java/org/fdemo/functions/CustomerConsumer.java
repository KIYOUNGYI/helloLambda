package org.fdemo.functions;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class CustomerConsumer implements Consumer<Map<String, String>> {

//    private static final Logger log = LoggerFactory.getLogger(CustomerConsumer.class);


    @Override
    public void accept(Map<String, String> stringStringMap) {
        System.out.println("CustomerConsumer.this : {}"+ this.hashCode());
        System.out.println("CustomerConsumer.accept : {}"+ stringStringMap.toString());

    }
}
