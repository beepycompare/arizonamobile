package com.miami.game.core.connection.resolver;

import android.content.SharedPreferences;
import android.util.Log;
import com.arizona.game.BuildConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0011J\f\u0010\"\u001a\u00020\u0013*\u00020\u0013H\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\u0011J\f\u0010$\u001a\u00020\u0005*\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0013H\u0002J\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110(H\u0086@¢\u0006\u0002\u0010)J\u0012\u0010*\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0011J\u0006\u0010.\u001a\u00020\u0011J\u0006\u0010/\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/miami/game/core/connection/resolver/FirebaseConfigHelper;", "", "<init>", "()V", "isDebug", "", "isArizona", "isBrazil", "sharedPref", "Landroid/content/SharedPreferences;", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "remoteConfig$delegate", "Lkotlin/Lazy;", "getRawLink", "", "type", "Lcom/miami/game/core/connection/resolver/FirebaseConfigLinks;", "linkCache", "", "hostRegex", "Lkotlin/text/Regex;", "httpClient", "Lokhttp3/OkHttpClient;", "setDebug", "", "debug", BuildConfig.FLAVOR, "sharedPreferences", "brazil", "isServiceAvailable", "url", "toReserve", "extractHost", "hasReserve", "fetchLink", "primary", "fetchAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "useDebug", "getProjectResourceUrl", "getServerApiUrl", "getHudPingUrl", "getChannelsState", "connection-resolver"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper {
    private static boolean isArizona;
    private static boolean isBrazil;
    private static boolean isDebug;
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
    private static final Map<FirebaseConfigLinks, String> linkCache = new LinkedHashMap();
    private static final Regex hostRegex = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*://([^/:]+)");
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();

    /* compiled from: FirebaseServerHandler.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
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
                iArr[FirebaseConfigLinks.NEWS_AUTH_BASE_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FirebaseConfigLinks.MAIN_HUD_PING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FirebaseConfigHelper() {
    }

    private final FirebaseRemoteConfig getRemoteConfig() {
        Object value = remoteConfig$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FirebaseRemoteConfig) value;
    }

    private final String getRawLink(FirebaseConfigLinks firebaseConfigLinks) {
        String string = getRemoteConfig().getString(firebaseConfigLinks.getKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
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
            Response execute = httpClient.newCall(new Request.Builder().url("https://" + extractHost + "/ping.json").header("User-Agent", "Arizona Mobile").get().build()).execute();
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
        } catch (IOException e2) {
            Log.w("FirebaseSrvHandler", "isServiceAvailable: " + extractHost + " " + e2.getClass().getSimpleName() + ": " + e2.getMessage());
            return false;
        }
    }

    private final FirebaseConfigLinks toReserve(FirebaseConfigLinks firebaseConfigLinks) {
        int i = WhenMappings.$EnumSwitchMapping$0[firebaseConfigLinks.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return FirebaseConfigLinks.RESERVE_HUD_PING;
                        }
                        throw new IllegalArgumentException("There is no backup link for " + firebaseConfigLinks + " channel.");
                    }
                    return FirebaseConfigLinks.RESERVE_NEWS_AUTH_BASE_URL;
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
        Object m9843constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9843constructorimpl = Result.m9843constructorimpl(INSTANCE.toReserve(firebaseConfigLinks));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9843constructorimpl = Result.m9843constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9850isSuccessimpl(m9843constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchLink(FirebaseConfigLinks firebaseConfigLinks) {
        Object m9843constructorimpl;
        String rawLink = getRawLink(firebaseConfigLinks);
        if (isServiceAvailable(rawLink)) {
            return rawLink;
        }
        try {
            Result.Companion companion = Result.Companion;
            FirebaseConfigHelper firebaseConfigHelper = this;
            m9843constructorimpl = Result.m9843constructorimpl(getRawLink(toReserve(firebaseConfigLinks)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9843constructorimpl = Result.m9843constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9849isFailureimpl(m9843constructorimpl)) {
            m9843constructorimpl = null;
        }
        String str = (String) m9843constructorimpl;
        if (str != null && isServiceAvailable(str)) {
            Log.w("FirebaseSrvHandler", "fetchLink: primary=" + firebaseConfigLinks.getKey() + " down, fall back to reserve");
            return str;
        }
        Log.w("FirebaseSrvHandler", "fetchLink: primary=" + firebaseConfigLinks.getKey() + " and reserve both unavailable, keep primary");
        return rawLink;
    }

    public final Object fetchAll(Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FirebaseConfigHelper$fetchAll$2(null), continuation);
    }

    static /* synthetic */ String getResourceUrl$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getResourceUrl(z);
    }

    private final String getResourceUrl(boolean z) {
        SharedPreferences sharedPreferences = sharedPref;
        int i = sharedPreferences != null ? sharedPreferences.getInt("server_id", 1) : 1;
        if (isDebug && z && isArizona && i == 0) {
            return "https://staging-cdn.azresources.cloud/";
        }
        String str = linkCache.get(FirebaseConfigLinks.MAIN_RESOURCE);
        return str == null ? getRawLink(FirebaseConfigLinks.MAIN_RESOURCE) : str;
    }

    public static /* synthetic */ String getProjectResourceUrl$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getProjectResourceUrl(z);
    }

    public final String getProjectResourceUrl(boolean z) {
        String str;
        if (isArizona) {
            str = isBrazil ? "projects/brazil-rp/" : "projects/arizona-rp/";
        } else {
            str = "projects/rodina-rp/";
        }
        return getResourceUrl(z) + str;
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
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new FirebaseConfigLinks[]{FirebaseConfigLinks.MAIN_RESOURCE, FirebaseConfigLinks.MAIN_SOUND, FirebaseConfigLinks.SERVER_API}), StringUtils.COMMA, null, null, 0, null, new Function1() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FirebaseConfigHelper.getChannelsState$lambda$0((FirebaseConfigLinks) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence getChannelsState$lambda$0(FirebaseConfigLinks linkType) {
        Object m9843constructorimpl;
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        String str = linkCache.get(linkType);
        if (str == null) {
            str = INSTANCE.getRawLink(linkType);
        }
        FirebaseConfigHelper firebaseConfigHelper = INSTANCE;
        String rawLink = firebaseConfigHelper.getRawLink(linkType);
        try {
            Result.Companion companion = Result.Companion;
            m9843constructorimpl = Result.m9843constructorimpl(firebaseConfigHelper.getRawLink(firebaseConfigHelper.toReserve(linkType)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9843constructorimpl = Result.m9843constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9849isFailureimpl(m9843constructorimpl)) {
            m9843constructorimpl = null;
        }
        String str2 = (String) m9843constructorimpl;
        if (!Intrinsics.areEqual(str, rawLink) && Intrinsics.areEqual(str, str2)) {
            return "1";
        }
        return "0";
    }
}
