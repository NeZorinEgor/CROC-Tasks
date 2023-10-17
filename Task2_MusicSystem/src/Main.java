import Songs.*;
import SoundMedia.*;
import SoundPlayer.CDPlaer;
import SoundPlayer.FlashPlayer;
import SoundPlayer.UNIVERSALPlayer;
import SoundPlayer.VenilPlayer;

public class Main {
    public static void main(String[] args){
        // Создаем экземпляры песен
        Song testSong = new Song("Земфира", "Хочешь?", new Venil());
        Song testSong2 = new Song("Земфира", "Кто?", new Flash());
        Song testSong3 = new Song("Земфира", "ИСКАЛА", new CD());
        Song testSong4 = new Song("Земфира", "Почему", new CD());
        // Создаем проигрыватели музыки
        VenilPlayer testVenil = new VenilPlayer();
        FlashPlayer testFlash = new FlashPlayer();
        CDPlaer testCD = new CDPlaer();
        UNIVERSALPlayer testUNIVERSAL = new UNIVERSALPlayer();

        //Запуск звуковых носителей в нужных проигрывателях

        testVenil.playSong(testSong);
        testFlash.playSong(testSong2);
        testCD.playSong(testSong3);
        testUNIVERSAL.playSong(testSong4);

        //Запуск звуковых носителей в не родных проигрывателях
        testVenil.playSong(testSong4);
        testFlash.playSong(testSong3);
        testCD.playSong(testSong2);
        testUNIVERSAL.playSong(testSong);
    }
}

