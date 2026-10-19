package com.arizona.launcher.util;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.game.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/util/FileServerRouteResolver;", "", "<init>", "()V", "stagingBuildTypes", "", "", "resolve", "Lcom/arizona/launcher/util/FileServerRoutes;", "flavor", "buildType", "origins", "Lcom/arizona/launcher/util/FileServerOrigins;", "channelPath", "channel", "join", TtmlNode.RUBY_BASE, "path", "STAGING_CHANNEL", "RELEASE_CHANNEL", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerRouteResolver {
    public static final int $stable = 0;
    private static final String RELEASE_CHANNEL = "release";
    public static final FileServerRouteResolver INSTANCE = new FileServerRouteResolver();
    private static final String STAGING_CHANNEL = "staging";
    private static final Set<String> stagingBuildTypes = SetsKt.setOf((Object[]) new String[]{"debug", "public_debug", STAGING_CHANNEL});

    private FileServerRouteResolver() {
    }

    public final FileServerRoutes resolve(String flavor, String buildType, FileServerOrigins origins) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(origins, "origins");
        String str = stagingBuildTypes.contains(buildType) ? STAGING_CHANNEL : "release";
        String mainArizona = Intrinsics.areEqual(flavor, BuildConfig.FLAVOR) ? origins.getMainArizona() : origins.getMainRodina();
        String reserveArizona = Intrinsics.areEqual(flavor, BuildConfig.FLAVOR) ? origins.getReserveArizona() : origins.getReserveRodina();
        String channelPath = channelPath(str);
        List listOf = CollectionsKt.listOf((Object[]) new String[]{join(mainArizona, channelPath), join(reserveArizona, channelPath)});
        String channelPath2 = channelPath(Intrinsics.areEqual(buildType, STAGING_CHANNEL) ? STAGING_CHANNEL : "release");
        return new FileServerRoutes(listOf, CollectionsKt.listOf((Object[]) new String[]{join(mainArizona, channelPath2), join(reserveArizona, channelPath2)}), listOf);
    }

    private final String channelPath(String str) {
        return "client/" + str;
    }

    private final String join(String str, String str2) {
        return StringsKt.trimEnd(StringsKt.trim((CharSequence) str).toString(), '/') + "/" + StringsKt.trim(StringsKt.trim((CharSequence) str2).toString(), '/') + "/";
    }
}
