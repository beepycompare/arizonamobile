package com.arizona.launcher.updater.archive.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveModelRules;", "", "<init>", "()V", "CURRENT_SCHEMA_VERSION", "", "MAX_ARCHIVE_SIZE_EXCLUSIVE", "", "MAX_UNSIGNED_CRC32", "packageIdRegex", "Lkotlin/text/Regex;", "encodedUnsafePathToken", "requirePackageId", "", TtmlNode.ATTR_ID, "", "requireManifestVersion", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "requireArchiveSize", "size", "requireNonNegativeSize", Constants.ScionAnalytics.PARAM_LABEL, "requireUnsignedCrc32", "crc32", "requirePackageUrl", "value", "entryTarget", "entryPath", "requireSafeSegments", "path", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveModelRules {
    public static final int $stable = 0;
    public static final int CURRENT_SCHEMA_VERSION = 2;
    public static final long MAX_ARCHIVE_SIZE_EXCLUSIVE = 500000000;
    public static final long MAX_UNSIGNED_CRC32 = 4294967295L;
    public static final ArchiveModelRules INSTANCE = new ArchiveModelRules();
    private static final Regex packageIdRegex = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}");
    private static final Regex encodedUnsafePathToken = new Regex("%(?:2e|2f|5c)", RegexOption.IGNORE_CASE);

    private ArchiveModelRules() {
    }

    public final void requirePackageId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Regex regex = packageIdRegex;
        if (regex.matches(id)) {
            return;
        }
        throw new IllegalArgumentException(("package id must match " + regex.getPattern()).toString());
    }

    public final void requireManifestVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        String str = version;
        if (StringsKt.isBlank(str) || !Intrinsics.areEqual(version, StringsKt.trim((CharSequence) str).toString()) || version.length() > 128) {
            throw new IllegalArgumentException("manifestVersion must be a non-blank trimmed string up to 128 characters".toString());
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isISOControl(str.charAt(i))) {
                throw new IllegalArgumentException("manifestVersion must not contain control characters".toString());
            }
        }
    }

    public final void requireArchiveSize(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("archive size must be positive".toString());
        }
        if (j >= MAX_ARCHIVE_SIZE_EXCLUSIVE) {
            throw new IllegalArgumentException("archive size must be less than 500000000 bytes".toString());
        }
    }

    public final void requireNonNegativeSize(long j, String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        if (j < 0) {
            throw new IllegalArgumentException((label + " must be nonnegative").toString());
        }
    }

    public final void requireUnsignedCrc32(long j) {
        if (0 > j || j >= 4294967296L) {
            throw new IllegalArgumentException("CRC32 must be an unsigned 32-bit value".toString());
        }
    }

    public final void requirePackageUrl(String value) {
        Object m9916constructorimpl;
        String host;
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        if (StringsKt.isBlank(str) || !Intrinsics.areEqual(value, StringsKt.trim((CharSequence) str).toString())) {
            throw new IllegalArgumentException("package URL must be non-blank and trimmed".toString());
        }
        int i = 0;
        while (true) {
            if (i < str.length()) {
                if (Character.isISOControl(str.charAt(i))) {
                    break;
                }
                i++;
            } else if (!StringsKt.contains$default((CharSequence) str, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    ArchiveModelRules archiveModelRules = this;
                    m9916constructorimpl = Result.m9916constructorimpl(new URI(value));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
                if (m9919exceptionOrNullimpl != null) {
                    throw new IllegalArgumentException("package URL is malformed", m9919exceptionOrNullimpl);
                }
                URI uri = (URI) m9916constructorimpl;
                if (uri.getFragment() != null) {
                    throw new IllegalArgumentException("package URL must not contain a fragment".toString());
                }
                if (uri.isAbsolute()) {
                    if (!StringsKt.equals(uri.getScheme(), com.adjust.sdk.Constants.SCHEME, true) || (host = uri.getHost()) == null || StringsKt.isBlank(host)) {
                        throw new IllegalArgumentException("absolute package URL must use HTTPS and include a host".toString());
                    }
                    if (uri.getUserInfo() != null) {
                        throw new IllegalArgumentException("package URL must not contain user info".toString());
                    }
                } else if (StringsKt.startsWith$default(value, "//", false, 2, (Object) null)) {
                    throw new IllegalArgumentException("relative package URL must not be a network-path reference".toString());
                }
                String rawPath = uri.getRawPath();
                if (rawPath == null) {
                    rawPath = "";
                }
                String path = uri.getPath();
                String str2 = path != null ? path : "";
                String str3 = rawPath;
                if (StringsKt.isBlank(str3) || encodedUnsafePathToken.containsMatchIn(str3)) {
                    throw new IllegalArgumentException("package URL path contains an encoded traversal or separator".toString());
                }
                requireSafeSegments(str2, "package URL");
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!StringsKt.endsWith$default(lowerCase, OriginalTzArchiveManifestParser.ZIP_SUFFIX, false, 2, (Object) null)) {
                    throw new IllegalArgumentException("archive package URL path must end with .zip".toString());
                }
                return;
            }
        }
        throw new IllegalArgumentException("package URL contains an unsafe character".toString());
    }

    public final String entryTarget(String entryPath) {
        Intrinsics.checkNotNullParameter(entryPath, "entryPath");
        String str = entryPath;
        if (StringsKt.isBlank(str) || !Intrinsics.areEqual(entryPath, StringsKt.trim((CharSequence) str).toString())) {
            throw new IllegalArgumentException("entry path must be non-blank and trimmed".toString());
        }
        int i = 0;
        while (true) {
            if (i < str.length()) {
                if (Character.isISOControl(str.charAt(i))) {
                    break;
                }
                i++;
            } else if (!StringsKt.contains$default((CharSequence) str, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
                if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("entry path must be relative".toString());
                }
                requireSafeSegments(entryPath, "entry path");
                List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
                if (!Intrinsics.areEqual(CollectionsKt.firstOrNull((List<? extends Object>) split$default), OriginalTzArchiveManifestParser.FILES_ROOT) || split$default.size() <= 1) {
                    throw new IllegalArgumentException("entry path must start with files/ and name a target".toString());
                }
                List drop = CollectionsKt.drop(split$default, 1);
                if (StringsKt.equals((String) CollectionsKt.first((List<? extends Object>) drop), ".archive-installing", true)) {
                    throw new IllegalArgumentException("entry path targets a reserved updater root".toString());
                }
                return CollectionsKt.joinToString$default(drop, "/", null, null, 0, null, null, 62, null);
            }
        }
        throw new IllegalArgumentException("entry path contains an unsafe character".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void requireSafeSegments(String str, String str2) {
        String str3 = str;
        boolean z = false;
        List<String> split$default = StringsKt.split$default((CharSequence) str3, new char[]{'/'}, false, 0, 6, (Object) null);
        if (!(split$default instanceof Collection) || !split$default.isEmpty()) {
            for (String str4 : split$default) {
                if (Intrinsics.areEqual(str4, ".") || Intrinsics.areEqual(str4, "..")) {
                    throw new IllegalArgumentException((str2 + " must not contain dot segments").toString());
                }
                while (r1.hasNext()) {
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!z) {
                if (((String) obj).length() != 0) {
                    arrayList.add(obj);
                    z = true;
                }
            } else {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return;
        }
        for (String str5 : arrayList2) {
            if (str5.length() == 0) {
                throw new IllegalArgumentException((str2 + " must not contain empty path segments").toString());
            }
        }
    }
}
