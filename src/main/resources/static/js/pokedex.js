function carregarPokemonsAjax() {
	//console.log("entrou no ajax de carregarPokemonsAjax");
	
	var total = document.getElementsByClassName("poke-card").length;
	console.log("total pokemons em tela="+total);
	
	var str = "?offset="+total;
	var url = "/carregarPokemonsAjax"+str;
	//console.log("url="+url);
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: url,
		data: "",
		dataType: 'json',
		cache: false,
		timeout: 30000,
		beforeSend: function() { 
			$('#loading').show();
		},
		complete: function() { 
			$('#loading').hide();
		},
		success: function (data) {
			
			//valida tamanho
// 		        	console.log("size "+data.length);
			
// 		        	if(count > data.length){
// 		        		$('#carregarTweets').addClass('disabled');
// 		        	} else {
// 		        		$('#carregarTweets').removeClass('disabled');
// 		        	}
			
			//var lastId = 5;
			var table = [];
			$.each(data, function(i, pokemon) {
				var id = (i+1);
				table.push("<div class='poke-card' id='"+id+"'>");
				table.push("<div class='pokemon "+pokemon.types[0]+"'>");
				table.push("<div class='img-container'>");
				table.push("<img src='"+pokemon.imagemUrl+"'/>");
				table.push("</div>");
				table.push("<div class='info'>");
				table.push("<span class='type'>#"+pokemon.order+"</span>");
				table.push("<h3 class='name'>"+pokemon.nome+"</h3>");
				//tipos
				$.each(pokemon.types, function(i, tipo) {
					table.push("<small class='number "+tipo+"'><span>"+tipo+"</span></small>");
				});
				table.push("</div>");
				table.push("</div>");
				table.push("</div>");
				//lastId = id;
			});
			
			$('#poke-container').html(table.join(""));
			window.location.href="/#"+(total+6); //ancora

		},
		error: function (e) {
			console.log("erro carregarPokemonsAjax : ", e.message);
		}
	});
}