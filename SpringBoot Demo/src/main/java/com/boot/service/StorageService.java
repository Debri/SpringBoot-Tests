package com.boot.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
public interface StorageService {
    public void init();

    void storage(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String fileName);

    Resource loadResource(String fileName);

    void deleteAll();


}
