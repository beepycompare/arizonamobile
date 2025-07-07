package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Nd;
import io.appmetrica.analytics.impl.Yn;
/* loaded from: classes4.dex */
public class UserProfileUpdate<T extends Yn> {

    /* renamed from: a  reason: collision with root package name */
    private final Yn f1260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserProfileUpdate(Nd nd) {
        this.f1260a = nd;
    }

    public T getUserProfileUpdatePatcher() {
        return (T) this.f1260a;
    }
}
