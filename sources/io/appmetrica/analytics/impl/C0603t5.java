package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0603t5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1210a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0603t5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0325ib a(C0267g5 c0267g5, G4 g4, InterfaceC0270g8 interfaceC0270g8, HashMap hashMap) {
        InterfaceC0325ib interfaceC0325ib = (InterfaceC0325ib) hashMap.get(c0267g5.toString());
        if (interfaceC0325ib == null) {
            InterfaceC0325ib a2 = interfaceC0270g8.a(this.c, c0267g5, g4);
            hashMap.put(c0267g5.toString(), a2);
            return a2;
        }
        interfaceC0325ib.a(g4);
        return interfaceC0325ib;
    }
}
