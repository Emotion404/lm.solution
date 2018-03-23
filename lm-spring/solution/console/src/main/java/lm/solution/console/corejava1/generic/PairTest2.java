package lm.solution.console.corejava1.generic;

import lm.solution.pojo.model.console.generic.Pair;

import java.time.LocalDate;

public class PairTest2 {

//    @Test
    public void genericMethodTest() {

        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22)
        };
        Pair<LocalDate> mm = new ArrayAlg2().minmax(birthdays);
        System.out.println(" min= " + mm.getFirst());
        System.out.println(" max= "+mm.getSecond());

    }

}
