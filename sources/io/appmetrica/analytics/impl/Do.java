package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Do extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f558a;

    public Do() {
        super(false, "[WakelocksToggle]");
        this.f558a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f558a.put(obj, null);
        if (this.f558a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f558a.remove(obj);
        if (this.f558a.isEmpty()) {
            updateState(false);
        }
    }
}
