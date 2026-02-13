package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Do extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f557a;

    public Do() {
        super(false, "[WakelocksToggle]");
        this.f557a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f557a.put(obj, null);
        if (this.f557a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f557a.remove(obj);
        if (this.f557a.isEmpty()) {
            updateState(false);
        }
    }
}
