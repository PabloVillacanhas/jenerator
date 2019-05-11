package jenerator.engine.generators;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import jenerator.Foo;
import jenerator.engine.GeneratorController;
import jenerator.filters.exceptions.NotAnnotationEncountered;

public class ValueGeneratorTest {

	@Test
	public void getValueTest() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, SecurityException, NotAnnotationEncountered {
		Foo foo = new Foo();
		GeneratorController generatorController = new GeneratorController(foo);
		generatorController.process();
		System.out.println(foo);
	}
}