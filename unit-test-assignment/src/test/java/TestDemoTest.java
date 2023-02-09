import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoTest {
	private static TestDemo testDemo;
	

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	@MethodSource ("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}
	public static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
				arguments (2, 4, 6, false),
				arguments (5, 5, 10, true),
				arguments (5, -3, 0, true)
				);
				//formatter:on
	}
	
	@Test
	private static void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo.getRandomInt());
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	}
	