package spell_checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellCheck {

	private HashSet<String> dictionary = new HashSet<String>();
	private TreeSet<String> miss_spelled_words = new TreeSet<String>();
	String line, dentry;
	boolean badLine;
	public SpellCheck() throws FileNotFoundException
	{
		// Add all of the words from "dictionary.txt" to the dictionary HashSet 
		Scanner dict = new Scanner(new File("./dictionary.txt"));
		while (dict.hasNext())
		{
			dentry = dict.next();
			dictionary.add(dentry);

		}
		dict.close();
	}

	public void checkSpelling(String fileName) throws FileNotFoundException
	{
		if (fileName != null)
		{
			System.out.println("======== Spell checking " + fileName
					+ " =========");
			miss_spelled_words.clear();
			String entry, entry2, userResponse;

			char c;
			@SuppressWarnings("resource")
			Scanner check = new Scanner(new File(fileName));
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			while (check.hasNextLine())
			{
				line = check.nextLine();
				badLine = false;
				StringTokenizer st = new StringTokenizer(line, " \t,.;:-%'\"");

				while (st.hasMoreTokens())
				{
					entry = st.nextToken().toLowerCase();
					entry2 = null;
					c = entry.charAt(0);
					if (!dictionary.contains(entry) && !miss_spelled_words.contains(entry))
					{

						if (Character.isLetter(c))
						{
							badLineCheck(entry);
							userResponse = input.next().trim();	
							wordsUpdate(userResponse, entry);

							if (entry.endsWith("s"))
							{
								entry2 = entry.substring(0, entry.length() -1); //
								if (!dictionary.contains(entry2) && !miss_spelled_words.contains(entry2)) {

									badLineCheck(entry2);
									userResponse = input.next().trim();
									wordsUpdate(userResponse, entry2);
								}
							}

						}


					}

				}

			}
		}


	}

	public void badLineCheck(String word)
	{
		if (!badLine)
		{
			System.out.println(line);
			badLine = true;
		}
		System.out.println("Would you like to add " + word + " to your dictionary? \"y\" to add to the Dictionary, \"n\" to add to Miss Spelled Words");
	}

	public void wordsUpdate (String s, String word)
	{

		switch(s)
		{
		case "y":
			dictionary.add(word);
			break;

		case "n":
			if (!miss_spelled_words.add(word)) {
				System.out.println(word + "not added to miss spelled words");
				break;}
		}
	}

	public void dump_miss_spelled_words()
	{
		Iterator<String> iter = miss_spelled_words.iterator();
		System.out.println("****** Miss spelled words ******");
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {

		try {
			SpellCheck spellCheck = new SpellCheck();

			for (int i=0; i < args.length; i++)
			{
				spellCheck.checkSpelling(args[i]);
				spellCheck.dump_miss_spelled_words();
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
