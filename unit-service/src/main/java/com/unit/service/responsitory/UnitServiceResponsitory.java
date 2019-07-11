package com.unit.service.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unit.service.modal.UnitServiceModal;

public interface UnitServiceResponsitory extends CrudRepository<UnitServiceModal, Integer>{

	// Get list Unit
	@Query(value="SELECT * FROM UNIT", nativeQuery=true)
	public List<UnitServiceModal> findAllUnit();

	// Get list Unit by offset and limit
	// :offset
	// :limit
	@Query(value="SELECT * FROM UNIT ORDER BY UNT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<UnitServiceModal> findAllUnitLimitOffset(@Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) ORDER BY UNT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<UnitServiceModal> findUnitByNameLimitOffset(@Param("untName") String untName , @Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND PRE_ID = :preId ORDER BY UNT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<UnitServiceModal> findUnitByPreIdAndName(@Param("untName") String untName, @Param("preId") int preId, @Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND DIT_ID = :ditId ORDER BY UNT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<UnitServiceModal> findUnitByDitIdAndName(@Param("untName") String untName, @Param("ditId") int ditId, @Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND WAD_ID = :wadId ORDER BY UNT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<UnitServiceModal> findUnitByWadIdAndName(@Param("untName") String untName, @Param("wadId") int wadId, @Param("offset") int offset,@Param("limit") int limit);
	
	//count of record
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName)", nativeQuery=true)
	public List<UnitServiceModal> countUnitByName(@Param("untName") String untName);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND PRE_ID = :preId", nativeQuery=true)
	public List<UnitServiceModal> countUnitByPreIdAndName(@Param("untName") String untName, @Param("preId") int preId);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND DIT_ID = :ditId", nativeQuery=true)
	public List<UnitServiceModal> countUnitByDitIdAndName(@Param("untName") String untName, @Param("ditId") int ditId);
	
	@Query(value="SELECT * FROM UNIT WHERE UPPER(UNT_NAME) LIKE UPPER(:untName) AND WAD_ID = :wadId", nativeQuery=true)
	public List<UnitServiceModal> countUnitByWadIdAndName(@Param("untName") String untName, @Param("wadId") int wadId);
}
