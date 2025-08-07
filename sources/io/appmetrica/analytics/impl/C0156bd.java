package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.bd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0156bd {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f782a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C0156bd("jvm", "binder"));
        EnumC0681wb enumC0681wb2 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new C0156bd("jvm", "file"));
        EnumC0681wb enumC0681wb3 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new C0156bd("jvm", "file"));
        EnumC0681wb enumC0681wb4 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new C0156bd("jni_native", "file"));
        EnumC0681wb enumC0681wb5 = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new C0156bd("jni_native", "file"));
    }

    public C0156bd(String str, String str2) {
        this.f782a = str;
        this.b = str2;
    }
}
