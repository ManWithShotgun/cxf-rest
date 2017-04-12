package ru.ilia.rest.exception;

/**
 * Created by ILIA on 12.04.2017.
 */
public class NotImplementedException extends Exception {
    public NotImplementedException() {
        super("SERVER ERROR: 501 Method not implemented");
    }
}
