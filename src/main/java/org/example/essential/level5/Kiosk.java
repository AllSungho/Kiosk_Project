package org.example.essential.level5;

import java.util.InputMismatchException;
import java.util.Scanner;

// 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    private int category;
    private final Menu menu;
    Scanner scanner;
    public Kiosk(){
        menu = new Menu();
        scanner = new Scanner(System.in);
    }

    // 키오스크 스타트
    public void startKiosk() {
        viewCategory();
    }
    // 카테고리 목록 보기
    public void viewCategory() {
        System.out.println("================================================================");
        System.out.println("[ Category ]");
        System.out.println("1. Burger");
        System.out.println("2. Drink");
        System.out.println("0. Exit");
        System.out.println("================================================================");
        try{
            this.category = scanner.nextInt();
            selectCategory(this.category);
        }catch(InputMismatchException e){
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
            scanner.nextLine();
            viewCategory();
        }
    }
    public void selectCategory(int category) {
        switch(category){
            case 0:
                System.out.println("================================================================");
                System.out.println("키오스크 종료");
                System.out.println("================================================================");
                return;
            case 1:
                this.menu.viewBurger();
                viewCategory();
                break;
            case 2:
                break;
            default:
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력");
                System.out.println("================================================================");
                viewCategory();
        }
    }
}
