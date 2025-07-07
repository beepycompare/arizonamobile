package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public final class Zc {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f735a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new Zc("jvm", "binder"));
        EnumC0636ub enumC0636ub2 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new Zc("jvm", "file"));
        EnumC0636ub enumC0636ub3 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new Zc("jvm", "file"));
        EnumC0636ub enumC0636ub4 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new Zc("jni_native", "file"));
        EnumC0636ub enumC0636ub5 = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new Zc("jni_native", "file"));
    }

    public Zc(String str, String str2) {
        this.f735a = str;
        this.b = str2;
    }
}
