package com.lgs.service.Impl;

import com.lgs.common.ServerResponse;
import com.lgs.service.IFileService;
import com.lgs.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload2WebServer(String path, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String type = fileName.substring(fileName.indexOf(".")+1);
        String uploadName = UUID.randomUUID().toString()+"." + type;

        File fileDir = new File(path);
        if(!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        logger.info("本地上传至服务器：上传的文件名{}，上传的路径{}，新文件名：{}", fileName, path, uploadName);

        File targetFile = new File(path, uploadName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            logger.error("上传至tomcat失败：", e);
        }
        return targetFile.getName();
    }

    public ServerResponse upload2FTP(String uploadName, String path) {
        File targetFile = new File(path, uploadName);
        if(!targetFile.exists()) return ServerResponse.createByErrorMsg("文件不存在请重新上传");
        List<File> list = new ArrayList<>();
        list.add(targetFile);
        try {
            FTPUtil.upload(list);
        } catch (IOException e) {
            logger.error("上传失败{}", e);
            return ServerResponse.createByErrorMsg("上传失败");
        }
        targetFile.delete();

        return ServerResponse.createBySuccess();
    }
}
