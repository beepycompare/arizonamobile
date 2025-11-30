package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f468a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f468a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f468a.put(obj, null);
        if (this.f468a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f468a.remove(obj);
        if (this.f468a.isEmpty()) {
            updateState(false);
        }
    }
}
