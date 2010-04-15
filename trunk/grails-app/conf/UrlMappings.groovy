class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
              "/"(view:"/user_main")
        	  "500"(view:'/error')
        	
//"/"{
  //          controller="level"
   //         action="list"
       // }
    }
}