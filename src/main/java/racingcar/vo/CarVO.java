package racingcar.vo;

public class CarVO {
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
}
