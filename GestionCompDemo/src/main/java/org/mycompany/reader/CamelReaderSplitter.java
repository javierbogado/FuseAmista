package org.mycompany.reader;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class CamelReaderSplitter {
	private final String _token;
	private final int _headerLinesNumber;

	public CamelReaderSplitter(String token, int headerLinesNumber) {
	    _token = token;
	    _headerLinesNumber = headerLinesNumber;
	}

	public CamelReaderSplitter(String token) {
	    _token = token;
	    _headerLinesNumber = 1;
	}

	public CamelReaderSplitter(int headerLinesNumber) {
	    _token = "\r\n";
	    _headerLinesNumber = headerLinesNumber;
	}

	public CamelReaderSplitter() {
	    _token = "\r\n";
	    _headerLinesNumber = 1;
	}

	public Iterator<String> tokenizeReader(final Reader reader) throws IOException {

	    Iterator<String> ret = new ReaderTokenizer(reader, _token) {

	        private final String _firstLines;

	        {
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < _headerLinesNumber; i++) {
	                if (super.hasNext()) {
	                    sb.append(super.next());
	                }
	            }
	            _firstLines = sb.toString();
	        }

	        @Override
	        public String next() {
	            return _firstLines + super.next();
	        }

	    };

	    return ret;
	}
}
