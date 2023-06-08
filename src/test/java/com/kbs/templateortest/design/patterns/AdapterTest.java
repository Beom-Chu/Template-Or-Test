package com.kbs.templateortest.design.patterns;

import com.kbs.templateortest.design.patterns.adapter.RoundHole;
import com.kbs.templateortest.design.patterns.adapter.RoundPeg;
import com.kbs.templateortest.design.patterns.adapter.SquarePeg;
import com.kbs.templateortest.design.patterns.adapter.SquarePegAdapter;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    public void test() {

        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);

        if(hole.fits(roundPeg)) {
            System.out.println("roundPeg is fits.");
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg bigSquarePeg = new SquarePeg(20);

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter bigSquarePegAdapter = new SquarePegAdapter(bigSquarePeg);

        if(hole.fits(smallSquarePegAdapter)) {
            System.out.println("smallSquarePeg is fits.");
        }
        if(!hole.fits(bigSquarePegAdapter)) {
            System.out.println("bigSquarePegAdapter is not fits.");
        }
    }
}
