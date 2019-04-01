package com.ssm.entity.common;

/**
 * @author HY
 */
public enum UserGradeEnum {

    FIRST_GRADE         (1, "新正", "[一月别称]，等级一级"),
    SECOND_GRADE        (2, "仲春", "[二月别称]，等级二级"),
    THIRD_GRADE         (3, "桃月", "[三月别称]，等级三级"),
    FOURTH_GRADE        (4, "孟夏", "[四月别称]，等级四级"),
    FIFTH_GRADE         (5, "仲夏", "[五月别称]，等级五级"),
    SIXTH_GRADE         (6, "伏月", "[六月别称]，等级六级"),
    SEVENTH_GRADE       (7, "霜月", "[七月别称]，等级七级"),
    EIGHTH_GRADE        (8, "桂月", "[八月别称]，等级八级"),
    NINTH_GRADE         (9, "季秋", "[九月别称]，等级九级"),
    TENTH_GRADE         (10, "孟冬", "[十月别称]，等级十级"),
    ELEVENTH_GRADE      (11, "葭月", "[十一月别称]，等级十一级"),
    TWELFTH_GRADE       (12, "暮岁", "[十二月别称]，等级十二级")
    ;

    /**
     * 等级编号
     */
    private Integer gradeCode;
    /**
     * 等级名称
     */
    private String gradeName;
    /**
     * 等级描述
     */
    private String gradeDesc;

    UserGradeEnum() {}

    UserGradeEnum(Integer gradeCode, String gradeName, String gradeDesc) {
        this.gradeCode = gradeCode;
        this.gradeName = gradeName;
        this.gradeDesc = gradeDesc;
    }

    /**
     * 获取 等级名称
     *
     * @return gradeName 等级名称
     */
    public String getGradeName() {
        return this.gradeName;
    }

    /**
     * 设置 等级名称
     *
     * @param gradeName 等级名称
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * 获取 等级描述
     *
     * @return gradeDesc 等级描述
     */
    public String getGradeDesc() {
        return this.gradeDesc;
    }

    /**
     * 设置 等级描述
     *
     * @param gradeDesc 等级描述
     */
    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    /**
     * 获取 等级编号
     *
     * @return gradeCode 等级编号
     */
    public Integer getGradeCode() {
        return this.gradeCode;
    }

    /**
     * 设置 等级编号
     *
     * @param gradeCode 等级编号
     */
    public void setGradeCode(Integer gradeCode) {
        this.gradeCode = gradeCode;
    }
}
