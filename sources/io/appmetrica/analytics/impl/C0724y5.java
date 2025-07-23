package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.y5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0724y5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1148a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0724y5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0153bb a(C0400l5 c0400l5, K4 k4, InterfaceC0304h8 interfaceC0304h8, HashMap hashMap) {
        InterfaceC0153bb interfaceC0153bb = (InterfaceC0153bb) hashMap.get(c0400l5.toString());
        if (interfaceC0153bb == null) {
            InterfaceC0153bb a2 = interfaceC0304h8.a(this.c, c0400l5, k4);
            hashMap.put(c0400l5.toString(), a2);
            return a2;
        }
        interfaceC0153bb.a(k4);
        return interfaceC0153bb;
    }
}
