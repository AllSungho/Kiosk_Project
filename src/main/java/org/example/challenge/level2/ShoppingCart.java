package org.example.challenge.level2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 장바구니 클래스
public class ShoppingCart {
    private List<MenuItem> shoppingItem;    // 장바구니 내 메뉴 목록
    private BigDecimal payMoney;                   // 총 금액 합계
    private Enum discountType;
    // 장바구니 생성자: 필드 초기화
    public ShoppingCart(){
        shoppingItem = new ArrayList<>();
        this.payMoney = new BigDecimal("0");
    }

    // 장바구니 조회
    public void checkShoppingCart(){
        if(shoppingItem.isEmpty()){
            System.out.println("================================================================");
            System.out.println("장바구니가 비어있습니다.");
            System.out.println("================================================================");
            return;
        }
        System.out.println("===========================[Orders]=============================");
        for(MenuItem item : shoppingItem){
            System.out.println(item.getName() + "\t| W " + item.getPrice() + "\t|\t" + item.getExplain());
        }
        System.out.println("============================[Total]=============================");
        System.out.println("W " + payMoney);
        System.out.println("================================================================");

        // 장바구니 주문
        orderShoppingCart();
    }
    // 장바구니 주문
    private void orderShoppingCart(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        System.out.println("1. Order");
        System.out.println("2. Delete");
        System.out.println("3. Go Back");
        System.out.println("================================================================");
        try{
            input = scanner.nextInt();
            scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력(예외)");
            System.out.println("================================================================");
            orderShoppingCart();
            return;
        }
        if(input == 1) {
            discountPrint();
            System.out.println("================================================================");
            System.out.println("주문이 완료되었습니다. 금액은 W " + this.payMoney + "입니다.");
            shoppingItem.clear();
            this.payMoney = BigDecimal.valueOf(0);
        }
        else if (input == 2) {
            deleteShoppingCart();
        }
        else if (input == 3) {
            return;
        }
        else {
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력(조건문)");
            System.out.println("================================================================");
            orderShoppingCart();
        }
    }
    // 장바구니 내 메뉴 추가
    public void insertShoppingCart(MenuItem item){
        this.shoppingItem.add(item);
        this.payMoney = this.payMoney.add(item.getPrice());
    }
    // 장바구니 내 목록 삭제
    public void deleteShoppingCart(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        // 삭제할 메뉴 번호 출력
        System.out.println("========================[Choose Menu]===========================");
        for(MenuItem item : this.shoppingItem){
            System.out.println( this.shoppingItem.indexOf(item) + 1+ ". " + item.getName() + "\t| W " + item.getPrice() + "\t|\t" + item.getExplain());
        }
        System.out.println("================================================================");
        // 삭제할 메뉴 입력
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력(예외)");
            System.out.println("================================================================");
            deleteShoppingCart();
            return;
        }
        if(input > 0 && input < this.shoppingItem.size()){
            this.payMoney = this.payMoney.subtract(this.shoppingItem.get(input-1).getPrice());
            this.shoppingItem.remove(input - 1);
        }
        else{
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
        }
    }
    // 할인 정보
    public void discountPrint(){
        System.out.println("================================================================");
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 군인   : 50%");
        System.out.println("2. 직원   : 30%");
        System.out.println("3. 학생   : 10%");
        System.out.println("4. 일반인  : 0%");
        System.out.println("================================================================");
        discountSelect();
    }
    // 할인 선택
    public void discountSelect(){
        Scanner scanner = new Scanner(System.in);
        int input= 0;
        try{
            input = scanner.nextInt();
            scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력(예외)");
            System.out.println("================================================================");
            orderShoppingCart();
            return;
        }
        switch(input){
            case 1:         // 군인
                this.payMoney = DiscountType.SOLDIER.discountInfo(this.payMoney);
                break;
            case 2:         // 직원
                this.payMoney = DiscountType.EMPOLYMENT.discountInfo(this.payMoney);
                break;
            case 3:         // 학생
                this.payMoney = DiscountType.STUDENT.discountInfo(this.payMoney);
                break;
            case 4:         // 일반인
                this.payMoney = DiscountType.COMMON.discountInfo(this.payMoney);
                break;
            default:
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(예외)");
                System.out.println("================================================================");
                discountPrint();
        }
    }
}
