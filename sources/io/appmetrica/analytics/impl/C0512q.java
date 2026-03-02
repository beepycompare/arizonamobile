package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.q  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0512q {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1181a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0487p enumC0487p) {
        if (activity == null || this.f1181a.get(activity) != enumC0487p) {
            if (activity != null) {
                this.f1181a.put(activity, enumC0487p);
                return true;
            }
            return true;
        }
        return false;
    }
}
