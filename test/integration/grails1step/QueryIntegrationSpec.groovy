package grails1step
import grails.test.GrailsUnitTestCase
/**
 *
 */
class QueryIntegrationSpec extends GrailsUnitTestCase {

    void testBasicDynamicFinders() {
        Calendar cal = Calendar.getInstance();
        new Person(name: 'John', salary: 15000, hireDate: cal.getTime()).save()
        new Person(name: 'Ozzy', salary: 12000, hireDate: cal.getTime()).save()

        def person = Person.findByName('Ozzy')
        assertEquals 'Ozzy', person.name

        person = Person.findBySalary(15000)
        assertEquals 15000, person.salary

    }

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
