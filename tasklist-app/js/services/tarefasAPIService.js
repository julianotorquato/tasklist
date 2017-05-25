 angular.module("listaTarefa").factory("tarefasAPI", function ($http, config) { 

	var _excluirTarefa = function (id){
		 return $http({
		 	method: 'DELETE',
		 	url: config.baseUrl + "/tasklist/"+id,		 	
		 	headers: {
		 		'Content-Type': 'application/json;',
		 	}			
		 });
	}

 	var _getTarefas = function () {
 		return $http.get(config.baseUrl + "/tasklist/list");
 	};

 	var _getTarefa = function (id) {
 		return $http.get(config.baseUrl + "/tasklist/" + id);
 	};

 	var _saveTarefa = function (tarefa) {
 		console.log("Passou aqui");
 		console.log(tarefa);
 		return $http.post(config.baseUrl + "/tasklist/save", tarefa);

		// return $http({
		// 	method: 'POST',
		// 	url: config.baseUrl + "/tasklist/save",
		// 	data:  JSON.stringify(tarefa) ,
		// 	headers: {
		// 		'Content-Type': 'application/json;',
		// 		'accept': 'application/json'

		// 	}
			
		// });
 	};




 	return {
 		getTarefas: _getTarefas,
 		getTarefa: _getTarefa,
 		saveTarefa: _saveTarefa,
		excluirTarefa: _excluirTarefa
 	};
 });