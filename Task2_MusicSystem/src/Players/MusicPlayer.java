package Players;

//Клас для всех музыкальных проигрывателей
public class MusicPlayer {
    //Конструктор
    public MusicPlayer(String supportedRecordType){
        this.supportedRecordType = supportedRecordType;
    }

    private String supportedRecordType;

    protected String getRecordType(){
        return this.supportedRecordType;
    }
}




