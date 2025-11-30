package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0510q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1076a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0485p enumC0485p) {
        if (activity == null || this.f1076a.get(activity) != enumC0485p) {
            if (activity != null) {
                this.f1076a.put(activity, enumC0485p);
                return true;
            }
            return true;
        }
        return false;
    }
}
