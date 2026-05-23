package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class hp extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1023a;

    public hp() {
        super(false, "[WakelocksToggle]");
        this.f1023a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1023a.put(obj, null);
        if (this.f1023a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1023a.remove(obj);
        if (this.f1023a.isEmpty()) {
            updateState(false);
        }
    }
}
