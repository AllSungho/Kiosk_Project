package org.example.essential.level1;

import java.util.*;

// MenuItem 클래스를 관리하는 클래스
// 예시 : 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {
    private List<MenuItem> burgerList;
    private List<MenuItem> juiceList;

    public Menu(){
        this.burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        this.juiceList = new ArrayList<>();
    }
    // 버거 카테고리 클릭 시 볼 수 카테고리에 포함되는 버거를 출력
    public void viewBurger() {
        System.out.println("================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for(MenuItem i : burgerList){
            System.out.println(burgerList.indexOf(i) + 1 + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
        }
        System.out.println("0. 종료\t\t\t| 종료");
        System.out.println("================================================================");
    }
    public MenuItem selectBurger(Scanner scanner){
        int select = scanner.nextInt();
        if(select == 0){
            System.out.println("================================================================");
            System.out.println(" answer = 0 버거 카테고리 종료(Level 1 Clear)");
            System.out.println("================================================================");
            return null;
        }
        else{
            System.out.println("================================================================");
            System.out.println("answer = " + select + "다시 입력(Level 1 Clear)");
            System.out.println("================================================================");
            viewBurger();
            selectBurger(scanner);
            return null;
        }
    }
}
