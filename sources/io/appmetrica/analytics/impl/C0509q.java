package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0509q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1159a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0484p enumC0484p) {
        if (activity == null || this.f1159a.get(activity) != enumC0484p) {
            if (activity != null) {
                this.f1159a.put(activity, enumC0484p);
                return true;
            }
            return true;
        }
        return false;
    }
}
