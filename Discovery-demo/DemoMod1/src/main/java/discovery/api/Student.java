package discovery.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student  {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
