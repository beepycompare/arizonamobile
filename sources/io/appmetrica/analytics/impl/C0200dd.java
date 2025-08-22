package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.dd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0200dd {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f829a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C0200dd("jvm", "binder"));
        EnumC0728yb enumC0728yb2 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new C0200dd("jvm", "file"));
        EnumC0728yb enumC0728yb3 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new C0200dd("jvm", "file"));
        EnumC0728yb enumC0728yb4 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new C0200dd("jni_native", "file"));
        EnumC0728yb enumC0728yb5 = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new C0200dd("jni_native", "file"));
    }

    public C0200dd(String str, String str2) {
        this.f829a = str;
        this.b = str2;
    }
}
