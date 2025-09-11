package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class B5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f363a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public B5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0275gb a(C0476o5 c0476o5, N4 n4, InterfaceC0427m8 interfaceC0427m8, HashMap hashMap) {
        InterfaceC0275gb interfaceC0275gb = (InterfaceC0275gb) hashMap.get(c0476o5.toString());
        if (interfaceC0275gb == null) {
            InterfaceC0275gb a2 = interfaceC0427m8.a(this.c, c0476o5, n4);
            hashMap.put(c0476o5.toString(), a2);
            return a2;
        }
        interfaceC0275gb.a(n4);
        return interfaceC0275gb;
    }
}
