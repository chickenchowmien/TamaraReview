package Java;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class lambda {
	
	private String brand;
	private Integer series;
	
	@Override
	public boolean equals (Object obj) {
	return EqualsBuilder.reflectionEquals(this,obj);
	



	

}
	
}
