package io.cygg.item.convert;

import io.cygg.item.convert.decorator.SkuConvertDecorator;
import io.cygg.item.model.po.SkuPO;
import io.cygg.item.model.vo.SkuVO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(SkuConvertDecorator.class)
public interface SkuConvert {

    SkuVO skuPOConvertVO(SkuPO sku);

    SkuPO skuVOConvertPO(SkuVO sku);

}
