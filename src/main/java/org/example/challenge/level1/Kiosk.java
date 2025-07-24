package org.example.challenge.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

// 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    private int category;   // 사용자에게 카테고리 입력을 받는 변수
    private final Menu menu;    // 메뉴를 볼 수 있는 Menu 타입 변수
    private final ShoppingCart shoppingCart;
    Scanner scanner;

    // 생성자로 해당 변수들 초기화
    public Kiosk(){
        menu = new Menu();
        shoppingCart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    // 키오스크 스타트
    public void startKiosk() {
        viewCategory();
    }

    // 카테고리 목록 보는 메소드
    public void viewCategory() {
        System.out.println("================================================================");
        System.out.println("[ Category ]");
        System.out.println("1. Burger");
        System.out.println("2. Drink");
        System.out.println("3. Shopping Cart");
        System.out.println("0. Exit");
        System.out.println("================================================================");
        try{
            this.category = scanner.nextInt();
            selectCategory(this.category);
        }catch(InputMismatchException e){
            printFail();
            scanner.nextLine();
            viewCategory();
        }
    }
    // 카테고리를 사용자에게 입력 받고 입력값에 따른 결과를 수행하는 메소드
    public void selectCategory(int category) {
        switch(category){
            case 0:
                System.out.println("================================================================");
                System.out.println("키오스크 종료");
                System.out.println("================================================================");
                return;
            case 1:         // 메뉴 출력 메소드 호출 (버거)
                this.menu.viewMenu(this.menu.getBurgerList(), this.shoppingCart);
                viewCategory();
                break;
            case 2:         // 메뉴 출력 메소드 호출 (음료)
                this.menu.viewMenu(this.menu.getDrinkList(), this.shoppingCart);
                viewCategory();
                break;
            case 3:         // 장바구니 호출 메소드
                this.shoppingCart.checkShoppingCart();
                viewCategory();
                break;
            default:
                printFail();
                viewCategory();
        }
    }
    // 잘못된 수 입력 출력
    public static void printFail(){
        System.out.println("================================================================");
        System.out.println("잘못된 수 입력");
        System.out.println("================================================================");
    }
}
