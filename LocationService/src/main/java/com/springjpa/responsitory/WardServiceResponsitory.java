package com.springjpa.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springjpa.model.WardServiceModel;
public interface WardServiceResponsitory extends CrudRepository<WardServiceModel, Long>{

	// Get list Unit
	@Query(value="SELECT * FROM ward", nativeQuery=true)
	public List<WardServiceModel> findAllward();

	// Get list Unit by offset and limit
	// :offset
	// :limit
	@Query(value="SELECT * FROM ward WHERE DIT_ID = :dit_id AND UPPER(WAD_NAME) LIKE UPPER(:wad_name) ORDER BY WAD_ORDER ASC", nativeQuery=true)
	public List<WardServiceModel> findAllwardLimitOffset(@Param("dit_id") long dit_id, @Param("wad_name") String wad_name);
	
}