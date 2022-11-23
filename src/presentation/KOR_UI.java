package Miniproject2.src.presentation;

import UserRepository.src.data.UserRepository;

import java.util.Scanner;

public class KOR_UI implements UI{
    UserRepository userRepository;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("========================");
        System.out.println("1. 메모 작성하기");
        System.out.println("2. 메모 목록보기");
        System.out.println("3. 메모 수정하기");
        System.out.println("4. 메모 삭제하기");
        System.out.println("5. 종료하기");
        System.out.println("========================");
        System.out.print("원하는 작업 번호를 입력해주세요 : ");
        String s = scanner.nextLine();
    }

    @Override
    public void start() {

    }
}
