package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Pk {

    /* renamed from: a  reason: collision with root package name */
    public final Tk f609a;
    public final Map b;

    public Pk(Context context, C0398l5 c0398l5) {
        c0398l5.a();
        Tk tk = new Tk(context, c0398l5);
        this.f609a = tk;
        this.b = MapsKt.toMutableMap(tk.a());
    }
}
