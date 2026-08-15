package com.miami.game.core.privacy;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: privacyInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.privacy.privacyInteractor$startFirstDownload$1", f = "privacyInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class privacyInteractor$startFirstDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ privacyInteractor this$0;

    /* compiled from: privacyInteractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StartDownloadClaimResult.values().length];
            try {
                iArr[StartDownloadClaimResult.CLAIMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StartDownloadClaimResult.ALREADY_REPORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StartDownloadClaimResult.PERSISTENCE_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public privacyInteractor$startFirstDownload$1(privacyInteractor privacyinteractor, Continuation<? super privacyInteractor$startFirstDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = privacyinteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new privacyInteractor$startFirstDownload$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((privacyInteractor$startFirstDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StartDownloadEventGate startDownloadEventGate;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            startDownloadEventGate = this.this$0.startDownloadEventGate;
            int i = WhenMappings.$EnumSwitchMapping$0[startDownloadEventGate.claim().ordinal()];
            if (i == 1) {
                this.this$0.sharedPreferences.edit().putBoolean(privacyInteractor.FIRST_DOWNLOAD_KEY, true).apply();
                Timber.Forest.d("start_first_download", new Object[0]);
                FirebaseAnalytics.getInstance(this.this$0.localRepository.getContext()).logEvent("start_download", new Bundle());
            } else if (i == 2) {
                Timber.Forest.d("start_first_download_already_reported", new Object[0]);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                Timber.Forest.e("start_first_download_marker_persistence_failed", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
