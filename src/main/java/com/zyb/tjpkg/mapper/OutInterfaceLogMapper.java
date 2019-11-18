package com.zyb.tjpkg.mapper;

import com.zyb.tjpkg.model.OutInterfaceLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;
import java.util.Map;

@Repository
public interface OutInterfaceLogMapper extends MyMapper<OutInterfaceLog> {

    List<OutInterfaceLog> getAll();
    /**
     * 关闭外部接口总开关，获取数据
     *
     * @param interfaceName
     * @param interfaceType
     * @return
     * @Description: TODO
     */
    String getData(@Param("interfaceName") String interfaceName, @Param("interfaceType") String interfaceType);

    List<OutInterfaceLog> qLi(@Param("param") String param, @Param("interfaceType") String interfaceType);

    List<OutInterfaceLog> tjGzt(@Param("st") String st, @Param("et") String et);

    List<String> delErrorStr(@Param("date") String date, @Param("error") String error);

    Integer getInterfacePayUsage(@Param("interfaceName") String interfaceName, @Param("year") Integer year, @Param("month") Integer month);

    Integer getInterfaceTotalUsage(@Param("interfaceName") String interfaceName, @Param("year") Integer year, @Param("month") Integer month);

    List<Map<String, Object>> getAllInterfaceUsageTotalByMonth(@Param("year") Integer year, @Param("month") Integer month);

    List<Map<String, Object>> getAllInterfaceUsagePayByMonth(@Param("year") Integer year, @Param("month") Integer month);

//    OutInterfaceLog qBytransactionId(@Param("transactionId") String transactionId,@Param("interfaceName") String interfaceName, @Param("interfaceType") String interfaceType);
}