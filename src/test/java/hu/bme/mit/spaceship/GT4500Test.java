package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private TorpedoStore mockTorpedoStore1;
  private TorpedoStore mockTorpedoStore2;

  private GT4500 ship;

  @BeforeEach
  public void init(){
    this.mockTorpedoStore1 = mock(TorpedoStore.class);
    this.mockTorpedoStore2 = mock(TorpedoStore.class);
    this.ship = new GT4500(this.mockTorpedoStore1, this.mockTorpedoStore2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTorpedoStore1.fire(1)).thenReturn(true);
    when(mockTorpedoStore1.isEmpty()).thenReturn(false);

    when(mockTorpedoStore2.fire(1)).thenReturn(true);
    when(mockTorpedoStore2.isEmpty()).thenReturn(false);


    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(mockTorpedoStore1, times(1)).isEmpty();
    verify(mockTorpedoStore1, times(1)).fire(1);
    verify(mockTorpedoStore2, times(0)).isEmpty();
    verify(mockTorpedoStore2, times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTorpedoStore1.fire(1)).thenReturn(true);
    when(mockTorpedoStore1.isEmpty()).thenReturn(false);

    when(mockTorpedoStore2.fire(1)).thenReturn(true);
    when(mockTorpedoStore2.isEmpty()).thenReturn(false);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(mockTorpedoStore1, times(1)).isEmpty();
    verify(mockTorpedoStore1, times(1)).fire(1);
    verify(mockTorpedoStore2, times(1)).isEmpty();
    verify(mockTorpedoStore2, times(1)).fire(1);
  }

}
