import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner inputSC = new Scanner(System.in);
        MemoArchive b7Memo = new MemoArchive();

        User user1 = new User(UUID.randomUUID().toString(), "뽀로로", "user1");
        User user2 = new User(UUID.randomUUID().toString(), "크롱", "user2");
        User user3 = new User(UUID.randomUUID().toString(), "루피", "user3");

        b7Memo.addUser(user1);
        b7Memo.addUser(user2);
        b7Memo.addUser(user3);

        b7Memo.addMemo(user1.getUserID(), "안녕하세요", "반갑습니다", "memo1");
        b7Memo.addMemo(user2.getUserID(), "프로젝트 테스트 케이스를 위한 글입니다.", "테스트는 잘 진행이 되어가고 있나요?", "memo2");
        b7Memo.addMemo(user3.getUserID(), "언제나 어디서나", "피카츄가 옆에 있어", "memo3");

        System.out.println("안녕하세요");
        User user;
        {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(" 회원 정보를 입력해주세요. ");
            System.out.print(" ID : ");
            String userID = inputSC.next();
            System.out.print(" PASSWORD : ");
            String password = inputSC.next();
            user = new User(UUID.randomUUID().toString(), userID, password);
        }

        program:
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            String memoList = b7Memo.getMemoList();

            if (!(memoList.trim().equals("메모가 텅 비었습니다.") || memoList == null)) {
                System.out.println("어떤 작업을 할까요?");
                System.out.println(String.format("0. 새 글 작성하기%s", System.lineSeparator()));

                System.out.println("- 메모 읽기");
                System.out.println(b7Memo.getMemoList());

                System.out.println(String.format("exit. 종료"));
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print(" > ");
                String input = inputSC.next();

                if (!(input.equals("exit"))) {
                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);
                        if (!(c >= 48 && c <= 57)) {
                            jump();
                            System.out.println(" 잘 못 입력하였습니다. ");
                            continue program;
                        }
                    }
                } else {
                    jump();
                    break;
                }

                if (Integer.parseInt(input) == 0) {
                    jump();
                    String title = writeTitle(inputSC);
                    String contents = writeContents(inputSC);
                    String password = writePassword(inputSC);
                    b7Memo.addMemo(user.getUserID(), title, contents, password);
                } else {
                    int index = Integer.parseInt(input);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    if (!b7Memo.readMemo(index)) {
                        continue;
                    } else {
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        System.out.println(" 어떤 작업을 할까요? ");
                        System.out.println("1. 돌아가기");
                        System.out.println("2. 수정");
                        System.out.println("3. 삭제");
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        System.out.print(" > ");
                        input = inputSC.next();

                        for (int i = 0; i < input.length(); i++) {
                            char c = input.charAt(i);
                            if (!(c >= 48 && c <= 57)) {
                                System.out.println(" 잘 못 입력하였습니다.");
                                System.out.println(" 처음으로 돌아갑니다.");
                                jump();
                                continue program;
                            }
                        }
                    }

                    switch (Integer.parseInt(input)) {
                        case 1:
                            break;
                        case 2:
                            System.out.println("--------------------------------------------------------------------------------------------------------");
                            String password = writePassword(inputSC);
                            if (b7Memo.checkPermission(index, password)) {
                                String title = writeTitle(inputSC);
                                String contents = writeContents(inputSC);
                                b7Memo.updateMemo(index, title, contents);
                            } else {
                                System.out.println(" 비밀번호가 틀립니다. ");
                            }
                            break;
                        case 3:
                            System.out.println("--------------------------------------------------------------------------------------------------------");
                            password = writePassword(inputSC);
                            if (b7Memo.checkPermission(index, password)) {
                                b7Memo.deleteMemo(index);
                            } else {
                                System.out.println(" 비밀번호가 틀립니다. ");
                            }
                            break;
                        default:
                            System.out.println(" 잘 못 입력하였습니다. ");
                            System.out.println(" 처음으로 돌아갑니다. ");
                    }
                }
            } else {
                System.out.print(b7Memo.getMemoList());
                System.out.println(System.lineSeparator());
                System.out.println("1. 첫번째 글 작성하기");
                System.out.println("2. 종료");
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print(" > ");
                String input = inputSC.next();

                switch (Integer.parseInt(input)) {
                    case 1:
                        String title = writeTitle(inputSC);
                        String contents = writeContents(inputSC);
                        String password = writePassword(inputSC);
                        b7Memo.addMemo(user.getUserID(), title, contents, password);
                        break;
                    case 2:
                        System.out.println("안녕히 가세요");
                        break program;
                    default:
                        System.out.println(" 잘 못 입력하였습니다. ");
                }
            }

            jump();
        }
    }

    private static String writeTitle(Scanner inputSC) {
        System.out.println("제목을 입력해주세요.");
        System.out.print(" > ");
        return inputSC.next();
    }

    private static String writeContents(Scanner inputSC) {
        System.out.println("내용을 입력해주세요.");
        System.out.print(" > ");
        return inputSC.next();
    }

    private static String writePassword(Scanner inputSC) {
        System.out.println("패스워드를 입력해주세요.");
        System.out.print(" > ");
        return inputSC.next();
    }

    private static void jump() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }
}
