package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0602t5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1212a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0602t5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0324ib a(C0266g5 c0266g5, G4 g4, InterfaceC0269g8 interfaceC0269g8, HashMap hashMap) {
        InterfaceC0324ib interfaceC0324ib = (InterfaceC0324ib) hashMap.get(c0266g5.toString());
        if (interfaceC0324ib == null) {
            InterfaceC0324ib a2 = interfaceC0269g8.a(this.c, c0266g5, g4);
            hashMap.put(c0266g5.toString(), a2);
            return a2;
        }
        interfaceC0324ib.a(g4);
        return interfaceC0324ib;
    }
}
