package com.example.group_5_project;

import android.content.Context;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import androidx.test.*;
import androidx.test.core.app.ApplicationProvider;


public class CheckUserTest extends TestCase {

    @Test
    public void testSharedPreferences(){

        Context context = ApplicationProvider.getApplicationContext();
        Assert.assertTrue(context.getSharedPreferences("userData", Context.MODE_PRIVATE).contains("userName"));
    }



}