package com.tongbanjie.tz.commons.baymax.route.model;

import com.tongbanjie.baymax.router.ColumnProcess;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 根据订单id 自定义分表规则
 *
 * @author xu.qiang
 * @date 2017/2/27.
 * @see com/tongbanjie/tz/commons/baymax/route/readMe.txt
 */
public class OrderNoColumnProcess implements ColumnProcess {

    private Logger logger = LoggerFactory.getLogger(OrderNoColumnProcess.class);

    private Integer dBSegment = 64;//默认
    private Integer tableSegment = 4;//默认

    public Integer getdBSegment() {
        return dBSegment;
    }

    public void setdBSegment(Integer dBSegment) {
        this.dBSegment = dBSegment;
    }

    public Integer getTableSegment() {
        return tableSegment;
    }

    public void setTableSegment(Integer tableSegment) {
        this.tableSegment = tableSegment;
    }

    @Override
    public Object apply(Object object) {

        try {
            // 订单后四位  userId/64%64 {0-63}    userId%64{0-63}
            int aa = Integer.parseInt(String.valueOf(object).substring(28, 30));
            int bb = Integer.parseInt(String.valueOf(object).substring(30, 32));

            return StringUtils.leftPad(String.valueOf(aa / dBSegment * dBSegment), 2, '0')
                    + StringUtils.leftPad(String.valueOf(bb / tableSegment * tableSegment), 2, '0');
        } catch (Exception e) {
            logger.error("bayMax 列转换出错，orderNo:{}", object);
            throw new RuntimeException("bayMax 列转换出错，orderNo:" + object);
        }
    }


}
