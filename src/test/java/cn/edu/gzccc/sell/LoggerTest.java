package cn.edu.gzccc.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * logger测试
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest  {
  private final Logger logger= LoggerFactory.getLogger(Logger.class);

  @Test
  public void Test1(){
      logger.debug("debug...");
      logger.info("info.....");
      logger.error("error...");
  }

}
