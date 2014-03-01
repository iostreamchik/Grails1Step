package grails1step
import grails.test.GrailsUnitTestCase

class PersonSpec extends GrailsUnitTestCase {

    void testPersonValidation() {
        Calendar cal = Calendar.getInstance();
        Person person = new Person(name: 'John',salary: 12000.05, hireDate: cal.getTime())
        assertTrue person.validate()
        assertEquals person, person.save()
    }

    def setup() {
    }

    def cleanup() {
    }

}
