package com.mk.convention.utils.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

//第二个消费者
public class Handler11 implements EventHandler<MyEvent>, WorkHandler<MyEvent> {
  private static final Logger log = LoggerFactory.getLogger(Handler11.class);

  @Override
  public void onEvent(MyEvent event) throws Exception {
      log.debug(event.getName() + "====Handler11 。。。。。");
  }

  @Override
  public void onEvent(MyEvent event, long sequence, boolean endOfBatch)
          throws Exception {
      onEvent(event);
  }

}