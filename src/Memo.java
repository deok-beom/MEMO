import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {
    private String writerID;
    private String memoID;
    private String password;
    private String contents;
    private String title;
    private OffsetDateTime createdDate;
    private OffsetDateTime updateDate;

    public Memo(String memoId, String writerId, String title, String contents, String password) {
        this.memoID = memoId;
        this.writerID = writerId;
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
        return this.writerID;
    }

    public void editMemo(String newTitle, String newContents) {
        this.title = newTitle;
        this.contents = newContents;
        this.updateDate = OffsetDateTime.now();
    }

}
