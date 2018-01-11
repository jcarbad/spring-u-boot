package com.boot;

import static org.junit.Assert.assertEquals;
import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController SC;

    @Mock
    private ShipwreckRepository SR;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreck() {
        Shipwreck ship = new Shipwreck();
        ship.setId(1L);
        assertEquals(1L, ship.getId().longValue());
        when(SR.findOne(1L)).thenReturn(ship);
        Shipwreck wreck = SC.get(1L);
        assertEquals(1L, wreck.getId().longValue());
    }
}
