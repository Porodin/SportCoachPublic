package com.sportCoach.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String gmail;
    private String dateOfBirth;
    private String city;
    private String phone;
    private String userName;
}
