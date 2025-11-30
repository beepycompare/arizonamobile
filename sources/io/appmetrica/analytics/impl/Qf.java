package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class Qf {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f650a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Wk wk = Wk.FOREGROUND;
        hashMap.put(wk, 0);
        Wk wk2 = Wk.BACKGROUND;
        hashMap.put(wk2, 1);
        f650a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, wk);
        sparseArray.put(1, wk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0165cb, 1);
        EnumC0165cb enumC0165cb2 = EnumC0165cb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0165cb2, 4);
        EnumC0165cb enumC0165cb3 = EnumC0165cb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0165cb3, 5);
        EnumC0165cb enumC0165cb4 = EnumC0165cb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0165cb4, 7);
        EnumC0165cb enumC0165cb5 = EnumC0165cb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0165cb5, 26);
        EnumC0165cb enumC0165cb6 = EnumC0165cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0165cb6, 26);
        EnumC0165cb enumC0165cb7 = EnumC0165cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0165cb7, 26);
        EnumC0165cb enumC0165cb8 = EnumC0165cb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0165cb8, 25);
        EnumC0165cb enumC0165cb9 = EnumC0165cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0165cb9, 26);
        EnumC0165cb enumC0165cb10 = EnumC0165cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0165cb10, 26);
        EnumC0165cb enumC0165cb11 = EnumC0165cb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0165cb11, 27);
        EnumC0165cb enumC0165cb12 = EnumC0165cb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0165cb12, 27);
        EnumC0165cb enumC0165cb13 = EnumC0165cb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0165cb13, 13);
        EnumC0165cb enumC0165cb14 = EnumC0165cb.EVENT_TYPE_START;
        hashMap2.put(enumC0165cb14, 2);
        EnumC0165cb enumC0165cb15 = EnumC0165cb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0165cb15, 16);
        EnumC0165cb enumC0165cb16 = EnumC0165cb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0165cb16, 17);
        EnumC0165cb enumC0165cb17 = EnumC0165cb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0165cb17, 18);
        EnumC0165cb enumC0165cb18 = EnumC0165cb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0165cb18, 19);
        EnumC0165cb enumC0165cb19 = EnumC0165cb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0165cb19, 20);
        EnumC0165cb enumC0165cb20 = EnumC0165cb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0165cb20, 21);
        EnumC0165cb enumC0165cb21 = EnumC0165cb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0165cb21, 40);
        EnumC0165cb enumC0165cb22 = EnumC0165cb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0165cb22, 35);
        hashMap2.put(EnumC0165cb.EVENT_TYPE_CLEANUP, 29);
        EnumC0165cb enumC0165cb23 = EnumC0165cb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0165cb23, 38);
        EnumC0165cb enumC0165cb24 = EnumC0165cb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0165cb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        C0693x8 c0693x8 = new C0693x8();
        D8 d8 = new D8(new I8());
        C0718y8 c0718y8 = new C0718y8();
        C0183d3 c0183d3 = new C0183d3(new I8());
        Qn qn = new Qn(new I8());
        Mf mf = new Mf();
        U8 a2 = V8.a();
        a2.b = mf;
        a2.c = mf;
        V8 v8 = new V8(a2);
        U8 a3 = V8.a();
        a3.b = d8;
        V8 v82 = new V8(a3);
        U8 a4 = V8.a();
        a4.b = c0183d3;
        V8 v83 = new V8(a4);
        U8 a5 = V8.a();
        a5.b = qn;
        V8 v84 = new V8(a5);
        U8 a6 = V8.a();
        a6.f707a = c0693x8;
        V8 v85 = new V8(a6);
        U8 a7 = V8.a();
        a7.b = new vo(new D8());
        V8 v86 = new V8(a7);
        hashMap3.put(enumC0165cb2, v82);
        U8 a8 = V8.a();
        a8.b = new Of();
        hashMap3.put(enumC0165cb3, new V8(a8));
        U8 a9 = V8.a();
        a9.f707a = c0693x8;
        a9.b = c0718y8;
        a9.e = new X7();
        a9.f = new Y7();
        hashMap3.put(enumC0165cb4, new V8(a9));
        hashMap3.put(enumC0165cb9, v8);
        hashMap3.put(enumC0165cb10, v8);
        hashMap3.put(enumC0165cb11, v83);
        hashMap3.put(enumC0165cb12, v83);
        hashMap3.put(enumC0165cb5, v83);
        hashMap3.put(enumC0165cb6, v83);
        hashMap3.put(enumC0165cb7, v83);
        hashMap3.put(enumC0165cb8, v83);
        U8 a10 = V8.a();
        a10.f707a = new C0693x8();
        a10.b = c0183d3;
        hashMap3.put(enumC0165cb14, new V8(a10));
        EnumC0165cb enumC0165cb25 = EnumC0165cb.EVENT_TYPE_CUSTOM_EVENT;
        U8 a11 = V8.a();
        a11.d = new Pf();
        hashMap3.put(enumC0165cb25, new V8(a11));
        hashMap3.put(enumC0165cb15, v82);
        hashMap3.put(enumC0165cb17, v85);
        hashMap3.put(enumC0165cb18, v85);
        hashMap3.put(enumC0165cb19, v83);
        hashMap3.put(enumC0165cb20, v83);
        hashMap3.put(enumC0165cb21, v83);
        hashMap3.put(enumC0165cb22, v84);
        hashMap3.put(enumC0165cb, v86);
        hashMap3.put(enumC0165cb16, v86);
        hashMap3.put(enumC0165cb13, v82);
        hashMap3.put(enumC0165cb23, v82);
        hashMap3.put(enumC0165cb24, v83);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C0343j9 a(Long l, Long l2, Boolean bool) {
        C0343j9 c0343j9 = new C0343j9();
        if (l != null) {
            c0343j9.f953a = l.longValue();
            c0343j9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c0343j9.c = l2.longValue();
        }
        if (bool != null) {
            c0343j9.d = bool.booleanValue();
        }
        return c0343j9;
    }

    public static void a(C0292h9 c0292h9) {
        C0240f9[] c0240f9Arr = c0292h9.c;
        if (c0240f9Arr != null) {
            for (C0240f9 c0240f9 : c0240f9Arr) {
            }
        }
    }
}
