import java.util.Random;

public class TestDemo {
	
	public int addPositive (int a, int b) {
	if ((a % 2 == 0 && a>0) && (b % 2 ==0 && b >0))
	{System.out.println(a + b);
	return (a+b);}
	else {
	throw new IllegalArgumentException("Both parameters must be positive");
	}	
	}
	
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
	return(randomNumber*randomNumber);
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
