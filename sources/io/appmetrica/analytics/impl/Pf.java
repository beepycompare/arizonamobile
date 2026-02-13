package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class Pf {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f738a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Vk vk = Vk.FOREGROUND;
        hashMap.put(vk, 0);
        Vk vk2 = Vk.BACKGROUND;
        hashMap.put(vk2, 1);
        f738a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, vk);
        sparseArray.put(1, vk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0143bb, 1);
        EnumC0143bb enumC0143bb2 = EnumC0143bb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0143bb2, 4);
        EnumC0143bb enumC0143bb3 = EnumC0143bb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0143bb3, 5);
        EnumC0143bb enumC0143bb4 = EnumC0143bb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0143bb4, 7);
        EnumC0143bb enumC0143bb5 = EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0143bb5, 26);
        EnumC0143bb enumC0143bb6 = EnumC0143bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0143bb6, 26);
        EnumC0143bb enumC0143bb7 = EnumC0143bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0143bb7, 26);
        EnumC0143bb enumC0143bb8 = EnumC0143bb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0143bb8, 25);
        EnumC0143bb enumC0143bb9 = EnumC0143bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0143bb9, 26);
        EnumC0143bb enumC0143bb10 = EnumC0143bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0143bb10, 26);
        EnumC0143bb enumC0143bb11 = EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0143bb11, 27);
        EnumC0143bb enumC0143bb12 = EnumC0143bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0143bb12, 27);
        EnumC0143bb enumC0143bb13 = EnumC0143bb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0143bb13, 13);
        EnumC0143bb enumC0143bb14 = EnumC0143bb.EVENT_TYPE_START;
        hashMap2.put(enumC0143bb14, 2);
        EnumC0143bb enumC0143bb15 = EnumC0143bb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0143bb15, 16);
        EnumC0143bb enumC0143bb16 = EnumC0143bb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0143bb16, 17);
        EnumC0143bb enumC0143bb17 = EnumC0143bb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0143bb17, 18);
        EnumC0143bb enumC0143bb18 = EnumC0143bb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0143bb18, 19);
        EnumC0143bb enumC0143bb19 = EnumC0143bb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0143bb19, 20);
        EnumC0143bb enumC0143bb20 = EnumC0143bb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0143bb20, 21);
        EnumC0143bb enumC0143bb21 = EnumC0143bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0143bb21, 40);
        EnumC0143bb enumC0143bb22 = EnumC0143bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0143bb22, 35);
        hashMap2.put(EnumC0143bb.EVENT_TYPE_CLEANUP, 29);
        EnumC0143bb enumC0143bb23 = EnumC0143bb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0143bb23, 38);
        EnumC0143bb enumC0143bb24 = EnumC0143bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0143bb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        C0671w8 c0671w8 = new C0671w8();
        C8 c8 = new C8(new H8());
        C0696x8 c0696x8 = new C0696x8();
        C0161c3 c0161c3 = new C0161c3(new H8());
        Pn pn = new Pn(new H8());
        Lf lf = new Lf();
        T8 a2 = U8.a();
        a2.b = lf;
        a2.c = lf;
        U8 u8 = new U8(a2);
        T8 a3 = U8.a();
        a3.b = c8;
        U8 u82 = new U8(a3);
        T8 a4 = U8.a();
        a4.b = c0161c3;
        U8 u83 = new U8(a4);
        T8 a5 = U8.a();
        a5.b = pn;
        U8 u84 = new U8(a5);
        T8 a6 = U8.a();
        a6.f795a = c0671w8;
        U8 u85 = new U8(a6);
        T8 a7 = U8.a();
        a7.b = new uo(new C8());
        U8 u86 = new U8(a7);
        hashMap3.put(enumC0143bb2, u82);
        T8 a8 = U8.a();
        a8.b = new Nf();
        hashMap3.put(enumC0143bb3, new U8(a8));
        T8 a9 = U8.a();
        a9.f795a = c0671w8;
        a9.b = c0696x8;
        a9.e = new W7();
        a9.f = new X7();
        hashMap3.put(enumC0143bb4, new U8(a9));
        hashMap3.put(enumC0143bb9, u8);
        hashMap3.put(enumC0143bb10, u8);
        hashMap3.put(enumC0143bb11, u83);
        hashMap3.put(enumC0143bb12, u83);
        hashMap3.put(enumC0143bb5, u83);
        hashMap3.put(enumC0143bb6, u83);
        hashMap3.put(enumC0143bb7, u83);
        hashMap3.put(enumC0143bb8, u83);
        T8 a10 = U8.a();
        a10.f795a = new C0671w8();
        a10.b = c0161c3;
        hashMap3.put(enumC0143bb14, new U8(a10));
        EnumC0143bb enumC0143bb25 = EnumC0143bb.EVENT_TYPE_CUSTOM_EVENT;
        T8 a11 = U8.a();
        a11.d = new Of();
        hashMap3.put(enumC0143bb25, new U8(a11));
        hashMap3.put(enumC0143bb15, u82);
        hashMap3.put(enumC0143bb17, u85);
        hashMap3.put(enumC0143bb18, u85);
        hashMap3.put(enumC0143bb19, u83);
        hashMap3.put(enumC0143bb20, u83);
        hashMap3.put(enumC0143bb21, u83);
        hashMap3.put(enumC0143bb22, u84);
        hashMap3.put(enumC0143bb, u86);
        hashMap3.put(enumC0143bb16, u86);
        hashMap3.put(enumC0143bb13, u82);
        hashMap3.put(enumC0143bb23, u82);
        hashMap3.put(enumC0143bb24, u83);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C0322i9 a(Long l, Long l2, Boolean bool) {
        C0322i9 c0322i9 = new C0322i9();
        if (l != null) {
            c0322i9.f1041a = l.longValue();
            c0322i9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c0322i9.c = l2.longValue();
        }
        if (bool != null) {
            c0322i9.d = bool.booleanValue();
        }
        return c0322i9;
    }

    public static void a(C0270g9 c0270g9) {
        C0218e9[] c0218e9Arr = c0270g9.c;
        if (c0218e9Arr != null) {
            for (C0218e9 c0218e9 : c0218e9Arr) {
            }
        }
    }
}
