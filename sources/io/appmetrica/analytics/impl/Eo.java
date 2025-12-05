package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f551a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f551a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f551a.put(obj, null);
        if (this.f551a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f551a.remove(obj);
        if (this.f551a.isEmpty()) {
            updateState(false);
        }
    }
}
