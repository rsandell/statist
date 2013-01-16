class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: "status", action: "status")
		"500"(view:'/error')
        "/status"(controller: "status", action: "status")
	}
}
