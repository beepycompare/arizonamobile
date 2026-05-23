package com.google.gson.internal.bind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
@interface IgnoreJRERequirement {
}
