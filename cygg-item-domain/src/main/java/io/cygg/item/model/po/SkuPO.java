package io.cygg.item.model.po;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.cygg.item.enums.ColorEnum;
import io.cygg.item.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sku_po")
public class SkuPO extends BaseModel {

    @TableField
    private String skuCode;

    @TableField
    private String skuName;

    @EnumValue
    @TableField
    private ColorEnum color;

}

