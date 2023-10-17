package Songs;

//import Contracts.SongsGetter;
import SoundMedia.*;


public class Song  extends SoundMediaAbsolute{ //implements SongsGetter
    //Поля
    private String groupName;
    private String songTitle;
    private SoundMediaAbsolute mediaType;

    //Конструктор
    public Song(String groupName, String songTitle, SoundMediaAbsolute mediaType){
        if (groupName.isEmpty() || songTitle.isEmpty()) {
            throw new IllegalArgumentException("Group name and song title must not be empty.");
        }
        this.groupName = groupName;
        this.songTitle =songTitle;
        this.mediaType = mediaType;
    }

    //Гетеры понадобятся для домонстрации работы
    public SoundMediaAbsolute getMediaType(){
        return this.mediaType;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public String getSongTitle(){
        return this.songTitle;
    }

}
