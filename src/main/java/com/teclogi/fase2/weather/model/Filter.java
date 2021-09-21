package com.teclogi.fase2.weather.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Filter {
    private String city;
    private String units;
    private String lang;
}
