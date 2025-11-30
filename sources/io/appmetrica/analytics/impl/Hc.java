package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class Hc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f505a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Hc("jvm", "binder"));
        EnumC0165cb enumC0165cb2 = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Hc("jvm", "file"));
        EnumC0165cb enumC0165cb3 = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Hc("jvm", "file"));
        EnumC0165cb enumC0165cb4 = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Hc("jni_native", "file"));
        EnumC0165cb enumC0165cb5 = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Hc("jni_native", "file"));
    }

    public Hc(String str, String str2) {
        this.f505a = str;
        this.b = str2;
    }
}
