package com.test.telda.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Region {
    public long id;

    @NonNull
    public String name;

    @NonNull
    public String abbreviatedName;
}
