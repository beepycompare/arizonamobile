package com.arizona.launcher.util;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.game.BuildConfig;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: GameFileServerRouteResolver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/util/GameArchiveStagingFallbacks;", "", "<init>", "()V", BuildConfig.FLAVOR, "Lcom/arizona/launcher/util/GameFileServerPair;", "rodina", "forFlavor", "flavor", "", "selectConfigured", "configured", "otherProductConfigured", "normalize", "pair", "normalizedOrigins", "", "usesDeprecatedArchiveCatalog", "", TtmlNode.RUBY_BASE, "DEPRECATED_ARCHIVE_CATALOG", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameArchiveStagingFallbacks {
    public static final int $stable = 0;
    private static final String DEPRECATED_ARCHIVE_CATALOG = "test_data";
    public static final GameArchiveStagingFallbacks INSTANCE = new GameArchiveStagingFallbacks();
    private static final GameFileServerPair arizona = new GameFileServerPair("https://mob.maz-ins.com/game/staging/zip_data/", "https://arz-mob.react-group.tech/game/staging/zip_data/");
    private static final GameFileServerPair rodina = new GameFileServerPair("https://mob.azinternal.com/staging/zip_data/", "https://rod-mob.react-group.tech/staging/zip_data/");

    private GameArchiveStagingFallbacks() {
    }

    public final GameFileServerPair forFlavor(String flavor) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        return Intrinsics.areEqual(flavor, BuildConfig.FLAVOR) ? arizona : rodina;
    }

    public final GameFileServerPair selectConfigured(String flavor, GameFileServerPair configured, GameFileServerPair otherProductConfigured) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        Intrinsics.checkNotNullParameter(configured, "configured");
        Intrinsics.checkNotNullParameter(otherProductConfigured, "otherProductConfigured");
        GameFileServerPair normalize = normalize(configured);
        if (normalize == null) {
            return configured;
        }
        List<String> asList = normalize.asList();
        if (!(asList instanceof Collection) || !asList.isEmpty()) {
            for (String str : asList) {
                if (usesDeprecatedArchiveCatalog(str)) {
                    return forFlavor(flavor);
                }
            }
        }
        String str2 = BuildConfig.FLAVOR;
        if (Intrinsics.areEqual(flavor, BuildConfig.FLAVOR)) {
            str2 = "rodina";
        }
        Set plus = SetsKt.plus((Set) normalizedOrigins(otherProductConfigured), (Iterable) normalizedOrigins(forFlavor(str2)));
        Set<String> normalizedOrigins = normalizedOrigins(normalize);
        if ((normalizedOrigins instanceof Collection) && normalizedOrigins.isEmpty()) {
            return configured;
        }
        for (String str3 : normalizedOrigins) {
            if (plus.contains(str3)) {
                return forFlavor(flavor);
            }
        }
        return configured;
    }

    private final GameFileServerPair normalize(GameFileServerPair gameFileServerPair) {
        String normalizeHttpsBaseOrNull$app;
        String normalizeHttpsBaseOrNull$app2 = GameFileServerRouteResolver.INSTANCE.normalizeHttpsBaseOrNull$app(gameFileServerPair.getMain());
        if (normalizeHttpsBaseOrNull$app2 == null || (normalizeHttpsBaseOrNull$app = GameFileServerRouteResolver.INSTANCE.normalizeHttpsBaseOrNull$app(gameFileServerPair.getReserve())) == null) {
            return null;
        }
        return new GameFileServerPair(normalizeHttpsBaseOrNull$app2, normalizeHttpsBaseOrNull$app);
    }

    private final Set<String> normalizedOrigins(GameFileServerPair gameFileServerPair) {
        String[] strArr = {gameFileServerPair.getMain(), gameFileServerPair.getReserve()};
        GameFileServerRouteResolver gameFileServerRouteResolver = GameFileServerRouteResolver.INSTANCE;
        ArrayList arrayList = new ArrayList();
        for (String str : CollectionsKt.listOf((Object[]) strArr)) {
            String normalizeHttpsOriginOrNull$app = gameFileServerRouteResolver.normalizeHttpsOriginOrNull$app(str);
            if (normalizeHttpsOriginOrNull$app != null) {
                arrayList.add(normalizeHttpsOriginOrNull$app);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final boolean usesDeprecatedArchiveCatalog(String str) {
        String path = new URI(str).getPath();
        if (path == null) {
            path = "";
        }
        List<String> split$default = StringsKt.split$default((CharSequence) path, new char[]{'/'}, false, 0, 6, (Object) null);
        if ((split$default instanceof Collection) && split$default.isEmpty()) {
            return false;
        }
        for (String str2 : split$default) {
            if (StringsKt.equals(str2, DEPRECATED_ARCHIVE_CATALOG, true)) {
                return true;
            }
        }
        return false;
    }
}
