package app.saikat.GsonManagement.Test_2;

import java.util.List;
import java.util.Map;

public class SampleClass {

	private int i;
	private String str;
	private double d;
	private float f;
	private byte b;
	private short s;
	private long l;
	private char c;

	private Class<?> cls;

	private Map<String, List<TestType>> map;

	public int getI() {
		return this.i;
	}

	public String getStr() {
		return this.str;
	}

	public double getD() {
		return this.d;
	}

	public float getF() {
		return this.f;
	}

	public byte getB() {
		return this.b;
	}

	public short getS() {
		return this.s;
	}

	public long getL() {
		return this.l;
	}

	public char getC() {
		return this.c;
	}

	public Class<?> getCls() {
		return cls;
	}

	public Map<String, List<TestType>> getMap() {
		return this.map;
	}

	public SampleClass(int i, String str, double d, float f, byte b, short s, long l, char c,
			Map<String, List<TestType>> map, Class<?> cls) {
		this.i = i;
		this.str = str;
		this.d = d;
		this.f = f;
		this.b = b;
		this.s = s;
		this.l = l;
		this.c = c;
		this.map = map;
		this.cls = cls;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SampleClass) {
			SampleClass sc = (SampleClass) obj;
			return i == sc.i && d == sc.d && f == sc.f && b == sc.b && s == sc.s && l == sc.l && c == sc.c
					&& str.equals(sc.str) && map.equals(sc.map) && cls.equals(sc.cls);
		} else {
			return false;
		}
	}
}