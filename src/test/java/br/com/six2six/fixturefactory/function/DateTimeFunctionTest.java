package br.com.six2six.fixturefactory.function;

import static br.com.six2six.fixturefactory.util.DateTimeUtils.toCalendar;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import br.com.six2six.fixturefactory.function.impl.DateTimeFunction;
import br.com.six2six.fixturefactory.function.impl.DateTimeFunction.DateType;

public class DateTimeFunctionTest {

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void afterDate() {
		String source = "2011-04-07";
		Calendar value = new DateTimeFunction(toCalendar(source, format), DateType.AFTER).generateValue();
		assertNotNull("Generated date can not be null", value);
		assertTrue(String.format("Generated date is not after %s", source), value.after(toCalendar(source, format)));
	}

	@Test
	public void beforeDate() {
		String source = "2011-04-07";
		Calendar value = new DateTimeFunction(toCalendar(source, format), DateType.BEFORE).generateValue();
		assertNotNull("Generated date can not be null", value);
		assertTrue(String.format("Generated date is not before %s", source), value.before(toCalendar(source, format)));
	}
	@Test
	public void randomDate() {
		String start = "2011-04-01", end = "2011-04-30";
		Calendar value = new DateTimeFunction(toCalendar(start, format), toCalendar(end, format)).generateValue();
		assertNotNull("Generated date can not be null", value);
		assertTrue(String.format("Generated date is not between %s and %s", start, end), toCalendar(start, format).before(value) && value.before(toCalendar(end, format)));
	}
	
}
