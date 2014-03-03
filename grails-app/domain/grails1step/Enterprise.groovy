package grails1step

class Enterprise {

    String name
    String edrpou

    static constraints = {
        name(blank: false)
        edrpou(unique: true, matches: '[0-9]{8}')
    }

    static hasMany = [departments: Department]

    @Override
    String toString() {
        "${name}"
    }
}
