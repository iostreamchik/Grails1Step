package grails1step
import grails.test.GrailsUnitTestCase
/**
 *
 */
class DepartmentSpec extends GrailsUnitTestCase {

    void createDepartment() {
        def department = new Department(name: 'supply')
        department.save()
        assertTrue department.validate()
        assertNotNull department.save()
    }

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
