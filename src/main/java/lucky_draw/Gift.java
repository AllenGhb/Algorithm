package lucky_draw;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 抽奖奖品实体类
 * 
 * @author 周何圳 2018年09月18日 新建
 */
public class Gift {

    /** 奖品id **/
    private int id;
    /** 奖品名称 **/
    private String name;
    /** 奖品概率 **/
    private double prob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
