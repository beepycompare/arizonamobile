package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ag  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0140ag {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f754a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap hashMap = new HashMap();
        Tk tk = Tk.FOREGROUND;
        hashMap.put(tk, 0);
        Tk tk2 = Tk.BACKGROUND;
        hashMap.put(tk2, 1);
        f754a = Collections.unmodifiableMap(hashMap);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, tk);
        sparseArray.put(1, tk2);
        b = sparseArray;
        HashMap hashMap2 = new HashMap();
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_INIT;
        hashMap2.put(enumC0636ub, 1);
        EnumC0636ub enumC0636ub2 = EnumC0636ub.EVENT_TYPE_REGULAR;
        hashMap2.put(enumC0636ub2, 4);
        EnumC0636ub enumC0636ub3 = EnumC0636ub.EVENT_TYPE_SEND_REFERRER;
        hashMap2.put(enumC0636ub3, 5);
        EnumC0636ub enumC0636ub4 = EnumC0636ub.EVENT_TYPE_ALIVE;
        hashMap2.put(enumC0636ub4, 7);
        EnumC0636ub enumC0636ub5 = EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        hashMap2.put(enumC0636ub5, 26);
        EnumC0636ub enumC0636ub6 = EnumC0636ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0636ub6, 26);
        EnumC0636ub enumC0636ub7 = EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        hashMap2.put(enumC0636ub7, 26);
        EnumC0636ub enumC0636ub8 = EnumC0636ub.EVENT_TYPE_ANR;
        hashMap2.put(enumC0636ub8, 25);
        EnumC0636ub enumC0636ub9 = EnumC0636ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0636ub9, 26);
        EnumC0636ub enumC0636ub10 = EnumC0636ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        hashMap2.put(enumC0636ub10, 26);
        EnumC0636ub enumC0636ub11 = EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        hashMap2.put(enumC0636ub11, 27);
        EnumC0636ub enumC0636ub12 = EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        hashMap2.put(enumC0636ub12, 27);
        EnumC0636ub enumC0636ub13 = EnumC0636ub.EVENT_TYPE_FIRST_ACTIVATION;
        hashMap2.put(enumC0636ub13, 13);
        EnumC0636ub enumC0636ub14 = EnumC0636ub.EVENT_TYPE_START;
        hashMap2.put(enumC0636ub14, 2);
        EnumC0636ub enumC0636ub15 = EnumC0636ub.EVENT_TYPE_APP_OPEN;
        hashMap2.put(enumC0636ub15, 16);
        EnumC0636ub enumC0636ub16 = EnumC0636ub.EVENT_TYPE_APP_UPDATE;
        hashMap2.put(enumC0636ub16, 17);
        EnumC0636ub enumC0636ub17 = EnumC0636ub.EVENT_TYPE_PERMISSIONS;
        hashMap2.put(enumC0636ub17, 18);
        EnumC0636ub enumC0636ub18 = EnumC0636ub.EVENT_TYPE_APP_FEATURES;
        hashMap2.put(enumC0636ub18, 19);
        EnumC0636ub enumC0636ub19 = EnumC0636ub.EVENT_TYPE_SEND_USER_PROFILE;
        hashMap2.put(enumC0636ub19, 20);
        EnumC0636ub enumC0636ub20 = EnumC0636ub.EVENT_TYPE_SEND_REVENUE_EVENT;
        hashMap2.put(enumC0636ub20, 21);
        EnumC0636ub enumC0636ub21 = EnumC0636ub.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        hashMap2.put(enumC0636ub21, 40);
        EnumC0636ub enumC0636ub22 = EnumC0636ub.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        hashMap2.put(enumC0636ub22, 35);
        hashMap2.put(EnumC0636ub.EVENT_TYPE_CLEANUP, 29);
        EnumC0636ub enumC0636ub23 = EnumC0636ub.EVENT_TYPE_WEBVIEW_SYNC;
        hashMap2.put(enumC0636ub23, 38);
        EnumC0636ub enumC0636ub24 = EnumC0636ub.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        hashMap2.put(enumC0636ub24, 42);
        c = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        M8 m8 = new M8();
        S8 s8 = new S8(new X8());
        N8 n8 = new N8();
        C0728y3 c0728y3 = new C0728y3(new X8());
        Jn jn = new Jn(new X8());
        Wf wf = new Wf();
        C0410l9 a2 = C0435m9.a();
        a2.b = wf;
        a2.c = wf;
        C0435m9 c0435m9 = new C0435m9(a2);
        C0410l9 a3 = C0435m9.a();
        a3.b = s8;
        C0435m9 c0435m92 = new C0435m9(a3);
        C0410l9 a4 = C0435m9.a();
        a4.b = c0728y3;
        C0435m9 c0435m93 = new C0435m9(a4);
        C0410l9 a5 = C0435m9.a();
        a5.b = jn;
        C0435m9 c0435m94 = new C0435m9(a5);
        C0410l9 a6 = C0435m9.a();
        a6.f919a = m8;
        C0435m9 c0435m95 = new C0435m9(a6);
        C0410l9 a7 = C0435m9.a();
        a7.b = new oo(new S8());
        C0435m9 c0435m96 = new C0435m9(a7);
        hashMap3.put(enumC0636ub2, c0435m92);
        C0410l9 a8 = C0435m9.a();
        a8.b = new Yf();
        hashMap3.put(enumC0636ub3, new C0435m9(a8));
        C0410l9 a9 = C0435m9.a();
        a9.f919a = m8;
        a9.b = n8;
        a9.e = new C0459n8();
        a9.f = new C0484o8();
        hashMap3.put(enumC0636ub4, new C0435m9(a9));
        hashMap3.put(enumC0636ub9, c0435m9);
        hashMap3.put(enumC0636ub10, c0435m9);
        hashMap3.put(enumC0636ub11, c0435m93);
        hashMap3.put(enumC0636ub12, c0435m93);
        hashMap3.put(enumC0636ub5, c0435m93);
        hashMap3.put(enumC0636ub6, c0435m93);
        hashMap3.put(enumC0636ub7, c0435m93);
        hashMap3.put(enumC0636ub8, c0435m93);
        C0410l9 a10 = C0435m9.a();
        a10.f919a = new M8();
        a10.b = c0728y3;
        hashMap3.put(enumC0636ub14, new C0435m9(a10));
        EnumC0636ub enumC0636ub25 = EnumC0636ub.EVENT_TYPE_CUSTOM_EVENT;
        C0410l9 a11 = C0435m9.a();
        a11.d = new Zf();
        hashMap3.put(enumC0636ub25, new C0435m9(a11));
        hashMap3.put(enumC0636ub15, c0435m92);
        hashMap3.put(enumC0636ub17, c0435m95);
        hashMap3.put(enumC0636ub18, c0435m95);
        hashMap3.put(enumC0636ub19, c0435m93);
        hashMap3.put(enumC0636ub20, c0435m93);
        hashMap3.put(enumC0636ub21, c0435m93);
        hashMap3.put(enumC0636ub22, c0435m94);
        hashMap3.put(enumC0636ub, c0435m96);
        hashMap3.put(enumC0636ub16, c0435m96);
        hashMap3.put(enumC0636ub13, c0435m92);
        hashMap3.put(enumC0636ub23, c0435m92);
        hashMap3.put(enumC0636ub24, c0435m93);
        d = Collections.unmodifiableMap(hashMap3);
    }

    public static A9 a(Long l, Long l2, Boolean bool) {
        A9 a9 = new A9();
        if (l != null) {
            a9.f333a = l.longValue();
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

    public static void a(C0734y9 c0734y9) {
        C0684w9[] c0684w9Arr = c0734y9.c;
        if (c0684w9Arr != null) {
            for (C0684w9 c0684w9 : c0684w9Arr) {
            }
        }
    }
}
