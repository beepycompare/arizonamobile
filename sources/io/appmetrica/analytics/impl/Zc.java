package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public final class Zc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f736a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Zc("jvm", "binder"));
        EnumC0628ub enumC0628ub2 = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Zc("jvm", "file"));
        EnumC0628ub enumC0628ub3 = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Zc("jvm", "file"));
        EnumC0628ub enumC0628ub4 = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Zc("jni_native", "file"));
        EnumC0628ub enumC0628ub5 = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Zc("jni_native", "file"));
    }

    public Zc(String str, String str2) {
        this.f736a = str;
        this.b = str2;
    }
}
