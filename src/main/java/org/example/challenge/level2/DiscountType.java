package org.example.challenge.level2;

import java.math.BigDecimal;

public enum DiscountType {
    SOLDIER{
        @Override
        public BigDecimal discountInfo(BigDecimal payMoney){
            return payMoney.multiply(BigDecimal.valueOf(0.5));     // 50% 할인
        }
    },
    EMPOLYMENT{
        @Override
        public BigDecimal discountInfo(BigDecimal payMoney){
            return payMoney.multiply(BigDecimal.valueOf(0.7));     // 30% 할인
        }
    },
    STUDENT{
        @Override
        public BigDecimal discountInfo(BigDecimal payMoney){
            return payMoney.multiply(BigDecimal.valueOf(0.9));     // 10% 할인
        }
    },
    COMMON{
        @Override
        public BigDecimal discountInfo(BigDecimal payMoney){
            return payMoney;     // 30% 할인
        }
    };

    public abstract BigDecimal discountInfo(BigDecimal payMoney);
}
