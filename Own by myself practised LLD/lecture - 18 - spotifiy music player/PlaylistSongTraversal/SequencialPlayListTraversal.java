package PlaylistSongTraversal;

import Enum.PlayListTraversalType;
import Model.PlayList;
import Model.Song;

public class SequencialPlayListTraversal implements IPlayListTraversalStrategy {
    PlayList playList;
    int index=0;
    String type = PlayListTraversalType.SEQUENCIAL.toString();

    public SequencialPlayListTraversal(PlayList playList) {
        this.playList=playList;
    }

    @Override
    public boolean hasNext() {
        return (index < playList.getSongs().size());
    }

    @Override
    public Song next() {
        Song present = playList.getSongs().get(index++);
        return present;
    }

    @Override
    public void setPlaylist(PlayList playList) {
        this.playList=playList;
        
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
