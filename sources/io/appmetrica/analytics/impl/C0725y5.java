package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.y5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0725y5 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1148a = new HashMap();
    public final HashMap b = new HashMap();
    public final Context c;

    public C0725y5(Context context) {
        this.c = context.getApplicationContext();
    }

    public final InterfaceC0154bb a(C0401l5 c0401l5, K4 k4, InterfaceC0305h8 interfaceC0305h8, HashMap hashMap) {
        InterfaceC0154bb interfaceC0154bb = (InterfaceC0154bb) hashMap.get(c0401l5.toString());
        if (interfaceC0154bb == null) {
            InterfaceC0154bb a2 = interfaceC0305h8.a(this.c, c0401l5, k4);
            hashMap.put(c0401l5.toString(), a2);
            return a2;
        }
        interfaceC0154bb.a(k4);
        return interfaceC0154bb;
    }
}
