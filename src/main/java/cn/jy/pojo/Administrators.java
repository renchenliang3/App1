package cn.jy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrators {

  private Integer id;
  private Integer state;          //App状态
  private Integer platform;       //所属平台
  private Integer statusOfRelease;    // 版本发布状态
  private String appName;         //app名字



}
