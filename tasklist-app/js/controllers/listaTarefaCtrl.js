angular.module("listaTarefa").controller("listaTarefaCtrl", function ($scope, tarefas, $filter) {
	$scope.app = $filter('upper')("Lista Tarefas");
	//$scope.app = $filter('upper')("Lista Tarefas");
	$scope.tarefas = tarefas.data;

	$scope.adicionarTarefa = function (tarefa) {
		tarefasAPI.saveTarefa(tarefa).success(function (data) {
		 	delete $scope.tarefa;
		 	$scope.tarefaForm.$setPristine();
		 	carregarTarefas();
		 });
	};
	$scope.apagarTarefas = function (tarefas) {
		$scope.tarefas = tarefas.filter(function (tarefa) {
			if (!tarefa.selecionado) return tarefa;
		});
		$scope.verificarTarefaSelecionada($scope.tarefas);
	};
	$scope.verificarTarefaSelecionada = function (tarefas) {
		$scope.hasTarefaSelecionada = tarefas.some(function (tarefa) {
			return tarefa.selecionado;
		});
	};
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
});