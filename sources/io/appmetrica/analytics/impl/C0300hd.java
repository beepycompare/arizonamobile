package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import coil3.util.UtilsKt;
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0300hd {
    public static final SparseArray c;

    /* renamed from: a  reason: collision with root package name */
    public final String f1015a;
    public final String b;

    static {
        SparseArray sparseArray = new SparseArray();
        c = sparseArray;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5891, new C0300hd("jvm", "binder"));
        Db db2 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5890, new C0300hd("jvm", UtilsKt.SCHEME_FILE));
        Db db3 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5889, new C0300hd("jvm", UtilsKt.SCHEME_FILE));
        Db db4 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5897, new C0300hd("jni_native", UtilsKt.SCHEME_FILE));
        Db db5 = Db.EVENT_TYPE_UNDEFINED;
        sparseArray.put(5898, new C0300hd("jni_native", UtilsKt.SCHEME_FILE));
    }

    public C0300hd(String str, String str2) {
        this.f1015a = str;
        this.b = str2;
    }
}
