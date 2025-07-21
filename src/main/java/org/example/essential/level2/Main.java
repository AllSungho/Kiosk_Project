package org.example.essential.level2;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// 시작 지점이 되는 클래스
public class Main {
    public static void main(String[] args) {
        List<MenuItem> burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {
            Scanner scanner = new Scanner(System.in);
            int select = 0;      // 사용자 입력값

            System.out.println("================================================================");
            System.out.println("[ SHAKESHACK MENU ]");
            for(MenuItem i : burgerList){
                System.out.println(burgerList.indexOf(i)+1 + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
            }
            System.out.println("0. 종료\t\t\t| 종료");
            System.out.println("================================================================");
            try{
                select = scanner.nextInt();
            } catch(InputMismatchException e){
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(정수를 입력하시오)");
                System.out.println("================================================================");
                continue;
            }
            if(select==0){
                System.out.println("================================================================");
                System.out.println("키오스크 종료");
                System.out.println("================================================================");
                break;
            }
            else if(select>0 && select <5){
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + burgerList.get(select - 1).getName() + "\t| W " + burgerList.get(select - 1).getPrice() + "\t|\t" + burgerList.get(select - 1).getExplain());
                System.out.println("================================================================");
            }
            else {
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(해당 번호의 버거는 없습니다)");
                System.out.println("================================================================");
            }
        }
    }
}
