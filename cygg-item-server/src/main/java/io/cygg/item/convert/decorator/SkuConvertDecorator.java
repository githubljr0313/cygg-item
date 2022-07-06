package io.cygg.item.convert.decorator;

import io.cygg.item.convert.SkuConvert;
import io.cygg.item.model.po.SkuPO;
import io.cygg.item.model.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SkuConvertDecorator implements SkuConvert {

    @Autowired
    @Qualifier("delegate")
    private SkuConvert delegate;

    @Override
    public SkuVO skuPOConvertVO(SkuPO sku) {
        SkuVO skuVO = delegate.skuPOConvertVO(sku);
        skuVO.setSkuName("VO" + skuVO.getSkuName());
        return skuVO;
    }

    @Override
    public SkuPO skuVOConvertPO(SkuVO sku) {
        return delegate.skuVOConvertPO(sku);
    }
}
