package com.lgs.service;

import com.lgs.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String upload2WebServer(String path, MultipartFile file);

    ServerResponse upload2FTP(String uploadName, String path);
}
