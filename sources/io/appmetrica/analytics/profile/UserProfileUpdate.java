package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.Pd;
/* loaded from: classes4.dex */
public class UserProfileUpdate<T extends InterfaceC0166bo> {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0166bo f1265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserProfileUpdate(Pd pd) {
        this.f1265a = pd;
    }

    public T getUserProfileUpdatePatcher() {
        return (T) this.f1265a;
    }
}
