package grails1step
import grails.test.GrailsUnitTestCase
/**
 *
 */
class EnterpriseSpec extends GrailsUnitTestCase {
    private final static String NAME
    private final static String EDRPOU

    static {
        NAME = 'Microsoft'
        EDRPOU = '02345678'
    }

    void testValidationAndSave() {
        def enterprise = new Enterprise(name: NAME, edrpou: EDRPOU)
        assertTrue enterprise.validate()
        assertNotNull enterprise.save()
    }

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
