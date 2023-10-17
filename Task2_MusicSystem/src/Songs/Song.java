package Songs;

//import Contracts.SongsGetter;
import SoundMedia.SoundMediaAbsolute;



public class Song  extends SoundMediaAbsolute{
    //Поля
    private String groupName;
    private String songTitle;
    private SoundMediaAbsolute mediaType; //Поле для хранения типа, на котором корректно проигрывается

    //Конструктор
    public Song(String groupName, String songTitle, SoundMediaAbsolute mediaType){
        if (groupName.isEmpty() || songTitle.isEmpty()) {
            throw new IllegalArgumentException("Group name and song title must not be empty.");
        }
        this.groupName = groupName;
        this.songTitle =songTitle;
        this.mediaType = mediaType;
    }

    /**
     * Для корректного вывода типа через строку, а не получая по итогу ссылку
     * @return mediaType.getMediaTyper()
     */
    public String getMediaType(){
        return mediaType.getMediaTyper();
    }

    //Для вывода названия группы
    public String getGroupName(){
        return this.groupName;
    }

    //Для вывода названия песни
    public String getSongTitle(){
        return this.songTitle;
    }

}
