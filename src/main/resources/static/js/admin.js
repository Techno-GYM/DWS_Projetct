function createActivity() {
	var name = document.getElementById('input_name').value;
	var description = document.getElementById('input_description').value;
	var img = document.getElementById('input_img').value;
	var beginning = document.getElementById('input_h_begin').value;
	var end = document.getElementById('input_h_end').value;
	var item = {name: name, description: description, img: img, beginning: beginning, end:end };	
	
	var client = new XMLHttpRequest();
	client.responseType = "json";
	client.open("POST", "/admin/activities/add");
	client.setRequestHeader("Content-type", "application/json");
	var body = JSON.stringify(item);
	client.send(body);
	location.reload(true);
}


function editActivity() {
	var name = document.getElementById('input_name').value;
	var description = document.getElementById('input_description').value;
	var img = document.getElementById('input_img').value;
	var beginning = document.getElementById('input_h_begin').value;
	var end = document.getElementById('input_h_end').value;
	var id = document.getElementById('id').value;
	var item = {name: name, description: description, img: img, beginning: beginning, end:end };
			
	var client = new XMLHttpRequest();
	client.responseType = "json";
	client.open("PUT", "/admin/activities/"+id+"/edit");
	client.setRequestHeader("Content-type", "application/json");
	var body = JSON.stringify(item);
	client.send(body);
}


function removeActivity(id){
	var client = new XMLHttpRequest();
	client.open("DELETE", "/admin/activities/"+id+"/remove");
	client.send();
	location.reload(true);

}