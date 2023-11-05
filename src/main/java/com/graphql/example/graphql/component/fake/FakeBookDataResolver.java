package com.graphql.example.graphql.component.fake;

import com.graphql.example.graphql.datasource.fake.FakeBookDataSource;
import com.netflix.dgs.codegen.generated.DgsConstants;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.dgs.codegen.generated.types.Book;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DgsComponent
public class FakeBookDataResolver {

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = "books")
    public List<Book> booksWrittenBy(@InputArgument(name = "author") Optional<String> authorName) {
        if (!authorName.isPresent()) {
            return FakeBookDataSource.BOOK_LIST;
        }

        return FakeBookDataSource.BOOK_LIST.stream()
                .filter(b -> b.getAuthor().getName().equalsIgnoreCase(authorName.get()))
                .collect(Collectors.toList());
    }
}
