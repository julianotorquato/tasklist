 angular.module("listaTarefa").controller("detalhesTarefaCtrl", function ($scope, $routeParams, tarefa) {     
 	$scope.tarefa = tarefa.data;
 });