package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class zo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1178a;

    public zo() {
        super(false, "[WakelocksToggle]");
        this.f1178a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1178a.put(obj, null);
        if (this.f1178a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1178a.remove(obj);
        if (this.f1178a.isEmpty()) {
            updateState(false);
        }
    }
}
