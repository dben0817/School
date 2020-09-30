package JH2Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellCheck {

	// We could have also used TreeSet for the dictionary
	private HashSet<String> dictionary = new HashSet<String>();
	private TreeSet<String> miss_spelled_words = new
			TreeSet<String>();

	public SpellCheck() throws FileNotFoundException
	{
		// Add all of the words from "dictionary.txt" to the dictionary HashSet 
		Scanner dict = new Scanner(new File("dictionary.txt"));
		while (dict.hasNext())
		{
			dictionary.add(dict.next());
		}
		dict.close();
	}

	public void checkSpelling(String fileName) throws FileNotFoundException
	{
		System.out.println("======== Spell checking " + fileName
				+ " =========");
		// Clear miss_spelled_words
		miss_spelled_words.clear();
		String line, entry, entry2, response;
		String badLine = null;
		char c;
		Scanner check = new Scanner(new File(fileName));
		Scanner input = new Scanner(System.in);
		while (check.hasNextLine())
		{
			line = check.nextLine();
			badLine = null;
			// Read in each line from "fileName"
			// For each line, break the line into words using the following StringTokenizer
			StringTokenizer st = new StringTokenizer(line, " \t,.;:-%'\"");

			while (st.hasMoreTokens())
			{
				entry = st.nextToken().toLowerCase();
				entry2 = null;
				c = entry.charAt(0);
				if (dictionary.contains(entry)||miss_spelled_words.contains(entry))
				{
					continue;
				}
				else
				{
					if (Character.isLetter(c))
					{
						if (entry.endsWith("s"))
						{
							entry2 = entry.substring(0, entry.length() -1); //
							if (!dictionary.contains(entry2)) {
								System.out.println("Would you like to add " + entry2 + " to your dictionary? \"y\" to add to the Dictiony, \"n\" to add to Miss Spelled Words");
								response = input.next().trim();
								if (response == "y")
									dictionary.add(entry2);
								else
								{miss_spelled_words.add(entry2);
								badLine = line;
								}
							}
						}

						else if (!dictionary.contains(entry)) {
							System.out.println("Would you like to add " + entry + " to your dictionary? \"y\" to add to the Dictiony, \"n\" to add to Miss Spelled Words");
							response = input.next().trim();
							if (response == "y")
								dictionary.add(entry);
							else
							{miss_spelled_words.add(entry);
							badLine = line;
							}
						}

					}
				}
			}
			if (badLine != null)
				System.out.println(badLine);
			//--// lower case each word obtained from the StringTokenizer
			//--// skip word if the first character is not a letter

			//--// Skip over word if it can be found in either dictionary, or miss_spelled_words
			//--// If word ends with 's', then try the singular version of the word in the dictionary and miss_spelled_words ... skip if found

			//--// Print line containing miss-spelled word(make sure you only print it once if multiple miss-spelled words are found on this line)

			//--// Ask the user if he wants the word added to the dictionary or the miss-spelled words and add word as specified by the user
		}
		check.close();
		input.close();
	}

	public void dump_miss_spelled_words()
	{
		// Print out the miss-spelled words
		Iterator<String> iter = miss_spelled_words.iterator();

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
