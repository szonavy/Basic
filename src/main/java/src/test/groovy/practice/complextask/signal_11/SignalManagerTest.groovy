package practice.complextask.signal_11

import spock.lang.Specification

class SignalManagerTest extends Specification{
    //5 42 42 76 692
    //5 47 42 71 699
    def 'getTheCoordinates'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheCoordinates(id)
        then:
            assert result == expected
        where:
            list                            | expected | id
        ["5 42 42 76 692","5 47 42 71 699"] | [76,692] | 1
    }
    def 'getDifferenceFirstAndLeastMeasuredDetails'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getDifferenceFirstAndLeastMeasuredDetails()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | "0:5:0"
    }
    def 'getTheSmallestX'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheSmallestX()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | 71
    }
    def 'getTheSmallestY'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheSmallestY()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | 692
    }
    def 'getTheLargestX'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheLargestX()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | 76
    }
    def 'getTheLargestY'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheLargestY()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | 699
    }
    def 'getTheDistance'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheDistance()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 47 42 71 699"] | 8.602325267042627
    }
    def 'getTheReasonOfTheMissingSignal'(){
        setup:
            SignalManager manager = new SignalManager(list)
        when:
            def result = manager.getTheReasonOfTheMissingSignal()
        then:
            assert result == expected
        where:
            list                            | expected
        ["5 42 42 76 692","5 48 42 71 699"] | [new SignalMessage(5,48,42,"time",1)]
        ["5 42 42 76 692","6 48 42 71 699"] | [new SignalMessage(5,48,42,"time",13)]
        ["5 42 42 76 692","6 48 42 171 1699"]| [new SignalMessage(5,48,42,"coordinates",101)]
    }

}
