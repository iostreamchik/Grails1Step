package grails1step

class Person {
    String name
    float salary
    Date hireDate
    Date dismissDate

    static constraints = {
        name(size: 2..20, matches: '\\w*')
        salary(blank: false)
        hireDate(blank: false)
        dismissDate(blank: true, nullable: true)
    }

    static hasMany = [departments: Department]
    static belongsTo = [Department]

    @Override
    String toString() {
        "${name}"
    }
}