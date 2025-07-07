package io.appmetrica.analytics.networktasks.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkTask;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkTask f1227a;
    public final String b;

    public d(NetworkTask networkTask) {
        this.f1227a = networkTask;
        this.b = networkTask.description();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((d) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
