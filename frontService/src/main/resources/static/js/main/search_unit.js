function XuLyLoadUnit(untName, preId, ditId, wadId, offset, limit){
	//xu ly
	var formData = {
			offset: offset,
			limit: limit,
			untName: untName,
			preId: preId,
			ditId: ditId,
			wadId: wadId
		};
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8111/danh-muc-dung-chung/units/search",
			data : JSON.stringify(formData),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);	
				var jsonMain = data;
				var metadata = jsonMain.metadata;
				var results = jsonMain.results;
				var total_record = metadata.resultset.count;
				console.log("total_recored:"+total_record);
				$(".row-phan-trang .ul-pagination").empty();
			// Khong co du lieu tinh thanh => ko show bang du lieu, thong bao du lieu rong
			if(total_record <= 0){
				$(".row-thong-bao-ket-qua h6").html("Không có dữ liệu kết quả");
			// Co du lieu tinh thanh => show du lieu vao bang.
		}else{
			$(".row-thong-bao-ket-qua h6").html(total_record + " kết quả");
			var table = "<table class='table table-bordered table-sm'>"+
			"<thead class='table-primary'>"+
				"<tr class=''>"+
					"<th class=''>STT</th>"+
					"<th>Mã</th>"+
					"<th>Tên</th>"+
					"<th>Mô tả</th>"+
					"<th>Địa chỉ</th>"+
					"<th>Điện thoại</th>"+
					"<th>Website</th>"+
					"</tr>"+
			"</thead>"+
				"<tbody></tbody>"+
			"</table>";

			$(".row-hien-thi-ket-qua .table-responsive").append(table);

			var results_length = results.length;
			for(var results_i = 0 ; results_i < results.length; results_i++){
				
				var describe = results[results_i].unt_describe == null ? " " : results[results_i].unt_describe;
				var address = results[results_i].unt_address == null ? " " : results[results_i].unt_address;
				var phone = results[results_i].unt_phone == null ? " " : results[results_i].unt_phone;
				var website = results[results_i].unt_website == null ? " " : results[results_i].unt_website;
				
				var rowData = "<tr>"+
				"<th class='text-center'>"+ (results_i + 1)+"</th>"+
				"<td>"+results[results_i].unt_id+"</td>"+
				"<td>"+results[results_i].unt_name+"</td>"+
				"<td>"+describe+"</td>"+
				"<td>"+address+"</td>"+
				"<td>"+phone+"</td>"+
				"<td><a href='"+website+"' target='_blank'>"+website+"</a></td>"+
				"</tr>";
				$(".row-hien-thi-ket-qua  table>tbody").append(rowData);  
			}


			if(total_record > 0){
            		// Tinh toan so trang
            		var total_page = 0;
            		if((total_record % limit) == 0){
            			total_page = total_record / limit;
            		}else{
            			total_page = (total_record / limit) + 1;
            		}

                	// Xu ly tao phan trang
                	for(var i = 1; i <= total_page; i++){
                		var data = "";
                		if(i == 1){
                			data = "<li class='page-item active' data-id="+i+"><a class='page-link'>" + i + "</a></li>";
                		}else{
                			data = "<li class='page-item' data-id="+i+"><a class='page-link'>" + i + "</a></li>";
                		}
                		
                		$(".row-phan-trang .ul-pagination").append(data);
                	}
                	
                	// Xu ly click phan trang
                	$('.row-phan-trang .ul-pagination li').click(function() {
                		$('.row-phan-trang .ul-pagination li').removeClass('active');
                		var cur_page = $(this).attr('data-id');
                		$(this).addClass("active");
                		var offset = ((cur_page - 1 ) * limit );
                		//getPageDataTinhThanh(ten_tinh_thanh, offset, limit);
                		getPageDataUnit(untName,preId,ditId,wadId,offset,limit);//(untName, preId, ditId, wadId, offset, limit)
                	});
                }

            }
        },
        error : function(e) {
        	console.log("ERROR: ", e);
        }
    });
}

function getPageDataUnit(untName, preId, ditId, wadId, offset, limit){
	var formData = {
			offset: offset,
			limit: limit,
			untName: untName,
			preId: preId,
			ditId: ditId,
			wadId: wadId
		};
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8111/danh-muc-dung-chung/units/search",
			data : JSON.stringify(formData),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);	
				var jsonMain = data;
				var metadata = jsonMain.metadata;
				var results = jsonMain.results;
				var total_record = metadata.resultset.count;
				if(total_record <= 0){
			// Co du lieu tinh thanh => show du lieu vao bang.
		}else{
			$(".row-hien-thi-ket-qua  table>tbody").empty();
			var results_length = results.length;
			for(var results_i = 0 ; results_i < results.length; results_i++){
				
				var describe = results[results_i].unt_describe == null ? " " : results[results_i].unt_describe;
				var address = results[results_i].unt_address == null ? " " : results[results_i].unt_describe;
				var phone = results[results_i].unt_phone == null ? " " : results[results_i].unt_describe;
				var website = results[results_i].unt_website == null ? " " : results[results_i].unt_describe;
				
				var rowData = "<tr>"+
				"<th class='text-center'>"+ (results_i + 1)+"</th>"+
				"<td>"+results[results_i].unt_id+"</td>"+
				"<td>"+results[results_i].unt_name+"</td>"+
				"<td>"+describe+"</td>"+
				"<td>"+address+"</td>"+
				"<td>"+phone+"</td>"+
				"<td>"+website+"</td>"+
				"</tr>";
				$(".row-hien-thi-ket-qua  table>tbody").append(rowData);  
			}
		}
	},
	error : function(e) {
		console.log("ERROR: ", e);
	}
});
	}