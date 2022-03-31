package cn.jy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class App {
    private Integer id;
    private String name;
    private String pwd;
    private Integer gly;
}
