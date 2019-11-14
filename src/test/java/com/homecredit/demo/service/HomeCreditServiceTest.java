package com.homecredit.demo.service;

import com.homecredit.demo.BaseTest;
import com.homecredit.demo.dto.Modules;
import com.homecredit.demo.exception.ResourceNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class HomeCreditServiceTest extends BaseTest {

    @Autowired
    private HomeCreditService homeCreditService;

    @Test
    public void whenGetUserMenu_thenSuccess() throws IOException {
        List<Modules> listModule = homeCreditService.getUserIdAndModule(12);
        assertEquals("PromoCard",listModule.get(0).getModuleName());
        assertEquals("CategoryCard",listModule.get(1).getModuleName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void whenGetUserMenu_thenFailed() throws IOException {
        homeCreditService.getUserIdAndModule(100);
    }
}
