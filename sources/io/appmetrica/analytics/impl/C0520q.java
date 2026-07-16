package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1156a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0494p enumC0494p) {
        if (activity == null || this.f1156a.get(activity) != enumC0494p) {
            if (activity != null) {
                this.f1156a.put(activity, enumC0494p);
                return true;
            }
            return true;
        }
        return false;
    }
}
