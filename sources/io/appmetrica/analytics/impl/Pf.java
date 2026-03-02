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
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0142bb, 1);
        EnumC0142bb enumC0142bb2 = EnumC0142bb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0142bb2, 4);
        EnumC0142bb enumC0142bb3 = EnumC0142bb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0142bb3, 5);
        EnumC0142bb enumC0142bb4 = EnumC0142bb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0142bb4, 7);
        EnumC0142bb enumC0142bb5 = EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0142bb5, 26);
        EnumC0142bb enumC0142bb6 = EnumC0142bb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0142bb6, 26);
        EnumC0142bb enumC0142bb7 = EnumC0142bb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0142bb7, 26);
        EnumC0142bb enumC0142bb8 = EnumC0142bb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0142bb8, 25);
        EnumC0142bb enumC0142bb9 = EnumC0142bb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0142bb9, 26);
        EnumC0142bb enumC0142bb10 = EnumC0142bb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0142bb10, 26);
        EnumC0142bb enumC0142bb11 = EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0142bb11, 27);
        EnumC0142bb enumC0142bb12 = EnumC0142bb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0142bb12, 27);
        EnumC0142bb enumC0142bb13 = EnumC0142bb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0142bb13, 13);
        EnumC0142bb enumC0142bb14 = EnumC0142bb.EVENT_TYPE_START;
        hashMap2.put(enumC0142bb14, 2);
        EnumC0142bb enumC0142bb15 = EnumC0142bb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0142bb15, 16);
        EnumC0142bb enumC0142bb16 = EnumC0142bb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0142bb16, 17);
        EnumC0142bb enumC0142bb17 = EnumC0142bb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0142bb17, 18);
        EnumC0142bb enumC0142bb18 = EnumC0142bb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0142bb18, 19);
        EnumC0142bb enumC0142bb19 = EnumC0142bb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0142bb19, 20);
        EnumC0142bb enumC0142bb20 = EnumC0142bb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0142bb20, 21);
        EnumC0142bb enumC0142bb21 = EnumC0142bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0142bb21, 40);
        EnumC0142bb enumC0142bb22 = EnumC0142bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0142bb22, 35);
        hashMap2.put(EnumC0142bb.EVENT_TYPE_CLEANUP, 29);
        EnumC0142bb enumC0142bb23 = EnumC0142bb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0142bb23, 38);
        EnumC0142bb enumC0142bb24 = EnumC0142bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0142bb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        C0670w8 c0670w8 = new C0670w8();
        C8 c8 = new C8(new H8());
        C0695x8 c0695x8 = new C0695x8();
        C0160c3 c0160c3 = new C0160c3(new H8());
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
        a4.b = c0160c3;
        U8 u83 = new U8(a4);
        T8 a5 = U8.a();
        a5.b = pn;
        U8 u84 = new U8(a5);
        T8 a6 = U8.a();
        a6.f795a = c0670w8;
        U8 u85 = new U8(a6);
        T8 a7 = U8.a();
        a7.b = new uo(new C8());
        U8 u86 = new U8(a7);
        hashMap3.put(enumC0142bb2, u82);
        T8 a8 = U8.a();
        a8.b = new Nf();
        hashMap3.put(enumC0142bb3, new U8(a8));
        T8 a9 = U8.a();
        a9.f795a = c0670w8;
        a9.b = c0695x8;
        a9.e = new W7();
        a9.f = new X7();
        hashMap3.put(enumC0142bb4, new U8(a9));
        hashMap3.put(enumC0142bb9, u8);
        hashMap3.put(enumC0142bb10, u8);
        hashMap3.put(enumC0142bb11, u83);
        hashMap3.put(enumC0142bb12, u83);
        hashMap3.put(enumC0142bb5, u83);
        hashMap3.put(enumC0142bb6, u83);
        hashMap3.put(enumC0142bb7, u83);
        hashMap3.put(enumC0142bb8, u83);
        T8 a10 = U8.a();
        a10.f795a = new C0670w8();
        a10.b = c0160c3;
        hashMap3.put(enumC0142bb14, new U8(a10));
        EnumC0142bb enumC0142bb25 = EnumC0142bb.EVENT_TYPE_CUSTOM_EVENT;
        T8 a11 = U8.a();
        a11.d = new Of();
        hashMap3.put(enumC0142bb25, new U8(a11));
        hashMap3.put(enumC0142bb15, u82);
        hashMap3.put(enumC0142bb17, u85);
        hashMap3.put(enumC0142bb18, u85);
        hashMap3.put(enumC0142bb19, u83);
        hashMap3.put(enumC0142bb20, u83);
        hashMap3.put(enumC0142bb21, u83);
        hashMap3.put(enumC0142bb22, u84);
        hashMap3.put(enumC0142bb, u86);
        hashMap3.put(enumC0142bb16, u86);
        hashMap3.put(enumC0142bb13, u82);
        hashMap3.put(enumC0142bb23, u82);
        hashMap3.put(enumC0142bb24, u83);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C0321i9 a(Long l, Long l2, Boolean bool) {
        C0321i9 c0321i9 = new C0321i9();
        if (l != null) {
            c0321i9.f1041a = l.longValue();
            c0321i9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c0321i9.c = l2.longValue();
        }
        if (bool != null) {
            c0321i9.d = bool.booleanValue();
        }
        return c0321i9;
    }

    public static void a(C0269g9 c0269g9) {
        C0217e9[] c0217e9Arr = c0269g9.c;
        if (c0217e9Arr != null) {
            for (C0217e9 c0217e9 : c0217e9Arr) {
            }
        }
    }
}
