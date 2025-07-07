package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.y5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0730y5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1139a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0730y5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final Za a(C0406l5 c0406l5, K4 k4, InterfaceC0235e8 interfaceC0235e8, HashMap hashMap) {
        Za za = (Za) hashMap.get(c0406l5.toString());
        if (za == null) {
            Za a2 = interfaceC0235e8.a(this.c, c0406l5, k4);
            hashMap.put(c0406l5.toString(), a2);
            return a2;
        }
        za.a(k4);
        return za;
    }
}
