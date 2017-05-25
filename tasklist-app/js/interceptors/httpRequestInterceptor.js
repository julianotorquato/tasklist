angular.module("listaTarefa").factory('httpRequestInterceptor', function () {
  return {
    request: function (config) {
      config.headers['Accept'] = 'application/json;odata=verbose';
      return config;
    }
  };
});
