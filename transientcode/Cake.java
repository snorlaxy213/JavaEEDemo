package transientcode;

import java.io.Serializable;

public class Cake implements Serializable {

    private static final long serialVersionUID = 7282968971122587488L;

    private String shape;
    transient private String color;

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setShape(final String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
