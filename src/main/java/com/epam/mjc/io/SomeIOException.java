package com.epam.mjc.io;

import java.io.IOException;

public class SomeIOException extends IOException {
    public SomeIOException(Throwable cause) {
        super(cause);
    }
}
