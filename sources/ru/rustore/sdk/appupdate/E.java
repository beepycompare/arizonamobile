package ru.rustore.sdk.appupdate;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.activitylauncher.ActivityLauncherResult;
import ru.rustore.sdk.activitylauncher.ContextExtensionKt;
import ru.rustore.sdk.activitylauncher.OnReceiveResultCallback;
import ru.rustore.sdk.appupdate.errors.RuStoreInstallException;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes4.dex */
public final class E extends Lambda implements Function1<SingleEmitter<Integer>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0813r f1349a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(C0813r c0813r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1349a = c0813r;
        this.b = appUpdateInfo;
    }

    public final void a(final SingleEmitter<Integer> emitter) {
        Object m9084constructorimpl;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0813r c0813r = this.f1349a;
        AppUpdateInfo appUpdateInfo = this.b;
        try {
            Result.Companion companion = Result.Companion;
            ContextExtensionKt.openActivityForResult(c0813r.f1405a, new Intent("ru.vk.store.AnyAppForceUpdateActivity"), new OnReceiveResultCallback() { // from class: ru.rustore.sdk.appupdate.E$$ExternalSyntheticLambda0
                @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
                public final void onReceiveResult(ActivityLauncherResult activityLauncherResult, Bundle bundle) {
                    E.a(SingleEmitter.this, activityLauncherResult, bundle);
                }
            });
            appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
            m9084constructorimpl = Result.m9084constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9084constructorimpl = Result.m9084constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9087exceptionOrNullimpl = Result.m9087exceptionOrNullimpl(m9084constructorimpl);
        if (m9087exceptionOrNullimpl != null) {
            emitter.error(m9087exceptionOrNullimpl);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SingleEmitter<Integer> singleEmitter) {
        a(singleEmitter);
        return Unit.INSTANCE;
    }

    public static final void a(SingleEmitter emitter, ActivityLauncherResult launcherResult, Bundle bundle) {
        Intrinsics.checkNotNullParameter(emitter, "$emitter");
        Intrinsics.checkNotNullParameter(launcherResult, "launcherResult");
        if (launcherResult instanceof ActivityLauncherResult.ActivityResultUnknown ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivitySendIntentError.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityUnknownError.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityNotFound.INSTANCE)) {
            emitter.error(new RuStoreInstallException(launcherResult.getCode()));
            return;
        }
        if (Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultCanceled.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultOk.INSTANCE)) {
            emitter.success(Integer.valueOf(launcherResult.getCode()));
        }
    }
}
