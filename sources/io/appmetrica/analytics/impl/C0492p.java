package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0492p {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f983a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0467o enumC0467o) {
        if (activity == null || this.f983a.get(activity) != enumC0467o) {
            if (activity != null) {
                this.f983a.put(activity, enumC0467o);
                return true;
            }
            return true;
        }
        return false;
    }
}
