package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Kk {

    /* renamed from: a  reason: collision with root package name */
    public final Ok f641a;
    public final Map b;

    public Kk(Context context, R4 r4) {
        r4.a();
        Ok ok = new Ok(context, r4);
        this.f641a = ok;
        this.b = MapsKt.toMutableMap(ok.a());
    }
}
