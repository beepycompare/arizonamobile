package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0497p {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1028a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0471o enumC0471o) {
        if (activity == null || this.f1028a.get(activity) != enumC0471o) {
            if (activity != null) {
                this.f1028a.put(activity, enumC0471o);
                return true;
            }
            return true;
        }
        return false;
    }
}
