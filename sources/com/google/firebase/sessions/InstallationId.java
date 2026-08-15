package com.google.firebase.sessions;

import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.tasks.TasksKt;
/* compiled from: InstallationId.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/InstallationId;", "", "fid", "", "authToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFid", "()Ljava/lang/String;", "getAuthToken", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstallationId {
    public static final Companion Companion = new Companion(null);
    private final String authToken;
    private final String fid;

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    /* compiled from: InstallationId.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/InstallationId$Companion;", "", "<init>", "()V", "create", "Lcom/google/firebase/sessions/InstallationId;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:(6:11|12|13|(1:15)|16|17)(2:20|21))(2:22|23))(3:30|31|(2:33|28))|24|25|26))|38|6|7|(0)(0)|24|25|26) */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
            android.util.Log.w(com.google.firebase.sessions.FirebaseSessions.TAG, "Error getting authentication token.", r7);
            r7 = r8;
            r8 = "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
            if (r7 != r9) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
            android.util.Log.w(com.google.firebase.sessions.FirebaseSessions.TAG, "Error getting Firebase installation id .", r7);
            r8 = r8;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
        /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object create(FirebaseInstallationsApi firebaseInstallationsApi, Continuation<? super InstallationId> continuation) {
            InstallationId$Companion$create$1 installationId$Companion$create$1;
            int i;
            if (continuation instanceof InstallationId$Companion$create$1) {
                installationId$Companion$create$1 = (InstallationId$Companion$create$1) continuation;
                if ((installationId$Companion$create$1.label & Integer.MIN_VALUE) != 0) {
                    installationId$Companion$create$1.label -= Integer.MIN_VALUE;
                    Object obj = installationId$Companion$create$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = installationId$Companion$create$1.label;
                    String str = "";
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Task<InstallationTokenResult> token = firebaseInstallationsApi.getToken(false);
                        Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
                        installationId$Companion$create$1.L$0 = firebaseInstallationsApi;
                        installationId$Companion$create$1.label = 1;
                        obj = TasksKt.await(token, installationId$Companion$create$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            ?? r8 = (String) installationId$Companion$create$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            firebaseInstallationsApi = r8;
                            String str2 = (String) obj;
                            ?? r82 = firebaseInstallationsApi;
                            if (str2 != null) {
                                str = str2;
                                r82 = firebaseInstallationsApi;
                            }
                            return new InstallationId(str, r82, null);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        firebaseInstallationsApi = (FirebaseInstallationsApi) installationId$Companion$create$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    String token2 = ((InstallationTokenResult) obj).getToken();
                    Intrinsics.checkNotNull(token2);
                    FirebaseInstallationsApi firebaseInstallationsApi2 = firebaseInstallationsApi;
                    String str3 = token2;
                    FirebaseInstallationsApi firebaseInstallationsApi3 = firebaseInstallationsApi2;
                    Task<String> id = firebaseInstallationsApi3.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    installationId$Companion$create$1.L$0 = str3;
                    installationId$Companion$create$1.label = 2;
                    obj = TasksKt.await(id, installationId$Companion$create$1);
                    firebaseInstallationsApi = str3;
                }
            }
            installationId$Companion$create$1 = new InstallationId$Companion$create$1(this, continuation);
            Object obj2 = installationId$Companion$create$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = installationId$Companion$create$1.label;
            String str4 = "";
            if (i != 0) {
            }
            String token22 = ((InstallationTokenResult) obj2).getToken();
            Intrinsics.checkNotNull(token22);
            FirebaseInstallationsApi firebaseInstallationsApi22 = firebaseInstallationsApi;
            String str32 = token22;
            FirebaseInstallationsApi firebaseInstallationsApi32 = firebaseInstallationsApi22;
            Task<String> id2 = firebaseInstallationsApi32.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
            installationId$Companion$create$1.L$0 = str32;
            installationId$Companion$create$1.label = 2;
            obj2 = TasksKt.await(id2, installationId$Companion$create$1);
            firebaseInstallationsApi = str32;
        }
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }
}
