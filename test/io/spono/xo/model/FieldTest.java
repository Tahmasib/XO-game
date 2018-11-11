package io.spono.xo.model;

import io.spono.xo.model.exceptions.AlreadyOccupiedException;
import io.spono.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure()
            throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureIsNotSet()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenAlreadyOccupied()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();

        } catch (final AlreadyOccupiedException e) {

        }
    }

    @Test
    public void getFigureWhenXIsLessThenZero()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void getFigureWhenYIsLessThenZero()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void getFigureWhenPointIsLessThenZero()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void getFigureWhenXIsMoreThenSize()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void getFigureWhenYIsMoreThenSize()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void getFigureWhenPointIsMoreThenSize()
            throws Exception {
        final Field field = new Field();
        final Point inputPoint =
                new Point(field.getSize() + 1, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }
}