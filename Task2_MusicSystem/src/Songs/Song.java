package Songs;

import SoundMedia.*;

public class Song extends SoundMediaAbsolute{
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


    public SoundMediaAbsolute getMediaType(){
        return mediaType;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public String getSongTitle(){
        return this.songTitle;
    }

}
