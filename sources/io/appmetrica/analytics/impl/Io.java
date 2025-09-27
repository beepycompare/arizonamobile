package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class Io extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f505a;

    public Io() {
        super(false, "[WakelocksToggle]");
        this.f505a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f505a.put(obj, null);
        if (this.f505a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f505a.remove(obj);
        if (this.f505a.isEmpty()) {
            updateState(false);
        }
    }
}
