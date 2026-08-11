package com.miami.game.core.design.system.component.background;

import coil3.util.UtilsKt;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: LauncherBackgroundPolicy.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0016\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundPolicy;", "", "<init>", "()V", "ARIZONA_PATH_KEY", "", "ARIZONA_HASH_KEY", "RODINA_PATH_KEY", "RODINA_HASH_KEY", "sha256Regex", "Lkotlin/text/Regex;", "remoteKeys", "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundRemoteKeys;", "isArizona", "", "remoteSpec", "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundRemoteSpec;", "path", "rawHash", "normalizeSha256", "buildLocalFileName", "remotePath", "remoteHash", "avoidDisplayedFile", "Ljava/io/File;", "preferred", "displayed", "cacheRevision", UtilsKt.SCHEME_FILE, NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "design-system", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LauncherBackgroundPolicy {
    public static final int $stable = 0;
    private static final String ARIZONA_HASH_KEY = "launcher_background_hash";
    private static final String ARIZONA_PATH_KEY = "launcher_background";
    private static final String RODINA_HASH_KEY = "launcher_background_hash_rodina";
    private static final String RODINA_PATH_KEY = "launcher_background_rodina";
    public static final LauncherBackgroundPolicy INSTANCE = new LauncherBackgroundPolicy();
    private static final Regex sha256Regex = new Regex("^[0-9a-f]{64}$");

    private LauncherBackgroundPolicy() {
    }

    public final LauncherBackgroundRemoteKeys remoteKeys(boolean z) {
        if (z) {
            return new LauncherBackgroundRemoteKeys(ARIZONA_PATH_KEY, ARIZONA_HASH_KEY);
        }
        return new LauncherBackgroundRemoteKeys(RODINA_PATH_KEY, RODINA_HASH_KEY);
    }

    public final LauncherBackgroundRemoteSpec remoteSpec(String str, String str2) {
        String obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        String normalizeSha256 = normalizeSha256(str2);
        if (normalizeSha256 == null || obj.length() == 0) {
            return null;
        }
        return new LauncherBackgroundRemoteSpec(obj, normalizeSha256);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String normalizeSha256(String str) {
        String str2;
        String obj;
        String removePrefix;
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null) {
            String lowerCase = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && (removePrefix = StringsKt.removePrefix(lowerCase, (CharSequence) "sha256:")) != null) {
                str2 = StringsKt.trim((CharSequence) removePrefix).toString();
                if (str2 == null) {
                    str2 = "";
                }
                if (sha256Regex.matches(str2)) {
                    return null;
                }
                return str2;
            }
        }
        str2 = null;
        if (str2 == null) {
        }
        if (sha256Regex.matches(str2)) {
        }
    }

    public final String buildLocalFileName(String remotePath, String remoteHash) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(remotePath, "remotePath");
        Intrinsics.checkNotNullParameter(remoteHash, "remoteHash");
        String substringAfterLast = StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(remotePath, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null), '/', "background_home.webp");
        String replace = new Regex("[^\\w.\\-]").replace(StringsKt.isBlank(substringAfterLast) ? "background_home.webp" : substringAfterLast, "_");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) replace, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            str = replace.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = replace;
        }
        if (lastIndexOf$default > 0) {
            str2 = replace.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
        } else {
            str2 = ".webp";
        }
        String take = StringsKt.take(str, 80);
        if (StringsKt.isBlank(take)) {
            take = "background_home";
        }
        String str3 = take;
        String str4 = new Regex("\\.[A-Za-z0-9]{1,8}").matches(str2) ? str2 : null;
        return str3 + "_" + remoteHash + (str4 != null ? str4 : ".webp");
    }

    public final File avoidDisplayedFile(File preferred, File file) {
        Intrinsics.checkNotNullParameter(preferred, "preferred");
        if (Intrinsics.areEqual(file != null ? file.getAbsoluteFile() : null, preferred.getAbsoluteFile())) {
            String extension = FilesKt.getExtension(preferred);
            String str = StringsKt.isBlank(extension) ? null : extension;
            StringBuilder sb = new StringBuilder();
            sb.append(FilesKt.getNameWithoutExtension(preferred));
            sb.append("_next");
            if (str != null) {
                sb.append('.');
                sb.append(str);
            }
            return new File(preferred.getParentFile(), sb.toString());
        }
        return preferred;
    }

    public final String cacheRevision(File file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        long length = file.length();
        return length + "_" + file.lastModified() + "_" + i;
    }
}
