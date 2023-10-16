package Songs;

public class Song {
    private String groupName;
    private String songTitle;
    //Конструктор
    public Song(String groupName, String songTitle){
        if (groupName.isEmpty() || songTitle.isEmpty()) {
            throw new IllegalArgumentException("Group name and song title must not be empty.");
        }
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
    // сеттер для поля songTitle
    public void setSongTitle(String songTitle){
        if (songTitle.isEmpty()){
            System.out.println("Enter correct SONG NAME!");
        } else {
            this.songTitle = songTitle;
        }
    }

    public void aboutSoung(){
        System.out.println("Group name: " + groupName + " Song title: " + songTitle);
    }
}
