package ind_2;

import ind_2.Diamond.Diamond;
import ind_2.Diamond.DiamondHandler;
import ind_2.Diamond.DiamondScanner;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var d = DiamondScanner.from("C:\\Java_lessons\\UniYar\\src\\ind_2\\data_diamond.txt");
//        for (var dim : d){
//            System.out.println(dim);
//        }
        Double minLength =5.10;
        Double maxLength =5.20;
        Double minWidth =5.10;
        Double maxWidth =5.20;
        Double minDepth =61.;
        Double maxDepth =62.;
        List<String> sortOrder = Arrays.asList("color");//"cut", "color", "clarity", "carat");

        var DH = new DiamondHandler(d);
        DH.sortDiamonds();
        DH.wtof();
        List<Diamond> selectedDiamonds = DH.filterAndSortDiamonds(minLength, maxLength, minWidth, maxWidth, minDepth, maxDepth, sortOrder);

    }
}
//Diamond{index=293, carat=0.51, cut=Ideal, color=D, clarity=VVS1, depth=61.7, percentageOfWidth=56.0, cost=2797.0, length=5.12, width=5.16}