function updateVideoInfo(){	
var json={"video_img":"video_img_src","video_url":"video_url","video_title"},

data = eval("("+data+")");
for (var one in json) 
{ 
	$('#index_img_'+i+'').attr("src","page_url"+n.video_img+"");
	$("#index_img_url"+i+'').attr("href",n.video_url);
	$('#index_title'+i+'').text(n.video_title);
	$('#index_content'+i+'').text(n.video_content); 
}
}


//ajax获取json并遍历
$.ajax({ 
	url: root+"getsafechild", 
	type:"POST", 
	data:{parentid:datatype}, 
	success: function(data){
			var childhtml = '<ul><li class="current" data-type="">不限</li>';
			data = eval("("+data+")");
			for(var o in data){
			data[o]['parentid'];
			childhtml += '<li data-type="1356_'+data[o]['catid']+'_'+data[o]['safetype_id']+'">'+data[o]['safetype_name']+'</li>';
															}
			childhtml += '</ul>';
			$('#pos_yh').html(childhtml);
			serachSwipe("#sw_slide", "#sw_slide_list",getArr);
}});