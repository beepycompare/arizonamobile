package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class hp extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f1026a;

    public hp() {
        super(false, "[WakelocksToggle]");
        this.f1026a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f1026a.put(obj, null);
        if (this.f1026a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f1026a.remove(obj);
        if (this.f1026a.isEmpty()) {
            updateState(false);
        }
    }
}
