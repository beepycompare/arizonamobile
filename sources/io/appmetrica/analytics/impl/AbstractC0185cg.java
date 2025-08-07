package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.cg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0185cg {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f798a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Wk wk = Wk.FOREGROUND;
        hashMap.put(wk, 0);
        Wk wk2 = Wk.BACKGROUND;
        hashMap.put(wk2, 1);
        f798a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, wk);
        sparseArray.put(1, wk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_INIT;
        hashMap2.put(enumC0681wb, 1);
        EnumC0681wb enumC0681wb2 = EnumC0681wb.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0681wb2, 4);
        EnumC0681wb enumC0681wb3 = EnumC0681wb.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0681wb3, 5);
        EnumC0681wb enumC0681wb4 = EnumC0681wb.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0681wb4, 7);
        EnumC0681wb enumC0681wb5 = EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0681wb5, 26);
        EnumC0681wb enumC0681wb6 = EnumC0681wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0681wb6, 26);
        EnumC0681wb enumC0681wb7 = EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0681wb7, 26);
        EnumC0681wb enumC0681wb8 = EnumC0681wb.EVENT_TYPE_ANR;
        hashMap2.put(enumC0681wb8, 25);
        EnumC0681wb enumC0681wb9 = EnumC0681wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0681wb9, 26);
        EnumC0681wb enumC0681wb10 = EnumC0681wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0681wb10, 26);
        EnumC0681wb enumC0681wb11 = EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0681wb11, 27);
        EnumC0681wb enumC0681wb12 = EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0681wb12, 27);
        EnumC0681wb enumC0681wb13 = EnumC0681wb.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0681wb13, 13);
        EnumC0681wb enumC0681wb14 = EnumC0681wb.EVENT_TYPE_START;
        hashMap2.put(enumC0681wb14, 2);
        EnumC0681wb enumC0681wb15 = EnumC0681wb.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0681wb15, 16);
        EnumC0681wb enumC0681wb16 = EnumC0681wb.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0681wb16, 17);
        EnumC0681wb enumC0681wb17 = EnumC0681wb.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0681wb17, 18);
        EnumC0681wb enumC0681wb18 = EnumC0681wb.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0681wb18, 19);
        EnumC0681wb enumC0681wb19 = EnumC0681wb.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0681wb19, 20);
        EnumC0681wb enumC0681wb20 = EnumC0681wb.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0681wb20, 21);
        EnumC0681wb enumC0681wb21 = EnumC0681wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0681wb21, 40);
        EnumC0681wb enumC0681wb22 = EnumC0681wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0681wb22, 35);
        hashMap2.put(EnumC0681wb.EVENT_TYPE_CLEANUP, 29);
        EnumC0681wb enumC0681wb23 = EnumC0681wb.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0681wb23, 38);
        EnumC0681wb enumC0681wb24 = EnumC0681wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0681wb24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        P8 p8 = new P8();
        V8 v8 = new V8(new C0126a9());
        Q8 q8 = new Q8();
        C0723y3 c0723y3 = new C0723y3(new C0126a9());
        Mn mn = new Mn(new C0126a9());
        Yf yf = new Yf();
        C0480o9 a2 = C0505p9.a();
        a2.b = yf;
        a2.c = yf;
        C0505p9 c0505p9 = new C0505p9(a2);
        C0480o9 a3 = C0505p9.a();
        a3.b = v8;
        C0505p9 c0505p92 = new C0505p9(a3);
        C0480o9 a4 = C0505p9.a();
        a4.b = c0723y3;
        C0505p9 c0505p93 = new C0505p9(a4);
        C0480o9 a5 = C0505p9.a();
        a5.b = mn;
        C0505p9 c0505p94 = new C0505p9(a5);
        C0480o9 a6 = C0505p9.a();
        a6.f983a = p8;
        C0505p9 c0505p95 = new C0505p9(a6);
        C0480o9 a7 = C0505p9.a();
        a7.b = new ro(new V8());
        C0505p9 c0505p96 = new C0505p9(a7);
        hashMap3.put(enumC0681wb2, c0505p92);
        C0480o9 a8 = C0505p9.a();
        a8.b = new C0133ag();
        hashMap3.put(enumC0681wb3, new C0505p9(a8));
        C0480o9 a9 = C0505p9.a();
        a9.f983a = p8;
        a9.b = q8;
        a9.e = new C0529q8();
        a9.f = new C0553r8();
        hashMap3.put(enumC0681wb4, new C0505p9(a9));
        hashMap3.put(enumC0681wb9, c0505p9);
        hashMap3.put(enumC0681wb10, c0505p9);
        hashMap3.put(enumC0681wb11, c0505p93);
        hashMap3.put(enumC0681wb12, c0505p93);
        hashMap3.put(enumC0681wb5, c0505p93);
        hashMap3.put(enumC0681wb6, c0505p93);
        hashMap3.put(enumC0681wb7, c0505p93);
        hashMap3.put(enumC0681wb8, c0505p93);
        C0480o9 a10 = C0505p9.a();
        a10.f983a = new P8();
        a10.b = c0723y3;
        hashMap3.put(enumC0681wb14, new C0505p9(a10));
        EnumC0681wb enumC0681wb25 = EnumC0681wb.EVENT_TYPE_CUSTOM_EVENT;
        C0480o9 a11 = C0505p9.a();
        a11.d = new C0159bg();
        hashMap3.put(enumC0681wb25, new C0505p9(a11));
        hashMap3.put(enumC0681wb15, c0505p92);
        hashMap3.put(enumC0681wb17, c0505p95);
        hashMap3.put(enumC0681wb18, c0505p95);
        hashMap3.put(enumC0681wb19, c0505p93);
        hashMap3.put(enumC0681wb20, c0505p93);
        hashMap3.put(enumC0681wb21, c0505p93);
        hashMap3.put(enumC0681wb22, c0505p94);
        hashMap3.put(enumC0681wb, c0505p96);
        hashMap3.put(enumC0681wb16, c0505p96);
        hashMap3.put(enumC0681wb13, c0505p92);
        hashMap3.put(enumC0681wb23, c0505p92);
        hashMap3.put(enumC0681wb24, c0505p93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static D9 a(Long l, Long l2, Boolean bool) {
        D9 d9 = new D9();
        if (l != null) {
            d9.f393a = l.longValue();
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
        C0754z9[] c0754z9Arr = b9.c;
        if (c0754z9Arr != null) {
            for (C0754z9 c0754z9 : c0754z9Arr) {
            }
        }
    }
}
