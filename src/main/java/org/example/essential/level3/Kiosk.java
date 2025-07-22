package org.example.essential.level3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    // 버거 리스트
    private final List<MenuItem> burgerList;

    // 키오스크 생성자로 버거 리스트 초기화
    public Kiosk(){
        this.burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // 키오스크 시작 메소드
    public void startKiosk(){
        viewBurger();
    }
    // 버거 메뉴를 출력하는 메소드
    public void viewBurger() {
        System.out.println("================================================================");
        System.out.println("[ SHAKESHACK MENU ]");
        for(MenuItem i : burgerList){
            System.out.println(burgerList.indexOf(i) + 1 + ". " + i.getName() + "\t| W " + i.getPrice() + "\t|\t" + i.getExplain());
        }
        System.out.println("0. Go Back");
        System.out.println("================================================================");
        selectBurger(new Scanner(System.in));       // 메뉴 출력 후 사용자에게 입력 요구
    }
    // 사용자에게 입력을 받고 그에 따른 결과값을 출력하는 메소드
    public void selectBurger(Scanner scanner) {
        int select = 0;      // 사용자 입력값

        // 입력 예외 처리
        try {
            select = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("================================================================");
            System.out.println("잘못된 수 입력");
            System.out.println("================================================================");
            viewBurger();
            return;     // 해당 메소드 종료
        }
        if(select == 0){        // 입력값이 0일 경우 키오스크 종료
            System.out.println("================================================================");
            System.out.println("종료");
            System.out.println("================================================================");
        }
        else if(select > 0 && select < burgerList.size()+1){        // 입력값이 1보다 크고 버거 리스트 크기보다 작을 경우 해당 번호 버거 출력
            System.out.println("================================================================");
            System.out.println("선택한 메뉴: " + burgerList.get(select-1).getName() + "\t| W " + burgerList.get(select-1).getPrice() + "\t|\t" + burgerList.get(select-1).getExplain());
            viewBurger();
        }
        else {      // 해당 번호 이외의 입력 시
            System.out.println("================================================================");
            System.out.println("잘못 입력");
            System.out.println("================================================================");
            viewBurger();
        }
    }
}
