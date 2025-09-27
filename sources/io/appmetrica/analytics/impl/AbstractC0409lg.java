package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0409lg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f974a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        EnumC0259fl enumC0259fl = EnumC0259fl.FOREGROUND;
        hashMap.put(enumC0259fl, 0);
        EnumC0259fl enumC0259fl2 = EnumC0259fl.BACKGROUND;
        hashMap.put(enumC0259fl2, 1);
        f974a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, enumC0259fl);
        sparseArray.put(1, enumC0259fl2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        Bb bb = Bb.EVENT_TYPE_INIT;
        hashMap2.put(bb, 1);
        Bb bb2 = Bb.EVENT_TYPE_REGULAR;
        hashMap2.put(bb2, 4);
        Bb bb3 = Bb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(bb3, 5);
        Bb bb4 = Bb.EVENT_TYPE_ALIVE;
        hashMap2.put(bb4, 7);
        Bb bb5 = Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(bb5, 26);
        Bb bb6 = Bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(bb6, 26);
        Bb bb7 = Bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(bb7, 26);
        Bb bb8 = Bb.EVENT_TYPE_ANR;
        hashMap2.put(bb8, 25);
        Bb bb9 = Bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(bb9, 26);
        Bb bb10 = Bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(bb10, 26);
        Bb bb11 = Bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(bb11, 27);
        Bb bb12 = Bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(bb12, 27);
        Bb bb13 = Bb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(bb13, 13);
        Bb bb14 = Bb.EVENT_TYPE_START;
        hashMap2.put(bb14, 2);
        Bb bb15 = Bb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(bb15, 16);
        Bb bb16 = Bb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(bb16, 17);
        Bb bb17 = Bb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(bb17, 18);
        Bb bb18 = Bb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(bb18, 19);
        Bb bb19 = Bb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(bb19, 20);
        Bb bb20 = Bb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(bb20, 21);
        Bb bb21 = Bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(bb21, 40);
        Bb bb22 = Bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(bb22, 35);
        hashMap2.put(Bb.EVENT_TYPE_CLEANUP, 29);
        Bb bb23 = Bb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(bb23, 38);
        Bb bb24 = Bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(bb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        U8 u8 = new U8();
        C0118a9 c0118a9 = new C0118a9(new C0247f9());
        V8 v8 = new V8();
        B3 b3 = new B3(new C0247f9());
        Vn vn = new Vn(new C0247f9());
        C0306hg c0306hg = new C0306hg();
        C0605t9 a2 = C0630u9.a();
        a2.b = c0306hg;
        a2.c = c0306hg;
        C0630u9 c0630u9 = new C0630u9(a2);
        C0605t9 a3 = C0630u9.a();
        a3.b = c0118a9;
        C0630u9 c0630u92 = new C0630u9(a3);
        C0605t9 a4 = C0630u9.a();
        a4.b = b3;
        C0630u9 c0630u93 = new C0630u9(a4);
        C0605t9 a5 = C0630u9.a();
        a5.b = vn;
        C0630u9 c0630u94 = new C0630u9(a5);
        C0605t9 a6 = C0630u9.a();
        a6.f1093a = u8;
        C0630u9 c0630u95 = new C0630u9(a6);
        C0605t9 a7 = C0630u9.a();
        a7.b = new Ao(new C0118a9());
        C0630u9 c0630u96 = new C0630u9(a7);
        hashMap3.put(bb2, c0630u92);
        C0605t9 a8 = C0630u9.a();
        a8.b = new C0357jg();
        hashMap3.put(bb3, new C0630u9(a8));
        C0605t9 a9 = C0630u9.a();
        a9.f1093a = u8;
        a9.b = v8;
        a9.e = new C0654v8();
        a9.f = new C0679w8();
        hashMap3.put(bb4, new C0630u9(a9));
        hashMap3.put(bb9, c0630u9);
        hashMap3.put(bb10, c0630u9);
        hashMap3.put(bb11, c0630u93);
        hashMap3.put(bb12, c0630u93);
        hashMap3.put(bb5, c0630u93);
        hashMap3.put(bb6, c0630u93);
        hashMap3.put(bb7, c0630u93);
        hashMap3.put(bb8, c0630u93);
        C0605t9 a10 = C0630u9.a();
        a10.f1093a = new U8();
        a10.b = b3;
        hashMap3.put(bb14, new C0630u9(a10));
        Bb bb25 = Bb.EVENT_TYPE_CUSTOM_EVENT;
        C0605t9 a11 = C0630u9.a();
        a11.d = new C0383kg();
        hashMap3.put(bb25, new C0630u9(a11));
        hashMap3.put(bb15, c0630u92);
        hashMap3.put(bb17, c0630u95);
        hashMap3.put(bb18, c0630u95);
        hashMap3.put(bb19, c0630u93);
        hashMap3.put(bb20, c0630u93);
        hashMap3.put(bb21, c0630u93);
        hashMap3.put(bb22, c0630u94);
        hashMap3.put(bb, c0630u96);
        hashMap3.put(bb16, c0630u96);
        hashMap3.put(bb13, c0630u92);
        hashMap3.put(bb23, c0630u92);
        hashMap3.put(bb24, c0630u93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static I9 a(Long l, Long l2, Boolean bool) {
        I9 i9 = new I9();
        if (l != null) {
            i9.f494a = l.longValue();
            i9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            i9.c = l2.longValue();
        }
        if (bool != null) {
            i9.d = bool.booleanValue();
        }
        return i9;
    }

    public static void a(G9 g9) {
        E9[] e9Arr = g9.c;
        if (e9Arr != null) {
            for (E9 e9 : e9Arr) {
            }
        }
    }
}
