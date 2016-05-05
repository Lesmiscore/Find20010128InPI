package com.nao20010128nao.f2ip;

import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class DeleteBreaklinesReader extends FilterReader {

	public DeleteBreaklinesReader(Reader reader) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(new BufferedReader(reader));
	}

	public DeleteBreaklinesReader(InputStream reader) {
		// TODO 自動生成されたコンストラクター・スタブ
		this(new InputStreamReader(reader));
	}

	@Override
	public int read() throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		int r = super.read();
		if (r == '\r' | r == '\n')
			return read();
		return r;
	}

	@Override
	public int read(char[] b, int off, int len) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		if (b == null)
			throw new NullPointerException();
		else if (off < 0 || len < 0 || len > b.length - off)
			throw new IndexOutOfBoundsException();
		else if (len == 0)
			return 0;

		int c = read();
		if (c == -1)
			return -1;
		b[off] = (char) c;

		int i = 1;
		try {
			for (; i < len; i++) {
				c = read();
				if (c == -1)
					break;
				b[off + i] = (char) c;
			}
		} catch (IOException ee) {
		}
		return i;
	}

	@Override
	public int read(char[] b) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		return read(b, 0, b.length);
	}
}
