package edu.kis.powp.jobs2d.command;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableComplexCommandTest {

    @Test
    void immutability() {
        List<DriverCommand> srcList = new ArrayList<>();
        srcList.add(new SetPositionCommand(10, 10));
        srcList.add(new SetPositionCommand(20, 20));
        
        List<DriverCommand> testList = new ArrayList<DriverCommand>(srcList);
        
        ImmutableComplexCommand immutableComplexCommand = new ImmutableComplexCommand(testList);
        
        testList.set(1, new OperateToCommand(30, 30));
        
        Iterator<DriverCommand> iterator = immutableComplexCommand.iterator();
        
        for (DriverCommand command : srcList) {
            assertEquals(command, iterator.next());
        }
        
        assertFalse(iterator.hasNext());
    }
}