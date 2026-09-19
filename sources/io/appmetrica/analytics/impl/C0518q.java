package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0518q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1156a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0492p enumC0492p) {
        if (activity == null || this.f1156a.get(activity) != enumC0492p) {
            if (activity != null) {
                this.f1156a.put(activity, enumC0492p);
                return true;
            }
            return true;
        }
        return false;
    }
}
