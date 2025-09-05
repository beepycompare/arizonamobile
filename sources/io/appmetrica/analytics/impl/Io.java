package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class Io extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f500a;

    public Io() {
        super(false, "[WakelocksToggle]");
        this.f500a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f500a.put(obj, null);
        if (this.f500a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f500a.remove(obj);
        if (this.f500a.isEmpty()) {
            updateState(false);
        }
    }
}
