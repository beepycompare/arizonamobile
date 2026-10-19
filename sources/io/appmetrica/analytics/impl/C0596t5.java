package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0596t5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1215a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0596t5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0318ib a(C0260g5 c0260g5, G4 g4, InterfaceC0263g8 interfaceC0263g8, HashMap hashMap) {
        InterfaceC0318ib interfaceC0318ib = (InterfaceC0318ib) hashMap.get(c0260g5.toString());
        if (interfaceC0318ib == null) {
            InterfaceC0318ib a2 = interfaceC0263g8.a(this.c, c0260g5, g4);
            hashMap.put(c0260g5.toString(), a2);
            return a2;
        }
        interfaceC0318ib.a(g4);
        return interfaceC0318ib;
    }
}
