package name.schnee.junk;

public class StringTests {
	//Drill1st Rang3ant Rang3ant
	private static final String NOT_WORD_CHARS = "[\\W]";

	public static void main(String[] args)
	{
		String re = "[\\w]{8,32}";
		
		String test1 = "abcd-123"; //s/b good
		String test2 = "abcd123"; //too short
		String test3 = "abcd\' 99 = 99 \'"; //illegal chars
		String test4 = "\' OR 1=1 \'";
		String test5 = "________";
		
		System.out.println(test1.matches(re));
		System.out.println(test2.matches(re));
		System.out.println(test3.matches(re));
		System.out.println(test4.matches(re) + " " + test4.length());
		System.out.println(test5.matches(re));
		
		String out = test1.replaceAll(NOT_WORD_CHARS, "_");
		System.out.println(out);
		
		System.out.println(test2.replaceAll(NOT_WORD_CHARS, "_"));
		System.out.println(test3.replaceAll(NOT_WORD_CHARS, "_"));
		System.out.println(test4.replaceAll(NOT_WORD_CHARS, "_"));
		System.out.println(test5.replaceAll(NOT_WORD_CHARS, "_"));
	}

}
