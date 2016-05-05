package com.nao20010128nao.f2ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Vector;
import java.util.zip.GZIPInputStream;

public class Finder {
	public static void main(String... args) throws IOException {
		final BigInteger STATUS_UNIT = new BigInteger("100000");
		System.out.println("Loading...");
		Vector<InputStream> lis = new Vector<>();
		ClassLoader currentClassLoader = Finder.class.getClassLoader();
		for (int i = 1; i <= 45; i++)
			lis.add(currentClassLoader.getResourceAsStream("com.nao20010128nao.f2ip.pi.".replace('.', '\\')
					+ "pi1g.txt.gz." + ("000" + i).substring(("000" + i).length() - 3, ("000" + i).length())));
		SequenceInputStream sis = new SequenceInputStream(lis.elements());
		GZIPInputStream gis = new GZIPInputStream(sis);
		DeleteBreaklinesReader dbr = new DeleteBreaklinesReader(gis);
		BufferedReader br = new BufferedReader(dbr);
		BigInteger reached = new BigInteger("8");
		char[] result = "20010128".toCharArray();
		char[] data = new char[8];
		br.read(data);
		System.out.println("Head 8 chars:" + new String(data));
		while (true) {
			if (Arrays.equals(data, result)) {
				System.out.println("\nFound at:" + reached);
				return;
			}
			{
				data[1] = data[0];
				data[2] = data[1];
				data[3] = data[2];
				data[4] = data[3];
				data[5] = data[4];
				data[6] = data[5];
				data[7] = data[6];
			}
			int r = br.read();
			if (r == -1)
				break;
			data[0] = (char) r;
			reached = reached.add(BigInteger.ONE);
			if (reached.mod(STATUS_UNIT).equals(BigInteger.ZERO))
				System.out.println("Reached:" + reached);
		}
		System.err.println("Not Found...");
	}
}
