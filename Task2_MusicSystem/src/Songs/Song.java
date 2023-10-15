package Songs;

public class Song {
    private String groupName;
    private String songTitle;

    //Конструктор
    public Song(String groupName, String songTitle){
        this.groupName = groupName;
        this.songTitle =songTitle;
    }

    // сеттер для поля groupName
    public void setGroupName(String groupName){
        if (groupName.isEmpty()){
            System.out.println("Enetr correct GROUP NAME!");
        } else {
            this.groupName = groupName;
        }
    }

    public void setSongTitle(String songTitle){
        if (songTitle.isEmpty()){
            System.out.println("Enetr correct SONG NAME!");
        } else {
            this.songTitle = songTitle;
        }
    }
}
