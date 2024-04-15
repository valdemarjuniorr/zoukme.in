package br.com.valdemarjr.zoukmein;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIntegrationTest {

  @LocalServerPort private int randomServerPort;

  /**
   * Method to get the server url and port.
   */
  protected String getServerPort() {
    return "http://localhost:" + randomServerPort;
  }
}
