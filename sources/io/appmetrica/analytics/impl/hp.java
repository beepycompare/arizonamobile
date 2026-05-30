package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class hp extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1024a;

    public hp() {
        super(false, "[WakelocksToggle]");
        this.f1024a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1024a.put(obj, null);
        if (this.f1024a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1024a.remove(obj);
        if (this.f1024a.isEmpty()) {
            updateState(false);
        }
    }
}
