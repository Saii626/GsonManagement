package app.saikat.GsonManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import app.saikat.DIManagement.Interfaces.DIManager;
import app.saikat.GsonManagement.Test_1.TestGson;
import app.saikat.GsonManagement.Test_2.SampleClass;
import app.saikat.GsonManagement.Test_2.TestType;

public class GsonTest {

	@Before
	public void resetDIManagement() {
		DIManager.newInstance();
	}

	@Test
	public void gsonInstanceCreate() {
		DIManager manager = DIManager.newInstance();
		manager.scan("app.saikat.GsonManagement", "app.saikat.DIManagement.Annotations", "app.saikat.DIManagement.Impl.BeanManagers");

		TestGson t = manager.getBeansOfType(TestGson.class).iterator().next().getProvider().get();
		Gson gson = manager.getBeansOfType(Gson.class).iterator().next().getProvider().get();

		assertNotNull("gson instance not null", gson);
		assertEquals("gson created and injected successfully", t.getGson(), gson);
	}

	@Test
	public void conversionTest() throws UnsupportedEncodingException, IOException {
		System.setProperty("build", "dev");
		DIManager manager = DIManager.newInstance();
		manager.scan("app.saikat.GsonManagement", "app.saikat.DIManagement.Annotations", "app.saikat.DIManagement.Impl.BeanManagers");

		Map<String, List<TestType>> map = new HashMap<>();
		List<TestType> l1 = new ArrayList<>();
		l1.add(new TestType("skdfhjks", 654));
		l1.add(new TestType("jdshgf", 346));
		l1.add(new TestType("khbdioe", 5464));
		l1.add(new TestType("cxkxjorbm", 921));
		l1.add(new TestType("rmbkivjb", 82174));
		map.put("eury", l1);

		List<TestType> l2 = new ArrayList<>();
		l2.add(new TestType("oiuertjgkhf", 21));
		l2.add(new TestType("cdsbmwjk", 4957095));
		l2.add(new TestType("vacmewr", 0542));
		l2.add(new TestType("phgo jdf", 0xf213d));
		l2.add(new TestType("pwigjbs", 1897));
		map.put("cvbud", l2);

		SampleClass sampleObject = new SampleClass(123, "saii", 10.56464654654324, 1.154f, (byte) 127, (short) 487,
				12487568754l, 'c', map, TestGson.class);
		Gson gson = manager.getBeansOfType(Gson.class).iterator().next().getProvider().get();
		String jsonStr = gson.toJson(sampleObject);

		File f = new File("src/test/java/app/saikat/GsonManagement/Test_2/pretty_json.txt");
		String fileContents = new String(Files.readAllBytes(f.toPath()), "utf-8");

		assertEquals("converted to json correctly", jsonStr, fileContents);

		SampleClass parsedObj = gson.fromJson(jsonStr, SampleClass.class);

		assertEquals("converted to object correctly", sampleObject, parsedObj);
	}

	@Test
	public void conversionTestProd() throws UnsupportedEncodingException, IOException {
		System.setProperty("build", "prod");
		DIManager manager = DIManager.newInstance();
		manager.scan("app.saikat.GsonManagement", "app.saikat.DIManagement.Annotations", "app.saikat.DIManagement.Impl.BeanManagers");

		Map<String, List<TestType>> map = new HashMap<>();
		List<TestType> l1 = new ArrayList<>();
		l1.add(new TestType("skdfhjks", 654));
		l1.add(new TestType("jdshgf", 346));
		l1.add(new TestType("khbdioe", 5464));
		l1.add(new TestType("cxkxjorbm", 921));
		l1.add(new TestType("rmbkivjb", 82174));
		map.put("eury", l1);

		List<TestType> l2 = new ArrayList<>();
		l2.add(new TestType("oiuertjgkhf", 21));
		l2.add(new TestType("cdsbmwjk", 4957095));
		l2.add(new TestType("vacmewr", 0542));
		l2.add(new TestType("phgo jdf", 0xf213d));
		l2.add(new TestType("pwigjbs", 1897));
		map.put("cvbud", l2);

		SampleClass sampleObject = new SampleClass(123, "saii", 10.56464654654324, 1.154f, (byte) 127, (short) 487,
				12487568754l, 'c', map, TestGson.class);

		Gson gson = manager.getBeansOfType(Gson.class).iterator().next().getProvider().get();
		String jsonStr = gson.toJson(sampleObject);

		File f = new File("src/test/java/app/saikat/GsonManagement/Test_2/compact_json.txt");
		String fileContents = new String(Files.readAllBytes(f.toPath()), "utf-8");

		assertEquals("converted to json correctly", jsonStr.trim(), fileContents.trim());

		SampleClass parsedObj = gson.fromJson(jsonStr, SampleClass.class);

		assertEquals("converted to object correctly", sampleObject, parsedObj);
	}
}