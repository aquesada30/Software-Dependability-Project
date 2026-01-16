package com.dependability.webapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ReverseControllerUnitTest {
  @Test
  void reverse_directCall() {
    ReverseController c = new ReverseController();
    assertEquals("aloh", c.reverse("hola"));
    assertEquals("", c.reverse(""));
  }
}

