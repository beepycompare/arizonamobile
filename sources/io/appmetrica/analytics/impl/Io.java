package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class Io extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f504a;

    public Io() {
        super(false, "[WakelocksToggle]");
        this.f504a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f504a.put(obj, null);
        if (this.f504a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f504a.remove(obj);
        if (this.f504a.isEmpty()) {
            updateState(false);
        }
    }
}
