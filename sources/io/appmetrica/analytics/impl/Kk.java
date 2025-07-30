package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Kk {

    /* renamed from: a  reason: collision with root package name */
    public final Ok f526a;
    public final Map b;

    public Kk(Context context, C0400l5 c0400l5) {
        c0400l5.a();
        Ok ok = new Ok(context, c0400l5);
        this.f526a = ok;
        this.b = MapsKt.toMutableMap(ok.a());
    }
}
