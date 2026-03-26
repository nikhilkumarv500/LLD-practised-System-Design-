package PlaylistSongTraversal;

import java.util.Random;

import Enum.PlayListTraversalType;
import Model.PlayList;
import Model.Song;

public class RandomPlayListTraversal implements IPlayListTraversalStrategy {
    PlayList playList;
    String type = PlayListTraversalType.RANDOM.toString();

    public RandomPlayListTraversal(PlayList list) {
        playList=list;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Song next() {
        Random random = new Random();
        int index = random.nextInt(playList.getSongs().size()) % playList.getSongs().size();
        return playList.getSongs().get(index);

    }

    @Override
    public void setPlaylist(PlayList playList) {
        this.playList = playList;
        
    }

    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public PlayList getPlaylist() {
        return playList;
    }
    

}
