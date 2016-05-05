package com.nao20010128nao.f2ip;

import java.io.FilterInputStream;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DeleteBreaklinesReader extends FilterReader {
	public DeleteBreaklinesReader(InputStream reader) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(new InputStreamReader(new FilterInputStream(reader) {
			@Override
			public int read() throws IOException {
				int r = super.read();
				if (r == -1)
					return -1;
				if (r == '\r' | r == '\n')
					return read();
				return r;
			}

			@Override
			public int read(byte b[]) throws IOException {
				return read(b, 0, b.length);
			}

			@Override
			public int read(byte b[], int off, int len) throws IOException {
				if (b == null)
					throw new NullPointerException();
				else if (off < 0 || len < 0 || len > b.length - off)
					throw new IndexOutOfBoundsException();
				else if (len == 0)
					return 0;

				int c = read();
				if (c == -1)
					return -1;
				b[off] = (byte) c;

				int i = 1;
				try {
					for (; i < len; i++) {
						c = read();
						if (c == -1)
							break;
						b[off + i] = (byte) c;
					}
				} catch (IOException ee) {
				}
				return i;
			}
		}));
	}
}
