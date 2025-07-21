package org.example.essential.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

// 시작 지점이 되는 클래스
public class Main {
    public static void main(String[] args) {
        final MenuItem[] burgerArrays = {new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        };

        while(true) {
            Scanner scanner = new Scanner(System.in);
            int input = 0;      // 사용자 입력값
            int number = 1;     // 버거 번호 출력값

            System.out.println("================================================================");
            System.out.println("[ SHAKESHACK MENU ]");
            for(MenuItem i : burgerArrays){
                System.out.println(number++ + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
            }
            System.out.println("0. 종료\t\t\t| 종료");
            System.out.println("================================================================");
            try{
                input = scanner.nextInt();
            } catch(InputMismatchException e){
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(정수를 입력하시오)");
                System.out.println("================================================================");
                continue;
            }
            if(input==0){
                System.out.println("================================================================");
                System.out.println("키오스크 종료");
                System.out.println("================================================================");
                break;
            }
            else if(input>0 && input <5){
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + burgerArrays[input - 1].getName() + "\t| W " + burgerArrays[input - 1].getPrice() + "\t|\t" + burgerArrays[input - 1].getExplain());
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
