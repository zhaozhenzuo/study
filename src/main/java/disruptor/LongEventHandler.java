package disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> { 
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception { 
        System.out.println("consume:"+longEvent.getValue()); 
    } 
} 