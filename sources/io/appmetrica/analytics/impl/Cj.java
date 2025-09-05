package io.appmetrica.analytics.impl;

import java.security.MessageDigest;
/* loaded from: classes4.dex */
public abstract class Cj {
    public static byte[] a(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        return messageDigest.digest();
    }
}
