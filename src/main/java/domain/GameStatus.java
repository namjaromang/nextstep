package domain;

public enum GameStatus {

    READY("게임 준비"),
    PLAY("게임 시작"),
    END("게임 종료");

    private final String description;

    GameStatus(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
