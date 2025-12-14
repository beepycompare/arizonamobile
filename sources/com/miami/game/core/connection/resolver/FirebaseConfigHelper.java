package com.miami.game.core.connection.resolver;

import com.arizona.game.BuildConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.InetAddress;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\f\u0010\u001d\u001a\u00020\u0010*\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u000eJ\f\u0010\u001f\u001a\u00020\u0005*\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0010H\u0002J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eJ\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0&H\u0086@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u000eJ\u0006\u0010-\u001a\u00020\u000eJ\u0006\u0010.\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/miami/game/core/connection/resolver/FirebaseConfigHelper;", "", "<init>", "()V", "isDebug", "", "isArizona", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "remoteConfig$delegate", "Lkotlin/Lazy;", "getRawLink", "", "type", "Lcom/miami/game/core/connection/resolver/FirebaseConfigLinks;", "linkCache", "", "hostRegex", "Lkotlin/text/Regex;", "httpClient", "Lokhttp3/OkHttpClient;", "setDebug", "", "debug", BuildConfig.FLAVOR, "isServiceAvailable", "url", "toReserve", "extractHost", "hasReserve", "fetchLink", "primary", "checkWithIsReachable", "checkWithUnixSystemPing", "checkWithLinuxNC", "fetchAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "useDebug", "getServerApiUrl", "getSoundUrl", "getNewsAuthBaseUrl", "getHudPingUrl", "getChannelsState", "connection-resolver_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FirebaseConfigHelper {
    private static boolean isArizona;
    private static boolean isDebug;
    public static final FirebaseConfigHelper INSTANCE = new FirebaseConfigHelper();
    private static final Lazy remoteConfig$delegate = LazyKt.lazy(new Function0() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FirebaseRemoteConfig remoteConfig_delegate$lambda$0;
            remoteConfig_delegate$lambda$0 = FirebaseConfigHelper.remoteConfig_delegate$lambda$0();
            return remoteConfig_delegate$lambda$0;
        }
    });
    private static final Map<FirebaseConfigLinks, String> linkCache = new LinkedHashMap();
    private static final Regex hostRegex = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*://([^/:]+)");
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();

    /* compiled from: FirebaseServerHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
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
        return (FirebaseRemoteConfig) remoteConfig$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseRemoteConfig remoteConfig_delegate$lambda$0() {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        return firebaseRemoteConfig;
    }

    private final String getRawLink(FirebaseConfigLinks firebaseConfigLinks) {
        String string = getRemoteConfig().getString(firebaseConfigLinks.getKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final void setDebug(boolean z, boolean z2) {
        isDebug = z;
        isArizona = z2;
    }

    public final boolean isServiceAvailable(String url) {
        ResponseBody body;
        String string;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Response execute = httpClient.newCall(new Request.Builder().url("https://" + extractHost(url) + "/ping.json").get().build()).execute();
            Response response = execute;
            if (response.isSuccessful() && (body = response.body()) != null && (string = body.string()) != null) {
                boolean areEqual = Intrinsics.areEqual(new JSONObject(string).optString("hash"), "5aa4731d5d84e09e2f7e7141e560104f");
                CloseableKt.closeFinally(execute, null);
                return areEqual;
            }
            CloseableKt.closeFinally(execute, null);
            return false;
        } catch (Exception unused) {
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
        Object m10215constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m10215constructorimpl = Result.m10215constructorimpl(INSTANCE.toReserve(firebaseConfigLinks));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m10215constructorimpl = Result.m10215constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m10222isSuccessimpl(m10215constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchLink(FirebaseConfigLinks firebaseConfigLinks) {
        Object m10215constructorimpl;
        String rawLink = getRawLink(firebaseConfigLinks);
        if ((checkWithIsReachable(rawLink) || checkWithUnixSystemPing(rawLink) || checkWithLinuxNC(rawLink)) && isServiceAvailable(rawLink)) {
            return rawLink;
        }
        try {
            Result.Companion companion = Result.Companion;
            FirebaseConfigHelper firebaseConfigHelper = this;
            m10215constructorimpl = Result.m10215constructorimpl(getRawLink(toReserve(firebaseConfigLinks)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m10215constructorimpl = Result.m10215constructorimpl(ResultKt.createFailure(th));
        }
        String str = null;
        if (Result.m10221isFailureimpl(m10215constructorimpl)) {
            m10215constructorimpl = null;
        }
        String str2 = (String) m10215constructorimpl;
        if (str2 != null) {
            FirebaseConfigHelper firebaseConfigHelper2 = INSTANCE;
            if ((firebaseConfigHelper2.checkWithIsReachable(rawLink) || firebaseConfigHelper2.checkWithUnixSystemPing(rawLink) || firebaseConfigHelper2.checkWithLinuxNC(rawLink)) && firebaseConfigHelper2.isServiceAvailable(str2)) {
                str = str2;
            }
            return str != null ? str : rawLink;
        }
        return rawLink;
    }

    public final boolean checkWithIsReachable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return InetAddress.getByName(extractHost(url)).isReachable(5000);
    }

    public final boolean checkWithUnixSystemPing(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return Runtime.getRuntime().exec(new StringBuilder("ping -c 1 ").append(extractHost(url)).toString()).waitFor() == 0;
    }

    public final boolean checkWithLinuxNC(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return Runtime.getRuntime().exec(new StringBuilder("nc -v ").append(extractHost(url)).append(" 80").toString()).waitFor() == 0;
    }

    public final Object fetchAll(Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FirebaseConfigHelper$fetchAll$2(null), continuation);
    }

    public static /* synthetic */ String getResourceUrl$default(FirebaseConfigHelper firebaseConfigHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return firebaseConfigHelper.getResourceUrl(z);
    }

    public final String getResourceUrl(boolean z) {
        if (isDebug && z && isArizona) {
            return "https://staging-cdn.azresources.cloud/";
        }
        String str = linkCache.get(FirebaseConfigLinks.MAIN_RESOURCE);
        return str == null ? getRawLink(FirebaseConfigLinks.MAIN_RESOURCE) : str;
    }

    public final String getServerApiUrl() {
        String str = linkCache.get(FirebaseConfigLinks.SERVER_API);
        return str == null ? getRawLink(FirebaseConfigLinks.SERVER_API) : str;
    }

    public final String getSoundUrl() {
        String str = linkCache.get(FirebaseConfigLinks.MAIN_SOUND);
        return str == null ? getRawLink(FirebaseConfigLinks.MAIN_SOUND) : str;
    }

    public final String getNewsAuthBaseUrl() {
        String str = linkCache.get(FirebaseConfigLinks.NEWS_AUTH_BASE_URL);
        return str == null ? getRawLink(FirebaseConfigLinks.NEWS_AUTH_BASE_URL) : str;
    }

    public final String getHudPingUrl() {
        String str = linkCache.get(FirebaseConfigLinks.MAIN_HUD_PING);
        return str == null ? getRawLink(FirebaseConfigLinks.MAIN_HUD_PING) : str;
    }

    public final String getChannelsState() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new FirebaseConfigLinks[]{FirebaseConfigLinks.MAIN_RESOURCE, FirebaseConfigLinks.MAIN_SOUND, FirebaseConfigLinks.SERVER_API}), StringUtils.COMMA, null, null, 0, null, new Function1() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence channelsState$lambda$0;
                channelsState$lambda$0 = FirebaseConfigHelper.getChannelsState$lambda$0((FirebaseConfigLinks) obj);
                return channelsState$lambda$0;
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getChannelsState$lambda$0(FirebaseConfigLinks linkType) {
        Object m10215constructorimpl;
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        String str = linkCache.get(linkType);
        if (str == null) {
            str = INSTANCE.getRawLink(linkType);
        }
        FirebaseConfigHelper firebaseConfigHelper = INSTANCE;
        String rawLink = firebaseConfigHelper.getRawLink(linkType);
        try {
            Result.Companion companion = Result.Companion;
            m10215constructorimpl = Result.m10215constructorimpl(firebaseConfigHelper.getRawLink(firebaseConfigHelper.toReserve(linkType)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m10215constructorimpl = Result.m10215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10221isFailureimpl(m10215constructorimpl)) {
            m10215constructorimpl = null;
        }
        String str2 = (String) m10215constructorimpl;
        if (!Intrinsics.areEqual(str, rawLink) && Intrinsics.areEqual(str, str2)) {
            return "1";
        }
        return "0";
    }
}
