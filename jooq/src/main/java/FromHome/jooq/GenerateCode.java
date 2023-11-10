package FromHome.jooq;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;

public class GenerateCode 
{

	public static void main(String[] args) 
	{
		String DB_REL_FILE = "/Users/iphoneloki/Documents/GitHubEx/skeleton/skeleton/skeleton/indirizzi.db3";
		String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		
		try 
		{
			Configuration configuration = new Configuration()
					.withJdbc(new Jdbc().withDriver("org.sqlite.JDBC")
					.withUrl(DB_URL))
					.withGenerator(new Generator()
					.withDatabase(new Database().withName("org.jooq.meta.sqlite.SQLiteDatabase").withIncludes(".*")
					.withExcludes(""))
					.withTarget(new Target().withPackageName("contatti.jooq.generated")
					.withDirectory("FromHome.jooq/")));

			GenerationTool.generate(configuration);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
