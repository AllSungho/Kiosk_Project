package org.example.essential.level3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    private final List<MenuItem> burgerList;

    public Kiosk(){
        this.burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void startKiosk(){
        viewBurger();
    }
    public void viewBurger() {
        System.out.println("================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for(MenuItem i : burgerList){
            System.out.println(burgerList.indexOf(i) + 1 + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
        }
        System.out.println("0. Go Back");
        System.out.println("================================================================");
        selectBurger(new Scanner(System.in));
    }

    public void selectBurger(Scanner scanner) {
        int select = 0;
        try {
            select = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
            viewBurger();
            return;
        }
        if(select == 0){
            System.out.println("================================================================");
            System.out.println("종료");
            System.out.println("================================================================");
            return;
        }
        else if(select > 0 && select < burgerList.size()+1){
            System.out.println("================================================================");
            System.out.println("선택한 메뉴: " + burgerList.get(select-1).getName() + "\t| W " + burgerList.get(select-1).getPrice() + "\t|\t" + burgerList.get(select-1).getExplain());
            viewBurger();
        }
        else {
            System.out.println("================================================================");
            System.out.println("잘못 입력");
            System.out.println("================================================================");
            viewBurger();
        }
    }
}
