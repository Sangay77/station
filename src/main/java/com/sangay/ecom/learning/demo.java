package com.sangay.ecom.learning;

import ch.qos.logback.core.model.INamedModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
@Builder
public class demo {

    public String name;

    public demo(String name) {

        this.name = name;
    }

    public static void main(String[] args) {

        List<Integer> even = Arrays.asList(1, 2, 3);
        Integer sum = even.stream().
                filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}

