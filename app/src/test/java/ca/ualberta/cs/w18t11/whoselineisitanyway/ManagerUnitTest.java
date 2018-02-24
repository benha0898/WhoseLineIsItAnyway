package ca.ualberta.cs.w18t11.whoselineisitanyway;

import junit.framework.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class ManagerUnitTest
{
    @Test(expected = IndexOutOfBoundsException.class)
    final public void testGetOutOfRange() {
        Manager<Integer> manager = new Manager<Integer>();
        manager.get(1);
    }

    @Test
    final public void testGetTask() {
        Manager<Task> taskManager = new Manager<Task>();
        Task addedTask = new Task("name", "description");
        Task wrongTask = new Task("name", "description");
        taskManager.add(addedTask);
        Assert.assertEquals(addedTask, taskManager.get(0));
        Assert.assertNotSame(wrongTask, taskManager.get(0));
    }

    @Test
    final public void testGetBid() {
        Manager<Bid> bidManager = new Manager<Bid>();
        Bid addedBid = new Bid("provider", "task", new BigDecimal(1));
        Bid wrongBid = new Bid("provider", "task", new BigDecimal(1));
        bidManager.add(addedBid);
        Assert.assertEquals(addedBid, bidManager.get(0));
        Assert.assertNotSame(wrongBid, bidManager.get(0));
    }

    @Test
    final public void testSetBid()
    {
        Manager<Bid> manager = new Manager<Bid>();
        Bid addedBid = new Bid("add", "add", new BigDecimal(1));
        Bid setBid = new Bid("set", "set", new BigDecimal(1));
        manager.add(addedBid);
        Assert.assertEquals(addedBid, manager.get(0));
        manager.set(0, setBid);
        Assert.assertEquals(setBid, manager.get(0));
    }

    @Test
    final public void testSetTask()
    {
        Manager<Task> manager = new Manager<Task>();
        Task addedTask = new Task("add", "add");
        Task setTask = new Task("set", "set");
        manager.add(addedTask);
        Assert.assertEquals(addedTask, manager.get(0));
        manager.set(0, setTask);
        Assert.assertEquals(setTask, manager.get(0));
    }
}
