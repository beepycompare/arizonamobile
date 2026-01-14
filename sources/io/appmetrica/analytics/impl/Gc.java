package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class Gc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f595a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Gc("jvm", "binder"));
        EnumC0143bb enumC0143bb2 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Gc("jvm", "file"));
        EnumC0143bb enumC0143bb3 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Gc("jvm", "file"));
        EnumC0143bb enumC0143bb4 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Gc("jni_native", "file"));
        EnumC0143bb enumC0143bb5 = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Gc("jni_native", "file"));
    }

    public Gc(String str, String str2) {
        this.f595a = str;
        this.b = str2;
    }
}
