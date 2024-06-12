package com.pandora.jpx.handler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pandora.jpx.model.FileBucket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MangaCrawler {

    @Value("${base.python-home}")
    private String PYTHON_HOME;

    private final String script = "manhuaren.py";

    public List<FileBucket> process(String... argv) {
        Process process = null;
        ProcessBuilder processBuilder = new ProcessBuilder(PYTHON_HOME, resolveScriptPath(script));
        processBuilder.command().addAll(Arrays.asList(argv)); // add arguments
        processBuilder.redirectErrorStream(true);
        List<FileBucket> resultList = null;

        try {
            log.info("Starting script: {} {}", script, argv);
            process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                resultList = readProcessOutput(process.getInputStream());
                log.info("Total: {} files", resultList.size());
            } else {
                log.error(readErrorMsg(process.getInputStream()));
            }
        } catch (Exception e) {
            log.error("Failed to execute python script", e);
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
        return resultList;
    }

    private List<FileBucket> readProcessOutput(InputStream inputStream) {
        String[] results = new BufferedReader(new InputStreamReader(inputStream))
                .lines().toArray(String[]::new);

        List<FileBucket> fileList = new ArrayList<>();
        for (int i = 1, len = results.length; i < len; i++) {
            FileBucket file = new FileBucket();
            file.setName(results[0]);
            file.setSource(results[i]);
            file.setContent(getImageFromUrl(results[i]));
            fileList.add(file);
        }
        return fileList;
    }

    private String readErrorMsg(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    private String resolveScriptPath(String fileName) {
        return (new File("script/" + fileName)).getAbsolutePath();
    }

    private byte[] getImageFromUrl(String url) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] byteChunk = new byte[4096];
        int n;
        try {
            inputStream = (new URL(url)).openStream();
            while ((n = inputStream.read(byteChunk)) > 0) {
                outputStream.write(byteChunk, 0, n);
            }
            inputStream.close();
        } catch (IOException e) {
            log.error("Failed while reading bytes from: " + url, e);
        }
        return outputStream.toByteArray();
    }

}
