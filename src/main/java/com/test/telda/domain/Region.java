package com.test.telda.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

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
