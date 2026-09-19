package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0601t5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1212a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0601t5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0323ib a(C0265g5 c0265g5, G4 g4, InterfaceC0268g8 interfaceC0268g8, HashMap hashMap) {
        InterfaceC0323ib interfaceC0323ib = (InterfaceC0323ib) hashMap.get(c0265g5.toString());
        if (interfaceC0323ib == null) {
            InterfaceC0323ib a2 = interfaceC0268g8.a(this.c, c0265g5, g4);
            hashMap.put(c0265g5.toString(), a2);
            return a2;
        }
        interfaceC0323ib.a(g4);
        return interfaceC0323ib;
    }
}
