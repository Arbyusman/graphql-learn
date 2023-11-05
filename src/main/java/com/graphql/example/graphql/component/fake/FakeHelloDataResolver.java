package com.graphql.example.graphql.component.fake;



import com.graphql.example.graphql.datasource.fake.FakeDataSource;
import com.netflix.dgs.codegen.generated.types.Hello;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DgsComponent
public class FakeHelloDataResolver {

    @DgsQuery
    public List<Hello> allHellos(){
            return FakeDataSource.HELLO_LIST;
    }


    @DgsQuery
    public Hello oneHello(){
        return FakeDataSource.HELLO_LIST.get(
                ThreadLocalRandom.current().nextInt(
                        FakeDataSource.HELLO_LIST.size()
                )

        );
    }


}