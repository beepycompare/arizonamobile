package ru.mrlargha.commonui.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\f\u0010\u0013\u001a\u00020\t*\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\f\u0010\u0015\u001a\u00020\u0011*\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/utils/FirebaseConfigHelper;", "", "<init>", "()V", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRawLink", "", "type", "Lru/mrlargha/commonui/utils/FirebaseConfigLinks;", "linkCache", "", "hostRegex", "Lkotlin/text/Regex;", "httpClient", "Lokhttp3/OkHttpClient;", "isServiceAvailable", "", "url", "toReserve", "extractHost", "hasReserve", "fetchLink", "primary", "checkWithIsReachable", "checkWithUnixSystemPing", "checkWithLinuxNC", "fetchAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "getServerApiUrl", "getSoundUrl", "getNewsAuthBaseUrl", "getHudPingUrl", "getChannelsState", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper {
    public static final FirebaseConfigHelper INSTANCE = new FirebaseConfigHelper();
    private static final Regex hostRegex;
    private static final OkHttpClient httpClient;
    private static final Map<FirebaseConfigLinks, String> linkCache;
    private static final FirebaseRemoteConfig remoteConfig;

    /* compiled from: FirebaseServerHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
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

    static {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        remoteConfig = firebaseRemoteConfig;
        linkCache = new LinkedHashMap();
        hostRegex = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*://([^/:]+)");
        httpClient = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).writeTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();
    }

    private final String getRawLink(FirebaseConfigLinks firebaseConfigLinks) {
        String string = remoteConfig.getString(firebaseConfigLinks.getKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final boolean isServiceAvailable(String url) {
        String string;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Response execute = httpClient.newCall(new Request.Builder().url("https://" + extractHost(url) + "/ping.json").get().build()).execute();
            Response response = execute;
            if (!response.isSuccessful()) {
                CloseableKt.closeFinally(execute, null);
                return false;
            }
            ResponseBody body = response.body();
            if (body != null && (string = body.string()) != null) {
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
        Object m8443constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(INSTANCE.toReserve(firebaseConfigLinks));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m8450isSuccessimpl(m8443constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchLink(FirebaseConfigLinks firebaseConfigLinks) {
        Object m8443constructorimpl;
        String rawLink = getRawLink(firebaseConfigLinks);
        if ((checkWithIsReachable(rawLink) || checkWithUnixSystemPing(rawLink) || checkWithLinuxNC(rawLink)) && isServiceAvailable(rawLink)) {
            return rawLink;
        }
        try {
            Result.Companion companion = Result.Companion;
            FirebaseConfigHelper firebaseConfigHelper = this;
            m8443constructorimpl = Result.m8443constructorimpl(getRawLink(toReserve(firebaseConfigLinks)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(ResultKt.createFailure(th));
        }
        String str = null;
        if (Result.m8449isFailureimpl(m8443constructorimpl)) {
            m8443constructorimpl = null;
        }
        String str2 = (String) m8443constructorimpl;
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

    public final String getResourceUrl() {
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
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new FirebaseConfigLinks[]{FirebaseConfigLinks.MAIN_RESOURCE, FirebaseConfigLinks.MAIN_SOUND, FirebaseConfigLinks.SERVER_API}), StringUtils.COMMA, null, null, 0, null, new Function1() { // from class: ru.mrlargha.commonui.utils.FirebaseConfigHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence channelsState$lambda$5;
                channelsState$lambda$5 = FirebaseConfigHelper.getChannelsState$lambda$5((FirebaseConfigLinks) obj);
                return channelsState$lambda$5;
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getChannelsState$lambda$5(FirebaseConfigLinks linkType) {
        Object m8443constructorimpl;
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        String str = linkCache.get(linkType);
        if (str == null) {
            str = INSTANCE.getRawLink(linkType);
        }
        FirebaseConfigHelper firebaseConfigHelper = INSTANCE;
        String rawLink = firebaseConfigHelper.getRawLink(linkType);
        try {
            Result.Companion companion = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(firebaseConfigHelper.getRawLink(firebaseConfigHelper.toReserve(linkType)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8443constructorimpl = Result.m8443constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m8449isFailureimpl(m8443constructorimpl)) {
            m8443constructorimpl = null;
        }
        String str2 = (String) m8443constructorimpl;
        if (!Intrinsics.areEqual(str, rawLink) && Intrinsics.areEqual(str, str2)) {
            return "1";
        }
        return "0";
    }
}
