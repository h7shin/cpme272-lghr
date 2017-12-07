package service.processor;

import common.JsonHelper;
import db.*;

/***
 *Created by Lin Cheng
 */
public class DeleteProcessor extends UrlProcessor {
    @Override
    String handle() throws Exception {

        BaseDao dao;

        switch (paramMap.get("type")){
            case "product":
                dao = new ProductImpl();
                dao.deleteById(paramMap.get("id"));
                return JsonHelper.toJson("true");
            case "order":
                dao = new OrderImpl();
                dao.deleteById(paramMap.get("id"));
                return JsonHelper.toJson("true");
            default:
                return JsonHelper.toJson("Not supported.");
        }
    }
}
