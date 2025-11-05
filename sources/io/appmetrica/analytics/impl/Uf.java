package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class Uf {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f719a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        EnumC0123al enumC0123al = EnumC0123al.FOREGROUND;
        hashMap.put(enumC0123al, 0);
        EnumC0123al enumC0123al2 = EnumC0123al.BACKGROUND;
        hashMap.put(enumC0123al2, 1);
        f719a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, enumC0123al);
        sparseArray.put(1, enumC0123al2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_INIT;
        hashMap2.put(enumC0320ib, 1);
        EnumC0320ib enumC0320ib2 = EnumC0320ib.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0320ib2, 4);
        EnumC0320ib enumC0320ib3 = EnumC0320ib.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0320ib3, 5);
        EnumC0320ib enumC0320ib4 = EnumC0320ib.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0320ib4, 7);
        EnumC0320ib enumC0320ib5 = EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0320ib5, 26);
        EnumC0320ib enumC0320ib6 = EnumC0320ib.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0320ib6, 26);
        EnumC0320ib enumC0320ib7 = EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0320ib7, 26);
        EnumC0320ib enumC0320ib8 = EnumC0320ib.EVENT_TYPE_ANR;
        hashMap2.put(enumC0320ib8, 25);
        EnumC0320ib enumC0320ib9 = EnumC0320ib.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0320ib9, 26);
        EnumC0320ib enumC0320ib10 = EnumC0320ib.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0320ib10, 26);
        EnumC0320ib enumC0320ib11 = EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0320ib11, 27);
        EnumC0320ib enumC0320ib12 = EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0320ib12, 27);
        EnumC0320ib enumC0320ib13 = EnumC0320ib.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0320ib13, 13);
        EnumC0320ib enumC0320ib14 = EnumC0320ib.EVENT_TYPE_START;
        hashMap2.put(enumC0320ib14, 2);
        EnumC0320ib enumC0320ib15 = EnumC0320ib.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0320ib15, 16);
        EnumC0320ib enumC0320ib16 = EnumC0320ib.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0320ib16, 17);
        EnumC0320ib enumC0320ib17 = EnumC0320ib.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0320ib17, 18);
        EnumC0320ib enumC0320ib18 = EnumC0320ib.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0320ib18, 19);
        EnumC0320ib enumC0320ib19 = EnumC0320ib.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0320ib19, 20);
        EnumC0320ib enumC0320ib20 = EnumC0320ib.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0320ib20, 21);
        EnumC0320ib enumC0320ib21 = EnumC0320ib.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0320ib21, 40);
        EnumC0320ib enumC0320ib22 = EnumC0320ib.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0320ib22, 35);
        hashMap2.put(EnumC0320ib.EVENT_TYPE_CLEANUP, 29);
        EnumC0320ib enumC0320ib23 = EnumC0320ib.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0320ib23, 38);
        EnumC0320ib enumC0320ib24 = EnumC0320ib.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0320ib24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        B8 b8 = new B8();
        H8 h8 = new H8(new M8());
        C8 c8 = new C8();
        C0363k3 c0363k3 = new C0363k3(new M8());
        Rn rn = new Rn(new M8());
        Qf qf = new Qf();
        C0111a9 a2 = C0137b9.a();
        a2.b = qf;
        a2.c = qf;
        C0137b9 c0137b9 = new C0137b9(a2);
        C0111a9 a3 = C0137b9.a();
        a3.b = h8;
        C0137b9 c0137b92 = new C0137b9(a3);
        C0111a9 a4 = C0137b9.a();
        a4.b = c0363k3;
        C0137b9 c0137b93 = new C0137b9(a4);
        C0111a9 a5 = C0137b9.a();
        a5.b = rn;
        C0137b9 c0137b94 = new C0137b9(a5);
        C0111a9 a6 = C0137b9.a();
        a6.f799a = b8;
        C0137b9 c0137b95 = new C0137b9(a6);
        C0111a9 a7 = C0137b9.a();
        a7.b = new wo(new H8());
        C0137b9 c0137b96 = new C0137b9(a7);
        hashMap3.put(enumC0320ib2, c0137b92);
        C0111a9 a8 = C0137b9.a();
        a8.b = new Sf();
        hashMap3.put(enumC0320ib3, new C0137b9(a8));
        C0111a9 a9 = C0137b9.a();
        a9.f799a = b8;
        a9.b = c8;
        a9.e = new C0162c8();
        a9.f = new C0188d8();
        hashMap3.put(enumC0320ib4, new C0137b9(a9));
        hashMap3.put(enumC0320ib9, c0137b9);
        hashMap3.put(enumC0320ib10, c0137b9);
        hashMap3.put(enumC0320ib11, c0137b93);
        hashMap3.put(enumC0320ib12, c0137b93);
        hashMap3.put(enumC0320ib5, c0137b93);
        hashMap3.put(enumC0320ib6, c0137b93);
        hashMap3.put(enumC0320ib7, c0137b93);
        hashMap3.put(enumC0320ib8, c0137b93);
        C0111a9 a10 = C0137b9.a();
        a10.f799a = new B8();
        a10.b = c0363k3;
        hashMap3.put(enumC0320ib14, new C0137b9(a10));
        EnumC0320ib enumC0320ib25 = EnumC0320ib.EVENT_TYPE_CUSTOM_EVENT;
        C0111a9 a11 = C0137b9.a();
        a11.d = new Tf();
        hashMap3.put(enumC0320ib25, new C0137b9(a11));
        hashMap3.put(enumC0320ib15, c0137b92);
        hashMap3.put(enumC0320ib17, c0137b95);
        hashMap3.put(enumC0320ib18, c0137b95);
        hashMap3.put(enumC0320ib19, c0137b93);
        hashMap3.put(enumC0320ib20, c0137b93);
        hashMap3.put(enumC0320ib21, c0137b93);
        hashMap3.put(enumC0320ib22, c0137b94);
        hashMap3.put(enumC0320ib, c0137b96);
        hashMap3.put(enumC0320ib16, c0137b96);
        hashMap3.put(enumC0320ib13, c0137b92);
        hashMap3.put(enumC0320ib23, c0137b92);
        hashMap3.put(enumC0320ib24, c0137b93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static C0495p9 a(Long l, Long l2, Boolean bool) {
        C0495p9 c0495p9 = new C0495p9();
        if (l != null) {
            c0495p9.f1054a = l.longValue();
            c0495p9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            c0495p9.c = l2.longValue();
        }
        if (bool != null) {
            c0495p9.d = bool.booleanValue();
        }
        return c0495p9;
    }

    public static void a(C0445n9 c0445n9) {
        C0395l9[] c0395l9Arr = c0445n9.c;
        if (c0395l9Arr != null) {
            for (C0395l9 c0395l9 : c0395l9Arr) {
            }
        }
    }
}
