package practice.complextask.camps_10

import spock.lang.Specification

class CampManagerTest extends Specification{
    def 'fileProcessing'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.fileProcessing(list)
        then:
            assert result == expected
        where:
            list                                    | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
                 "7\t14\t7\t21\tFPUY\tszinjatszo"] | [new CampDetails(new CampDate(6,26),new CampDate(7,10),"GIOSY","foci")]
    }

    def 'countTheDetails'(){
            setup:
                def manager = new CampManager(list)
            when:
                def result = manager.countTheDetails()
            then:
                assert result == expected
            where:
                list                           | expected
            ["6\t26\t7\t10\tGIOSY\tfoci",
             "7\t14\t7\t21\tFPUY\tszinjatszo"] | 2
    }
    def 'getTheFirstProgram'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.getTheFirstProgram()
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | "foci"
    }
    def 'getTheLastProgram'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.getTheLastProgram()
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | "szinjatszo"
    }
    // because of the equals
    def 'getTheStartDatesOfTheMusicCamp'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.getTheStartDatesOfTheMusicCamp("szinjatszo")
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | [new CampDate(7,14)]
    }
    def 'getTheNumberOfMostInterestedProgram'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.getTheNumberOfMostInterestedProgram()
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | 5
    }

    //because of the equals
    def 'getTheDetailsOfTheMostInterestedProgram'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.getTheDetailsOfTheMostInterestedProgram()
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | [new CampDetails(new CampDate(6,26), new CampDate(7,10),"GIOSY","foci")]
    }
    def 'countTheCampsByTime'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.countTheCampsByTime(7,1)
        then:
            assert result == expected
        where:
            list                           | expected
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | 1
    }
    def 'studentInterests'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.studentInterests(student)
        then:
            assert result == expected
        where:
            list                           | expected                                                                         | student
            ["6\t26\t7\t10\tGIOSY\tfoci",
            "7\t14\t7\t21\tFPUY\tszinjatszo"] | [new CampDetails(new CampDate(7,14), new CampDate(7,21),"FPUY","szinjatszo")] | 'Y'
    }
    def 'participation'(){
        setup:
            def manager = new CampManager(list)
        when:
            def result = manager.participation(student)
        then:
            assert result == expected
        where:
            list                           | expected                             | student
        ["6\t26\t7\t10\tGIOSY\tfoci",
         "7\t14\t7\t21\tFPUY\tszinjatszo"] | "The student can go every camp." | 'Y'
    }

}
