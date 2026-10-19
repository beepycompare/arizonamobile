package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Ho;
/* loaded from: classes5.dex */
public class UserProfileUpdate<T extends Ho> {

    /* renamed from: a  reason: collision with root package name */
    private final Ho f1426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserProfileUpdate(Ho ho) {
        this.f1426a = ho;
    }

    public T getUserProfileUpdatePatcher() {
        return (T) this.f1426a;
    }
}
