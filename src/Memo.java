import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {
    private int memoIdx;
    private String writerId;
    private String memoId;
    private String password;
    private String contents;
    private String title;
    private OffsetDateTime createdDate;
    private OffsetDateTime updateDate;

    public Memo(String memoId, String writerId, String title, String contents, String password) {
        this.memoIdx = 1;
        this.memoId = memoId;
        this.writerId = writerId;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.createdDate = OffsetDateTime.now();
        this.updateDate = this.createdDate;
    }

    public String getContents() {
        return this.contents;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCreatedDate() {
        return this.createdDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분"));
    }

    public String getUpdateDate() {
        return this.updateDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분"));
    }

    public String getPassword() {
        return this.password;
    }

    public String getWriterId() {
        return this.writerId;
    }

    public void editMemo(String newTitle, String newContents) {
        this.title = newTitle;
        this.contents = newContents;
        this.updateDate = OffsetDateTime.now();
    }

}
