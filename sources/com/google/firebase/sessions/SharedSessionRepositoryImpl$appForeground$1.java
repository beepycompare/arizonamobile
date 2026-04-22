package com.google.firebase.sessions;

import android.util.Log;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.util.Map;
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
/* compiled from: SharedSessionRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1", f = "SharedSessionRepository.kt", i = {}, l = {142, DownloaderService.STATUS_PAUSED_BY_APP}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SharedSessionRepositoryImpl$appForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionData $sessionData;
    int label;
    final /* synthetic */ SharedSessionRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedSessionRepositoryImpl$appForeground$1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, SessionData sessionData, Continuation<? super SharedSessionRepositoryImpl$appForeground$1> continuation) {
        super(2, continuation);
        this.this$0 = sharedSessionRepositoryImpl;
        this.$sessionData = sessionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharedSessionRepositoryImpl$appForeground$1(this.this$0, this.$sessionData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SharedSessionRepositoryImpl$appForeground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r9 == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
        if (r9.this$0.notifySubscribers(r4.getSessionId(), com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType.FALLBACK, r9) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean isSessionExpired;
        SessionFirelogPublisher sessionFirelogPublisher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            Log.d(FirebaseSessions.TAG, "App foregrounded, failed to update data. Message: " + e.getMessage());
            isSessionExpired = this.this$0.isSessionExpired(this.$sessionData);
            if (isSessionExpired) {
                SessionDetails generateNewSession = this.this$0.sessionGenerator.generateNewSession(this.$sessionData.getSessionDetails());
                this.this$0.setLocalSessionData$com_google_firebase_firebase_sessions(SessionData.copy$default(this.$sessionData, generateNewSession, null, null, 4, null));
                sessionFirelogPublisher = this.this$0.sessionFirelogPublisher;
                sessionFirelogPublisher.mayLogSession(generateNewSession);
                this.label = 2;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object updateData = this.this$0.sessionDataStore.updateData(new AnonymousClass1(this.this$0, null), this);
            this = updateData;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            this = this;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SharedSessionRepository.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/google/firebase/sessions/SessionData;", "currentSessionData"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1", f = "SharedSessionRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SessionData, Continuation<? super SessionData>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SharedSessionRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = sharedSessionRepositoryImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SessionData sessionData, Continuation<? super SessionData> continuation) {
            return ((AnonymousClass1) create(sessionData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean isSessionExpired;
            boolean isColdStart;
            boolean isMyProcessStale;
            Map<String, ProcessData> processDataMap;
            ProcessDataManager processDataManager;
            SessionFirelogPublisher sessionFirelogPublisher;
            ProcessDataManager processDataManager2;
            ProcessDataManager processDataManager3;
            ProcessDataManager processDataManager4;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SessionData sessionData = (SessionData) this.L$0;
                isSessionExpired = this.this$0.isSessionExpired(sessionData);
                isColdStart = this.this$0.isColdStart(sessionData);
                isMyProcessStale = this.this$0.isMyProcessStale(sessionData);
                if (isColdStart) {
                    processDataManager4 = this.this$0.processDataManager;
                    processDataMap = processDataManager4.generateProcessDataMap();
                } else if (isMyProcessStale) {
                    processDataManager = this.this$0.processDataManager;
                    processDataMap = processDataManager.updateProcessDataMap(sessionData.getProcessDataMap());
                } else {
                    processDataMap = sessionData.getProcessDataMap();
                }
                SessionDetails sessionDetails = isColdStart ? null : sessionData.getSessionDetails();
                if (!isSessionExpired && !isColdStart) {
                    if (isMyProcessStale) {
                        processDataManager3 = this.this$0.processDataManager;
                        return SessionData.copy$default(sessionData, null, null, processDataManager3.updateProcessDataMap(processDataMap), 3, null);
                    }
                    return sessionData;
                }
                SessionDetails generateNewSession = this.this$0.sessionGenerator.generateNewSession(sessionDetails);
                sessionFirelogPublisher = this.this$0.sessionFirelogPublisher;
                sessionFirelogPublisher.mayLogSession(generateNewSession);
                processDataManager2 = this.this$0.processDataManager;
                processDataManager2.onSessionGenerated();
                return sessionData.copy(generateNewSession, null, processDataMap);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
