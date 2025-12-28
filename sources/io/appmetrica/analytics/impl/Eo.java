package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f566a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f566a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f566a.put(obj, null);
        if (this.f566a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f566a.remove(obj);
        if (this.f566a.isEmpty()) {
            updateState(false);
        }
    }
}
