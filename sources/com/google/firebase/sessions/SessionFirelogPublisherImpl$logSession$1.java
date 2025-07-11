package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.settings.SessionsSettings;
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
/* compiled from: SessionFirelogPublisher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", i = {2}, l = {69, 70, 76}, m = "invokeSuspend", n = {"installationId"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = sessionDetails;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        if (r10 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (r10 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        InstallationId installationId;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        FirebaseApp firebaseApp;
        SessionsSettings sessionsSettings;
        FirebaseApp firebaseApp2;
        SessionDetails sessionDetails;
        SessionEvents sessionEvents;
        SessionsSettings sessionsSettings2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.shouldLogSession(this);
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    FirebaseApp firebaseApp3 = (FirebaseApp) this.L$3;
                    SessionEvents sessionEvents2 = (SessionEvents) this.L$2;
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) this.L$1;
                    installationId = (InstallationId) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sessionsSettings2 = (SessionsSettings) this.L$5;
                    sessionEvents = sessionEvents2;
                    sessionDetails = (SessionDetails) this.L$4;
                    firebaseApp2 = firebaseApp3;
                    InstallationId installationId2 = installationId;
                    sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp2, sessionDetails, sessionsSettings2, (Map) obj, installationId2.getFid(), installationId2.getAuthToken()));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            installationId = (InstallationId) obj;
            sessionFirelogPublisherImpl = this.this$0;
            SessionEvents sessionEvents3 = SessionEvents.INSTANCE;
            firebaseApp = this.this$0.firebaseApp;
            SessionDetails sessionDetails2 = this.$sessionDetails;
            sessionsSettings = this.this$0.sessionSettings;
            this.L$0 = installationId;
            this.L$1 = sessionFirelogPublisherImpl;
            this.L$2 = sessionEvents3;
            this.L$3 = firebaseApp;
            this.L$4 = sessionDetails2;
            this.L$5 = sessionsSettings;
            this.label = 3;
            Object registeredSubscribers$com_google_firebase_firebase_sessions = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                firebaseApp2 = firebaseApp;
                obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                sessionDetails = sessionDetails2;
                sessionEvents = sessionEvents3;
                sessionsSettings2 = sessionsSettings;
                InstallationId installationId22 = installationId;
                sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp2, sessionDetails, sessionsSettings2, (Map) obj, installationId22.getFid(), installationId22.getAuthToken()));
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            InstallationId.Companion companion = InstallationId.Companion;
            firebaseInstallationsApi = this.this$0.firebaseInstallations;
            this.label = 2;
            obj = companion.create(firebaseInstallationsApi, this);
        }
        return Unit.INSTANCE;
    }
}
