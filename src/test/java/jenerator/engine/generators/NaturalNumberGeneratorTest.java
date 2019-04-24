package jenerator.engine.generators;

import org.junit.Test;

import jenerator.annotations.NaturalNumberGenerable;
import jenerator.annotations.reader.NaturalNumberConstraints;
import jenerator.annotations.reader.NaturalNumberGeneratorReader;
import jenerator.engine.generators.ByteGenerator;
import jenerator.engine.generators.IntegerGenerator;
import jenerator.engine.generators.LongGenerator;
import jenerator.engine.generators.NaturalNumberGenerator;
import jenerator.engine.generators.ShortGenerator;

public class NaturalNumberGeneratorTest {

	@NaturalNumberGenerable
	private Integer i;

	@Test
	public void testConcordanceBetweenFieldTypeAndValueGenerated() throws NoSuchFieldException, SecurityException {
		NaturalNumberGenerable annotation = NaturalNumberGeneratorTest.class.getDeclaredField("i")
				.getAnnotation(NaturalNumberGenerable.class);
		NaturalNumberConstraints constraints = new NaturalNumberGeneratorReader().readValues(annotation);

		NaturalNumberGenerator<Integer> naturalNumberGenerator = new IntegerGenerator(constraints);
		assert (naturalNumberGenerator.getRandomValue() instanceof Integer);

		NaturalNumberGenerator<Long> naturalNumberGenerator2 = new LongGenerator(constraints);
		assert (naturalNumberGenerator2.getRandomValue() instanceof Long);

		NaturalNumberGenerator<Short> naturalNumberGenerator3 = new ShortGenerator(constraints);
		assert (naturalNumberGenerator3.getRandomValue() instanceof Short);

		NaturalNumberGenerator<Byte> naturalNumberGenerator4 = new ByteGenerator(constraints);
		assert (naturalNumberGenerator4.getRandomValue() instanceof Byte);
	}
}