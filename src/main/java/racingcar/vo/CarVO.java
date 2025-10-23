package racingcar.vo;

public class CarVO {
    private static final int MOVE_LIMIT = 4;

    private final CarNameVO name;
    private int position;

    public CarVO(String name) {
        this.name = new CarNameVO(name);
        this.position = 0;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomValue) {
        if (canMove(randomValue)) {
            position++;
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_LIMIT;
    }
}
