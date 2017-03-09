package com.selbylei.sqlite.anntion;

import android.annotation.TargetApi;

import com.selbylei.sqlite.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by selbylei on 17/3/8.
 */

@Target(ElementType.TYPE)
@Retention(User.CLASS)
public class DbTable {
}
