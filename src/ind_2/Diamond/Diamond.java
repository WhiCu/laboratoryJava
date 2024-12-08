package ind_2.Diamond;

import ind_2.Diamond.Quality.Clarity;
import ind_2.Diamond.Quality.Color;
import ind_2.Diamond.Quality.Cut;

public class Diamond {
    Long index;
    Double carat;
    Cut cut;
    Color color;
    Clarity clarity;
    Double depth;
    Double percentageOfWidth;
    Double cost;
    Double length, width;

    public Diamond(Long index, Double carat, Cut cut, Color color, Clarity clarity, Double depth, Double percentageOfWidth, Double cost, Double length, Double width) {
        this.index = index;
        this.carat = carat;
        this.cut = cut;
        this.color = color;
        this.clarity = clarity;
        this.depth = depth;
        this.percentageOfWidth = percentageOfWidth;
        this.cost = cost;
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Diamond{" +
                "index=" + index +
                ", carat=" + carat +
                ", cut=" + cut +
                ", color=" + color +
                ", clarity=" + clarity +
                ", depth=" + depth +
                ", percentageOfWidth=" + percentageOfWidth +
                ", cost=" + cost +
                ", length=" + length +
                ", width=" + width +
                '}';
    }

    public long getIndex() {
        return index;
    }
    public Cut getCut() {
        return cut;
    }

    public Color getColor() {
        return color;
    }

    public Clarity getClarity() {
        return clarity;
    }

    public Double getCarat() {
        return carat;
    }
}
