package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0496p {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1023a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0470o enumC0470o) {
        if (activity == null || this.f1023a.get(activity) != enumC0470o) {
            if (activity != null) {
                this.f1023a.put(activity, enumC0470o);
                return true;
            }
            return true;
        }
        return false;
    }
}
