import java.util.ArrayList;

public class Klass {
    private String klass;
    private Aine[] aineteKogum;


    public Klass(String klass, Aine[] aineteKogum) {
        this.klass = klass;
        this.aineteKogum = aineteKogum;

    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public Aine[] getAineteKogum() {
        return aineteKogum;
    }

    public void setAineteKogum(Aine[] aineteKogum) {
        this.aineteKogum = aineteKogum;
    }
}
