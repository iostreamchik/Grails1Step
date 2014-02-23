package grails1step

class Person {
    String name
    float salary
    Date hireDate
    Date dismissDate

    static constraints = {
        name(size: 2..20,matches: '/^[a-z\' -]$/i')
        salary(blank: false)
        hireDate(blank: false)
    }

    static hasMany = [departments: Department]
}