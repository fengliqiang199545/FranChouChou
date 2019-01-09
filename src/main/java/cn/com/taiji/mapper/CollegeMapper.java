package cn.com.taiji.mapper;

import cn.com.taiji.entity.College;
import cn.com.taiji.entity.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    long countByExample(CollegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int deleteByExample(CollegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int deleteByPrimaryKey(Integer collegeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int insert(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int insertSelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    List<College> selectByExample(CollegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    College selectByPrimaryKey(Integer collegeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int updateByPrimaryKeySelective(College record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table college
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    int updateByPrimaryKey(College record);
}