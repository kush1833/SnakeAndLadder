package kushagra.strategy;

import kushagra.model.Board;

import java.io.IOException;

public interface InputStrategy {
    Board setBoard() throws IOException;
}
