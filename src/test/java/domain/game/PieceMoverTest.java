package domain.game;

import domain.chessboard.Square;
import domain.piece.Color;
import domain.piece.Piece;
import domain.piece.PieceRole;
import domain.piece.PieceType;
import domain.position.File;
import domain.position.Position;
import domain.position.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceMoverTest {

    @DisplayName("source에 위치한 piece를 target으로 이동한다.")
    @Test
    void movePieceToTarget() {
        Position sourcePosition = new Position(new File('b'), new Rank(1));
        Square sourceSquare = new Square(sourcePosition);

        Position targetPosition = new Position(new File('c'), new Rank(2));
        Square targetSquare = new Square(targetPosition);

        PieceMover pieceMover = new PieceMover();

        Piece piece = new Piece(new PieceType(PieceRole.KING, Color.BLACK), sourcePosition);
        pieceMover.add(sourceSquare, piece);

        pieceMover.move(sourceSquare, targetSquare);

        Piece findPiece = pieceMover.findPieceBySquare(targetSquare);
        Assertions.assertThat(findPiece).isEqualTo(piece);
    }

}
