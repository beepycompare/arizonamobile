package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.gd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0277gd {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f890a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C0277gd("jvm", "binder"));
        Bb bb2 = Bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new C0277gd("jvm", "file"));
        Bb bb3 = Bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new C0277gd("jvm", "file"));
        Bb bb4 = Bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new C0277gd("jni_native", "file"));
        Bb bb5 = Bb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new C0277gd("jni_native", "file"));
    }

    public C0277gd(String str, String str2) {
        this.f890a = str;
        this.b = str2;
    }
}
