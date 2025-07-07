package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0500p {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f982a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0475o enumC0475o) {
        if (activity == null || this.f982a.get(activity) != enumC0475o) {
            if (activity != null) {
                this.f982a.put(activity, enumC0475o);
                return true;
            }
            return true;
        }
        return false;
    }
}
