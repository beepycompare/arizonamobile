package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class hp extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1029a;

    public hp() {
        super(false, "[WakelocksToggle]");
        this.f1029a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1029a.put(obj, null);
        if (this.f1029a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1029a.remove(obj);
        if (this.f1029a.isEmpty()) {
            updateState(false);
        }
    }
}
