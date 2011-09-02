import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sethholloway.Permutation;
import com.sethholloway.Utilities;


public class PermutationTest {
	private Permutation permutation;
	private static int one_factorial   = 1;
	private static int two_factorial   = 2;
	private static int three_factorial = 6;
	private static int four_factorial  = 24;
	private static int five_factorial  = 120;
	private static int six_factorial   = 720;
	private static int seven_factorial = 5040;
	private static int eight_factorial = 40320;
	

	@Before
	public void setUp() throws Exception {
		permutation = new Permutation();
	}

	@Test
	public void test_remove_character_at_index() throws Exception {
		String original    = "tests";
		String removeZero  = "ests";
		String removeOne   = "tsts";
		String removeTwo   = "tets";
		String removeThree = "tess";
		String removeFour  = "test";
		
		assertTrue(Utilities.removeCharacterAtIndex(original, 0).equals(removeZero));
		assertTrue(Utilities.removeCharacterAtIndex(original, 1).equals(removeOne));
		assertTrue(Utilities.removeCharacterAtIndex(original, 2).equals(removeTwo));
		assertTrue(Utilities.removeCharacterAtIndex(original, 3).equals(removeThree));
		assertTrue(Utilities.removeCharacterAtIndex(original, 4).equals(removeFour));
	}
	
	@Test
	public void test_one_character_string() throws Exception {
		List<String> known = new ArrayList<String>();
		known.add("1");
		
		permutation.permute("1");
		assertEquals("permutation strings did not match", permutation.getPermutations(), known);
	}
	
	@Test
	public void test_two_character_string() throws Exception {
		List<String> known = new ArrayList<String>();
		known.add("12");
		known.add("21");
		
		permutation.permute("12");
		assertEquals("permutation strings did not match", permutation.getPermutations(), known);
	}
	
	@Test
	public void test_three_character_string() throws Exception {
		List<String> known = new ArrayList<String>();
		known.add("123");
		known.add("132");
		known.add("213");
		known.add("231");
		known.add("312");
		known.add("321");
		
		permutation.permute("123");
		assertEquals("permutation strings did not match", permutation.getPermutations(), known);
	}
	
	@Test
	public void test_output_list_size() throws Exception {
		Permutation perm_one   = new Permutation("1");
		assertEquals("permutation strings did not match", 
				perm_one.getPermutations().size(), one_factorial);
		
		Permutation perm_two   = new Permutation("12");
		assertEquals("permutation of length two did not have proper output size", 
				perm_two.getPermutations().size(), two_factorial);
		
		Permutation perm_three = new Permutation("123");
		assertEquals("permutation of length three did not have proper output size", 
				perm_three.getPermutations().size(), three_factorial);
		
		Permutation perm_four  = new Permutation("1234");
		assertEquals("permutation of length four did not have proper output size", 
				perm_four.getPermutations().size(), four_factorial);
		
		Permutation perm_five  = new Permutation("12345");
		assertEquals("permutation of length five did not have proper output size", 
				perm_five.getPermutations().size(), five_factorial);
		
		Permutation perm_six   = new Permutation("123456");
		assertEquals("permutation of length six did not have proper output size", 
				perm_six.getPermutations().size(), six_factorial);
		
		Permutation perm_seven = new Permutation("1234567");
		assertEquals("permutation of length seven did not have proper output size", 
				perm_seven.getPermutations().size(), seven_factorial);

		Permutation perm_eight = new Permutation("12345678");
		assertEquals("permutation of length eight did not have proper output size", 
				perm_eight.getPermutations().size(), eight_factorial);
	}
}
