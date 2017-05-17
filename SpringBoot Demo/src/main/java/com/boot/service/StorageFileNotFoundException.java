package com.boot.service;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);

    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
