package ru.khamedov.ildar.store;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class DataLoader implements InitializingBean {
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);




    @Override
    public void afterPropertiesSet() throws Exception {
    }
}