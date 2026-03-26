package Manager;

import Enum.PlayListTraversalType;
import Factory.PlayListTraversalGeneratorFactory;
import Model.PlayList;
import PlaylistSongTraversal.IPlayListTraversalStrategy;

public class PlayListTraversalManager {
    PlayListTraversalGeneratorFactory factory;
    IPlayListTraversalStrategy playListTraversalStrategy;

    public PlayListTraversalManager(PlayListTraversalType type, PlayList playList) {
        factory = new PlayListTraversalGeneratorFactory();
        playListTraversalStrategy=factory.createStrategy(type, playList);
    }

    public void doPlayListTraversal() {
        System.out.println("---------------------");
        System.out.println("Traversal = " + playListTraversalStrategy.getType());
        
        int sz = playListTraversalStrategy.getPlaylist().getSongs().size();
        if(playListTraversalStrategy.getType().equals(PlayListTraversalType.RANDOM.toString())) sz=4;

        while((sz-- > 0) && playListTraversalStrategy.hasNext()) {
            System.out.println(playListTraversalStrategy.next());
        }
        System.out.println("---------------------");
    }

}
