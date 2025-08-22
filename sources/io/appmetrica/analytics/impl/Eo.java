package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class Eo extends SimpleThreadSafeToggle {

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap f420a;

    public Eo() {
        super(false, "[WakelocksToggle]");
        this.f420a = new WeakHashMap();
    }

    public final synchronized void a(Object obj) {
        this.f420a.put(obj, null);
        if (this.f420a.size() == 1) {
            updateState(true);
        }
    }

    public final synchronized void b(Object obj) {
        this.f420a.remove(obj);
        if (this.f420a.isEmpty()) {
            updateState(false);
        }
    }
}
