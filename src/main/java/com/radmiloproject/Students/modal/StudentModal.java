package com.radmiloproject.Students.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModal {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String indexNumber;
}
