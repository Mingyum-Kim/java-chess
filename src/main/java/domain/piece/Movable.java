package domain.piece;

import domain.game.Direction;
import domain.position.Position;
import java.util.Objects;

public class Movable {
    private final int maxMovement;
    private final Direction direction;

    public Movable(int maxMovement, Direction direction) {
        this.maxMovement = maxMovement;
        this.direction = direction;
    }

    public boolean canMove(Position sourcePosition, Position targetPosition) {
        Direction findDirection = Direction.findDirection(sourcePosition, targetPosition);
        return this.direction == findDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movable movable = (Movable) o;
        return maxMovement == movable.maxMovement && direction == movable.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxMovement, direction);
    }
}
