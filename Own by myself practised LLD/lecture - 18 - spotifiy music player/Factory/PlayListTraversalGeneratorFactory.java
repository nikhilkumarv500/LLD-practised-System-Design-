package Factory;

import Enum.PlayListTraversalType;
import Model.PlayList;
import PlaylistSongTraversal.IPlayListTraversalStrategy;
import PlaylistSongTraversal.RandomPlayListTraversal;
import PlaylistSongTraversal.SequencialPlayListTraversal;

public class PlayListTraversalGeneratorFactory {
    IPlayListTraversalStrategy iPlayListTraversalStrategy;

    public IPlayListTraversalStrategy createStrategy(PlayListTraversalType type, PlayList playList) {

        if(type == PlayListTraversalType.SEQUENCIAL)
         iPlayListTraversalStrategy = new SequencialPlayListTraversal(playList);
         else if(type == PlayListTraversalType.RANDOM)
         iPlayListTraversalStrategy = new RandomPlayListTraversal(playList);

         return iPlayListTraversalStrategy;

    }

    public IPlayListTraversalStrategy getPlayListTraversalStrategy() {
        return iPlayListTraversalStrategy;
    }
}
