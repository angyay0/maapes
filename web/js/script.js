$(document).on('ready',function() {

	function indexToName(){
		$('.buscar').css('display','block');
		var id = $('#ciudadBuscar').val();
		$.ajax({
			type : 'POST',
			url: './solicitarRegistroGenteCiudades.do',
			data: {
				'ciudadBuscar' : ""
			}, success: function (data){
				var ciu = JSON.parse(data);
				for(x in ciu){
					if(id == ciu[x].idCiudad) $('#ciudadBuscar').val(ciu[x].ciudad);
					if(x == 0) $("#estadoNombre").append("<strong>"+ciu[x].estado+"</strong>");
					$("#idCiudad").append("<option value=\""+ciu[x].idCiudad+"\" data-estado=\""+ciu[x].estado+"\" >"+
						ciu[x].ciudad+"</option>");
				}
			}, error: function (e){
				console.log(e);
			}
		});
	}

	$("#idCiudad").change(function (){
		$("#estadoNombre").empty();
		$("#estadoNombre").append("<strong>"+$("#idCiudad option:selected").data("estado")+"</strong>");
	});

	$('#ciudadBuscar').keyup(function() {
		$('.buscar').css('display','block');
		var busqueda = $('#ciudadBuscar').val();
		$.ajax({
			type : 'POST',
			url: './solicitarRegistroGenteCiudades.do',
			data: {
				'ciudadBuscar' : busqueda
			}, success: function (data){
				//console.log(JSON.parse(data));
				var ciu = JSON.parse(data);
				$("#idCiudad").empty();
				$("#estadoNombre").empty();
				for(x in ciu){
					//console.log(ciu[x]);
					if(x == 0) $("#estadoNombre").append("<strong>"+ciu[x].estado+"</strong>");
					$("#idCiudad").append("<option value=\""+ciu[x].idCiudad+"\" data-estado=\""+ciu[x].estado+"\" >"+
						ciu[x].ciudad+"</option>");
				}
			}, error: function (e){
				console.log(e);
			}
		});
	});

	var valorNombres = 0;
	$('#nombres').on('click', function () {
		$.ajax({
			type : 'POST',
			url: './procesarListadoGenteOrd.do',
			data: {
				'ordenar' : 'nombres',
				'tipo' : valorNombres
			}, success: function (data){
				var markup = "";
				$("#tablecontent tbody").empty();
				var gen = JSON.parse(data);
				for(x in gen){
					console.log("aaa"+x);
					markup += "<tr class='tr'>";
					for(var elem in gen[x]){
						//console.log(gen[x]);
						markup += "<td class='td' align='left' style='width:16%'>"+gen[x][elem]+"</td>";
					}
					markup += "</tr>"
				}
				
				$("#tablecontent tbody").append(markup);
				valorNombres = (valorNombres == 0 ? 1 : 0);
				//console.log(elem);
			}, error: function (e){
				console.log(e);
			}
		});
	});
	
	var valorApellidos = 0;
	$('#apellidos').on('click', function () {
		$.ajax({
			type : 'POST',
			url: './procesarListadoGenteOrd.do',
			data: {
				'ordenar' : 'apellidos',
				'tipo' : valorApellidos
			}, success: function (data){
				var markup = "";
				$("#tablecontent tbody").empty();
				var gen = JSON.parse(data);
				for(x in gen){
					console.log("aaa"+x);
					markup += "<tr class='tr'>";
					for(var elem in gen[x]){
						markup += "<td class='td' align='left' style='width:16%'>"+gen[x][elem]+"</td>";
					}
					markup += "</tr>"
				}
				
				$("#tablecontent tbody").append(markup);
				valorApellidos = (valorApellidos == 0 ? 1 : 0);
			}, error: function (e){
				console.log(e);
			}
		});
	});
	
	var valorDireccion = 0;
	$('#direccion').on('click', function () {
		$.ajax({
			type : 'POST',
			url: './procesarListadoGenteOrd.do',
			data: {
				'ordenar' : 'direccion',
				'tipo' : valorDireccion
			}, success: function (data){
				var markup = "";
				$("#tablecontent tbody").empty();
				var gen = JSON.parse(data);
				for(x in gen){
					console.log("aaa"+x);
					markup += "<tr class='tr'>";
					for(var elem in gen[x]){
						markup += "<td class='td' align='left' style='width:16%'>"+gen[x][elem]+"</td>";
					}
					markup += "</tr>"
				}
				
				$("#tablecontent tbody").append(markup);
				valorDireccion = (valorDireccion == 0 ? 1 : 0);
			}, error: function (e){
				console.log(e);
			}
		});
	});
	
	var valorTelefono = 0;
	$('#telefono').on('click', function () {
		$.ajax({
			type : 'POST',
			url: './procesarListadoGenteOrd.do',
			data: {
				'ordenar' : 'telefono',
				'tipo' : valorTelefono
			}, success: function (data){
				var markup = "";
				$("#tablecontent tbody").empty();
				var gen = JSON.parse(data);
				for(x in gen){
					console.log("aaa"+x);
					markup += "<tr class='tr'>";
					for(var elem in gen[x]){
						markup += "<td class='td' align='left' style='width:16%'>"+gen[x][elem]+"</td>";
					}
					markup += "</tr>"
				}
				
				$("#tablecontent tbody").append(markup);
				valorTelefono = (valorTelefono == 0 ? 1 : 0);
			}, error: function (e){
				console.log(e);
			}
		});
	});
	
	var valorCiudad = 0;
	$('#ciudad').on('click', function () {
		$.ajax({
			type : 'POST',
			url: './procesarListadoGenteOrd.do',
			data: {
				'ordenar' : 'ciudad',
				'tipo' : valorCiudad
			}, success: function (data){
				var markup = "";
				$("#tablecontent tbody").empty();
				var gen = JSON.parse(data);
				for(x in gen){
					console.log("aaa"+x);
					markup += "<tr class='tr'>";
					for(var elem in gen[x]){
						markup += "<td class='td' align='left' style='width:16%'>"+gen[x][elem]+"</td>";
					}
					markup += "</tr>"
				}
				
				$("#tablecontent tbody").append(markup);
				valorCiudad = (valorCiudad == 0 ? 1 : 0);
			}, error: function (e){
				console.log(e);
			}
		});
	});	

	indexToName();
});

function seleccionarCiudad(id, ciudad, estado) {
	$('.buscar').css('display','none');
	$("#idCiudad").val(id);
	$("#ciudadBuscar").val(ciudad);
	$("#estadoNombre").html(estado);
}