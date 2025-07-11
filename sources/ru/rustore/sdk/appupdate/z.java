package ru.rustore.sdk.appupdate;

import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.rustore.sdk.appupdate.model.InstallState;
/* loaded from: classes5.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final MutableStateFlow<InstallState> f1369a;
    public final MutableStateFlow b;

    public z() {
        MutableStateFlow<InstallState> MutableStateFlow = StateFlowKt.MutableStateFlow(InstallState.Companion.empty$sdk_public_appupdate_release());
        this.f1369a = MutableStateFlow;
        this.b = MutableStateFlow;
    }
}
