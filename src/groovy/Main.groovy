import groovy.transform.TypeChecked
import groovy.xml.MarkupBuilder

@TypeChecked
class DefExample {
    def someVariable;

    DefExample(someVariable) {
        this.someVariable = someVariable
    }
}

@TypeChecked
class Test implements Comparable {
    private String name;
    private int digit;

    Test() {
    }

    Test(String name) {
        this.name = name
    }

    Test(String name, int digit) {
        this.name = name
        this.digit = digit
    }

    @Override
    int compareTo(Object o) {
        Test tmp = (Test) o
        return this.name <=> tmp.name
    }
}

class Main {

    public static void main(String[] args) {

        //check class create with uncertain variable
        println "check class create with uncertain variable"
        DefExample example = new DefExample("hello")
        DefExample example2 = new DefExample(34 + 15)
        println example.someVariable;
        println example2.someVariable;
        println("******************")

        //null check
        println "null check"
        Test test;
        List testClassCollection = new ArrayList()
        if (!testClassCollection)
            println "testClassCollection is null or empty"
        for (int i = 0; i < 5; i++) {
            testClassCollection.add(test)
        }
        if (!testClassCollection)
            println "testClassCollection is null or empty"
        else println testClassCollection
        println("******************")

        //GString test and Closer class
        println "GString test"
        println new Date()
        def x = "It is currently ${new Date()}"
        assert x.values[0] instanceof Date
        def y = "It is currently ${writer -> writer << new Date()}"
        assert y.values[0] instanceof Closure
        sleep 1000
        println x
        println y
        println "******************"

        //elvis test
        test = new Test()
        test.digit = 5
        def name = test.name ?: 'test.name is null'
        println name
        test.name = "Elvis"
        name = test.name ?: 'test.name is null'
        println name
        println "******************"

        //Collections test
        println "Collections test"
        List names = new ArrayList()
        for (int i = 0; i < 3; i++) {
            names.add(test.name)
        }
        println names as String

        Set nameCollector = names
        println nameCollector as String
        println "******************"

        //*.
        println "*. && sort && collect && join"
        List elvisCollection = new ArrayList()
        for (int i = 0; i < 3; i++) {
            elvisCollection.add(test)
        }
        println elvisCollection as String

        List elvisCollectionNames = elvisCollection*.name
        println elvisCollectionNames as String

        println "sort"
        def sortNames = elvisCollection.sort() { tmp1, tmp2 -> tmp1.name <=> tmp2.name }
        println sortNames*.name

        println "collect"
        def elvisCollectionElemetsSize = elvisCollection.collect { it.name.size() }
        println elvisCollectionElemetsSize as String


        println "join"
        println elvisCollectionElemetsSize.join(":::::::")

        println "******************"

        println "<=> && =="
        Test tmp1 = new Test("Name1")
        Test tmp2 = new Test("Name2")
        Test tmp3 = new Test("Name1")
        Test tmp4 = new Test("Name0")

        println tmp1 <=> tmp2
        println tmp1 <=> tmp3
        println tmp1 <=> tmp4

        println tmp1 == tmp2
        println tmp1 == tmp3
        println tmp1 == tmp4
        println "******************"

        //List itar
        println "List itar"
        List numbers = ["one", "two", "three", "Four", "five"]
        for (int i in 0..<numbers.size()) {
            println "number $i = ${numbers[i]}"
        }
        println ""
        List sub = numbers[2..3]
        for (int i in 0..<sub.size()) {
            println "number $i = ${sub[i]}"
        }
        numbers[2] = "modified three"
        for (int i in 0..<sub.size()) {
            println "number $i = ${sub[i]}"
        }
        println "******************"

        println "sort"
        numbers.sort() /*{String a, String b -> a.compareTo(b)}*/
        numbers.each { print "$it " }
        println "\n******************"

        println "->"
        int dig = 15;
        GString mes = "$dig is ${-> dig}"
        println mes
        dig = 13
        println mes

        List tmp = [1, 1, 1, 1, 1]
        println tmp.inject(2) { runningTotal, value -> runningTotal + value }
        println "******************"

        println "Files"
        File file = new File("/home/iostream/Documents/test")
        !file ?: file.createNewFile()
        file.write("groovy with files works perfect")
        println file.text
        println "${file.size()} bites"
        file.append(" and fast")
        println file.text
        file.delete()

        println "xml"
        File xmlFile = new File("/home/iostream/Documents/test.xml")
        def myData = [[color: "green", type: "calm"], [color: "red", type: "alert"], [color: "blue"]]
        def builder = new MarkupBuilder(new FileWriter(xmlFile))
        builder.root {
            myData.each { o ->
                color(position: myData.size()) {
                    color(o.color)
                    type(o.type)
                }
            }
        }
        def xml = new XmlSlurper().parse(xmlFile)
        println xml.size()
        println xml.item.findAll()

        xmlFile.delete()
        println "******************"
    }
}
