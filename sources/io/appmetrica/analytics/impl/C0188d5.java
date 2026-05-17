package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0188d5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f957a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0188d5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final Ga a(Q4 q4, C0492p4 c0492p4, O7 o7, HashMap hashMap) {
        Ga ga = (Ga) hashMap.get(q4.toString());
        if (ga == null) {
            Ga a2 = o7.a(this.c, q4, c0492p4);
            hashMap.put(q4.toString(), a2);
            return a2;
        }
        ga.a(c0492p4);
        return ga;
    }
}
