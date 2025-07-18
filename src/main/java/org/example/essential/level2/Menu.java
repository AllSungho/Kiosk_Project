package org.example.essential.level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// MenuItem 클래스를 관리하는 클래스
// 예시 : 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {
    private final List<MenuItem> burgerList;
    private final List<MenuItem> juiceList;

    public Menu(){
        this.burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        this.juiceList = new ArrayList<>();
        juiceList.add(new MenuItem("Coke",2.0, "탄산 음료"));
        juiceList.add(new MenuItem("Pepsi",2.0, "탄산 음료"));
        juiceList.add(new MenuItem("Cider",2.0, "탄산 음료"));
        juiceList.add(new MenuItem("Orange Juice",2.0, "오렌지 주스"));
        juiceList.add(new MenuItem("Americano",2.0, "아메리카노"));
    }

    public List<MenuItem> getBurgerList() {
        return burgerList;
    }

    public List<MenuItem> getJuiceList() {
        return juiceList;
    }

    // 버거 카테고리 클릭 시 볼 수 카테고리에 포함되는 버거를 출력
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
        }
        if(select == 0){
            return;
        }
        else if(select > 0 && select < list.size()){
            System.out.println("================================================================");
            System.out.println("선택한 메뉴: " + burgerList.get(select-1).getName() + "\t| W " + burgerList.get(select-1).getPrice() + "\t|\t" + burgerList.get(select-1).getExplain());
        }
        else {
            System.out.println("================================================================");
            System.out.println("잘못 입력");
            System.out.println("================================================================");
            viewBurger();
        }
    }
}
