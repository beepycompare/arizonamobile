package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0301hd {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f1013a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C0301hd("jvm", "binder"));
        Db db2 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new C0301hd("jvm", "file"));
        Db db3 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new C0301hd("jvm", "file"));
        Db db4 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new C0301hd("jni_native", "file"));
        Db db5 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new C0301hd("jni_native", "file"));
    }

    public C0301hd(String str, String str2) {
        this.f1013a = str;
        this.b = str2;
    }
}
