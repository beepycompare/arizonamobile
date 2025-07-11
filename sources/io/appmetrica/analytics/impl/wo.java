package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class wo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1113a;

    public wo() {
        super(false, "[WakelocksToggle]");
        this.f1113a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1113a.put(obj, null);
        if (this.f1113a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1113a.remove(obj);
        if (this.f1113a.isEmpty()) {
            updateState(false);
        }
    }
}
