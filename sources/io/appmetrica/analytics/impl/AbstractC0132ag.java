package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0132ag {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f755a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Tk tk = Tk.FOREGROUND;
        hashMap.put(tk, 0);
        Tk tk2 = Tk.BACKGROUND;
        hashMap.put(tk2, 1);
        f755a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, tk);
        sparseArray.put(1, tk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_INIT;
        hashMap2.put(enumC0628ub, 1);
        EnumC0628ub enumC0628ub2 = EnumC0628ub.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0628ub2, 4);
        EnumC0628ub enumC0628ub3 = EnumC0628ub.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0628ub3, 5);
        EnumC0628ub enumC0628ub4 = EnumC0628ub.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0628ub4, 7);
        EnumC0628ub enumC0628ub5 = EnumC0628ub.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0628ub5, 26);
        EnumC0628ub enumC0628ub6 = EnumC0628ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0628ub6, 26);
        EnumC0628ub enumC0628ub7 = EnumC0628ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0628ub7, 26);
        EnumC0628ub enumC0628ub8 = EnumC0628ub.EVENT_TYPE_ANR;
        hashMap2.put(enumC0628ub8, 25);
        EnumC0628ub enumC0628ub9 = EnumC0628ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0628ub9, 26);
        EnumC0628ub enumC0628ub10 = EnumC0628ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0628ub10, 26);
        EnumC0628ub enumC0628ub11 = EnumC0628ub.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0628ub11, 27);
        EnumC0628ub enumC0628ub12 = EnumC0628ub.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0628ub12, 27);
        EnumC0628ub enumC0628ub13 = EnumC0628ub.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0628ub13, 13);
        EnumC0628ub enumC0628ub14 = EnumC0628ub.EVENT_TYPE_START;
        hashMap2.put(enumC0628ub14, 2);
        EnumC0628ub enumC0628ub15 = EnumC0628ub.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0628ub15, 16);
        EnumC0628ub enumC0628ub16 = EnumC0628ub.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0628ub16, 17);
        EnumC0628ub enumC0628ub17 = EnumC0628ub.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0628ub17, 18);
        EnumC0628ub enumC0628ub18 = EnumC0628ub.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0628ub18, 19);
        EnumC0628ub enumC0628ub19 = EnumC0628ub.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0628ub19, 20);
        EnumC0628ub enumC0628ub20 = EnumC0628ub.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0628ub20, 21);
        EnumC0628ub enumC0628ub21 = EnumC0628ub.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0628ub21, 40);
        EnumC0628ub enumC0628ub22 = EnumC0628ub.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0628ub22, 35);
        hashMap2.put(EnumC0628ub.EVENT_TYPE_CLEANUP, 29);
        EnumC0628ub enumC0628ub23 = EnumC0628ub.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0628ub23, 38);
        EnumC0628ub enumC0628ub24 = EnumC0628ub.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0628ub24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        M8 m8 = new M8();
        S8 s8 = new S8(new X8());
        N8 n8 = new N8();
        C0720y3 c0720y3 = new C0720y3(new X8());
        Jn jn = new Jn(new X8());
        Wf wf = new Wf();
        C0402l9 a2 = C0427m9.a();
        a2.b = wf;
        a2.c = wf;
        C0427m9 c0427m9 = new C0427m9(a2);
        C0402l9 a3 = C0427m9.a();
        a3.b = s8;
        C0427m9 c0427m92 = new C0427m9(a3);
        C0402l9 a4 = C0427m9.a();
        a4.b = c0720y3;
        C0427m9 c0427m93 = new C0427m9(a4);
        C0402l9 a5 = C0427m9.a();
        a5.b = jn;
        C0427m9 c0427m94 = new C0427m9(a5);
        C0402l9 a6 = C0427m9.a();
        a6.f920a = m8;
        C0427m9 c0427m95 = new C0427m9(a6);
        C0402l9 a7 = C0427m9.a();
        a7.b = new oo(new S8());
        C0427m9 c0427m96 = new C0427m9(a7);
        hashMap3.put(enumC0628ub2, c0427m92);
        C0402l9 a8 = C0427m9.a();
        a8.b = new Yf();
        hashMap3.put(enumC0628ub3, new C0427m9(a8));
        C0402l9 a9 = C0427m9.a();
        a9.f920a = m8;
        a9.b = n8;
        a9.e = new C0451n8();
        a9.f = new C0476o8();
        hashMap3.put(enumC0628ub4, new C0427m9(a9));
        hashMap3.put(enumC0628ub9, c0427m9);
        hashMap3.put(enumC0628ub10, c0427m9);
        hashMap3.put(enumC0628ub11, c0427m93);
        hashMap3.put(enumC0628ub12, c0427m93);
        hashMap3.put(enumC0628ub5, c0427m93);
        hashMap3.put(enumC0628ub6, c0427m93);
        hashMap3.put(enumC0628ub7, c0427m93);
        hashMap3.put(enumC0628ub8, c0427m93);
        C0402l9 a10 = C0427m9.a();
        a10.f920a = new M8();
        a10.b = c0720y3;
        hashMap3.put(enumC0628ub14, new C0427m9(a10));
        EnumC0628ub enumC0628ub25 = EnumC0628ub.EVENT_TYPE_CUSTOM_EVENT;
        C0402l9 a11 = C0427m9.a();
        a11.d = new Zf();
        hashMap3.put(enumC0628ub25, new C0427m9(a11));
        hashMap3.put(enumC0628ub15, c0427m92);
        hashMap3.put(enumC0628ub17, c0427m95);
        hashMap3.put(enumC0628ub18, c0427m95);
        hashMap3.put(enumC0628ub19, c0427m93);
        hashMap3.put(enumC0628ub20, c0427m93);
        hashMap3.put(enumC0628ub21, c0427m93);
        hashMap3.put(enumC0628ub22, c0427m94);
        hashMap3.put(enumC0628ub, c0427m96);
        hashMap3.put(enumC0628ub16, c0427m96);
        hashMap3.put(enumC0628ub13, c0427m92);
        hashMap3.put(enumC0628ub23, c0427m92);
        hashMap3.put(enumC0628ub24, c0427m93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static A9 a(Long l, Long l2, Boolean bool) {
        A9 a9 = new A9();
        if (l != null) {
            a9.f334a = l.longValue();
            a9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            a9.c = l2.longValue();
        }
        if (bool != null) {
            a9.d = bool.booleanValue();
        }
        return a9;
    }

    public static void a(C0726y9 c0726y9) {
        C0676w9[] c0676w9Arr = c0726y9.c;
        if (c0676w9Arr != null) {
            for (C0676w9 c0676w9 : c0676w9Arr) {
            }
        }
    }
}
