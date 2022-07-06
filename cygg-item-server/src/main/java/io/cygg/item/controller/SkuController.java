package io.cygg.item.controller;

import io.cygg.item.convert.SkuConvert;
import io.cygg.item.model.po.SkuPO;
import io.cygg.item.model.vo.SkuVO;
import io.cygg.item.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;
    @Autowired
    private SkuConvert skuConvert;

    @GetMapping(path = "/list")
    public List<SkuVO> listSku(){
//        LambdaQueryWrapper<SkuPO> queryWrapper = Wrappers.lambdaQuery();
//        queryWrapper.like(SkuPO::getSkuCode, "qiezi");
//        List<SkuPO> skuPOList = skuService.list(queryWrapper);
        List<SkuPO> skuPOList = skuService.list();
        return skuPOList.stream().map(skuConvert::skuPOConvertVO).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public String saveSku(@RequestBody SkuVO skuVO){
        if(Objects.isNull(skuVO)){
            throw new IllegalArgumentException("不允许提交空数据");
        }
        SkuPO skuPO = skuConvert.skuVOConvertPO(skuVO);
        if(Objects.isNull(skuPO.getId())){
            skuService.save(skuPO);
            return skuPO.getId() + "创建成功";
        }else{
            skuService.updateById(skuPO);
            return "更新成功";
        }
    }


}
