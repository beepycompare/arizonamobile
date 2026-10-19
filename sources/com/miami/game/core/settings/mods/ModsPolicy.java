package com.miami.game.core.settings.mods;

import androidx.media3.common.MimeTypes;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ModsPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsPolicy;", "", "<init>", "()V", "starterDirectories", "", "", "getStarterDirectories", "()Ljava/util/List;", "configs", "", "resources", "userFiles", "userRoots", "ignored", "", "path", "allowedInRelease", "isPngTexture", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsPolicy {
    public static final ModsPolicy INSTANCE = new ModsPolicy();
    private static final List<String> starterDirectories = CollectionsKt.listOf((Object[]) new String[]{"data", "data/maps", "models", "anim", "texdb", MimeTypes.BASE_TYPE_AUDIO, "audio/sounds"});
    private static final Set<String> configs = SetsKt.setOf((Object[]) new String[]{"data/timecyc.json", "data/colorcycle.dat", "data/animgrp.dat"});
    private static final Set<String> resources = SetsKt.setOf((Object[]) new String[]{"dff", "col", "ipl", "ifp", "aetex"});
    private static final Set<String> userFiles = SetsKt.setOf((Object[]) new String[]{"game_settings.json", "settings.ini", "re3.ini", "mapcache.bin", "sound.cache", "caps.dat", "gta_vc.set", "gta_sa.set", "gtasatelem.set", "touchconfig.dat"});
    private static final Set<String> userRoots = SetsKt.setOf((Object[]) new String[]{"mods", "logcat", "save", "saves", "userfiles"});

    private ModsPolicy() {
    }

    public final List<String> getStarterDirectories() {
        return starterDirectories;
    }

    public final boolean ignored(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (userFiles.contains(StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null)) || userRoots.contains(StringsKt.substringBefore$default(path, '/', (String) null, 2, (Object) null)) || StringsKt.endsWith$default(path, ".log", false, 2, (Object) null) || StringsKt.endsWith$default(path, ".b", false, 2, (Object) null)) {
            return true;
        }
        String str = path;
        return StringsKt.startsWith$default((CharSequence) str, '.', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "/.", false, 2, (Object) null) || StringsKt.endsWith$default(path, ".tmp", false, 2, (Object) null) || StringsKt.endsWith$default(path, ".swp", false, 2, (Object) null) || StringsKt.endsWith$default((CharSequence) str, '~', false, 2, (Object) null);
    }

    public final boolean allowedInRelease(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (ignored(path)) {
            return false;
        }
        if (configs.contains(path)) {
            return true;
        }
        if (Intrinsics.areEqual(path, "anim/ped.ifp")) {
            return false;
        }
        return resources.contains(StringsKt.substringAfterLast(path, '.', "")) || isPngTexture(path);
    }

    private final boolean isPngTexture(String str) {
        return StringsKt.startsWith$default(str, "texdb/", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) ".zip/", false, 2, (Object) null) && StringsKt.endsWith$default(str, ".png", false, 2, (Object) null);
    }
}
