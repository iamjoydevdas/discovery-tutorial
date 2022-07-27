package discovery.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "student")
public class Student  {
    @Id
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message="Name cannot be blank")
    private String name;
    private Integer age;
    private String address;
}
