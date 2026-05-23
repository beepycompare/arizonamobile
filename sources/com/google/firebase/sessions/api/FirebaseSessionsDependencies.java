package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;
/* compiled from: FirebaseSessionsDependencies.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\tH\u0080@¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0002RN\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies;", "", "<init>", "()V", "dependencies", "", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "kotlin.jvm.PlatformType", "Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "addDependency", "", "subscriberName", "register", "subscriber", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "getRegisteredSubscribers", "getRegisteredSubscribers$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriber", "getSubscriber$com_google_firebase_firebase_sessions", "reset", "reset$com_google_firebase_firebase_sessions", "getDependency", "Dependency", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FirebaseSessionsDependencies {
    public static final FirebaseSessionsDependencies INSTANCE = new FirebaseSessionsDependencies();
    private static final Map<SessionSubscriber.Name, Dependency> dependencies = Collections.synchronizedMap(new LinkedHashMap());

    private FirebaseSessionsDependencies() {
    }

    @JvmStatic
    public static final void addDependency(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        if (dependencies2.containsKey(subscriberName)) {
            Log.d(FirebaseSessions.TAG, "Dependency " + subscriberName + " already added.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
        dependencies2.put(subscriberName, new Dependency(new CountDownLatch(1), null, 2, null));
        Log.d(FirebaseSessions.TAG, "Dependency to " + subscriberName + " added.");
    }

    @JvmStatic
    public static final void register(SessionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        SessionSubscriber.Name sessionSubscriberName = subscriber.getSessionSubscriberName();
        Dependency dependency = INSTANCE.getDependency(sessionSubscriberName);
        if (dependency.getSubscriber() != null) {
            Log.d(FirebaseSessions.TAG, "Subscriber " + sessionSubscriberName + " already registered.");
            return;
        }
        dependency.setSubscriber(subscriber);
        Log.d(FirebaseSessions.TAG, "Subscriber " + sessionSubscriberName + " registered.");
        dependency.getLatch().countDown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[RETURN] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009e -> B:21:0x009f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getRegisteredSubscribers$com_google_firebase_firebase_sessions(Continuation<? super Map<SessionSubscriber.Name, ? extends SessionSubscriber>> continuation) {
        FirebaseSessionsDependencies$getRegisteredSubscribers$1 firebaseSessionsDependencies$getRegisteredSubscribers$1;
        int i;
        Iterator it;
        LinkedHashMap linkedHashMap;
        if (continuation instanceof FirebaseSessionsDependencies$getRegisteredSubscribers$1) {
            firebaseSessionsDependencies$getRegisteredSubscribers$1 = (FirebaseSessionsDependencies$getRegisteredSubscribers$1) continuation;
            if ((firebaseSessionsDependencies$getRegisteredSubscribers$1.label & Integer.MIN_VALUE) != 0) {
                firebaseSessionsDependencies$getRegisteredSubscribers$1.label -= Integer.MIN_VALUE;
                Object obj = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
                    Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
                    it = dependencies2.entrySet().iterator();
                    linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(dependencies2.size()));
                    if (it.hasNext()) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object key = firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4;
                    SessionSubscriber.Name name = (SessionSubscriber.Name) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2;
                    it = (Iterator) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1;
                    ?? r6 = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    LinkedHashMap linkedHashMap2 = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3;
                    linkedHashMap2.put(key, INSTANCE.getSubscriber$com_google_firebase_firebase_sessions(name));
                    linkedHashMap = r6;
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        key = entry.getKey();
                        name = (SessionSubscriber.Name) entry.getKey();
                        final Dependency dependency = (Dependency) entry.getValue();
                        Function0 function0 = new Function0() { // from class: com.google.firebase.sessions.api.FirebaseSessionsDependencies$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FirebaseSessionsDependencies.getRegisteredSubscribers$lambda$2$lambda$1(FirebaseSessionsDependencies.Dependency.this);
                            }
                        };
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0 = linkedHashMap;
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1 = it;
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2 = name;
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3 = linkedHashMap;
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4 = key;
                        firebaseSessionsDependencies$getRegisteredSubscribers$1.label = 1;
                        if (InterruptibleKt.runInterruptible$default(null, function0, firebaseSessionsDependencies$getRegisteredSubscribers$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r6 = linkedHashMap;
                        linkedHashMap2 = linkedHashMap;
                        linkedHashMap2.put(key, INSTANCE.getSubscriber$com_google_firebase_firebase_sessions(name));
                        linkedHashMap = r6;
                        if (it.hasNext()) {
                            return linkedHashMap;
                        }
                    }
                }
            }
        }
        firebaseSessionsDependencies$getRegisteredSubscribers$1 = new FirebaseSessionsDependencies$getRegisteredSubscribers$1(this, continuation);
        Object obj2 = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getRegisteredSubscribers$lambda$2$lambda$1(Dependency dependency) {
        dependency.getLatch().await();
        return Unit.INSTANCE;
    }

    public final SessionSubscriber getSubscriber$com_google_firebase_firebase_sessions(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        SessionSubscriber subscriber = getDependency(subscriberName).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }

    public final void reset$com_google_firebase_firebase_sessions() {
        dependencies.clear();
    }

    private final Dependency getDependency(SessionSubscriber.Name name) {
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
        Dependency dependency = dependencies2.get(name);
        if (dependency != null) {
            Intrinsics.checkNotNullExpressionValue(dependency, "getOrElse(...)");
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FirebaseSessionsDependencies.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "subscriber", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "<init>", "(Ljava/util/concurrent/CountDownLatch;Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "getSubscriber", "()Lcom/google/firebase/sessions/api/SessionSubscriber;", "setSubscriber", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Dependency {
        private final CountDownLatch latch;
        private SessionSubscriber subscriber;

        public static /* synthetic */ Dependency copy$default(Dependency dependency, CountDownLatch countDownLatch, SessionSubscriber sessionSubscriber, int i, Object obj) {
            if ((i & 1) != 0) {
                countDownLatch = dependency.latch;
            }
            if ((i & 2) != 0) {
                sessionSubscriber = dependency.subscriber;
            }
            return dependency.copy(countDownLatch, sessionSubscriber);
        }

        public final CountDownLatch component1() {
            return this.latch;
        }

        public final SessionSubscriber component2() {
            return this.subscriber;
        }

        public final Dependency copy(CountDownLatch latch, SessionSubscriber sessionSubscriber) {
            Intrinsics.checkNotNullParameter(latch, "latch");
            return new Dependency(latch, sessionSubscriber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dependency) {
                Dependency dependency = (Dependency) obj;
                return Intrinsics.areEqual(this.latch, dependency.latch) && Intrinsics.areEqual(this.subscriber, dependency.subscriber);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.latch.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.subscriber;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public String toString() {
            return "Dependency(latch=" + this.latch + ", subscriber=" + this.subscriber + ')';
        }

        public Dependency(CountDownLatch latch, SessionSubscriber sessionSubscriber) {
            Intrinsics.checkNotNullParameter(latch, "latch");
            this.latch = latch;
            this.subscriber = sessionSubscriber;
        }

        public /* synthetic */ Dependency(CountDownLatch countDownLatch, SessionSubscriber sessionSubscriber, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(countDownLatch, (i & 2) != 0 ? null : sessionSubscriber);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public final SessionSubscriber getSubscriber() {
            return this.subscriber;
        }

        public final void setSubscriber(SessionSubscriber sessionSubscriber) {
            this.subscriber = sessionSubscriber;
        }
    }
}
