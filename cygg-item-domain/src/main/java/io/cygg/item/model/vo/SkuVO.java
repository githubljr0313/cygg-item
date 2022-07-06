package io.cygg.item.model.vo;

import io.cygg.item.enums.ColorEnum;
import io.cygg.item.model.BaseModel;
import lombok.Data;

@Data
public class SkuVO extends BaseModel {

    private String skuCode;

    private String skuName;

    private ColorEnum color;

}