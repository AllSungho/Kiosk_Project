package org.example.challenge.level1;

import javax.management.ListenerNotFoundException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// 장바구니 클래스
public class ShoppingCart {
    private List<MenuItem> shoppingItem;    // 장바구니 내 메뉴 목록
    private BigDecimal payMoney;                   // 총 금액 합계
    // 장바구니 생성자: 필드 초기화
    public ShoppingCart(){
        shoppingItem = new ArrayList<>();
        this.payMoney = new BigDecimal("0");
    }

    // 장바구니 조회
    public void checkShoppingCart(){
        try{
            System.out.println("===========================[Orders]=============================");
            for(MenuItem item : shoppingItem){
                System.out.println(item.getName() + "\t| W " + item.getPrice() + "\t|\t" + item.getExplain());
            }
            System.out.println("============================[Total]=============================");
            System.out.println("W " + payMoney);
            System.out.println("================================================================");
        } catch(NullPointerException e) {
            System.out.println("================================================================");
            System.out.println("장바구니가 비어있습니다.");
            System.out.println("================================================================");
            return;
        }
        // 장바구니 주문
        orderShoppingCart();
    }
    // 장바구니 주문
    public void orderShoppingCart(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        System.out.println("1. Order");
        System.out.println("2. Go Back");
        System.out.println("================================================================");
        try{
            input = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
            orderShoppingCart();
            return;
        }
        if(input == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + this.payMoney + "입니다.");
            System.out.println("================================================================");
            shoppingItem.clear();
        }
        else if (input == 2) {
            return;
        }
        else {
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
            orderShoppingCart();
        }
    }
    // 장바구니 내 메뉴 추가
    public void insertShoppingCart(MenuItem item){
        shoppingItem.add(item);
        this.payMoney = this.payMoney.add(item.getPrice());
    }
    // 장바구니 내 목록 삭제
    public void deleteShoppingCart(MenuItem item){
        shoppingItem.remove(item);
        this.payMoney = this.payMoney.subtract(item.getPrice());
    }
}
