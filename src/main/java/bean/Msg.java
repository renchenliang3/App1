package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Msg {
    /*
     * 状态码
     * 100  失败
     * 200  成功
     * */
    private Integer code;
    /*
     * 提示信息
     * */
    private String info;
    /*
     * 返回的数据
     * */
    private Map<String,Object> returnDate=new HashMap<>();
    /*
     * 成功时
     * */
    public static Msg success(){
        Msg result=new Msg();
        result.setCode(200);
        result.setInfo("操作成功");
        return result;
    }
    /*
     * 失败时
     * */
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(100);
        result.setInfo("操作失败");
        return result;
    }
    /*
     * key:map的键值
     * value:map的value值
     * */
    public Msg add(String key,Object value){
        this.returnDate.put(key, value);
        return this;
    }
}
