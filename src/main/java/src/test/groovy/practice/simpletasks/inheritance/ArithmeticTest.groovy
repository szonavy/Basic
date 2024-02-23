package practice.simpletasks.inheritance

import spock.lang.Specification

class ArithmeticTest extends Specification{
    

    def 'Arithmetic add'(){
        setup:
            def arithmetic = new Arithmetic()
        when:
            def result = arithmetic.add(1,2)
        then:
            assert result == expected
        where:
            expected = 3
    }
}
