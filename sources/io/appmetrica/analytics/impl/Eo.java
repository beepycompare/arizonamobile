package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f466a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f466a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f466a.put(obj, null);
        if (this.f466a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f466a.remove(obj);
        if (this.f466a.isEmpty()) {
            updateState(false);
        }
    }
}
