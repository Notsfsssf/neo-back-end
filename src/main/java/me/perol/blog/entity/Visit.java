package me.perol.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Visit extends BaseEntity{
    @TableId(type= IdType.AUTO)
    private Long id;
    private  Long website;
    private  Long pixez;
}
