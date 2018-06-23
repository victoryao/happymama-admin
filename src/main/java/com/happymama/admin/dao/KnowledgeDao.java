package com.happymama.admin.dao;

import com.happymama.admin.model.KnowledgeDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yaoqiang on 2018/6/22.
 */
public interface KnowledgeDao {

    @Insert("insert into knowledge(`title`,`content`,`img`, `type`, `created`, `updated`) " +
            "values(#{title},#{content},#{img}, #{type}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as id", keyProperty = "id", before = false, resultType = Integer.class)
    boolean addKnowledge(KnowledgeDO knowledgeDO);

    @Update("update knowledge set count = count +1 where id = #{id}")
    boolean addKnowledgeCount(int id);

    @Select("select * from knowledge  limit #{offset},#{limit}")
    List<KnowledgeDO> getKnowledgeList(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(1) from knowledge")
    long getKnowledgeCount();

    @Delete("delete from knowledge where id = #{id}")
    void deleteKnowledgeById(int id);

    @Select("select * from knowledge  where id = #{id}")
    KnowledgeDO getKnowledgeById(int id);

    @Update({"<script>", "update knowledge set updated = now()",
            "<if test='title != null'> , title = #{title}</if>",
            "<if test='content != null'> , content = #{content}</if>",
            "<if test='img != null'> , img = #{img}</if>",
            " where id = #{id}", "</script>"})
    boolean updateKnowledge(KnowledgeDO knowledgeDO);
}
