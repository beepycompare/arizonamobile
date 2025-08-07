package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Collection;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: FirebaseSessions.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fB+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "settings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "sessionsActivityLifecycleCallbacks", "Lcom/google/firebase/sessions/SessionsActivityLifecycleCallbacks;", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/sessions/settings/SessionsSettings;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/SessionsActivityLifecycleCallbacks;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FirebaseSessions {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FirebaseSessions";
    private final FirebaseApp firebaseApp;
    private final SessionsSettings settings;

    @Inject
    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, @Background CoroutineContext backgroundDispatcher, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(sessionsActivityLifecycleCallbacks, "sessionsActivityLifecycleCallbacks");
        this.firebaseApp = firebaseApp;
        this.settings = settings;
        Log.d(TAG, "Initializing Firebase Sessions 3.0.0.");
        Context applicationContext = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionsActivityLifecycleCallbacks);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(backgroundDispatcher), null, null, new AnonymousClass1(sessionsActivityLifecycleCallbacks, null), 3, null);
            return;
        }
        Integer.valueOf(Log.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.'));
    }

    /* compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionsActivityLifecycleCallbacks $sessionsActivityLifecycleCallbacks;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sessionsActivityLifecycleCallbacks = sessionsActivityLifecycleCallbacks;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$sessionsActivityLifecycleCallbacks, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
            if (r6 == r0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
            if (r5.this$0.settings.updateSettings(r5) == r0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    if (FirebaseSessions.this.settings.getSessionsEnabled()) {
                        FirebaseApp firebaseApp = FirebaseSessions.this.firebaseApp;
                        final SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks = this.$sessionsActivityLifecycleCallbacks;
                        firebaseApp.addLifecycleEventListener(new FirebaseAppLifecycleListener() { // from class: com.google.firebase.sessions.FirebaseSessions$1$$ExternalSyntheticLambda0
                            @Override // com.google.firebase.FirebaseAppLifecycleListener
                            public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
                                FirebaseSessions.AnonymousClass1.invokeSuspend$lambda$1(SessionsActivityLifecycleCallbacks.this, str, firebaseOptions);
                            }
                        });
                        Unit unit = Unit.INSTANCE;
                    } else {
                        Boxing.boxInt(Log.d(FirebaseSessions.TAG, "Sessions SDK disabled. Not listening to lifecycle events."));
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            Collection<SessionSubscriber> values = ((Map) obj).values();
            if (!(values instanceof Collection) || !values.isEmpty()) {
                for (SessionSubscriber sessionSubscriber : values) {
                    if (sessionSubscriber.isDataCollectionEnabled()) {
                        this.label = 2;
                    }
                }
            }
            Boxing.boxInt(Log.d(FirebaseSessions.TAG, "No Sessions subscribers. Not listening to lifecycle events."));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks, String str, FirebaseOptions firebaseOptions) {
            Log.w(FirebaseSessions.TAG, "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            sessionsActivityLifecycleCallbacks.onAppDelete();
        }
    }

    /* compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            return (FirebaseSessions) obj;
        }
    }
}
