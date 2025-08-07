package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.InterfaceC0167bo;
import io.appmetrica.analytics.impl.Pd;
/* loaded from: classes4.dex */
public class UserProfileUpdate<T extends InterfaceC0167bo> {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0167bo f1264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserProfileUpdate(Pd pd) {
        this.f1264a = pd;
    }

    public T getUserProfileUpdatePatcher() {
        return (T) this.f1264a;
    }
}
