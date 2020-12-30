package pt.iade.unimaneger_db.models;

import java.io.Serializable;

public class InsId implements Serializable {

    private static final long serialVersionUID = 3103463164387407729L;
    private int alu_id;
    private int pla_cur_id;
    private int pla_dis_id;

    public InsId () {
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == InsId.class && ((InsId) obj).alu_id == alu_id
                && ((InsId) obj).pla_cur_id == pla_cur_id && ((InsId) obj).pla_dis_id == pla_dis_id;

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getAlu_id() {
        return alu_id;
    }



    public int getPla_cur_id() {
        return pla_cur_id;
    }

    

    public int getPla_dis_id() {
        return pla_dis_id;
    }

   


       
}
