package practice.complextask.receptionhr_4

import spock.lang.Specification

class ReceptionManagerTest extends Specification{
    ReceptionManager manager = new ReceptionManager(["Csorba Ede 16:30 2017.10.28-18:48"])

    def 'ReceptionManager fillTheDetails'(){
        setup:
            def row = ["Csorba Ede 16:30 2017.10.28-18:48"]
        when:
            def controller = new ReceptionManager(row)
        then:
            assert controller.details.size() == 1
            assert controller.details.get(0).firstName.equals("Ede")
            assert controller.details.get(0).lastName.equals("Csorba")
            assert controller.details.get(0).receptionHr == 16
            assert controller.details.get(0).receptionMin == 30
            assert controller.details.get(0).parents.year == 2017
            assert controller.details.get(0).parents.month == 10
            assert controller.details.get(0).parents.day == 28
            assert controller.details.get(0).parents.hr == 18
            assert controller.details.get(0).parents.min == 48
            assert controller.details.get(0).parents.equals(new BookingDetails(2017,10,28,18,48))
    }
    def 'numberOfBookingRecords'(){
        setup:
            def list1 = ["Csorba Ede 16:30 2017.10.28-18:48"]
            def list2 = ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
                             "Csorba Ede 16:40 2017.10.28-19:56"]
            def expected1 = 1
            def expected2 = 2
        when:
            def result1 = new ReceptionManager(list1).numberOfBookingRecords()
            def result2 = new ReceptionManager(list2).numberOfBookingRecords()
        then:
            assert result1 == expected1
            assert result2 == expected2
    }
    def 'cutTheTime'(){
        setup:
            def time = "18:48"
            def expected = [18,48]
        when:
            def result = manager.cutTheTime(time)
        then:
            assert result == expected
    }
    def 'teachersSameAppointments'(){
        setup:
            def controller = new ReceptionManager(list)
        when:
            def result = controller.teachersSameAppointments(requestedHr,requestedMin)
        then:
            assert result == expected
        where:
            list                                    | expected                          | requestedHr   | requestedMin
        ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
         "Csorba Ede 16:40 2017.10.28-19:56"]       | ["Fodor Zsuzsanna"]               | 16            | 50
        ["Fodor Zsuzsanna 18:51 2017.10.28-18:51",
         "Csorba Ede 18:51 2017.10.28-18:51"]       | ["Fodor Zsuzsanna", "Csorba Ede"] | 18            | 51
    }
    //???
    def 'createTheAppointments'(){

        setup:
            def controller = new ReceptionManager(list)
            def rows = [new TeacherDetails('Fodor','Zsuzsanna',16,50, new BookingDetails(2017,10,28,18,51)),]
                                            new TeacherDetails('Csorba','Ede',16,40,new BookingDetails(2017,10,27,19,56))
        when:
            def result = controller.createTheAppointments(rows)
        then:
            assert result == expected
        where:
            list                                        | expected
            ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
            "Csorba Ede 16:40 2017.10.27-19:56"]        | new BookingDetails(2017,10,27,19,56)
    }
    //uaz csak mivel nincs hash igy nem jo
    def 'findTheFirstBookedTeacherMeeting'(){
        setup:
            def controller = new ReceptionManager(list)
        when:
            def result = controller.findTheFirstBookedTeacherMeeting()
        then:
            assert result == exception
        where:
            list                                        | exception
        ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
         "Csorba Ede 16:40 2017.10.27-19:56"]           | new TeacherDetails("Csorba","Ede",16,40, new BookingDetails(2017,10,27,19,56))
    }

    def 'bookedAppointments'(){
        setup:
        def controller = new ReceptionManager(list)
        when:
        def result = controller.bookedAppointments()
        then:
        assert result == exception
        where:
        list                                        | exception
        ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
         "Csorba Ede 16:40 2017.10.27-19:56"]           | ["16:0","16:10","16:20","16:30","16:40","16:50","17:0","17:10","17:20","17:30","17:40","17:50"]
    }
    def 'requestedTeacherAppointments'(){
        setup:
            def controller = new ReceptionManager(list)
        when:
             def result = controller.requestedTeacherAppointments(lName,fName)
        then:
            assert result == exception
        where:
            list                                        | exception                                                                                 | lName     | fName
        ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
         "Csorba Ede 16:40 2017.10.27-19:56"]           | ["16:0","16:10","16:20","16:30","16:50","17:0","17:10","17:20","17:30","17:40","17:50"]   | "Csorba" | "Ede"
    }
    def 'theTimeWhenTheTeacherLeft'(){
        setup:
            def controller = new ReceptionManager(list)
        when:
            def result = controller.theTimeWhenTheTeacherLeft(lName,fName)
        then:
            assert result == exception
        where:
            list                                            | exception                                                                                 | lName     | fName
            ["Fodor Zsuzsanna 16:50 2017.10.28-18:51",
            "Csorba Ede 16:40 2017.10.27-19:56"]            |  "16:50"  | "Csorba" | "Ede"
    }

}
