package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class Gc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f594a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Gc("jvm", "binder"));
        EnumC0142bb enumC0142bb2 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Gc("jvm", "file"));
        EnumC0142bb enumC0142bb3 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Gc("jvm", "file"));
        EnumC0142bb enumC0142bb4 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Gc("jni_native", "file"));
        EnumC0142bb enumC0142bb5 = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Gc("jni_native", "file"));
    }

    public Gc(String str, String str2) {
        this.f594a = str;
        this.b = str2;
    }
}
