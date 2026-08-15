package com.arizona.launcher.updater.apk;

import androidx.compose.runtime.ComposerKt;
import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import com.arizona.launcher.updater.apk.LauncherApkOutcome;
import com.arizona.launcher.updater.apk.LauncherApkPreparation;
import com.arizona.launcher.updater.apk.LauncherUpdateController;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherUpdateController$startLauncherApkDownload$job$1", f = "LauncherUpdateController.kt", i = {}, l = {ComposerKt.providerValuesKey}, m = "invokeSuspend", n = {}, nl = {ComposerKt.reuseKey}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherUpdateController$startLauncherApkDownload$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $owner;
    final /* synthetic */ LauncherApkPreparation.Ready $preparation;
    final /* synthetic */ long $token;
    int label;
    final /* synthetic */ LauncherUpdateController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateController$startLauncherApkDownload$job$1(LauncherUpdateController launcherUpdateController, LauncherApkPreparation.Ready ready, Object obj, long j, Continuation<? super LauncherUpdateController$startLauncherApkDownload$job$1> continuation) {
        super(2, continuation);
        this.this$0 = launcherUpdateController;
        this.$preparation = ready;
        this.$owner = obj;
        this.$token = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherUpdateController$startLauncherApkDownload$job$1(this.this$0, this.$preparation, this.$owner, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherUpdateController$startLauncherApkDownload$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks2;
        Function3 function3;
        LauncherApkDownloadObserver apkObserver;
        boolean z;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks3;
        boolean z2;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    function3 = this.this$0.apkDownload;
                    LauncherApkDownloadRequest request = this.$preparation.getRequest();
                    apkObserver = this.this$0.apkObserver(this.$owner, this.$token);
                    this.label = 1;
                    obj = function3.invoke(request, apkObserver, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                LauncherApkDownloadResult launcherApkDownloadResult = (LauncherApkDownloadResult) obj;
                JobKt.ensureActive(getContext());
                if (launcherApkDownloadResult instanceof LauncherApkDownloadResult.Success) {
                    LauncherUpdateController launcherUpdateController = this.this$0;
                    Object obj2 = this.$owner;
                    long j = this.$token;
                    synchronized (launcherUpdateController.apkJobLock) {
                        LauncherUpdateController.ActiveApkDownload activeApkDownload = launcherUpdateController.activeApkDownload;
                        z2 = (activeApkDownload != null ? activeApkDownload.getOwner() : null) == obj2;
                    }
                    if (z2 && ((Boolean) launcherUpdateController.isCurrent.invoke(Boxing.boxLong(j))).booleanValue()) {
                        launcherUpdateControllerCallbacks4 = launcherUpdateController.callbacks;
                        launcherUpdateControllerCallbacks4.onApkOutcome(j, new LauncherApkOutcome.Success((LauncherApkDownloadResult.Success) launcherApkDownloadResult));
                    }
                } else if (launcherApkDownloadResult instanceof LauncherApkDownloadResult.Failure) {
                    LauncherUpdateController launcherUpdateController2 = this.this$0;
                    Object obj3 = this.$owner;
                    long j2 = this.$token;
                    synchronized (launcherUpdateController2.apkJobLock) {
                        LauncherUpdateController.ActiveApkDownload activeApkDownload2 = launcherUpdateController2.activeApkDownload;
                        z = (activeApkDownload2 != null ? activeApkDownload2.getOwner() : null) == obj3;
                    }
                    if (z && ((Boolean) launcherUpdateController2.isCurrent.invoke(Boxing.boxLong(j2))).booleanValue()) {
                        launcherUpdateControllerCallbacks3 = launcherUpdateController2.callbacks;
                        launcherUpdateControllerCallbacks3.onApkOutcome(j2, new LauncherApkOutcome.Failure((LauncherApkDownloadResult.Failure) launcherApkDownloadResult, LauncherApkFailurePolicy.INSTANCE.classify(((LauncherApkDownloadResult.Failure) launcherApkDownloadResult).getError())));
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (Exception unused) {
            }
        } catch (CancellationException e) {
            LauncherUpdateController launcherUpdateController3 = this.this$0;
            Object obj4 = this.$owner;
            long j3 = this.$token;
            synchronized (launcherUpdateController3.apkJobLock) {
                LauncherUpdateController.ActiveApkDownload activeApkDownload3 = launcherUpdateController3.activeApkDownload;
                if (((activeApkDownload3 != null ? activeApkDownload3.getOwner() : null) == obj4) && ((Boolean) launcherUpdateController3.isCurrent.invoke(Boxing.boxLong(j3))).booleanValue()) {
                    try {
                        launcherUpdateControllerCallbacks2 = launcherUpdateController3.callbacks;
                        launcherUpdateControllerCallbacks2.onCancelled(j3, LauncherUpdatePhase.APK_DOWNLOAD);
                    } catch (Exception unused2) {
                    }
                }
                throw e;
            }
        } catch (Exception e2) {
            LauncherUpdateController launcherUpdateController4 = this.this$0;
            Object obj5 = this.$owner;
            long j4 = this.$token;
            synchronized (launcherUpdateController4.apkJobLock) {
                LauncherUpdateController.ActiveApkDownload activeApkDownload4 = launcherUpdateController4.activeApkDownload;
                if (((activeApkDownload4 != null ? activeApkDownload4.getOwner() : null) == obj5) && ((Boolean) launcherUpdateController4.isCurrent.invoke(Boxing.boxLong(j4))).booleanValue()) {
                    launcherUpdateControllerCallbacks = launcherUpdateController4.callbacks;
                    launcherUpdateControllerCallbacks.onUnexpectedFailure(j4, LauncherUpdatePhase.APK_DOWNLOAD, e2);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
