package com.arizona.launcher.updater.apk;

import androidx.media3.extractor.ts.TsExtractor;
import com.arizona.launcher.updater.apk.LauncherUpdateCheckOutcome;
import com.arizona.launcher.updater.apk.LauncherVersionDecision;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherUpdateController$checkLauncherUpdate$1", f = "LauncherUpdateController.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, nl = {137}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class LauncherUpdateController$checkLauncherUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $server;
    final /* synthetic */ long $token;
    int label;
    final /* synthetic */ LauncherUpdateController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateController$checkLauncherUpdate$1(String str, LauncherUpdateController launcherUpdateController, long j, Continuation<? super LauncherUpdateController$checkLauncherUpdate$1> continuation) {
        super(2, continuation);
        this.$server = str;
        this.this$0 = launcherUpdateController;
        this.$token = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherUpdateController$checkLauncherUpdate$1(this.$server, this.this$0, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherUpdateController$checkLauncherUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks2;
        Function2 function2;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks3;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks4;
        LauncherUpdateConfig launcherUpdateConfig;
        LauncherUpdateConfig launcherUpdateConfig2;
        LauncherUpdateConfig launcherUpdateConfig3;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks5;
        LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    int length = this.$server.length();
                    LauncherUpdateController launcherUpdateController = this.this$0;
                    if (length != 0) {
                        function2 = launcherUpdateController.metadataRequest;
                        this.label = 1;
                        obj = function2.invoke(this.$server + LauncherUpdateController.METADATA_FILE_NAME, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        long j = this.$token;
                        if (((Boolean) launcherUpdateController.isCurrent.invoke(Boxing.boxLong(j))).booleanValue()) {
                            try {
                                launcherUpdateControllerCallbacks3 = launcherUpdateController.callbacks;
                                launcherUpdateControllerCallbacks3.onCheckOutcome(j, LauncherUpdateCheckOutcome.ServerEmpty.INSTANCE);
                            } catch (Exception unused) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                UpdateMetadataHttpResult updateMetadataHttpResult = (UpdateMetadataHttpResult) obj;
                if (updateMetadataHttpResult instanceof UpdateMetadataHttpResult.Success) {
                    LauncherVersionPolicy launcherVersionPolicy = LauncherVersionPolicy.INSTANCE;
                    String body = ((UpdateMetadataHttpResult.Success) updateMetadataHttpResult).getBody();
                    launcherUpdateConfig = this.this$0.config;
                    int installedVersionCode = launcherUpdateConfig.getInstalledVersionCode();
                    launcherUpdateConfig2 = this.this$0.config;
                    String installedVersionName = launcherUpdateConfig2.getInstalledVersionName();
                    launcherUpdateConfig3 = this.this$0.config;
                    LauncherVersionDecision decide = launcherVersionPolicy.decide(body, installedVersionCode, installedVersionName, launcherUpdateConfig3.getBuildType());
                    if (decide instanceof LauncherVersionDecision.Valid) {
                        LauncherUpdateController launcherUpdateController2 = this.this$0;
                        long j2 = this.$token;
                        if (((Boolean) launcherUpdateController2.isCurrent.invoke(Boxing.boxLong(j2))).booleanValue()) {
                            launcherUpdateControllerCallbacks6 = launcherUpdateController2.callbacks;
                            launcherUpdateControllerCallbacks6.onCheckOutcome(j2, new LauncherUpdateCheckOutcome.Success(((LauncherVersionDecision.Valid) decide).getNeedsUpdate()));
                        }
                    } else if (Intrinsics.areEqual(decide, LauncherVersionDecision.InvalidMetadata.INSTANCE)) {
                        LauncherUpdateController launcherUpdateController3 = this.this$0;
                        long j3 = this.$token;
                        if (((Boolean) launcherUpdateController3.isCurrent.invoke(Boxing.boxLong(j3))).booleanValue()) {
                            launcherUpdateControllerCallbacks5 = launcherUpdateController3.callbacks;
                            launcherUpdateControllerCallbacks5.onCheckOutcome(j3, LauncherUpdateCheckOutcome.InvalidMetadata.INSTANCE);
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    LauncherUpdateController launcherUpdateController4 = this.this$0;
                    long j4 = this.$token;
                    if (((Boolean) launcherUpdateController4.isCurrent.invoke(Boxing.boxLong(j4))).booleanValue()) {
                        launcherUpdateControllerCallbacks4 = launcherUpdateController4.callbacks;
                        launcherUpdateControllerCallbacks4.onCheckOutcome(j4, new LauncherUpdateCheckOutcome.RequestFailed(updateMetadataHttpResult));
                    }
                }
            } catch (Exception unused2) {
            }
        } catch (CancellationException e) {
            LauncherUpdateController launcherUpdateController5 = this.this$0;
            long j5 = this.$token;
            if (((Boolean) launcherUpdateController5.isCurrent.invoke(Boxing.boxLong(j5))).booleanValue()) {
                try {
                    launcherUpdateControllerCallbacks2 = launcherUpdateController5.callbacks;
                    launcherUpdateControllerCallbacks2.onCancelled(j5, LauncherUpdatePhase.METADATA_CHECK);
                } catch (Exception unused3) {
                }
            }
            throw e;
        } catch (Exception e2) {
            LauncherUpdateController launcherUpdateController6 = this.this$0;
            long j6 = this.$token;
            if (((Boolean) launcherUpdateController6.isCurrent.invoke(Boxing.boxLong(j6))).booleanValue()) {
                launcherUpdateControllerCallbacks = launcherUpdateController6.callbacks;
                launcherUpdateControllerCallbacks.onUnexpectedFailure(j6, LauncherUpdatePhase.METADATA_CHECK, e2);
            }
        }
        return Unit.INSTANCE;
    }
}
