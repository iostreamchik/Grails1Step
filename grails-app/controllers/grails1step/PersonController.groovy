package grails1step

class PersonController {
    def scaffold = true

    def search = {
    }

    def result = {
        def person = Person.findAllByNameLike(params.name)
        return [persons: person, term: params.name]
    }

}
