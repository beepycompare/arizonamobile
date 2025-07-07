package ru.rustore.sdk.appupdate;

import android.os.Bundle;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.rustore.sdk.activitylauncher.OnReceiveResultCallback;
import ru.rustore.sdk.appupdate.errors.RuStoreInstallException;
import ru.rustore.sdk.core.exception.RuStoreOutdatedException;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
/* loaded from: classes5.dex */
public final class o implements OnReceiveResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f1358a;

    public o(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f1358a = cancellableContinuationImpl;
    }

    @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == -1 || i == 0) {
            CancellableContinuationExtKt.resumeIfActive(this.f1358a, Unit.INSTANCE);
        } else if (i == 2) {
            CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1358a, new RuStoreOutdatedException());
        } else if (i == 9901 || i == 9902) {
            CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1358a, new RuStoreInstallException(i));
        } else {
            CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1358a, new RuStoreInstallException(i));
        }
    }
}
