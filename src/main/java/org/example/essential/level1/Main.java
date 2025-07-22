package org.example.essential.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            int input = 0;      // 사용자 입력값

            // 메뉴 출력
            System.out.println("================================================================");
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println(1 + ". " + "ShackBurger" + "\t| W " + 6.9 + "\t|\t" + "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println(2 + ". " + "SmokeShack" + "\t| W " + 8.9 + "\t|\t" + "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println(3 + ". " + "Cheeseburger" + "\t| W " + 6.9 + "\t|\t" + "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println(4 + ". " + "Hamburger" + "\t| W " + 5.4 + "\t|\t" + "비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료\t\t\t| 종료");
            System.out.println("================================================================");
            // 입력 예외 처리
            try{
                input = scanner.nextInt();
            } catch(InputMismatchException e){
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(정수를 입력하시오)");
                System.out.println("================================================================");
                continue;
            }
            if(input==0){       // 입력값이 0일 경우 키오스크 종료
                System.out.println("================================================================");
                System.out.println("키오스크 종료");
                System.out.println("================================================================");
                break;
            }
            else if(input==1){  // 입력값이 1일 경우 1번 햄버거 출력
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + "ShackBurger" + "\t| W " + 6.9 + "\t|\t" + "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                System.out.println("================================================================");
            }
            else if(input==2){  // 입력값이 2일 경우 2번 햄버거 출력
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + "SmokeShack" + "\t| W " + 8.9 + "\t|\t" + "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                System.out.println("================================================================");
            }
            else if(input==3){  // 입력값이 2일 경우 2번 햄버거 출력
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + "Cheeseburger" + "\t| W " + 6.9 + "\t|\t" + "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                System.out.println("================================================================");
            }
            else if(input==4){  // 입력값이 4일 경우 4번 햄버거 출력
                System.out.println("================================================================");
                System.out.println("선택한 메뉴: " + "Hamburger" + "\t| W " + 5.4 + "\t|\t" + "비프패티를 기반으로 야채가 들어간 기본버거");
                System.out.println("================================================================");
            }
            else {              // 그 외 번호 입력 시
                System.out.println("================================================================");
                System.out.println("잘못된 수 입력(해당 번호의 버거는 없습니다)");
                System.out.println("================================================================");
            }
        }
    }
}
