package practice.complextask.minelake_12.controller

import practice.complextask.minelake_12.model.DeepestPartCoordinates
import practice.complextask.minelake_12.model.LakeDiagram
import practice.complextask.minelake_12.model.MineLakeData
import spock.lang.Specification

class MineLakeControllerTest extends Specification {

    def 'getTheRequestedValue'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.getTheRequestedValue(row, column)
        then:
        assert result == expected
        where:
        list                | row | column | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 3   | 4      | 18
    }

    def 'getTheArea'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.getTheArea()
        then:
        assert result == expected
        where:
        list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 19
    }

    def 'getTheDepth'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.getTheDepth()
        then:
        assert result == expected
        where:
        list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 848.0
    }

    def 'getTheDeepestPoint'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.getTheDeepestPoint()
        then:
        assert result == expected
        where:
        list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 75
    }
    //because of hash , I've generated hashCode
    def 'getTheDeepestPartsCoordinates'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.getTheDeepestPartsCoordinates()
        then:
        assert result == expected
        where:
        list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | [new DeepestPartCoordinates(2, 2), new DeepestPartCoordinates(3, 5), new DeepestPartCoordinates(5, 2)]
    }

    def 'getLakeLine'() {
        setup:
            MineLakeController controller = new MineLakeController(list)
        when:
            def result = controller.getLakeLine(new MineLakeData(2, 2, 75, true))
        then:
            assert result == expected
        where:
            list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 2
    }
    def 'countTheSizeOfLake'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.countTheSizeOfLake()
        then:
        assert result == expected
        where:
        list                | expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 64 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 26
    }
    
    def 'makeTheDiagram'() {
        setup:
        MineLakeController controller = new MineLakeController(list)
        when:
        def result = controller.makeTheDiagram(column)
        then:
        assert result == expected
        where:
        list                | column |expected
        ["0 0 0 0 0 0 0 0 ",
         "0 75 4 53 61 25 0",
         "0 2 0 18 75 58 64 0",
         "0 0 0 34 74 73 67 0",
         "0 75 3 15 2 10 0 0",
         "0 0 0 0 0 0 0 0"] | 3 | [new LakeDiagram("01",""),new LakeDiagram("02","****"),new LakeDiagram("03",""),new LakeDiagram("04",""),new LakeDiagram("05","***"),new LakeDiagram("06","")]
    }
}