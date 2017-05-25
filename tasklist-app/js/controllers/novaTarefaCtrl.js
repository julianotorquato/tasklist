angular.module("listaTarefa").controller("novaTarefaCtrl", function ($scope, tarefasAPI, $location) {
	
	$scope.adicionarTarefa = function (tarefa) {		
		tarefasAPI.saveTarefa(tarefa).success(function (data) {
			delete $scope.tarefa;
			$scope.tarefaForm.$setPristine();
			$location.path("/save");
		});
	};
});