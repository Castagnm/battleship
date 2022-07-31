package com.mcas;

import org.junit.Test;

import com.mcas.game.model.coord.CoordX;
import com.mcas.game.model.coord.CoordY;

import static org.junit.Assert.assertTrue;

public class ShotTest {
    
    @Test
    public void shouldReportWhenShotSuccessful() {

        // Given
        Shot shot = Shot.create(CoordX.A, CoordY.ONE);

        // When
        shot.execute();

        // Then
        assertTrue(shot.hasMissed());

    }
}
