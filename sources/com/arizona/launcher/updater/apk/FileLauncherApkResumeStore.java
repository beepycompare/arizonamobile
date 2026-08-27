package com.arizona.launcher.updater.apk;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.UtilsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: LauncherApkResumeStore.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/apk/FileLauncherApkResumeStore;", "Lcom/arizona/launcher/updater/apk/LauncherApkResumeStore;", "fileOps", "Lcom/arizona/launcher/updater/apk/LauncherApkFileOps;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkFileOps;)V", "sidecarFile", "Ljava/io/File;", "partialFile", "temporarySidecarFile", "load", "Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "save", "", TtmlNode.TAG_METADATA, "delete", "", "deleteFileIfPresent", UtilsKt.SCHEME_FILE, "description", "", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileLauncherApkResumeStore implements LauncherApkResumeStore {
    private static final int FORMAT_VERSION = 1;
    public static final String SIDECAR_SUFFIX = ".resume";
    public static final String TEMP_SUFFIX = ".tmp";
    private final LauncherApkFileOps fileOps;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex SHA256_REGEX = new Regex("[0-9a-fA-F]{64}");

    public FileLauncherApkResumeStore(LauncherApkFileOps fileOps) {
        Intrinsics.checkNotNullParameter(fileOps, "fileOps");
        this.fileOps = fileOps;
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkResumeStore
    public File sidecarFile(File partialFile) {
        Intrinsics.checkNotNullParameter(partialFile, "partialFile");
        return new File(partialFile.getParentFile(), partialFile.getName() + SIDECAR_SUFFIX);
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkResumeStore
    public File temporarySidecarFile(File partialFile) {
        Intrinsics.checkNotNullParameter(partialFile, "partialFile");
        return new File(partialFile.getParentFile(), partialFile.getName() + ".resume.tmp");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.arizona.launcher.updater.apk.LauncherApkResumeStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LauncherApkResumeMetadata load(File partialFile) {
        Boolean m9919constructorimpl;
        File parentFile;
        boolean z;
        File canonicalFile;
        Intrinsics.checkNotNullParameter(partialFile, "partialFile");
        File sidecarFile = sidecarFile(partialFile);
        if (!sidecarFile.isFile()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            FileLauncherApkResumeStore fileLauncherApkResumeStore = this;
            parentFile = sidecarFile.getParentFile();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (parentFile != null && (canonicalFile = parentFile.getCanonicalFile()) != null && Intrinsics.areEqual(sidecarFile.getCanonicalPath(), new File(canonicalFile, sidecarFile.getName()).getAbsolutePath())) {
            z = false;
            m9919constructorimpl = Result.m9919constructorimpl(Boolean.valueOf(z));
            if (Result.m9925isFailureimpl(m9919constructorimpl)) {
                m9919constructorimpl = true;
            }
            if (((Boolean) m9919constructorimpl).booleanValue()) {
                try {
                    return Companion.parse(FilesKt.readText(sidecarFile, Charsets.UTF_8));
                } catch (IOException | RuntimeException unused) {
                    return null;
                }
            }
            return null;
        }
        z = true;
        m9919constructorimpl = Result.m9919constructorimpl(Boolean.valueOf(z));
        if (Result.m9925isFailureimpl(m9919constructorimpl)) {
        }
        if (((Boolean) m9919constructorimpl).booleanValue()) {
        }
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkResumeStore
    public void save(File partialFile, LauncherApkResumeMetadata metadata) {
        Intrinsics.checkNotNullParameter(partialFile, "partialFile");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (StringsKt.isBlank(metadata.getSourceUrl())) {
            throw new IllegalArgumentException("sourceUrl must not be blank".toString());
        }
        if (metadata.getTotalBytes() <= 0) {
            throw new IllegalArgumentException("totalBytes must be positive".toString());
        }
        long totalBytes = metadata.getTotalBytes();
        long committedBytes = metadata.getCommittedBytes();
        if (0 > committedBytes || committedBytes > totalBytes) {
            throw new IllegalArgumentException("committedBytes is outside the payload".toString());
        }
        if (StringsKt.isBlank(metadata.getValidatorValue())) {
            throw new IllegalArgumentException("validatorValue must not be blank".toString());
        }
        File parentFile = partialFile.getParentFile();
        if (parentFile == null) {
            throw new IOException("Partial launcher APK has no parent directory");
        }
        if ((!parentFile.exists() && !parentFile.mkdirs()) || !parentFile.isDirectory()) {
            throw new IOException("Unable to create launcher APK sidecar directory");
        }
        File sidecarFile = sidecarFile(partialFile);
        File temporarySidecarFile = temporarySidecarFile(partialFile);
        deleteFileIfPresent(temporarySidecarFile, "temporary launcher APK sidecar");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(temporarySidecarFile);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bytes = Companion.encode(metadata).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream2.write(bytes);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            this.fileOps.atomicReplace(temporarySidecarFile, sidecarFile);
            this.fileOps.syncDirectory(parentFile);
        } catch (IOException e) {
            temporarySidecarFile.delete();
            throw e;
        } catch (RuntimeException e2) {
            temporarySidecarFile.delete();
            throw new IOException("Unable to save launcher APK resume sidecar", e2);
        }
    }

    @Override // com.arizona.launcher.updater.apk.LauncherApkResumeStore
    public boolean delete(File partialFile) {
        Intrinsics.checkNotNullParameter(partialFile, "partialFile");
        File sidecarFile = sidecarFile(partialFile);
        File temporarySidecarFile = temporarySidecarFile(partialFile);
        boolean z = sidecarFile.exists() || temporarySidecarFile.exists();
        deleteFileIfPresent(temporarySidecarFile, "temporary launcher APK sidecar");
        deleteFileIfPresent(sidecarFile, "launcher APK sidecar");
        return z;
    }

    private final void deleteFileIfPresent(File file, String str) {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete " + str);
        }
    }

    /* compiled from: LauncherApkResumeStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/apk/FileLauncherApkResumeStore$Companion;", "", "<init>", "()V", "SIDECAR_SUFFIX", "", "TEMP_SUFFIX", "FORMAT_VERSION", "", "encode", TtmlNode.TAG_METADATA, "Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "parse", "raw", "escape", "value", "unescape", "SHA256_REGEX", "Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String encode(LauncherApkResumeMetadata metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            StringBuilder sb = new StringBuilder("arizona-launcher-apk-resume=1\nsourceUrl=");
            sb.append(FileLauncherApkResumeStore.Companion.escape(metadata.getSourceUrl())).append("\ntotalBytes=");
            sb.append(metadata.getTotalBytes()).append("\ncommittedBytes=");
            sb.append(metadata.getCommittedBytes()).append("\nvalidatorKind=");
            sb.append(metadata.getValidatorKind().name()).append("\nvalidatorValue=");
            sb.append(FileLauncherApkResumeStore.Companion.escape(metadata.getValidatorValue())).append("\nexpectedSizeBytes=");
            Long expectedSizeBytes = metadata.getExpectedSizeBytes();
            String valueOf = expectedSizeBytes != null ? String.valueOf(expectedSizeBytes.longValue()) : null;
            if (valueOf == null) {
                valueOf = "";
            }
            sb.append(valueOf).append("\nexpectedSha256=");
            String expectedSha256 = metadata.getExpectedSha256();
            sb.append(expectedSha256 != null ? expectedSha256 : "").append('\n');
            return sb.toString();
        }

        public final LauncherApkResumeMetadata parse(String raw) {
            Integer intOrNull;
            String str;
            String str2;
            Long longOrNull;
            Long longOrNull2;
            Object m9919constructorimpl;
            String str3;
            String str4;
            Long valueOf;
            Intrinsics.checkNotNullParameter(raw, "raw");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str5 : StringsKt.lineSequence(raw)) {
                String str6 = str5;
                if (!StringsKt.isBlank(str6) && !StringsKt.startsWith$default(str5, "#", false, 2, (Object) null)) {
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str6, '=', 0, false, 6, (Object) null);
                    if (indexOf$default <= 0) {
                        return null;
                    }
                    String substring = str5.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String substring2 = str5.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    linkedHashMap.put(substring, unescape(substring2));
                }
            }
            String str7 = (String) linkedHashMap.get("arizona-launcher-apk-resume");
            if (str7 != null && (intOrNull = StringsKt.toIntOrNull(str7)) != null && intOrNull.intValue() == 1 && (str = (String) linkedHashMap.get("sourceUrl")) != null) {
                String str8 = !StringsKt.isBlank(str) ? str : null;
                if (str8 != null && (str2 = (String) linkedHashMap.get("totalBytes")) != null && (longOrNull = StringsKt.toLongOrNull(str2)) != null) {
                    long longValue = longOrNull.longValue();
                    String str9 = (String) linkedHashMap.get("committedBytes");
                    if (str9 != null && (longOrNull2 = StringsKt.toLongOrNull(str9)) != null) {
                        long longValue2 = longOrNull2.longValue();
                        String str10 = (String) linkedHashMap.get("validatorKind");
                        if (str10 != null) {
                            Companion companion = FileLauncherApkResumeStore.Companion;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                m9919constructorimpl = Result.m9919constructorimpl(LauncherApkValidatorKind.valueOf(str10));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.Companion;
                                m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m9925isFailureimpl(m9919constructorimpl)) {
                                m9919constructorimpl = null;
                            }
                            LauncherApkValidatorKind launcherApkValidatorKind = (LauncherApkValidatorKind) m9919constructorimpl;
                            if (launcherApkValidatorKind != null && (str3 = (String) linkedHashMap.get("validatorValue")) != null) {
                                String str11 = !StringsKt.isBlank(str3) ? str3 : null;
                                if (str11 == null || (str4 = (String) linkedHashMap.get("expectedSizeBytes")) == null) {
                                    return null;
                                }
                                if (str4.length() == 0) {
                                    valueOf = null;
                                } else {
                                    Long longOrNull3 = StringsKt.toLongOrNull(str4);
                                    if (longOrNull3 != null) {
                                        valueOf = Long.valueOf(longOrNull3.longValue());
                                    }
                                }
                                LinkedHashMap linkedHashMap2 = linkedHashMap;
                                if (!linkedHashMap2.containsKey("expectedSha256")) {
                                    return null;
                                }
                                Object value = MapsKt.getValue(linkedHashMap2, "expectedSha256");
                                if (((String) value).length() <= 0) {
                                    value = null;
                                }
                                String str12 = (String) value;
                                if (longValue > 0 && 0 <= longValue2 && longValue2 <= longValue) {
                                    if (valueOf == null || valueOf.longValue() > 0) {
                                        if (str12 == null || FileLauncherApkResumeStore.SHA256_REGEX.matches(str12)) {
                                            return new LauncherApkResumeMetadata(str8, longValue, longValue2, launcherApkValidatorKind, str11, valueOf, str12);
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        private final String escape(String str) {
            return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        }

        private final String unescape(String str) {
            int i;
            StringBuilder sb = new StringBuilder(str.length());
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' || (i = i2 + 1) >= str.length()) {
                    sb.append(charAt);
                    i2++;
                } else {
                    char charAt2 = str.charAt(i);
                    if (charAt2 == '\\') {
                        sb.append(AbstractJsonLexerKt.STRING_ESC);
                    } else if (charAt2 == 'n') {
                        sb.append('\n');
                    } else if (charAt2 == 'r') {
                        sb.append('\r');
                    } else {
                        sb.append(charAt);
                        i2 = i;
                    }
                    i2 += 2;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }
}
