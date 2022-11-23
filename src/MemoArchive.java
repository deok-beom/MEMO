import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MemoArchive {
    private List<Memo> memoList;
    private HashMap<String, User> users;

    public MemoArchive() {
        this.memoList = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public String getMemoList() {
        StringBuilder listBuilder = new StringBuilder();

        if (this.memoList.size() == 0) {
            listBuilder.append("메모가 텅 비었습니다.");
        }

        for (int i = 0; i < memoList.size(); ) {
            Memo singleMemo = memoList.get(i);
            User writer = users.get(singleMemo.getWriterId());
            listBuilder.append(String.format("%d. %s : %s [%s]%s", ++i, singleMemo.getTitle(), writer.getName(), singleMemo.getUpdateDate(), System.lineSeparator()));
        }

        return listBuilder.toString();
    }

    public boolean readMemo(int index) {
        if (index > memoList.size()) {
            System.out.println(" 잘 못 입력하였습니다. ");
            return false;
        } else {
            Memo targetMemo = memoList.get(index - 1);
            System.out.println(String.format("제목 : %s", targetMemo.getTitle()));

            User writer = users.get(targetMemo.getWriterId());
            System.out.println(String.format("작성자 : %s", writer.getName()));
            System.out.println(String.format("내용 : %s", targetMemo.getContents()));
            System.out.println(String.format("갱신 시간 : %s", targetMemo.getUpdateDate()));
            return true;
        }
    }

    public void addMemo(String writerId, String title, String contents, String password) {
        String memoId = UUID.randomUUID().toString();
        Memo newMemo = new Memo(memoId, writerId, title, contents, password);
        memoList.add(newMemo);
    }

    public void updateMemo(int index, String title, String contents) {
        Memo targetMemo = memoList.get(index - 1);
        targetMemo.editMemo(title, contents);
    }

    public void deleteMemo(int index) {
        memoList.remove(index - 1);
    }

    public boolean checkPermission(int index, String password) {
        Memo targetMemo = memoList.get(index - 1);
        if (targetMemo.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(User user) {
        users.put(user.getUserID(), user);
    }
}
