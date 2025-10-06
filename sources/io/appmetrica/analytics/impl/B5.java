package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class B5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f364a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public B5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0276gb a(C0477o5 c0477o5, N4 n4, InterfaceC0428m8 interfaceC0428m8, HashMap hashMap) {
        InterfaceC0276gb interfaceC0276gb = (InterfaceC0276gb) hashMap.get(c0477o5.toString());
        if (interfaceC0276gb == null) {
            InterfaceC0276gb a2 = interfaceC0428m8.a(this.c, c0477o5, n4);
            hashMap.put(c0477o5.toString(), a2);
            return a2;
        }
        interfaceC0276gb.a(n4);
        return interfaceC0276gb;
    }
}
