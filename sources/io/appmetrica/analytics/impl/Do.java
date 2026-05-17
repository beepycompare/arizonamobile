package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Do extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f562a;

    public Do() {
        super(false, "[WakelocksToggle]");
        this.f562a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f562a.put(obj, null);
        if (this.f562a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f562a.remove(obj);
        if (this.f562a.isEmpty()) {
            updateState(false);
        }
    }
}
