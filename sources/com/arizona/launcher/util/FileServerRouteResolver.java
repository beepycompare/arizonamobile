package com.arizona.launcher.util;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.game.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/util/FileServerRouteResolver;", "", "<init>", "()V", "stagingBuildTypes", "", "", "archiveProducts", "resolve", "Lcom/arizona/launcher/util/FileServerRoutes;", "flavor", "buildType", "origins", "Lcom/arizona/launcher/util/FileServerOrigins;", "channelPath", "channel", "join", TtmlNode.RUBY_BASE, "path", "STAGING_CHANNEL", "RELEASE_CHANNEL", "ARCHIVE_CATALOG", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerRouteResolver {
    public static final int $stable = 0;
    private static final String ARCHIVE_CATALOG = "zip_data";
    private static final String RELEASE_CHANNEL = "release";
    public static final FileServerRouteResolver INSTANCE = new FileServerRouteResolver();
    private static final String STAGING_CHANNEL = "staging";
    private static final Set<String> stagingBuildTypes = SetsKt.setOf((Object[]) new String[]{"debug", "public_debug", STAGING_CHANNEL});
    private static final Set<String> archiveProducts = SetsKt.setOf((Object[]) new String[]{BuildConfig.FLAVOR, "rodina"});

    private FileServerRouteResolver() {
    }

    public final FileServerRoutes resolve(String flavor, String buildType, FileServerOrigins origins) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(origins, "origins");
        String str = stagingBuildTypes.contains(buildType) ? STAGING_CHANNEL : "release";
        String mainArizona = Intrinsics.areEqual(flavor, BuildConfig.FLAVOR) ? origins.getMainArizona() : origins.getMainRodina();
        String reserveArizona = Intrinsics.areEqual(flavor, BuildConfig.FLAVOR) ? origins.getReserveArizona() : origins.getReserveRodina();
        String channelPath = channelPath(flavor, str);
        List listOf = CollectionsKt.listOf((Object[]) new String[]{join(mainArizona, channelPath), join(reserveArizona, channelPath)});
        if (archiveProducts.contains(flavor)) {
            List<String> list = listOf;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str2 : list) {
                arrayList2.add(INSTANCE.join(str2, ARCHIVE_CATALOG));
            }
            arrayList = arrayList2;
        } else {
            arrayList = listOf;
        }
        return new FileServerRoutes(listOf, arrayList);
    }

    private final String channelPath(String str, String str2) {
        return Intrinsics.areEqual(str, BuildConfig.FLAVOR) ? "game/" + str2 : str2;
    }

    private final String join(String str, String str2) {
        return StringsKt.trimEnd(StringsKt.trim((CharSequence) str).toString(), '/') + "/" + StringsKt.trim(StringsKt.trim((CharSequence) str2).toString(), '/') + "/";
    }
}
