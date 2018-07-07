package com.ouisncf.xspeedit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ouisncf.xspeedit.robot.impl.XspRobot;
import com.ouisncf.xspeedit.util.XspRobotUtils;
public class xspRobotTest {
    @Test
    public void optimizedTest() {
        String input = "163841689525773";
        String expectedResult = "91/82/81/73/73/64/6/55";

        String realResult = XspRobotUtils.cartonsToString(new XspRobot(input).emballer());
        assertEquals(expectedResult, realResult);
    }
}