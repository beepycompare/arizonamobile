package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0537qg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f1164a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Al al = Al.FOREGROUND;
        hashMap.put(al, 0);
        Al al2 = Al.BACKGROUND;
        hashMap.put(al2, 1);
        f1164a = Collections.unmodifiableMap(hashMap);
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
        V8 v8 = new V8(new C0142b9());
        Q8 q8 = new Q8();
        C0575s3 c0575s3 = new C0575s3(new C0142b9());
        C0596so c0596so = new C0596so(new C0142b9());
        C0433mg c0433mg = new C0433mg();
        C0452n9 a2 = C0478o9.a();
        a2.b = c0433mg;
        a2.c = c0433mg;
        C0478o9 c0478o9 = new C0478o9(a2);
        C0452n9 a3 = C0478o9.a();
        a3.b = v8;
        C0478o9 c0478o92 = new C0478o9(a3);
        C0452n9 a4 = C0478o9.a();
        a4.b = c0575s3;
        C0478o9 c0478o93 = new C0478o9(a4);
        C0452n9 a5 = C0478o9.a();
        a5.b = c0596so;
        C0478o9 c0478o94 = new C0478o9(a5);
        C0452n9 a6 = C0478o9.a();
        a6.f1112a = p8;
        C0478o9 c0478o95 = new C0478o9(a6);
        C0452n9 a7 = C0478o9.a();
        a7.b = new Xo(new V8());
        C0478o9 c0478o96 = new C0478o9(a7);
        hashMap3.put(db2, c0478o92);
        C0452n9 a8 = C0478o9.a();
        a8.b = new C0485og();
        hashMap3.put(db3, new C0478o9(a8));
        C0452n9 a9 = C0478o9.a();
        a9.f1112a = p8;
        a9.b = q8;
        a9.e = new C0503p8();
        a9.f = new C0529q8();
        hashMap3.put(db4, new C0478o9(a9));
        hashMap3.put(db9, c0478o9);
        hashMap3.put(db10, c0478o9);
        hashMap3.put(db11, c0478o93);
        hashMap3.put(db12, c0478o93);
        hashMap3.put(db5, c0478o93);
        hashMap3.put(db6, c0478o93);
        hashMap3.put(db7, c0478o93);
        hashMap3.put(db8, c0478o93);
        C0452n9 a10 = C0478o9.a();
        a10.f1112a = new P8();
        a10.b = c0575s3;
        hashMap3.put(db14, new C0478o9(a10));
        Db db25 = Db.EVENT_TYPE_CUSTOM_EVENT;
        C0452n9 a11 = C0478o9.a();
        a11.d = new C0511pg();
        hashMap3.put(db25, new C0478o9(a11));
        hashMap3.put(db15, c0478o92);
        hashMap3.put(db17, c0478o95);
        hashMap3.put(db18, c0478o95);
        hashMap3.put(db19, c0478o93);
        hashMap3.put(db20, c0478o93);
        hashMap3.put(db21, c0478o93);
        hashMap3.put(db22, c0478o94);
        hashMap3.put(db, c0478o96);
        hashMap3.put(db16, c0478o96);
        hashMap3.put(db13, c0478o92);
        hashMap3.put(db23, c0478o92);
        hashMap3.put(db24, c0478o93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C9 a(Long l, Long l2, Boolean bool) {
        C9 c9 = new C9();
        if (l != null) {
            c9.f492a = l.longValue();
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
