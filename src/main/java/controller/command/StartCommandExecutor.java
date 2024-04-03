package controller.command;

import controller.ChessGame;
import view.OutputView;
import view.command.CommandType;

public class StartCommandExecutor implements CommandExecutor {
    public StartCommandExecutor(final CommandType commandType) {
        if (commandType.hasSupplements()) {
            throw new IllegalArgumentException("[ERROR] 게임 시작 명령어를 올바르게 입력해주세요.");
        }
    }

    @Override
    public void execute(final OutputView outputView, final ChessGame chessGame) {
        chessGame.start(outputView);
    }
}
