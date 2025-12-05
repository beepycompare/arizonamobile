package io.appmetrica.analytics.impl;

import java.security.MessageDigest;
/* renamed from: io.appmetrica.analytics.impl.hj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0301hj {
    public static byte[] a(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        return messageDigest.digest();
    }
}
