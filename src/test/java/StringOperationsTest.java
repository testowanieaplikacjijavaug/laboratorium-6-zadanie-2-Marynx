import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringOperationsTest {
    
    private StringOperations stringOperations;
    
    @BeforeEach
    void setup(){
        stringOperations=new StringOperations();
    }
    
    @Test
    void testReverseWithNull(){
        assertThat(stringOperations.reverse(null),nullValue());
    }
    
    @Test
    void testReverseWithEmptyString(){
        assertThat(stringOperations.reverse("").isEmpty(),is(true));
    }
    
    @Test
    void testReverseWithSmallLetters(){
        String result=stringOperations.reverse("abc");
        assertThat(result).contains("cba");
    }
    
    @Test
    void testReverseWithSmallAndBigLetters(){
        assertThat(stringOperations.reverse("abcABC")).isEqualTo("CBAcba");
    }
    
    @Test
    void testReverseWithList(){
        List<String> reverseList= Arrays.asList(stringOperations.reverse("abc123"),stringOperations.reverse("a bc 123"),stringOperations.reverse("a bc 123 !@#"));
        assertThat(reverseList,containsInAnyOrder("321 cb a","321cba","#@! 321 cb a"));
    }
    
    @Test
    void testReverseWithSmallLettersAndNumbersAndSpaces(){
        List<String> reverseList= Arrays.asList(stringOperations.reverse("abc123"),stringOperations.reverse("a bc 123"),stringOperations.reverse("a bc 123 !@#"));
        assertThat(reverseList).contains("321cba").hasSize(3);
    }
    
    @Test
    void testReverseWithSmallLettersAndNumbersAndSpacesAndSpecialCharacters(){
        List<String> reverseList= Arrays.asList(stringOperations.reverse("abc123"),stringOperations.reverse("a bc 123"),stringOperations.reverse("a bc 123 !@#"));
        assertThat(reverseList).hasSize(3);
    }
    
    @Test
    void testConcatWithFirstValueNullAndSecondValueNull(){
        assertThat(stringOperations.concat(null,null)).isNull();
    }
    
    
    @Test
    void testConcatWithFirstValueNull(){
        String b="abc";
        assertThat(stringOperations.concat(null,b), isEmptyOrNullString());
    }
    
    @Test
    void testConcatWithSecondValueNull(){
        String a="abc";
        assertThat(stringOperations.concat(a,null),is(a));
    }
    
    @Test
    void testConcatWithOnlySmallLetters(){
        String a="abc";
        String b="def";
        assertThat(stringOperations.concat(a,b)).contains(a);
    }
    
    
    @Test
    void testPalindromeWithEmptyString(){
        
        assertThat(stringOperations.isPalindrome(""), notNullValue());
    }
    
    @Test
    void testPalindromeWithNull(){
        assertThat(stringOperations.isPalindrome(null)).isNotNull();
    }
    
    @Test
    void testPalindromeWithOnlySmallLetters(){
        
        assertThat(stringOperations.isPalindrome("itopinonavevanonipoti")).isTrue();
    }
    
    @Test
    void testPalindromeWithOnlyCapitalLetters(){
        List<Boolean> palindromeList=Arrays.asList(stringOperations.isPalindrome("ITOPINONAVEVANONIPOTI"),stringOperations.isPalindrome("itoPinonAvevAnoniPoti"),stringOperations.isPalindrome("iGattiNonAvevanoCugini"));
        assertThat(palindromeList,containsInAnyOrder(false,true,true));
    }

    @AfterEach
    void teardown(){
        stringOperations=null;
    }
    
}
