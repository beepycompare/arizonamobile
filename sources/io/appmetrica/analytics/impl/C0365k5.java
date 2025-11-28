package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0365k5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f967a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0365k5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final Na a(X4 x4, C0664w4 c0664w4, U7 u7, HashMap hashMap) {
        Na na = (Na) hashMap.get(x4.toString());
        if (na == null) {
            Na a2 = u7.a(this.c, x4, c0664w4);
            hashMap.put(x4.toString(), a2);
            return a2;
        }
        na.a(c0664w4);
        return na;
    }
}
