package com.reflection;

public class VipUser extends User implements Comparable<VipUser> {

    private Integer score;

    private String vipNo;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VipUser{");
        sb.append("id=").append(getId());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", score=").append(score);
        sb.append(", vipNo='").append(vipNo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(VipUser user) {
        return score - user.score;
    }
}
