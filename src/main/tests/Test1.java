package main.tests;

import main.java.ParkingLotApplication;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void testGetAllCommands() {
        List<String> ls = ParkingLotApplication.getAllCommands();
        Assert.assertEquals(ls.size(), 19);
    }
}

