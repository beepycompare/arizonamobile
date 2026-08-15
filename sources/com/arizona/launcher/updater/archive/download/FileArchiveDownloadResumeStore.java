package com.arizona.launcher.updater.archive.download;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/FileArchiveDownloadResumeStore;", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;", "fileOps", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumeFileOps;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Lcom/arizona/launcher/updater/archive/download/ArchiveResumeFileOps;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "sidecarFile", "Ljava/io/File;", FirebaseAnalytics.Param.DESTINATION, "load", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeMetadata;", "save", "", TtmlNode.TAG_METADATA, "delete", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileArchiveDownloadResumeStore implements ArchiveDownloadResumeStore {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final int FORMAT_VERSION = 1;
    private static final long MAX_UNSIGNED_CRC32 = 4294967295L;
    public static final String SIDECAR_SUFFIX = ".arizona-resume";
    public static final String TEMP_SUFFIX = ".tmp";
    private final ArchiveDirectoryCreator directoryCreator;
    private final ArchiveResumeFileOps fileOps;

    public FileArchiveDownloadResumeStore() {
        this(null, null, 3, null);
    }

    public FileArchiveDownloadResumeStore(ArchiveResumeFileOps fileOps, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(fileOps, "fileOps");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.fileOps = fileOps;
        this.directoryCreator = directoryCreator;
    }

    public /* synthetic */ FileArchiveDownloadResumeStore(JvmArchiveResumeFileOps jvmArchiveResumeFileOps, JvmArchiveDirectoryCreator jvmArchiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JvmArchiveResumeFileOps.INSTANCE : jvmArchiveResumeFileOps, (i & 2) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : jvmArchiveDirectoryCreator);
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadResumeStore
    public File sidecarFile(File destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return new File(destination.getParentFile(), destination.getName() + SIDECAR_SUFFIX);
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadResumeStore
    public ArchiveDownloadResumeMetadata load(File destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        File sidecarFile = sidecarFile(destination);
        if (sidecarFile.isFile()) {
            try {
                return Companion.parse$app(FilesKt.readText(sidecarFile, Charsets.UTF_8));
            } catch (IOException | IllegalArgumentException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadResumeStore
    public void save(File destination, ArchiveDownloadResumeMetadata metadata) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (StringsKt.isBlank(metadata.getPackageId())) {
            throw new IllegalArgumentException("packageId must not be blank".toString());
        }
        if (metadata.getExpectedSize() <= 0) {
            throw new IllegalArgumentException("expectedSize must be positive".toString());
        }
        long expectedCrc32 = metadata.getExpectedCrc32();
        if (0 > expectedCrc32 || expectedCrc32 >= 4294967296L) {
            throw new IllegalArgumentException("expectedCrc32 out of unsigned range".toString());
        }
        long expectedSize = metadata.getExpectedSize();
        long committedOffset = metadata.getCommittedOffset();
        if (0 > committedOffset || committedOffset > expectedSize) {
            throw new IllegalArgumentException("committedOffset out of range".toString());
        }
        File parentFile = destination.getParentFile();
        if (parentFile == null) {
            throw new IOException("Destination has no parent: " + destination.getPath());
        } else if ((!parentFile.exists() && !this.directoryCreator.createDirectories(parentFile)) || !parentFile.isDirectory()) {
            throw new IOException("Unable to create sidecar parent: " + parentFile.getPath());
        } else {
            File sidecarFile = sidecarFile(destination);
            File file = new File(parentFile, sidecarFile.getName() + ".tmp");
            if (file.exists() && !file.delete()) {
                throw new IOException("Unable to clear sidecar temp: " + file.getPath());
            }
            String encode$app = Companion.encode$app(metadata);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileOutputStream fileOutputStream2 = fileOutputStream;
                byte[] bytes = encode$app.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                fileOutputStream2.write(bytes);
                fileOutputStream2.flush();
                fileOutputStream2.getFD().sync();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                this.fileOps.replaceAtomically(file, sidecarFile);
                this.fileOps.syncDirectory(parentFile);
            } catch (IOException e) {
                file.delete();
                throw e;
            } catch (RuntimeException e2) {
                file.delete();
                throw new IOException("Failed to persist archive resume sidecar", e2);
            }
        }
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveDownloadResumeStore
    public void delete(File destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        File sidecarFile = sidecarFile(destination);
        File file = new File(sidecarFile.getParentFile(), sidecarFile.getName() + ".tmp");
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete sidecar temp: " + file.getPath());
        } else if (!sidecarFile.exists() || sidecarFile.delete()) {
        } else {
            throw new IOException("Unable to delete resume sidecar: " + sidecarFile.getPath());
        }
    }

    /* compiled from: ArchiveDownloadResumeSidecar.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/FileArchiveDownloadResumeStore$Companion;", "", "<init>", "()V", "SIDECAR_SUFFIX", "", "TEMP_SUFFIX", "FORMAT_VERSION", "", "MAX_UNSIGNED_CRC32", "", "forAndroid", "Lcom/arizona/launcher/updater/archive/download/FileArchiveDownloadResumeStore;", "encode", TtmlNode.TAG_METADATA, "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeMetadata;", "encode$app", "parse", "raw", "parse$app", "escape", "value", "unescape", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileArchiveDownloadResumeStore forAndroid() {
            return new FileArchiveDownloadResumeStore(AndroidArchiveResumeFileOps.INSTANCE, AndroidArchiveDirectoryCreator.INSTANCE);
        }

        public final String encode$app(ArchiveDownloadResumeMetadata metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            StringBuilder sb = new StringBuilder("arizona-archive-resume=1\npackageId=");
            sb.append(FileArchiveDownloadResumeStore.Companion.escape(metadata.getPackageId())).append("\nexpectedSize=");
            sb.append(metadata.getExpectedSize()).append("\nexpectedCrc32=");
            sb.append(metadata.getExpectedCrc32()).append("\ncommittedOffset=");
            sb.append(metadata.getCommittedOffset()).append('\n');
            String strongEtag = metadata.getStrongEtag();
            if (strongEtag != null) {
                sb.append("strongEtag=").append(FileArchiveDownloadResumeStore.Companion.escape(strongEtag)).append('\n');
            }
            String lastModified = metadata.getLastModified();
            if (lastModified != null) {
                sb.append("lastModified=").append(FileArchiveDownloadResumeStore.Companion.escape(lastModified)).append('\n');
            }
            return sb.toString();
        }

        public final ArchiveDownloadResumeMetadata parse$app(String raw) {
            Integer intOrNull;
            String str;
            String str2;
            Long longOrNull;
            Long longOrNull2;
            Long longOrNull3;
            Intrinsics.checkNotNullParameter(raw, "raw");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str3 : StringsKt.lineSequence(raw)) {
                String obj = StringsKt.trim((CharSequence) str3).toString();
                String str4 = obj;
                if (str4.length() != 0 && !StringsKt.startsWith$default(obj, "#", false, 2, (Object) null)) {
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str4, '=', 0, false, 6, (Object) null);
                    if (indexOf$default <= 0) {
                        return null;
                    }
                    String substring = obj.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String substring2 = obj.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    linkedHashMap.put(substring, unescape(substring2));
                }
            }
            String str5 = (String) linkedHashMap.get("arizona-archive-resume");
            if (str5 != null && (intOrNull = StringsKt.toIntOrNull(str5)) != null && intOrNull.intValue() == 1 && (str = (String) linkedHashMap.get("packageId")) != null) {
                String str6 = !StringsKt.isBlank(str) ? str : null;
                if (str6 != null && (str2 = (String) linkedHashMap.get("expectedSize")) != null && (longOrNull = StringsKt.toLongOrNull(str2)) != null) {
                    long longValue = longOrNull.longValue();
                    String str7 = (String) linkedHashMap.get("expectedCrc32");
                    if (str7 != null && (longOrNull2 = StringsKt.toLongOrNull(str7)) != null) {
                        long longValue2 = longOrNull2.longValue();
                        String str8 = (String) linkedHashMap.get("committedOffset");
                        if (str8 != null && (longOrNull3 = StringsKt.toLongOrNull(str8)) != null) {
                            long longValue3 = longOrNull3.longValue();
                            if (longValue > 0 && 0 <= longValue2 && longValue2 < 4294967296L && 0 <= longValue3 && longValue3 <= longValue) {
                                String str9 = (String) linkedHashMap.get("strongEtag");
                                String str10 = (str9 == null || str9.length() <= 0) ? null : str9;
                                String str11 = (String) linkedHashMap.get("lastModified");
                                return new ArchiveDownloadResumeMetadata(str6, longValue, longValue2, longValue3, str10, (str11 == null || str11.length() <= 0) ? null : str11);
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
