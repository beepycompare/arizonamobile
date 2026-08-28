package com.miami.game.core.connection.resolver;

import android.content.SharedPreferences;
import android.util.Log;
import com.arizona.game.BuildConfig;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.net.HttpHeaders;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0011J\f\u00101\u001a\u00020\u0013*\u00020\u0013H\u0002J\u0010\u00102\u001a\u0004\u0018\u00010\u00112\u0006\u00100\u001a\u00020\u0011J\f\u00103\u001a\u00020\u0005*\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013H\u0002J\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001107H\u0086@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u00108J\u000e\u0010:\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00108J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010<\u001a\u00020*H\u0002J\u0016\u0010=\u001a\u00020*2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00110\"H\u0002J\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001107H\u0086@¢\u0006\u0002\u00108J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110A2\b\b\u0002\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00112\b\b\u0002\u0010B\u001a\u00020\u0005J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110A2\b\b\u0002\u0010B\u001a\u00020\u0005J\u0006\u0010E\u001a\u00020\u0011J\u0006\u0010F\u001a\u00020\u0011J\u0006\u0010G\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\"0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/miami/game/core/connection/resolver/FirebaseConfigHelper;", "", "<init>", "()V", "isDebug", "", "isArizona", "isBrazil", "sharedPref", "Landroid/content/SharedPreferences;", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "remoteConfig$delegate", "Lkotlin/Lazy;", "getRawLink", "", "type", "Lcom/miami/game/core/connection/resolver/FirebaseConfigLinks;", "linkCache", "Ljava/util/concurrent/ConcurrentHashMap;", "hostRegex", "Lkotlin/text/Regex;", "remoteConfigReadyMutex", "Lkotlinx/coroutines/sync/Mutex;", "remoteConfigFetchTaskLock", "remoteConfigFetchTask", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "remoteConfigReady", "remoteConfigListenerRegistered", "_remoteConfigUpdates", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "remoteConfigUpdates", "Lkotlinx/coroutines/flow/SharedFlow;", "getRemoteConfigUpdates", "()Lkotlinx/coroutines/flow/SharedFlow;", "httpClient", "Lokhttp3/OkHttpClient;", "setDebug", "", "debug", BuildConfig.FLAVOR, "sharedPreferences", "brazil", "isServiceAvailable", "url", "toReserve", "extractHost", "hasReserve", "fetchLink", "primary", "bootstrap", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRemoteConfigReady", "fetchAndActivateWithRetry", "currentOrStartRemoteConfigFetch", "registerRemoteConfigUpdates", "publishRemoteConfigUpdate", "updatedKeys", "fetchAll", "getResourceUrls", "", "useDebug", "getProjectResourceUrl", "getProjectResourceUrls", "getServerApiUrl", "getHudPingUrl", "getChannelsState", "connection-resolver"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper {
    private static final MutableSharedFlow<Set<String>> _remoteConfigUpdates;
    private static final OkHttpClient httpClient;
    private static boolean isArizona;
    private static boolean isBrazil;
    private static boolean isDebug;
    private static volatile Task<Void> remoteConfigFetchTask;
    private static volatile boolean remoteConfigListenerRegistered;
    private static volatile boolean remoteConfigReady;
    private static final SharedFlow<Set<String>> remoteConfigUpdates;
    private static SharedPreferences sharedPref;
    public static final FirebaseConfigHelper INSTANCE = new FirebaseConfigHelper();
    private static final Lazy remoteConfig$delegate = LazyKt.lazy(new Function0() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FirebaseRemoteConfig firebaseRemoteConfig;
            firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
            return firebaseRemoteConfig;
        }
    });
    private static final ConcurrentHashMap<FirebaseConfigLinks, String> linkCache = new ConcurrentHashMap<>();
    private static final Regex hostRegex = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*://([^/:]+)");
    private static final Mutex remoteConfigReadyMutex = MutexKt.Mutex$default(false, 1, null);
    private static final Object remoteConfigFetchTaskLock = new Object();

    /* compiled from: FirebaseServerHandler.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FirebaseConfigLinks.values().length];
            try {
                iArr[FirebaseConfigLinks.MAIN_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FirebaseConfigLinks.SERVER_API.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FirebaseConfigLinks.MAIN_SOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FirebaseConfigLinks.MAIN_HUD_PING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FirebaseConfigHelper() {
    }

    static {
        MutableSharedFlow<Set<String>> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST);
        _remoteConfigUpdates = MutableSharedFlow;
        remoteConfigUpdates = FlowKt.asSharedFlow(MutableSharedFlow);
        httpClient = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).writeTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FirebaseRemoteConfig getRemoteConfig() {
        Object value = remoteConfig$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FirebaseRemoteConfig) value;
    }

    private final String getRawLink(FirebaseConfigLinks firebaseConfigLinks) {
        String string = getRemoteConfig().getString(firebaseConfigLinks.getKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final SharedFlow<Set<String>> getRemoteConfigUpdates() {
        return remoteConfigUpdates;
    }

    public static /* synthetic */ void setDebug$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, boolean z2, SharedPreferences sharedPreferences, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        firebaseConfigHelper.setDebug(z, z2, sharedPreferences, z3);
    }

    public final void setDebug(boolean z, boolean z2, SharedPreferences sharedPreferences, boolean z3) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        isDebug = z;
        isArizona = z2;
        isBrazil = z3;
        sharedPref = sharedPreferences;
    }

    public final boolean isServiceAvailable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String extractHost = extractHost(url);
        String str = extractHost;
        if (str == null || StringsKt.isBlank(str)) {
            Log.w("FirebaseSrvHandler", "isServiceAvailable: cannot extract host from url=" + url);
            return false;
        }
        try {
            try {
                Response execute = httpClient.newCall(new Request.Builder().url("https://" + extractHost + "/ping.json").header(HttpHeaders.USER_AGENT, "Arizona Mobile").get().build()).execute();
                Response response = execute;
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    String string = body != null ? body.string() : null;
                    String str2 = string;
                    if (str2 != null && str2.length() != 0) {
                        try {
                            String optString = new JSONObject(string).optString("hash");
                            boolean areEqual = Intrinsics.areEqual(optString, "5aa4731d5d84e09e2f7e7141e560104f");
                            if (areEqual) {
                                Log.d("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " OK");
                            } else {
                                Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " hash mismatch got=" + optString);
                            }
                            CloseableKt.closeFinally(execute, null);
                            return areEqual;
                        } catch (JSONException e) {
                            Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " bad json: " + e.getMessage());
                            CloseableKt.closeFinally(execute, null);
                            return false;
                        }
                    }
                    Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " empty body");
                } else {
                    Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " non-2xx code=" + response.code());
                }
                CloseableKt.closeFinally(execute, null);
                return false;
            } catch (Exception e2) {
                Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " " + e2.getClass().getSimpleName() + ": " + e2.getMessage());
                return false;
            }
        } catch (Exception e3) {
            Log.w("FirebaseSrvHandler", "isServiceAvailable: cannot build request for host=" + extractHost + ": " + e3.getMessage());
            return false;
        }
    }

    private final FirebaseConfigLinks toReserve(FirebaseConfigLinks firebaseConfigLinks) {
        int i = WhenMappings.$EnumSwitchMapping$0[firebaseConfigLinks.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return FirebaseConfigLinks.RESERVE_HUD_PING;
                    }
                    throw new IllegalArgumentException("There is no backup link for " + firebaseConfigLinks + " channel.");
                }
                return FirebaseConfigLinks.RESERVE_SOUND;
            }
            return FirebaseConfigLinks.RESERVE_SERVER_API;
        }
        return FirebaseConfigLinks.RESERVE_RESOURCE;
    }

    public final String extractHost(String url) {
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(url, "url");
        MatchResult find$default = Regex.find$default(hostRegex, url, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null) {
            return null;
        }
        return groupValues.get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasReserve(FirebaseConfigLinks firebaseConfigLinks) {
        Object m9920constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(INSTANCE.toReserve(firebaseConfigLinks));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9927isSuccessimpl(m9920constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchLink(FirebaseConfigLinks firebaseConfigLinks) {
        Object m9920constructorimpl;
        String rawLink = getRawLink(firebaseConfigLinks);
        if (isServiceAvailable(rawLink)) {
            return rawLink;
        }
        try {
            Result.Companion companion = Result.Companion;
            FirebaseConfigHelper firebaseConfigHelper = this;
            m9920constructorimpl = Result.m9920constructorimpl(getRawLink(toReserve(firebaseConfigLinks)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9926isFailureimpl(m9920constructorimpl)) {
            m9920constructorimpl = null;
        }
        String str = (String) m9920constructorimpl;
        if (str != null && isServiceAvailable(str)) {
            Log.w("FirebaseSrvHandler", "fetchLink: primary=" + firebaseConfigLinks.getKey() + " down, fall back to reserve");
            return str;
        }
        Log.w("FirebaseSrvHandler", "fetchLink: primary=" + firebaseConfigLinks.getKey() + " and reserve both unavailable, keep primary");
        return rawLink;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (awaitRemoteConfigReady(r0) == r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bootstrap(Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        FirebaseConfigHelper$bootstrap$1 firebaseConfigHelper$bootstrap$1;
        int i;
        if (continuation instanceof FirebaseConfigHelper$bootstrap$1) {
            firebaseConfigHelper$bootstrap$1 = (FirebaseConfigHelper$bootstrap$1) continuation;
            if ((firebaseConfigHelper$bootstrap$1.label & Integer.MIN_VALUE) != 0) {
                firebaseConfigHelper$bootstrap$1.label -= Integer.MIN_VALUE;
                Object obj = firebaseConfigHelper$bootstrap$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = firebaseConfigHelper$bootstrap$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    firebaseConfigHelper$bootstrap$1.label = 1;
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                firebaseConfigHelper$bootstrap$1.label = 2;
                Object fetchAll = fetchAll(firebaseConfigHelper$bootstrap$1);
                return fetchAll != coroutine_suspended ? coroutine_suspended : fetchAll;
            }
        }
        firebaseConfigHelper$bootstrap$1 = new FirebaseConfigHelper$bootstrap$1(this, continuation);
        Object obj2 = firebaseConfigHelper$bootstrap$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = firebaseConfigHelper$bootstrap$1.label;
        if (i != 0) {
        }
        firebaseConfigHelper$bootstrap$1.label = 2;
        Object fetchAll2 = fetchAll(firebaseConfigHelper$bootstrap$1);
        if (fetchAll2 != coroutine_suspended2) {
        }
    }

    public final Object awaitRemoteConfigReady(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FirebaseConfigHelper$awaitRemoteConfigReady$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ce -> B:34:0x00e3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e0 -> B:34:0x00e3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAndActivateWithRetry(Continuation<? super Boolean> continuation) {
        FirebaseConfigHelper$fetchAndActivateWithRetry$1 firebaseConfigHelper$fetchAndActivateWithRetry$1;
        int i;
        int i2;
        int i3;
        int i4;
        if (continuation instanceof FirebaseConfigHelper$fetchAndActivateWithRetry$1) {
            firebaseConfigHelper$fetchAndActivateWithRetry$1 = (FirebaseConfigHelper$fetchAndActivateWithRetry$1) continuation;
            if ((firebaseConfigHelper$fetchAndActivateWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                firebaseConfigHelper$fetchAndActivateWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = firebaseConfigHelper$fetchAndActivateWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = firebaseConfigHelper$fetchAndActivateWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 2;
                    i3 = 0;
                    if (i3 < i2) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = firebaseConfigHelper$fetchAndActivateWithRetry$1.I$3;
                    int i6 = firebaseConfigHelper$fetchAndActivateWithRetry$1.I$2;
                    i3 = firebaseConfigHelper$fetchAndActivateWithRetry$1.I$1;
                    i2 = firebaseConfigHelper$fetchAndActivateWithRetry$1.I$0;
                    ResultKt.throwOnFailure(obj);
                    i3++;
                    if (i3 < i2) {
                        try {
                        } catch (CancellationException e) {
                            throw e;
                        } catch (TimeoutException unused) {
                            Log.w("FirebaseSrvHandler", "fetchAndActivateWithRetry: attempt=" + (i3 + 1) + " timed out; do not overlap another fetch");
                            return Boxing.boxBoolean(false);
                        } catch (Throwable th) {
                            Log.w("FirebaseSrvHandler", "fetchAndActivateWithRetry: fetch attempt=" + (i3 + 1) + " failed: " + th.getMessage());
                            i4 = 0;
                        }
                        Tasks.await(INSTANCE.currentOrStartRemoteConfigFetch(), 20L, TimeUnit.SECONDS);
                        i4 = 1;
                        if (i4 != 0) {
                            try {
                            } catch (CancellationException e2) {
                                throw e2;
                            } catch (TimeoutException unused2) {
                                Log.w("FirebaseSrvHandler", "fetchAndActivateWithRetry: activate timed out; do not overlap another activation");
                                return Boxing.boxBoolean(false);
                            } catch (Throwable th2) {
                                Log.w("FirebaseSrvHandler", "fetchAndActivateWithRetry: activate attempt=" + (i3 + 1) + " failed: " + th2.getMessage());
                            }
                            FirebaseConfigHelper firebaseConfigHelper = INSTANCE;
                            Tasks.await(firebaseConfigHelper.getRemoteConfig().activate(), 5L, TimeUnit.SECONDS);
                            firebaseConfigHelper.publishRemoteConfigUpdate(firebaseConfigHelper.getRemoteConfig().getAll().keySet());
                            return Boxing.boxBoolean(true);
                        }
                        if (i3 < 1) {
                            firebaseConfigHelper$fetchAndActivateWithRetry$1.I$0 = i2;
                            firebaseConfigHelper$fetchAndActivateWithRetry$1.I$1 = i3;
                            firebaseConfigHelper$fetchAndActivateWithRetry$1.I$2 = i3;
                            firebaseConfigHelper$fetchAndActivateWithRetry$1.I$3 = i4;
                            firebaseConfigHelper$fetchAndActivateWithRetry$1.label = 1;
                            if (DelayKt.delay(1000L, firebaseConfigHelper$fetchAndActivateWithRetry$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        i3++;
                        if (i3 < i2) {
                            return Boxing.boxBoolean(false);
                        }
                    }
                }
            }
        }
        firebaseConfigHelper$fetchAndActivateWithRetry$1 = new FirebaseConfigHelper$fetchAndActivateWithRetry$1(this, continuation);
        Object obj2 = firebaseConfigHelper$fetchAndActivateWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = firebaseConfigHelper$fetchAndActivateWithRetry$1.label;
        if (i != 0) {
        }
    }

    private final Task<Void> currentOrStartRemoteConfigFetch() {
        final Task<Void> task;
        synchronized (remoteConfigFetchTaskLock) {
            task = remoteConfigFetchTask;
            if (task == null) {
                task = INSTANCE.getRemoteConfig().fetch(0L);
                remoteConfigFetchTask = task;
                task.addOnCompleteListener(new OnCompleteListener() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task2) {
                        FirebaseConfigHelper.currentOrStartRemoteConfigFetch$lambda$0$0$0(Task.this, task2);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(task, "also(...)");
            }
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void currentOrStartRemoteConfigFetch$lambda$0$0$0(Task task, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        synchronized (remoteConfigFetchTaskLock) {
            if (remoteConfigFetchTask == task) {
                remoteConfigFetchTask = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRemoteConfigUpdates() {
        if (remoteConfigListenerRegistered) {
            return;
        }
        try {
            getRemoteConfig().addOnConfigUpdateListener(new FirebaseConfigHelper$registerRemoteConfigUpdates$1());
            remoteConfigListenerRegistered = true;
        } catch (Throwable th) {
            remoteConfigListenerRegistered = false;
            Log.w("FirebaseSrvHandler", "remoteConfigUpdate: listener registration failed: " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishRemoteConfigUpdate(Set<String> set) {
        Log.d("FirebaseSrvHandler", "remoteConfigUpdate: activated keys=" + set);
        _remoteConfigUpdates.tryEmit(set);
    }

    public final Object fetchAll(Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FirebaseConfigHelper$fetchAll$2(null), continuation);
    }

    static /* synthetic */ List getResourceUrls$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getResourceUrls(z);
    }

    private final List<String> getResourceUrls(boolean z) {
        SharedPreferences sharedPreferences = sharedPref;
        int i = sharedPreferences != null ? sharedPreferences.getInt("server_id", 1) : 1;
        if (isDebug && z && isArizona && i == 0) {
            return CollectionsKt.listOf("https://staging-cdn.azresources.cloud/");
        }
        String[] strArr = {linkCache.get(FirebaseConfigLinks.MAIN_RESOURCE), getRawLink(FirebaseConfigLinks.MAIN_RESOURCE), getRawLink(FirebaseConfigLinks.RESERVE_RESOURCE)};
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.listOfNotNull((Object[]) strArr)) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.distinct(arrayList);
    }

    public static /* synthetic */ String getProjectResourceUrl$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getProjectResourceUrl(z);
    }

    public final String getProjectResourceUrl(boolean z) {
        String str = (String) CollectionsKt.firstOrNull((List<? extends Object>) getProjectResourceUrls(z));
        return str == null ? "" : str;
    }

    public static /* synthetic */ List getProjectResourceUrls$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getProjectResourceUrls(z);
    }

    public final List<String> getProjectResourceUrls(boolean z) {
        String str;
        if (isArizona) {
            str = isBrazil ? "projects/brazil-rp/" : "projects/arizona-rp/";
        } else {
            str = "projects/rodina-rp/";
        }
        List<String> resourceUrls = getResourceUrls(z);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(resourceUrls, 10));
        Iterator<T> it = resourceUrls.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trimEnd((String) it.next(), '/') + "/" + str);
        }
        return arrayList;
    }

    public final String getServerApiUrl() {
        String str = linkCache.get(FirebaseConfigLinks.SERVER_API);
        return str == null ? getRawLink(FirebaseConfigLinks.SERVER_API) : str;
    }

    public final String getHudPingUrl() {
        String str = linkCache.get(FirebaseConfigLinks.MAIN_HUD_PING);
        return str == null ? getRawLink(FirebaseConfigLinks.MAIN_HUD_PING) : str;
    }

    public final String getChannelsState() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new FirebaseConfigLinks[]{FirebaseConfigLinks.MAIN_RESOURCE, FirebaseConfigLinks.MAIN_SOUND, FirebaseConfigLinks.SERVER_API}), StringUtils.COMMA, null, null, 0, null, new Function1() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FirebaseConfigHelper.getChannelsState$lambda$0((FirebaseConfigLinks) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence getChannelsState$lambda$0(FirebaseConfigLinks linkType) {
        Object m9920constructorimpl;
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        String str = linkCache.get(linkType);
        if (str == null) {
            str = INSTANCE.getRawLink(linkType);
        }
        FirebaseConfigHelper firebaseConfigHelper = INSTANCE;
        String rawLink = firebaseConfigHelper.getRawLink(linkType);
        try {
            Result.Companion companion = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(firebaseConfigHelper.getRawLink(firebaseConfigHelper.toReserve(linkType)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9926isFailureimpl(m9920constructorimpl)) {
            m9920constructorimpl = null;
        }
        String str2 = (String) m9920constructorimpl;
        if (!Intrinsics.areEqual(str, rawLink) && Intrinsics.areEqual(str, str2)) {
            return "1";
        }
        return "0";
    }
}
