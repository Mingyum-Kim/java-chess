package chess.domain.piece;

import chess.domain.move.MoveStrategy;
import chess.domain.move.RookMoveStrategy;

public final class Rook extends ValidPiece {

    private static final double POINT = 5;

    public Rook(final Team team) {
        super(team, POINT);
    }

    @Override
    public MoveStrategy getMoveStrategy() {
        return new RookMoveStrategy();
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return false;
    }
}
