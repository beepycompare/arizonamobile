package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.cg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0184cg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f799a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Wk wk = Wk.FOREGROUND;
        hashMap.put(wk, 0);
        Wk wk2 = Wk.BACKGROUND;
        hashMap.put(wk2, 1);
        f799a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, wk);
        sparseArray.put(1, wk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0680wb, 1);
        EnumC0680wb enumC0680wb2 = EnumC0680wb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0680wb2, 4);
        EnumC0680wb enumC0680wb3 = EnumC0680wb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0680wb3, 5);
        EnumC0680wb enumC0680wb4 = EnumC0680wb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0680wb4, 7);
        EnumC0680wb enumC0680wb5 = EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0680wb5, 26);
        EnumC0680wb enumC0680wb6 = EnumC0680wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0680wb6, 26);
        EnumC0680wb enumC0680wb7 = EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0680wb7, 26);
        EnumC0680wb enumC0680wb8 = EnumC0680wb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0680wb8, 25);
        EnumC0680wb enumC0680wb9 = EnumC0680wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0680wb9, 26);
        EnumC0680wb enumC0680wb10 = EnumC0680wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0680wb10, 26);
        EnumC0680wb enumC0680wb11 = EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0680wb11, 27);
        EnumC0680wb enumC0680wb12 = EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0680wb12, 27);
        EnumC0680wb enumC0680wb13 = EnumC0680wb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0680wb13, 13);
        EnumC0680wb enumC0680wb14 = EnumC0680wb.EVENT_TYPE_START;
        hashMap2.put(enumC0680wb14, 2);
        EnumC0680wb enumC0680wb15 = EnumC0680wb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0680wb15, 16);
        EnumC0680wb enumC0680wb16 = EnumC0680wb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0680wb16, 17);
        EnumC0680wb enumC0680wb17 = EnumC0680wb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0680wb17, 18);
        EnumC0680wb enumC0680wb18 = EnumC0680wb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0680wb18, 19);
        EnumC0680wb enumC0680wb19 = EnumC0680wb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0680wb19, 20);
        EnumC0680wb enumC0680wb20 = EnumC0680wb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0680wb20, 21);
        EnumC0680wb enumC0680wb21 = EnumC0680wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0680wb21, 40);
        EnumC0680wb enumC0680wb22 = EnumC0680wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0680wb22, 35);
        hashMap2.put(EnumC0680wb.EVENT_TYPE_CLEANUP, 29);
        EnumC0680wb enumC0680wb23 = EnumC0680wb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0680wb23, 38);
        EnumC0680wb enumC0680wb24 = EnumC0680wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0680wb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        P8 p8 = new P8();
        V8 v8 = new V8(new C0125a9());
        Q8 q8 = new Q8();
        C0722y3 c0722y3 = new C0722y3(new C0125a9());
        Mn mn = new Mn(new C0125a9());
        Yf yf = new Yf();
        C0479o9 a2 = C0504p9.a();
        a2.b = yf;
        a2.c = yf;
        C0504p9 c0504p9 = new C0504p9(a2);
        C0479o9 a3 = C0504p9.a();
        a3.b = v8;
        C0504p9 c0504p92 = new C0504p9(a3);
        C0479o9 a4 = C0504p9.a();
        a4.b = c0722y3;
        C0504p9 c0504p93 = new C0504p9(a4);
        C0479o9 a5 = C0504p9.a();
        a5.b = mn;
        C0504p9 c0504p94 = new C0504p9(a5);
        C0479o9 a6 = C0504p9.a();
        a6.f984a = p8;
        C0504p9 c0504p95 = new C0504p9(a6);
        C0479o9 a7 = C0504p9.a();
        a7.b = new ro(new V8());
        C0504p9 c0504p96 = new C0504p9(a7);
        hashMap3.put(enumC0680wb2, c0504p92);
        C0479o9 a8 = C0504p9.a();
        a8.b = new C0132ag();
        hashMap3.put(enumC0680wb3, new C0504p9(a8));
        C0479o9 a9 = C0504p9.a();
        a9.f984a = p8;
        a9.b = q8;
        a9.e = new C0528q8();
        a9.f = new C0552r8();
        hashMap3.put(enumC0680wb4, new C0504p9(a9));
        hashMap3.put(enumC0680wb9, c0504p9);
        hashMap3.put(enumC0680wb10, c0504p9);
        hashMap3.put(enumC0680wb11, c0504p93);
        hashMap3.put(enumC0680wb12, c0504p93);
        hashMap3.put(enumC0680wb5, c0504p93);
        hashMap3.put(enumC0680wb6, c0504p93);
        hashMap3.put(enumC0680wb7, c0504p93);
        hashMap3.put(enumC0680wb8, c0504p93);
        C0479o9 a10 = C0504p9.a();
        a10.f984a = new P8();
        a10.b = c0722y3;
        hashMap3.put(enumC0680wb14, new C0504p9(a10));
        EnumC0680wb enumC0680wb25 = EnumC0680wb.EVENT_TYPE_CUSTOM_EVENT;
        C0479o9 a11 = C0504p9.a();
        a11.d = new C0158bg();
        hashMap3.put(enumC0680wb25, new C0504p9(a11));
        hashMap3.put(enumC0680wb15, c0504p92);
        hashMap3.put(enumC0680wb17, c0504p95);
        hashMap3.put(enumC0680wb18, c0504p95);
        hashMap3.put(enumC0680wb19, c0504p93);
        hashMap3.put(enumC0680wb20, c0504p93);
        hashMap3.put(enumC0680wb21, c0504p93);
        hashMap3.put(enumC0680wb22, c0504p94);
        hashMap3.put(enumC0680wb, c0504p96);
        hashMap3.put(enumC0680wb16, c0504p96);
        hashMap3.put(enumC0680wb13, c0504p92);
        hashMap3.put(enumC0680wb23, c0504p92);
        hashMap3.put(enumC0680wb24, c0504p93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static D9 a(Long l, Long l2, Boolean bool) {
        D9 d9 = new D9();
        if (l != null) {
            d9.f394a = l.longValue();
            d9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / 1000;
        }
        if (l2 != null) {
            d9.c = l2.longValue();
        }
        if (bool != null) {
            d9.d = bool.booleanValue();
        }
        return d9;
    }

    public static void a(B9 b9) {
        C0753z9[] c0753z9Arr = b9.c;
        if (c0753z9Arr != null) {
            for (C0753z9 c0753z9 : c0753z9Arr) {
            }
        }
    }
}
