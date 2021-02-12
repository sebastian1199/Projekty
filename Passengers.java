import javax.swing.*;
import java.util.Objects;
import java.util.Vector;

public class Passengers {

    int adults,childrens,infants;
    AirlineSystem system ;
    private JComboBox AdultsBox,ChildrenBox,InfantsBox;

    public Passengers(AirlineSystem system)
    {
        this.system=system;
        AdultsBox=system.getAdultsBox();
        ChildrenBox=system.getChildrensBox();
        InfantsBox=system.getInfantsBox();
    }

    public void setpassengersvec(Vector<String> vec)
    {
        vec.clear();

        for(int r=0;r<adults;r++) {
            vec.add("Adult");
        }
        for(int t=0;t<childrens;t++) {
            vec.add("Children");
        }
        for(int o=0;o<infants;o++) {
            vec.add("Infant");
        }
    }

    public int passengers_sum()
    {
        return adults+childrens+infants;
    }

    public void getpassengers()
    {
    adults=Integer.parseInt(Objects.requireNonNull(AdultsBox.getSelectedItem()).toString());
    childrens = Integer.parseInt(Objects.requireNonNull(ChildrenBox.getSelectedItem()).toString());
    infants = Integer.parseInt(Objects.requireNonNull(InfantsBox.getSelectedItem()).toString());
    }

    public int getAdults()
    {
        return adults;
    }
    public int getChildrens()
    {
        return childrens;
    }
    public int getInfants()
    {
        return infants;
    }

}
