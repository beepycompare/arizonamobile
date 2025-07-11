package ru.rustore.sdk.appupdate;

import android.os.Bundle;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.rustore.sdk.activitylauncher.OnReceiveResultCallback;
import ru.rustore.sdk.appupdate.errors.RuStoreInstallException;
import ru.rustore.sdk.core.util.CancellableContinuationExtKt;
/* loaded from: classes5.dex */
public final class n implements OnReceiveResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Integer> f1358a;

    public n(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f1358a = cancellableContinuationImpl;
    }

    @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 2 || i == 9901 || i == 9902) {
            CancellableContinuationExtKt.resumeWithExceptionIfActive(this.f1358a, new RuStoreInstallException(i));
        } else {
            CancellableContinuationExtKt.resumeIfActive(this.f1358a, Integer.valueOf(i));
        }
    }
}
