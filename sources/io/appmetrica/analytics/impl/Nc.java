package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class Nc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f605a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Nc("jvm", "binder"));
        EnumC0320ib enumC0320ib2 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Nc("jvm", "file"));
        EnumC0320ib enumC0320ib3 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Nc("jvm", "file"));
        EnumC0320ib enumC0320ib4 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Nc("jni_native", "file"));
        EnumC0320ib enumC0320ib5 = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Nc("jni_native", "file"));
    }

    public Nc(String str, String str2) {
        this.f605a = str;
        this.b = str2;
    }
}
