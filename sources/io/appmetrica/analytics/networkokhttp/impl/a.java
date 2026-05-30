package io.appmetrica.analytics.networkokhttp.impl;

import io.appmetrica.analytics.networkapi.Request;
/* loaded from: classes5.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1378a;

    static {
        int[] iArr = new int[Request.Method.values().length];
        try {
            iArr[Request.Method.GET.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[Request.Method.HEAD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[Request.Method.POST.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[Request.Method.PUT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[Request.Method.PATCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[Request.Method.DELETE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[Request.Method.OPTIONS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        f1378a = iArr;
    }
}
