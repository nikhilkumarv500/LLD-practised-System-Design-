package PlaylistSongTraversal;
import Model.PlayList;
import Model.Song;

public interface IPlayListTraversalStrategy {

    void setPlaylist(PlayList playList);

    boolean hasNext();
    Song next();

    String getType();

    PlayList getPlaylist();
    
}