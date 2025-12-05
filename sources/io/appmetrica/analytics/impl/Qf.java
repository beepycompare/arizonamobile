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
    public static final Map f733a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Wk wk = Wk.FOREGROUND;
        hashMap.put(wk, 0);
        Wk wk2 = Wk.BACKGROUND;
        hashMap.put(wk2, 1);
        f733a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, wk);
        sparseArray.put(1, wk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0164cb, 1);
        EnumC0164cb enumC0164cb2 = EnumC0164cb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0164cb2, 4);
        EnumC0164cb enumC0164cb3 = EnumC0164cb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0164cb3, 5);
        EnumC0164cb enumC0164cb4 = EnumC0164cb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0164cb4, 7);
        EnumC0164cb enumC0164cb5 = EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0164cb5, 26);
        EnumC0164cb enumC0164cb6 = EnumC0164cb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0164cb6, 26);
        EnumC0164cb enumC0164cb7 = EnumC0164cb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0164cb7, 26);
        EnumC0164cb enumC0164cb8 = EnumC0164cb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0164cb8, 25);
        EnumC0164cb enumC0164cb9 = EnumC0164cb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0164cb9, 26);
        EnumC0164cb enumC0164cb10 = EnumC0164cb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0164cb10, 26);
        EnumC0164cb enumC0164cb11 = EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0164cb11, 27);
        EnumC0164cb enumC0164cb12 = EnumC0164cb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0164cb12, 27);
        EnumC0164cb enumC0164cb13 = EnumC0164cb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0164cb13, 13);
        EnumC0164cb enumC0164cb14 = EnumC0164cb.EVENT_TYPE_START;
        hashMap2.put(enumC0164cb14, 2);
        EnumC0164cb enumC0164cb15 = EnumC0164cb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0164cb15, 16);
        EnumC0164cb enumC0164cb16 = EnumC0164cb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0164cb16, 17);
        EnumC0164cb enumC0164cb17 = EnumC0164cb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0164cb17, 18);
        EnumC0164cb enumC0164cb18 = EnumC0164cb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0164cb18, 19);
        EnumC0164cb enumC0164cb19 = EnumC0164cb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0164cb19, 20);
        EnumC0164cb enumC0164cb20 = EnumC0164cb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0164cb20, 21);
        EnumC0164cb enumC0164cb21 = EnumC0164cb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0164cb21, 40);
        EnumC0164cb enumC0164cb22 = EnumC0164cb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0164cb22, 35);
        hashMap2.put(EnumC0164cb.EVENT_TYPE_CLEANUP, 29);
        EnumC0164cb enumC0164cb23 = EnumC0164cb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0164cb23, 38);
        EnumC0164cb enumC0164cb24 = EnumC0164cb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0164cb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        C0692x8 c0692x8 = new C0692x8();
        D8 d8 = new D8(new I8());
        C0717y8 c0717y8 = new C0717y8();
        C0182d3 c0182d3 = new C0182d3(new I8());
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
        a4.b = c0182d3;
        V8 v83 = new V8(a4);
        U8 a5 = V8.a();
        a5.b = qn;
        V8 v84 = new V8(a5);
        U8 a6 = V8.a();
        a6.f790a = c0692x8;
        V8 v85 = new V8(a6);
        U8 a7 = V8.a();
        a7.b = new vo(new D8());
        V8 v86 = new V8(a7);
        hashMap3.put(enumC0164cb2, v82);
        U8 a8 = V8.a();
        a8.b = new Of();
        hashMap3.put(enumC0164cb3, new V8(a8));
        U8 a9 = V8.a();
        a9.f790a = c0692x8;
        a9.b = c0717y8;
        a9.e = new X7();
        a9.f = new Y7();
        hashMap3.put(enumC0164cb4, new V8(a9));
        hashMap3.put(enumC0164cb9, v8);
        hashMap3.put(enumC0164cb10, v8);
        hashMap3.put(enumC0164cb11, v83);
        hashMap3.put(enumC0164cb12, v83);
        hashMap3.put(enumC0164cb5, v83);
        hashMap3.put(enumC0164cb6, v83);
        hashMap3.put(enumC0164cb7, v83);
        hashMap3.put(enumC0164cb8, v83);
        U8 a10 = V8.a();
        a10.f790a = new C0692x8();
        a10.b = c0182d3;
        hashMap3.put(enumC0164cb14, new V8(a10));
        EnumC0164cb enumC0164cb25 = EnumC0164cb.EVENT_TYPE_CUSTOM_EVENT;
        U8 a11 = V8.a();
        a11.d = new Pf();
        hashMap3.put(enumC0164cb25, new V8(a11));
        hashMap3.put(enumC0164cb15, v82);
        hashMap3.put(enumC0164cb17, v85);
        hashMap3.put(enumC0164cb18, v85);
        hashMap3.put(enumC0164cb19, v83);
        hashMap3.put(enumC0164cb20, v83);
        hashMap3.put(enumC0164cb21, v83);
        hashMap3.put(enumC0164cb22, v84);
        hashMap3.put(enumC0164cb, v86);
        hashMap3.put(enumC0164cb16, v86);
        hashMap3.put(enumC0164cb13, v82);
        hashMap3.put(enumC0164cb23, v82);
        hashMap3.put(enumC0164cb24, v83);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C0342j9 a(Long l, Long l2, Boolean bool) {
        C0342j9 c0342j9 = new C0342j9();
        if (l != null) {
            c0342j9.f1036a = l.longValue();
            c0342j9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c0342j9.c = l2.longValue();
        }
        if (bool != null) {
            c0342j9.d = bool.booleanValue();
        }
        return c0342j9;
    }

    public static void a(C0291h9 c0291h9) {
        C0239f9[] c0239f9Arr = c0291h9.c;
        if (c0239f9Arr != null) {
            for (C0239f9 c0239f9 : c0239f9Arr) {
            }
        }
    }
}
