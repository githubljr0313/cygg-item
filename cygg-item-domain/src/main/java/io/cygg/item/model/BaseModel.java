package io.cygg.item.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    @TableId
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    @TableField
    private String createdBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    @TableField
    private String updatedBy;
}
