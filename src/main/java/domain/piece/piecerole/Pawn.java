package domain.piece.piecerole;

import domain.game.Direction;
import domain.piece.Color;
import domain.piece.Movable;
import domain.position.Position;
import java.util.List;
import java.util.Objects;

public class Pawn implements PieceRole {
    protected List<Movable> routes;
    protected int count;

    public Pawn(final Color color) {
        count = 1;
        if (color == Color.BLACK) {
            this.routes = List.of(
                    new Movable(getMaxMovement(count), Direction.SOUTH),
                    new Movable(getMaxMovement(count), Direction.SOUTH_EAST),
                    new Movable(getMaxMovement(count), Direction.SOUTH_WEST)
            );
        }
        if (color == Color.WHITE) {
            this.routes = List.of(
                    new Movable(getMaxMovement(count), Direction.NORTH),
                    new Movable(getMaxMovement(count), Direction.NORTH_EAST),
                    new Movable(getMaxMovement(count), Direction.NORTH_WEST)
            );
        }
    }

    protected int getMaxMovement(final int count) {
        if (count == 1) {
            return 2;
        }
        return 1;
    }

    @Override
    public boolean canMove(final Position sourcePosition, final Position targetPosition) {
        boolean canMove = routes.stream()
                .anyMatch(movable -> movable.canMove(sourcePosition, targetPosition));
        if (count == 1) {
            for (Movable movable : routes) {
                movable.decreaseMaxMovement();
            }
            count++;
        }
        return canMove;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Pawn pawn = (Pawn) o;
        return Objects.equals(routes, pawn.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routes);
    }
}
