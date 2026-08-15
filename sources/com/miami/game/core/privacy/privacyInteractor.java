package com.miami.game.core.privacy;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.local.repository.common.LocalRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import timber.log.Timber;
/* compiled from: privacyInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u001c¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/privacy/privacyInteractor;", "", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "Ljavax/inject/Inject;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "startDownloadWasPreviouslyReported", "", "startDownloadEventGate", "Lcom/miami/game/core/privacy/StartDownloadEventGate;", "acceptPrivacy", "", "isPrivacyAccepted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFirstDownload", "startFirstDownload", "finishFirstDownload", "logFirstLaunch", "Companion", "privacy", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class privacyInteractor {
    public static final String FIRST_DOWNLOAD_KEY = "firstDownload";
    public static final String FIRST_LAUNCH_KEY = "firstLaunch";
    public static final String FIRST_START_ERROR_SESSION_KEY = "firstStartErrorSession";
    public static final String FIRST_START_KEY = "firstStart";
    public static final String PRIVACY_ACCEPTED_KEY = "firstOpen";
    public static final String SP_NAME = "SP_NAME";
    public static final String START_DOWNLOAD_REPORTED_KEY = "startDownloadReported";
    private final LocalRepository localRepository;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPreferences;
    private final StartDownloadEventGate startDownloadEventGate;
    private final boolean startDownloadWasPreviouslyReported;
    public static final Companion Companion = new Companion(null);
    private static final String privacyKey = "IS_PRIVACY_ACCEPTED";

    @Inject
    public privacyInteractor(LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.localRepository = localRepository;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        SharedPreferences sharedPreferences = localRepository.getContext().getSharedPreferences("SP_NAME", 0);
        this.sharedPreferences = sharedPreferences;
        boolean wasPreviouslyReported = StartDownloadEventGate.Companion.wasPreviouslyReported(sharedPreferences.getBoolean(START_DOWNLOAD_REPORTED_KEY, false), sharedPreferences.getBoolean(FIRST_DOWNLOAD_KEY, false), sharedPreferences.getBoolean(PRIVACY_ACCEPTED_KEY, false));
        this.startDownloadWasPreviouslyReported = wasPreviouslyReported;
        this.startDownloadEventGate = new StartDownloadEventGate(wasPreviouslyReported, new Function0() { // from class: com.miami.game.core.privacy.privacyInteractor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean commit;
                commit = privacyInteractor.this.sharedPreferences.edit().putBoolean(privacyInteractor.START_DOWNLOAD_REPORTED_KEY, true).commit();
                return Boolean.valueOf(commit);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* compiled from: privacyInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.privacy.privacyInteractor$1", f = "privacyInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.miami.game.core.privacy.privacyInteractor$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (privacyInteractor.this.startDownloadWasPreviouslyReported && !privacyInteractor.this.sharedPreferences.getBoolean(privacyInteractor.START_DOWNLOAD_REPORTED_KEY, false)) {
                    privacyInteractor.this.sharedPreferences.edit().putBoolean(privacyInteractor.START_DOWNLOAD_REPORTED_KEY, true).commit();
                }
                boolean z = privacyInteractor.this.sharedPreferences.getBoolean("firstStart", true);
                privacyInteractor privacyinteractor = privacyInteractor.this;
                if (!z) {
                    privacyinteractor.sharedPreferences.edit().putBoolean("firstStartErrorSession", false).apply();
                } else {
                    privacyinteractor.sharedPreferences.edit().putBoolean("firstStart", false).putBoolean("firstStartErrorSession", true).apply();
                    FirebaseAnalytics.getInstance(privacyInteractor.this.localRepository.getContext()).logEvent("start_application", new Bundle());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void acceptPrivacy() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new privacyInteractor$acceptPrivacy$1(this, null), 3, null);
    }

    public final Object isPrivacyAccepted(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.sharedPreferences.getBoolean(PRIVACY_ACCEPTED_KEY, false));
    }

    public final Object isFirstDownload(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.sharedPreferences.getBoolean(FIRST_DOWNLOAD_KEY, false));
    }

    public final void startFirstDownload() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new privacyInteractor$startFirstDownload$1(this, null), 3, null);
    }

    public final void finishFirstDownload() {
        if (this.sharedPreferences.getBoolean(FIRST_DOWNLOAD_KEY, false)) {
            Timber.Forest.d("finish_first_download", new Object[0]);
            this.sharedPreferences.edit().putBoolean(FIRST_DOWNLOAD_KEY, false).apply();
            FirebaseAnalytics.getInstance(this.localRepository.getContext()).logEvent("end_download", new Bundle());
        }
    }

    public final void logFirstLaunch() {
        if (this.sharedPreferences.getBoolean(FIRST_LAUNCH_KEY, true)) {
            this.sharedPreferences.edit().putBoolean(FIRST_LAUNCH_KEY, false).apply();
            FirebaseAnalytics.getInstance(this.localRepository.getContext()).logEvent("start_game", new Bundle());
        }
    }

    /* compiled from: privacyInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/privacy/privacyInteractor$Companion;", "", "<init>", "()V", "FIRST_START_ERROR_SESSION_KEY", "", "FIRST_START_KEY", "FIRST_DOWNLOAD_KEY", "FIRST_LAUNCH_KEY", "PRIVACY_ACCEPTED_KEY", "START_DOWNLOAD_REPORTED_KEY", "SP_NAME", "privacyKey", "getPrivacyKey", "()Ljava/lang/String;", "privacy"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getPrivacyKey() {
            return privacyInteractor.privacyKey;
        }
    }
}
