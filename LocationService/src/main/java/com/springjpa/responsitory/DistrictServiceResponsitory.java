package com.springjpa.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springjpa.model.DistrictServiceModel;
public interface DistrictServiceResponsitory extends CrudRepository<DistrictServiceModel, Long>{

	// Get list Unit
	@Query(value="SELECT * FROM DISTRICT", nativeQuery=true)
	public List<DistrictServiceModel> findAlldistrict();

	// Get list Unit by offset and limit
	// :offset
	// :limit
	//@Query(value="SELECT * FROM DISTRICT WHERE PRE_ID = :pre_id AND UPPER(DIT_NAME) LIKE UPPER(:dit_name) ORDER BY DIT_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	//public List<DistrictServiceModel> findAlldistrictLimitOffset(@Param("pre_id") long pre_id, @Param("dit_name") String dit_name, @Param("offset") int offset, @Param("limit") int limit);
	
	@Query(value="SELECT * FROM DISTRICT WHERE PRE_ID = :pre_id AND UPPER(DIT_NAME) LIKE UPPER(:dit_name)", nativeQuery=true)
	public List<DistrictServiceModel> countDistrictByNameAndPreId(@Param("pre_id") long pre_id, @Param("dit_name") String dit_name);

	
}