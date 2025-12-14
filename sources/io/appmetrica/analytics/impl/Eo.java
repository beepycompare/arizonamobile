package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f565a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f565a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f565a.put(obj, null);
        if (this.f565a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f565a.remove(obj);
        if (this.f565a.isEmpty()) {
            updateState(false);
        }
    }
}
