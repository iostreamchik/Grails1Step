package grails1step

class Department {

    String name

    static constraints = {
        name(blank: false, unique: true)
    }

    static belongsTo = [enterprise: Enterprise]

    static hasMany = [persons: Person]

    @Override
    String toString() {
        "${name}"
    }
}
