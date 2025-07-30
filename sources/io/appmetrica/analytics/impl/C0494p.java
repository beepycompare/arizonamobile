package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;
/* renamed from: io.appmetrica.analytics.impl.p  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0494p {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f994a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC0469o enumC0469o) {
        if (activity == null || this.f994a.get(activity) != enumC0469o) {
            if (activity != null) {
                this.f994a.put(activity, enumC0469o);
                return true;
            }
            return true;
        }
        return false;
    }
}
