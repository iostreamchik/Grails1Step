package grails1step

class Department {

    String name

    static constraints = {
        name(blank: false, unique: true)
    }

    static hasMany = [persons: Person]
    static belongsTo = [Person]
}
