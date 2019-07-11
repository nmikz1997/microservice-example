package com.springjpa.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springjpa.model.LocationServiceModel;
public interface LocationServiceResponsitory extends CrudRepository<LocationServiceModel, Long>{

	// Get list Unit
	@Query(value="SELECT * FROM PROVINCE", nativeQuery=true)
	public List<LocationServiceModel> findAllLocation();

	// Get list Unit by offset and limit
	// :offset
	// :limit
	@Query(value="SELECT * FROM PROVINCE ORDER BY PRE_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<LocationServiceModel> findAllLocationLimitOffset(@Param("offset") int offset,@Param("limit") int limit);
	
	@Query(value="SELECT *, count(*) OVER() AS count FROM PROVINCE WHERE UPPER(PRE_NAME) LIKE UPPER(:preName) ORDER BY PRE_ORDER ASC OFFSET :offset LIMIT :limit", nativeQuery=true)
	public List<LocationServiceModel> findLocationNameLimitOffset(@Param("preName") String preName, @Param("offset") int offset,@Param("limit") int limit);
	
	
}