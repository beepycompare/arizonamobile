package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0530qg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f1169a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Al al = Al.FOREGROUND;
        hashMap.put(al, 0);
        Al al2 = Al.BACKGROUND;
        hashMap.put(al2, 1);
        f1169a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, al);
        sparseArray.put(1, al2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        Db db = Db.EVENT_TYPE_INIT;
        hashMap2.put(db, 1);
        Db db2 = Db.EVENT_TYPE_REGULAR;
        hashMap2.put(db2, 4);
        Db db3 = Db.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(db3, 5);
        Db db4 = Db.EVENT_TYPE_ALIVE;
        hashMap2.put(db4, 7);
        Db db5 = Db.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(db5, 26);
        Db db6 = Db.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(db6, 26);
        Db db7 = Db.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(db7, 26);
        Db db8 = Db.EVENT_TYPE_ANR;
        hashMap2.put(db8, 25);
        Db db9 = Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(db9, 26);
        Db db10 = Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(db10, 26);
        Db db11 = Db.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(db11, 27);
        Db db12 = Db.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(db12, 27);
        Db db13 = Db.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(db13, 13);
        Db db14 = Db.EVENT_TYPE_START;
        hashMap2.put(db14, 2);
        Db db15 = Db.EVENT_TYPE_APP_OPEN;
        hashMap2.put(db15, 16);
        Db db16 = Db.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(db16, 17);
        Db db17 = Db.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(db17, 18);
        Db db18 = Db.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(db18, 19);
        Db db19 = Db.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(db19, 20);
        Db db20 = Db.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(db20, 21);
        Db db21 = Db.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(db21, 40);
        Db db22 = Db.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(db22, 35);
        hashMap2.put(Db.EVENT_TYPE_CLEANUP, 29);
        Db db23 = Db.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(db23, 38);
        Db db24 = Db.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(db24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        P8 p8 = new P8();
        V8 v8 = new V8(new C0135b9());
        Q8 q8 = new Q8();
        C0568s3 c0568s3 = new C0568s3(new C0135b9());
        C0589so c0589so = new C0589so(new C0135b9());
        C0426mg c0426mg = new C0426mg();
        C0445n9 a2 = C0471o9.a();
        a2.b = c0426mg;
        a2.c = c0426mg;
        C0471o9 c0471o9 = new C0471o9(a2);
        C0445n9 a3 = C0471o9.a();
        a3.b = v8;
        C0471o9 c0471o92 = new C0471o9(a3);
        C0445n9 a4 = C0471o9.a();
        a4.b = c0568s3;
        C0471o9 c0471o93 = new C0471o9(a4);
        C0445n9 a5 = C0471o9.a();
        a5.b = c0589so;
        C0471o9 c0471o94 = new C0471o9(a5);
        C0445n9 a6 = C0471o9.a();
        a6.f1117a = p8;
        C0471o9 c0471o95 = new C0471o9(a6);
        C0445n9 a7 = C0471o9.a();
        a7.b = new Xo(new V8());
        C0471o9 c0471o96 = new C0471o9(a7);
        hashMap3.put(db2, c0471o92);
        C0445n9 a8 = C0471o9.a();
        a8.b = new C0478og();
        hashMap3.put(db3, new C0471o9(a8));
        C0445n9 a9 = C0471o9.a();
        a9.f1117a = p8;
        a9.b = q8;
        a9.e = new C0496p8();
        a9.f = new C0522q8();
        hashMap3.put(db4, new C0471o9(a9));
        hashMap3.put(db9, c0471o9);
        hashMap3.put(db10, c0471o9);
        hashMap3.put(db11, c0471o93);
        hashMap3.put(db12, c0471o93);
        hashMap3.put(db5, c0471o93);
        hashMap3.put(db6, c0471o93);
        hashMap3.put(db7, c0471o93);
        hashMap3.put(db8, c0471o93);
        C0445n9 a10 = C0471o9.a();
        a10.f1117a = new P8();
        a10.b = c0568s3;
        hashMap3.put(db14, new C0471o9(a10));
        Db db25 = Db.EVENT_TYPE_CUSTOM_EVENT;
        C0445n9 a11 = C0471o9.a();
        a11.d = new C0504pg();
        hashMap3.put(db25, new C0471o9(a11));
        hashMap3.put(db15, c0471o92);
        hashMap3.put(db17, c0471o95);
        hashMap3.put(db18, c0471o95);
        hashMap3.put(db19, c0471o93);
        hashMap3.put(db20, c0471o93);
        hashMap3.put(db21, c0471o93);
        hashMap3.put(db22, c0471o94);
        hashMap3.put(db, c0471o96);
        hashMap3.put(db16, c0471o96);
        hashMap3.put(db13, c0471o92);
        hashMap3.put(db23, c0471o92);
        hashMap3.put(db24, c0471o93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C9 a(Long l, Long l2, Boolean bool) {
        C9 c9 = new C9();
        if (l != null) {
            c9.f497a = l.longValue();
            c9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c9.c = l2.longValue();
        }
        if (bool != null) {
            c9.d = bool.booleanValue();
        }
        return c9;
    }
}
