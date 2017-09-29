package test.bwie.com.mymusic.Model.Bean;

/**
 * Created by 黑白 on 2017/9/29.
 */

public class MusicListChild {
    /**
     * type =
     * 1-新歌榜,
     * 2-热歌榜,
     * 11-摇滚榜,
     * 12-爵士,
     * 16-流行,
     * 21-欧美金曲榜,
     * 22-经典老歌榜,
     * 23-情歌对唱榜,
     * 24-影视金曲榜,
     * 25-网络歌曲榜
     */
    private String type;

    private String  listName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
