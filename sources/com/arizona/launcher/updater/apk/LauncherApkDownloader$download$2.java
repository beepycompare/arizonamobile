package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkDownloadError;
import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherApkDownloader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader$download$2", f = "LauncherApkDownloader.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"validated", "owner"}, nl = {99}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherApkDownloader$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LauncherApkDownloadResult>, Object> {
    final /* synthetic */ LauncherApkDownloadObserver $observer;
    final /* synthetic */ LauncherApkDownloadRequest $request;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LauncherApkDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherApkDownloader$download$2(LauncherApkDownloader launcherApkDownloader, LauncherApkDownloadRequest launcherApkDownloadRequest, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super LauncherApkDownloader$download$2> continuation) {
        super(2, continuation);
        this.this$0 = launcherApkDownloader;
        this.$request = launcherApkDownloadRequest;
        this.$observer = launcherApkDownloadObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherApkDownloader$download$2(this.this$0, this.$request, this.$observer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LauncherApkDownloadResult> continuation) {
        return ((LauncherApkDownloader$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.arizona.launcher.updater.apk.LauncherApkDownloader$ValidatedRequest] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.arizona.launcher.updater.apk.LauncherApkDownloader$ValidatedRequest] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.arizona.launcher.updater.apk.LauncherApkDownloader$ValidatedRequest, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LauncherApkNetworkPolicy launcherApkNetworkPolicy;
        Object obj2;
        LauncherApkDownloadError invalidRequestError;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        LauncherApkDownloader.ValidatedRequest validatedRequest = this.label;
        try {
            if (validatedRequest == 0) {
                ResultKt.throwOnFailure(obj);
                validatedRequest = this.this$0.validateRequest(this.$request);
                if (validatedRequest == 0) {
                    invalidRequestError = this.this$0.invalidRequestError(this.$request);
                    return new LauncherApkDownloadResult.Failure(invalidRequestError, 0);
                }
                launcherApkNetworkPolicy = this.this$0.networkPolicy;
                if (!launcherApkNetworkPolicy.isAllowed(validatedRequest.getSourceUrl())) {
                    return new LauncherApkDownloadResult.Failure(new LauncherApkDownloadError.UnsafeUrl(validatedRequest.getSourceUrl().toString()), 0);
                }
                Object obj3 = new Object();
                if (LauncherApkDestinationRegistry.INSTANCE.tryAcquire(validatedRequest.getDestinationKey(), obj3)) {
                    try {
                        this.L$0 = validatedRequest;
                        this.L$1 = obj3;
                        this.label = 1;
                        obj = this.this$0.downloadOwned(validatedRequest, this.$observer, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj3;
                        validatedRequest = validatedRequest;
                    } catch (CancellationException e) {
                        e = e;
                        this.this$0.discardNonResumablePartialQuietly(validatedRequest);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        coroutine_suspended = obj3;
                        LauncherApkDestinationRegistry.INSTANCE.release(validatedRequest.getDestinationKey(), coroutine_suspended);
                        throw th;
                    }
                } else {
                    return new LauncherApkDownloadResult.Failure(LauncherApkDownloadError.DestinationBusy.INSTANCE, 0);
                }
            } else if (validatedRequest != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                obj2 = this.L$1;
                validatedRequest = (LauncherApkDownloader.ValidatedRequest) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    validatedRequest = validatedRequest;
                } catch (CancellationException e2) {
                    e = e2;
                    this.this$0.discardNonResumablePartialQuietly(validatedRequest);
                    throw e;
                }
            }
            LauncherApkDownloadResult launcherApkDownloadResult = (LauncherApkDownloadResult) obj;
            LauncherApkDestinationRegistry.INSTANCE.release(validatedRequest.getDestinationKey(), obj2);
            return launcherApkDownloadResult;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
