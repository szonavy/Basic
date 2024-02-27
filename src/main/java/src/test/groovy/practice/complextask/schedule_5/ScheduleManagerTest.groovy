package practice.complextask.schedule_5

import spock.lang.Specification

class ScheduleManagerTest extends Specification {

    def 'fileHandling'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.fileHandling(list)
        then:
        assert result == expected
        where:
        list                                | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE"] | [new TrainDetails(1, 0, 5, 45, "I"), new TrainDetails(1, 1, 6, 0, "E")]
    }

    def 'numberOfStations'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.numberOfStations()
        then:
        assert result == expected
        where:
        list                                | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE"] | 2
    }

    def 'numberOfTrains'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.numberOfTrains()
        then:
        assert result == expected
        where:
        list                                | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE"] | 1
    }

    def 'convertToMin'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.convertToMin(trainHr, trainMin)
        then:
        assert result == expected
        where:
        list                                | trainHr | trainMin | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE"] | 12      | 50       | 770
    }
    //not the same due to hash
    def 'theMostWaitTimeTrain'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.theMostWaitTimeTrain()
        then:
        assert result == expected
        where:
        list                                                  | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | [new TrainDetails(1, 1, 6, 0, "E"): 50]
    }

    def 'lastTimeOfTheRequestedTrain'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.lastTimeOfTheRequestedTrain(trainNr)
        then:
        assert result == expected
        where:
        list                                                  | trainNr | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | 1       | 410
    }

    def 'findTheStartOfTrain'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.findTheStartOfTrain(trainNr)
        then:
        assert result == expected
        where:
        list                                                  | trainNr | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | 1       | 345
    }
    //"the in the manager class
    def 'tellTheScheduleStatus'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.tellTheScheduleStatus(1, 6, 0)
        then:
        assert result == expected
        where:
        list                                                  | trainNr | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | 1       | "he journey of train number 1 was 295 minutes shorter than prescribed."
    }
    //??
    def 'scheduleOfTheArrivalTimeByTrain'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.scheduleOfTheArrivalTimeByTrain(trainNr)
        then:
        assert result == expected
        where:
        list                                                  | trainNr | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | 1       | ["1.station: 6:0"]
    }
    // hoan kell voidot tesztelni?
    def 'whereIsTheTrain'() {
        setup:
        def manager = new TrainManager(list)
        when:
        def result = manager.whereIsTheTrain()
        then:
        assert result == expected
        where:
        list                                                  | trainHr | trainMin | expected
        ["1\t0\t5\t45\tI", "1\t1\t6\t0\tE", "1\t1\t6\t50\tI"] | 6       | 40       | 2
    }


}
