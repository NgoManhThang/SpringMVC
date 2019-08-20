package thangnm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TTeacherInformation {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String email;
}
