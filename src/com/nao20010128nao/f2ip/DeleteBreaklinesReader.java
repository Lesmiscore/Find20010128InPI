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
}
