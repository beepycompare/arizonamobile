package com.arizona.launcher.util;

import com.adjust.sdk.Constants;
import com.arizona.game.BuildConfig;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: GameFileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0002¨\u0006&"}, d2 = {"Lcom/arizona/launcher/util/GameFileServerRouteResolver;", "", "<init>", "()V", "stagingBuildTypes", "", "", "archiveFlavors", "resolveGame", "", "flavor", "buildType", "origins", "Lcom/arizona/launcher/util/GameFileServerOrigins;", "configuredArchiveStaging", "Lcom/arizona/launcher/util/GameFileServerPair;", "fallbackArchiveStaging", "resolveLauncher", "resolveArchiveChannel", "channel", "resolveLegacy", "stagingLike", "", "resolveProductChannel", "normalizeHttpsBaseOrNull", "raw", "normalizeHttpsBaseOrNull$app", "normalizeHttpsOriginOrNull", "normalizeHttpsOriginOrNull$app", "normalizedHttpsOrNull", "appendPath", "origin", "path", "HTTPS_DEFAULT_PORT", "", "STAGING_CHANNEL", "RELEASE_CHANNEL", "ARCHIVE_CATALOG", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameFileServerRouteResolver {
    public static final int $stable = 0;
    private static final String ARCHIVE_CATALOG = "zip_data";
    private static final int HTTPS_DEFAULT_PORT = 443;
    private static final String RELEASE_CHANNEL = "release";
    public static final GameFileServerRouteResolver INSTANCE = new GameFileServerRouteResolver();
    private static final String STAGING_CHANNEL = "staging";
    private static final Set<String> stagingBuildTypes = SetsKt.setOf((Object[]) new String[]{"debug", "public_debug", STAGING_CHANNEL});
    private static final Set<String> archiveFlavors = SetsKt.setOf((Object[]) new String[]{BuildConfig.FLAVOR, "rodina"});

    private GameFileServerRouteResolver() {
    }

    public final List<String> resolveGame(String flavor, String buildType, GameFileServerOrigins origins, GameFileServerPair configuredArchiveStaging, GameFileServerPair fallbackArchiveStaging) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(origins, "origins");
        Intrinsics.checkNotNullParameter(configuredArchiveStaging, "configuredArchiveStaging");
        Intrinsics.checkNotNullParameter(fallbackArchiveStaging, "fallbackArchiveStaging");
        if (archiveFlavors.contains(flavor)) {
            if (stagingBuildTypes.contains(buildType)) {
                GameFileServerPair normalizedHttpsOrNull = normalizedHttpsOrNull(configuredArchiveStaging);
                if (normalizedHttpsOrNull == null && (normalizedHttpsOrNull = normalizedHttpsOrNull(fallbackArchiveStaging)) == null) {
                    throw new IllegalStateException("Archive staging fallback servers must be valid HTTPS base URLs".toString());
                }
                return normalizedHttpsOrNull.asList();
            }
            return resolveArchiveChannel(flavor, "release", origins);
        }
        return resolveLegacy(flavor, stagingBuildTypes.contains(buildType), origins);
    }

    public final List<String> resolveLauncher(String flavor, String buildType, GameFileServerOrigins origins) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(origins, "origins");
        return resolveLegacy(flavor, stagingBuildTypes.contains(buildType), origins);
    }

    private final List<String> resolveArchiveChannel(String str, String str2, GameFileServerOrigins gameFileServerOrigins) {
        List<String> resolveProductChannel = resolveProductChannel(str, str2, gameFileServerOrigins);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(resolveProductChannel, 10));
        for (String str3 : resolveProductChannel) {
            arrayList.add(INSTANCE.appendPath(str3, ARCHIVE_CATALOG));
        }
        return arrayList;
    }

    private final List<String> resolveLegacy(String str, boolean z, GameFileServerOrigins gameFileServerOrigins) {
        return resolveProductChannel(str, z ? STAGING_CHANNEL : "release", gameFileServerOrigins);
    }

    private final List<String> resolveProductChannel(String str, String str2, GameFileServerOrigins gameFileServerOrigins) {
        boolean areEqual = Intrinsics.areEqual(str, BuildConfig.FLAVOR);
        String mainArizona = areEqual ? gameFileServerOrigins.getMainArizona() : gameFileServerOrigins.getMainRodina();
        String reserveArizona = areEqual ? gameFileServerOrigins.getReserveArizona() : gameFileServerOrigins.getReserveRodina();
        if (areEqual) {
            str2 = "game/" + str2;
        }
        return new GameFileServerPair(appendPath(mainArizona, str2), appendPath(reserveArizona, str2)).asList();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String normalizeHttpsBaseOrNull$app(String raw) {
        Object m9916constructorimpl;
        String host;
        Intrinsics.checkNotNullParameter(raw, "raw");
        String obj = StringsKt.trim((CharSequence) raw).toString();
        if (obj.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            GameFileServerRouteResolver gameFileServerRouteResolver = this;
            m9916constructorimpl = Result.m9916constructorimpl(new URI(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
            m9916constructorimpl = null;
        }
        URI uri = (URI) m9916constructorimpl;
        if (uri != null && uri.isAbsolute() && StringsKt.equals(uri.getScheme(), Constants.SCHEME, true) && (host = uri.getHost()) != null && !StringsKt.isBlank(host) && uri.getUserInfo() == null && uri.getQuery() == null && uri.getFragment() == null) {
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            List<String> split$default = StringsKt.split$default((CharSequence) path, new char[]{'/'}, false, 0, 6, (Object) null);
            if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
                for (String str : split$default) {
                    if (Intrinsics.areEqual(str, ".") || Intrinsics.areEqual(str, "..")) {
                        return null;
                    }
                    while (r3.hasNext()) {
                    }
                }
            }
            String host2 = uri.getHost();
            Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = host2.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str2 = lowerCase;
            if (StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.COLON, false, 2, (Object) null) && !StringsKt.startsWith$default((CharSequence) str2, (char) AbstractJsonLexerKt.BEGIN_LIST, false, 2, (Object) null)) {
                lowerCase = "[" + lowerCase + "]";
            }
            int intValue = Integer.valueOf(uri.getPort()).intValue();
            Integer num = (intValue == -1 || intValue == HTTPS_DEFAULT_PORT) ? null : null;
            String rawPath = uri.getRawPath();
            String str3 = rawPath != null ? rawPath : "";
            StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(lowerCase);
            if (num != null) {
                sb.append(AbstractJsonLexerKt.COLON).append(num.intValue());
            }
            if (str3.length() == 0) {
                sb.append('/');
            } else {
                sb.append(str3);
            }
            if (!StringsKt.endsWith$default((CharSequence) sb, '/', false, 2, (Object) null)) {
                sb.append('/');
            }
            return sb.toString();
        }
        return null;
    }

    public final String normalizeHttpsOriginOrNull$app(String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        String normalizeHttpsBaseOrNull$app = normalizeHttpsBaseOrNull$app(raw);
        if (normalizeHttpsBaseOrNull$app == null) {
            return null;
        }
        return "https://" + new URI(normalizeHttpsBaseOrNull$app).getRawAuthority();
    }

    private final GameFileServerPair normalizedHttpsOrNull(GameFileServerPair gameFileServerPair) {
        String normalizeHttpsBaseOrNull$app;
        String normalizeHttpsBaseOrNull$app2 = normalizeHttpsBaseOrNull$app(gameFileServerPair.getMain());
        if (normalizeHttpsBaseOrNull$app2 == null || (normalizeHttpsBaseOrNull$app = normalizeHttpsBaseOrNull$app(gameFileServerPair.getReserve())) == null) {
            return null;
        }
        return new GameFileServerPair(normalizeHttpsBaseOrNull$app2, normalizeHttpsBaseOrNull$app);
    }

    private final String appendPath(String str, String str2) {
        return StringsKt.trimEnd(StringsKt.trim((CharSequence) str).toString(), '/') + "/" + StringsKt.trim(StringsKt.trim((CharSequence) str2).toString(), '/') + "/";
    }
}
