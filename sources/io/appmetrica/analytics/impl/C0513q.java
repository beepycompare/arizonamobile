package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0513q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1182a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0488p enumC0488p) {
        if (activity == null || this.f1182a.get(activity) != enumC0488p) {
            if (activity != null) {
                this.f1182a.put(activity, enumC0488p);
                return true;
            }
            return true;
        }
        return false;
    }
}
