package jenerator;

/**
 * <p>
 * This class must provide a minimal configuration, like if the developer is
 * going to use our annotations or Hibernate ones.
 * </p>
 * 
 * @author Pablo Villacanas
 *
 */
public class JeneratorConfiguration {

	private static JeneratorConfiguration engineConfiguration;
	private FieldFilterType fieldFilterType;

	/**
	 * <p>
	 * Sets the filter type for the future value generated fields.
	 * </p>
	 * 
	 * @author Pablo Villacanas
	 *
	 */
	public enum FieldFilterType {

		/**
		 * This predicate filters all fields that have one annotation of type
		 * jenerator.annotations and does not have a
		 * {@link jenerator.annotation.NoGenerable NoGenerable} annotation
		 */
		EXPLICITFILTER,

		/**
		 * This predicate filters all fields that do not have a
		 * {@link jenerator.annotation.NoGenerable NoGenerable} annotation
		 */
		LAZYFILTER;
	}

	private JeneratorConfiguration() {
	}

	public static JeneratorConfiguration getInstance() {
		if (engineConfiguration == null) {
			engineConfiguration = new JeneratorConfiguration();
			engineConfiguration.setFieldFilterType(FieldFilterType.EXPLICITFILTER);
		}
		return engineConfiguration;
	}

	public FieldFilterType getFieldFilter() {
		return fieldFilterType;
	}

	public void setFieldFilterType(FieldFilterType fieldFilterType) {
		this.fieldFilterType = fieldFilterType;
	}
}
