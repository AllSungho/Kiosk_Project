package org.example.essential.level5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// MenuItem 클래스를 관리하는 클래스
// 예시 : 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {
    private final List<MenuItem> burgerList;
    private final List<MenuItem> drinkList;

    // Menu 생성자를 통해 해당 필드들 초기화
    public Menu(){
        this.burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        this.drinkList = new ArrayList<>();
        drinkList.add(new MenuItem("Coke",2.0, "탄산 음료"));
        drinkList.add(new MenuItem("Pepsi",2.0, "탄산 음료"));
        drinkList.add(new MenuItem("Cider",2.0, "탄산 음료"));
        drinkList.add(new MenuItem("Orange Juice",2.0, "오렌지 주스"));
        drinkList.add(new MenuItem("Americano",2.0, "아메리카노"));
    }

    // 버거 리스트 Getter
    public List<MenuItem> getBurgerList() { return burgerList; }

    // 음료 리스트 Getter
    public List<MenuItem> getDrinkList() { return drinkList; }

    // 매개변수에 따른 메뉴 리스트 출력 메소드
    public void viewMenu(List<MenuItem> list) {
        System.out.println("================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for(MenuItem i : list){
            System.out.println(list.indexOf(i) + 1 + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
        }
        System.out.println("0. Go Back");
        System.out.println("================================================================");
        selectMenu(new Scanner(System.in), list);
    }

    // 메뉴 리스트 출력 후 사용자에게 입력받고 입력값에 따른 결과를 수행하는 메소드
    public void selectMenu(Scanner scanner, List<MenuItem> list) {
        int select = 0;
        try {
            select = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            Kiosk.printFail();
        }
        if(select == 0){
            return;
        }
        else if(select > 0 && select < list.size()+1){
            System.out.println("================================================================");
            System.out.println("선택한 메뉴: " + list.get(select-1).getName() + "\t| W " + list.get(select-1).getPrice() + "\t|\t" + list.get(select-1).getExplain());
        }
        else {
            Kiosk.printFail();
            viewMenu(list);
        }
    }
}
