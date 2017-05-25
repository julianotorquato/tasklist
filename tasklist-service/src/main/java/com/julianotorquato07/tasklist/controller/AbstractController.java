package com.julianotorquato07.tasklist.controller;

import javax.inject.Inject;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

public class AbstractController {

    @Inject protected  Result result;
    
    protected void toJson(Object objeto)throws Exception{
        result.use(Results.json()).withoutRoot().from(objeto).serialize();
    }
    
}
