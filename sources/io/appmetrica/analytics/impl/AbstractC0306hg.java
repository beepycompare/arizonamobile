package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0306hg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f889a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        EnumC0156bl enumC0156bl = EnumC0156bl.FOREGROUND;
        hashMap.put(enumC0156bl, 0);
        EnumC0156bl enumC0156bl2 = EnumC0156bl.BACKGROUND;
        hashMap.put(enumC0156bl2, 1);
        f889a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, enumC0156bl);
        sparseArray.put(1, enumC0156bl2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0728yb, 1);
        EnumC0728yb enumC0728yb2 = EnumC0728yb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0728yb2, 4);
        EnumC0728yb enumC0728yb3 = EnumC0728yb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0728yb3, 5);
        EnumC0728yb enumC0728yb4 = EnumC0728yb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0728yb4, 7);
        EnumC0728yb enumC0728yb5 = EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0728yb5, 26);
        EnumC0728yb enumC0728yb6 = EnumC0728yb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0728yb6, 26);
        EnumC0728yb enumC0728yb7 = EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0728yb7, 26);
        EnumC0728yb enumC0728yb8 = EnumC0728yb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0728yb8, 25);
        EnumC0728yb enumC0728yb9 = EnumC0728yb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0728yb9, 26);
        EnumC0728yb enumC0728yb10 = EnumC0728yb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0728yb10, 26);
        EnumC0728yb enumC0728yb11 = EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0728yb11, 27);
        EnumC0728yb enumC0728yb12 = EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0728yb12, 27);
        EnumC0728yb enumC0728yb13 = EnumC0728yb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0728yb13, 13);
        EnumC0728yb enumC0728yb14 = EnumC0728yb.EVENT_TYPE_START;
        hashMap2.put(enumC0728yb14, 2);
        EnumC0728yb enumC0728yb15 = EnumC0728yb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0728yb15, 16);
        EnumC0728yb enumC0728yb16 = EnumC0728yb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0728yb16, 17);
        EnumC0728yb enumC0728yb17 = EnumC0728yb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0728yb17, 18);
        EnumC0728yb enumC0728yb18 = EnumC0728yb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0728yb18, 19);
        EnumC0728yb enumC0728yb19 = EnumC0728yb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0728yb19, 20);
        EnumC0728yb enumC0728yb20 = EnumC0728yb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0728yb20, 21);
        EnumC0728yb enumC0728yb21 = EnumC0728yb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0728yb21, 40);
        EnumC0728yb enumC0728yb22 = EnumC0728yb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0728yb22, 35);
        hashMap2.put(EnumC0728yb.EVENT_TYPE_CLEANUP, 29);
        EnumC0728yb enumC0728yb23 = EnumC0728yb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0728yb23, 38);
        EnumC0728yb enumC0728yb24 = EnumC0728yb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0728yb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        R8 r8 = new R8();
        X8 x8 = new X8(new C0170c9());
        S8 s8 = new S8();
        C0720y3 c0720y3 = new C0720y3(new C0170c9());
        Rn rn = new Rn(new C0170c9());
        C0203dg c0203dg = new C0203dg();
        C0527q9 a2 = C0551r9.a();
        a2.b = c0203dg;
        a2.c = c0203dg;
        C0551r9 c0551r9 = new C0551r9(a2);
        C0527q9 a3 = C0551r9.a();
        a3.b = x8;
        C0551r9 c0551r92 = new C0551r9(a3);
        C0527q9 a4 = C0551r9.a();
        a4.b = c0720y3;
        C0551r9 c0551r93 = new C0551r9(a4);
        C0527q9 a5 = C0551r9.a();
        a5.b = rn;
        C0551r9 c0551r94 = new C0551r9(a5);
        C0527q9 a6 = C0551r9.a();
        a6.f1023a = r8;
        C0551r9 c0551r95 = new C0551r9(a6);
        C0527q9 a7 = C0551r9.a();
        a7.b = new wo(new X8());
        C0551r9 c0551r96 = new C0551r9(a7);
        hashMap3.put(enumC0728yb2, c0551r92);
        C0527q9 a8 = C0551r9.a();
        a8.b = new C0254fg();
        hashMap3.put(enumC0728yb3, new C0551r9(a8));
        C0527q9 a9 = C0551r9.a();
        a9.f1023a = r8;
        a9.b = s8;
        a9.e = new C0575s8();
        a9.f = new C0600t8();
        hashMap3.put(enumC0728yb4, new C0551r9(a9));
        hashMap3.put(enumC0728yb9, c0551r9);
        hashMap3.put(enumC0728yb10, c0551r9);
        hashMap3.put(enumC0728yb11, c0551r93);
        hashMap3.put(enumC0728yb12, c0551r93);
        hashMap3.put(enumC0728yb5, c0551r93);
        hashMap3.put(enumC0728yb6, c0551r93);
        hashMap3.put(enumC0728yb7, c0551r93);
        hashMap3.put(enumC0728yb8, c0551r93);
        C0527q9 a10 = C0551r9.a();
        a10.f1023a = new R8();
        a10.b = c0720y3;
        hashMap3.put(enumC0728yb14, new C0551r9(a10));
        EnumC0728yb enumC0728yb25 = EnumC0728yb.EVENT_TYPE_CUSTOM_EVENT;
        C0527q9 a11 = C0551r9.a();
        a11.d = new C0280gg();
        hashMap3.put(enumC0728yb25, new C0551r9(a11));
        hashMap3.put(enumC0728yb15, c0551r92);
        hashMap3.put(enumC0728yb17, c0551r95);
        hashMap3.put(enumC0728yb18, c0551r95);
        hashMap3.put(enumC0728yb19, c0551r93);
        hashMap3.put(enumC0728yb20, c0551r93);
        hashMap3.put(enumC0728yb21, c0551r93);
        hashMap3.put(enumC0728yb22, c0551r94);
        hashMap3.put(enumC0728yb, c0551r96);
        hashMap3.put(enumC0728yb16, c0551r96);
        hashMap3.put(enumC0728yb13, c0551r92);
        hashMap3.put(enumC0728yb23, c0551r92);
        hashMap3.put(enumC0728yb24, c0551r93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static F9 a(Long l, Long l2, Boolean bool) {
        F9 f9 = new F9();
        if (l != null) {
            f9.f431a = l.longValue();
            f9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            f9.c = l2.longValue();
        }
        if (bool != null) {
            f9.d = bool.booleanValue();
        }
        return f9;
    }

    public static void a(D9 d9) {
        B9[] b9Arr = d9.c;
        if (b9Arr != null) {
            for (B9 b9 : b9Arr) {
            }
        }
    }
}
