angular.module("listaTarefa").config(function ($routeProvider) {
	$routeProvider.when("/tarefas", {
		templateUrl: "view/tarefas.html",
		controller: "listaTarefaCtrl",
		resolve: {
			tarefas: function (tarefasAPI) {
				return tarefasAPI.getTarefas();
			}
		}
	});
	$routeProvider.when("/novaTarefa", {
		templateUrl: "view/novaTarefa.html",
		controller: "novaTarefaCtrl"		
	});
	 $routeProvider.when("/detalhesTarefa/:id", {
	 	templateUrl: "view/detalhesTarefa.html",
	 	controller: "detalhesTarefaCtrl",
	 	resolve: {
	 		tarefa: function (tarefasAPI, $route) {
	 			return tarefasAPI.getTarefa($route.current.params.id);
	 		}
	 	}
	 });
	$routeProvider.when("/error", {
		templateUrl: "view/error.html"
	});
	$routeProvider.otherwise({redirectTo: "/tarefas"});
});