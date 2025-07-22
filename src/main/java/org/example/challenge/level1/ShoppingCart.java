package org.example.challenge.level1;

import java.util.List;
import java.util.ArrayList;

// 장바구니 클래스
public class ShoppingCart {
    private List<MenuItem> shoppingItem;    // 장바구니 내 메뉴 목록
    private int payMoney;                   // 총 금액 합계
    // 장바구니 생성자: 필드 초기화
    public ShoppingCart(){
        shoppingItem = new ArrayList<>();
        payMoney = 0;
    }

    // 장바구니 내 메뉴 추가
    public void insertShoppingCart(){

    }
    // 장바구니 조회, 주문
    public void checkAndOrderShoppingCart(){

    }
    // 장바구니 내 목록 삭제
    public void deleteShoppingCart(){

    }
}
