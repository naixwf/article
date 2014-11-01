package com.naixwf.article.persistence;

import com.naixwf.article.domain.Authority;
import com.naixwf.article.domain.AuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AuthorityMapper {
    int countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExampleWithRowbounds(AuthorityExample example, RowBounds rowBounds);

    List<Authority> selectByExample(AuthorityExample example);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);
}