package pt.iade.unimaneger_db.models;

import java.io.Serializable;

public class PlanEstd_Id implements Serializable {

    private static final long serialVersionUID = 3103463164387407729L;
    private int dis_id;
    private int cur_id;

    public PlanEstd_Id () {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == PlanEstd_Id.class && ((PlanEstd_Id) obj).dis_id == dis_id
                && ((PlanEstd_Id) obj).cur_id == cur_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getDis_id() {
        return dis_id;
    }


    public int getCur_id() {
        return cur_id;
    }


}