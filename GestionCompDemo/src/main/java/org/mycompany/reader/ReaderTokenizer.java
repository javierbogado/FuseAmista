package org.mycompany.reader;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReaderTokenizer implements Iterator<String>{
	
	private String _curString = null;
	private boolean _endReached = false;
	private final Reader _reader;
	private char[] _token;

	public ReaderTokenizer(Reader reader, String token) {
	    setToken(token);
	    _reader = reader;
	}

	public final void setToken(String token){
	    _token = token.toCharArray();
	    if(_token.length==0){
	        throw new IllegalArgumentException("Can't tokenize with the empty string");
	    }
	}

	private void _readNextToken() throws IOException {

	    int curCharInt;
	    char previousChar = (char) -1;
	    int tokenPos = 0;
	    StringBuilder sb = new StringBuilder(255);

	    while (true) {
	        curCharInt = _reader.read();
	        if (curCharInt == -1) {
	            _endReached = true;
	            _reader.close();
	            break;
	        }
	        if (curCharInt == _token[tokenPos]) {

	            if (tokenPos != 0 || !Character.isHighSurrogate(previousChar)) {
	                tokenPos++;

	                if (tokenPos >= _token.length) {
	                    tokenPos = 0;
	                    previousChar = (char) curCharInt;
	                    sb.append(previousChar);
	                    break;
	                }
	            }
	        }

	        previousChar = (char) curCharInt;
	        sb.append(previousChar);
	    }
	    _curString = sb.toString();
	}

	@Override
	public boolean hasNext() {
	    if (_curString == null) {
	        if (_endReached) {
	            return false;
	        }
	        try {
	            _readNextToken();
	        } catch (IOException ex) {
	            throw new RuntimeException(ex);
	        }

	        if (_curString != null) {
	            return true;
	        }

	        if (_endReached) {
	            return false;
	        }

	        throw new RuntimeException("Someting wrong");

	    } else {
	        return true;
	    }
	}

	@Override
	public String next() {
	    if (_curString != null) {
	        String ret = _curString;
	        _curString = null;
	        return ret;
	    }
	    if (_endReached) {
	        throw new NoSuchElementException();
	    }

	    try {
	        _readNextToken();
	    } catch (IOException ex) {
	        throw new RuntimeException(ex);
	    }

	    if (_curString != null) {
	        String ret = _curString;
	        _curString = null;
	        return ret;
	    }

	    throw new RuntimeException("Someting wrong");
	}

	@Override
	public void remove() {
	    throw new UnsupportedOperationException("Not supported.");
	}

}
