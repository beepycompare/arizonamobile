package ru.rustore.sdk.appupdate;

import ru.rustore.sdk.appupdate.model.InstallState;
import ru.rustore.sdk.reactive.subject.MutableStateSubject;
import ru.rustore.sdk.reactive.subject.StateSubject;
import ru.rustore.sdk.reactive.subject.SubjectExtensionsKt;
/* loaded from: classes5.dex */
public final class Q {

    /* renamed from: a  reason: collision with root package name */
    public final MutableStateSubject<InstallState> f1347a;
    public final StateSubject<InstallState> b;

    public Q() {
        MutableStateSubject<InstallState> mutableStateSubject = new MutableStateSubject<>(InstallState.Companion.empty$sdk_public_appupdate_release());
        this.f1347a = mutableStateSubject;
        this.b = SubjectExtensionsKt.asStateSubject(mutableStateSubject);
    }
}
