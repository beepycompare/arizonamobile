package com.arizona.launcher.updater.archive.state;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchiveStateValidation.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002J:\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J$\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveStateValidation;", "", "<init>", "()V", "requireValidIdentity", "", "identity", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", Constants.ScionAnalytics.PARAM_LABEL, "", "requireValidEntry", "entry", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "requireValidState", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "requireValidFiles", "packageId", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "requireValidRelativePath", "path", "registerOwnership", "owners", "", "sameFileProofs", "", "first", "second", "LOWERCASE_MD5", "Lkotlin/text/Regex;", "PACKAGE_ID", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStateValidation {
    public static final int $stable = 0;
    public static final ArchiveStateValidation INSTANCE = new ArchiveStateValidation();
    private static final Regex LOWERCASE_MD5 = new Regex("^[0-9a-f]{32}$");
    private static final Regex PACKAGE_ID = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}");

    private ArchiveStateValidation() {
    }

    public static /* synthetic */ void requireValidIdentity$default(ArchiveStateValidation archiveStateValidation, ArchivePackageIdentity archivePackageIdentity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "identity";
        }
        archiveStateValidation.requireValidIdentity(archivePackageIdentity, str);
    }

    public final void requireValidIdentity(ArchivePackageIdentity identity, String label) {
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(label, "label");
        if (StringsKt.isBlank(identity.getPackageId())) {
            throw new ArchiveStateInvariantException(label + ".packageId must be non-blank", null, 2, null);
        }
        if (identity.getArchiveSize() <= 0) {
            throw new ArchiveStateInvariantException(label + ".archiveSize must be > 0, got " + identity.getArchiveSize(), null, 2, null);
        }
        long archiveCrc32 = identity.getArchiveCrc32();
        if (0 > archiveCrc32 || archiveCrc32 >= 4294967296L) {
            throw new ArchiveStateInvariantException(label + ".archiveCrc32 must be unsigned CRC32 (0..4294967295), got " + identity.getArchiveCrc32(), null, 2, null);
        }
    }

    public final void requireValidEntry(ArchivePackageJournalEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        requireValidIdentity(entry.getIdentity(), "identity");
        if (entry.getBytesDownloaded() < 0) {
            throw new ArchiveStateInvariantException("bytesDownloaded must be >= 0 for package '" + entry.getPackageId() + "'", null, 2, null);
        } else if (entry.getBytesDownloaded() > entry.getArchiveSize()) {
            long bytesDownloaded = entry.getBytesDownloaded();
            long archiveSize = entry.getArchiveSize();
            throw new ArchiveStateInvariantException("bytesDownloaded (" + bytesDownloaded + ") exceeds archiveSize (" + archiveSize + ") for package '" + entry.getPackageId() + "'", null, 2, null);
        } else if (entry.getPhaseUpdatedAtEpochMs() < 0) {
            throw new ArchiveStateInvariantException("phaseUpdatedAtEpochMs must be >= 0 for package '" + entry.getPackageId() + "'", null, 2, null);
        } else {
            ArchivePackageIdentity previousCommitted = entry.getPreviousCommitted();
            if (previousCommitted != null) {
                INSTANCE.requireValidIdentity(previousCommitted, "previousCommitted");
                if (!Intrinsics.areEqual(previousCommitted.getPackageId(), entry.getPackageId())) {
                    String packageId = previousCommitted.getPackageId();
                    throw new ArchiveStateInvariantException("previousCommitted.packageId ('" + packageId + "') must match entry packageId ('" + entry.getPackageId() + "')", null, 2, null);
                }
            }
            requireValidFiles(entry.getPackageId(), OriginalTzArchiveManifestParser.FILES_ROOT, entry.getFiles());
            requireValidFiles(entry.getPackageId(), "desiredFiles", entry.getDesiredFiles());
            requireValidFiles(entry.getPackageId(), "previousFiles", entry.getPreviousFiles());
            if (entry.getPreviousCommitted() == null && !entry.getPreviousFiles().isEmpty()) {
                throw new ArchiveStateInvariantException("previousFiles require previousCommitted for package '" + entry.getPackageId() + "'", null, 2, null);
            } else if (entry.getPhase() == ArchivePackagePhase.COMMITTED && entry.getPreviousCommitted() != null) {
                throw new ArchiveStateInvariantException("COMMITTED package '" + entry.getPackageId() + "' must not retain previousCommitted", null, 2, null);
            } else if (entry.getPhase() == ArchivePackagePhase.COMMITTED && !entry.getPreviousFiles().isEmpty()) {
                throw new ArchiveStateInvariantException("COMMITTED package '" + entry.getPackageId() + "' must not retain previousFiles", null, 2, null);
            } else if (entry.getPhase() != ArchivePackagePhase.COMMITTED || entry.getDesiredFiles().isEmpty() || sameFileProofs(entry.getFiles(), entry.getDesiredFiles())) {
            } else {
                throw new ArchiveStateInvariantException("COMMITTED package '" + entry.getPackageId() + "' files must match desiredFiles", null, 2, null);
            }
        }
    }

    public final void requireValidState(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getSchemaVersion() != 1) {
            throw new ArchiveStateInvariantException("Unsupported schemaVersion " + state.getSchemaVersion() + "; expected 1", null, 2, null);
        } else if (StringsKt.isBlank(state.getManifestId())) {
            throw new ArchiveStateInvariantException("manifestId must be non-blank", null, 2, null);
        } else {
            if (StringsKt.isBlank(state.getManifestVersion())) {
                throw new ArchiveStateInvariantException("manifestVersion must be non-blank", null, 2, null);
            }
            if (state.getManifestSchemaVersion() <= 0) {
                throw new ArchiveStateInvariantException("manifestSchemaVersion must be positive", null, 2, null);
            }
            if (StringsKt.isBlank(state.getSelectedGpu()) || !Intrinsics.areEqual(state.getSelectedGpu(), StringsKt.trim((CharSequence) state.getSelectedGpu()).toString())) {
                throw new ArchiveStateInvariantException("selectedGpu must be a non-blank trimmed value", null, 2, null);
            }
            if (state.getUpdatedAtEpochMs() < 0) {
                throw new ArchiveStateInvariantException("updatedAtEpochMs must be >= 0", null, 2, null);
            }
            if (state.getLegacyMetadataReconciled() && !state.isPayloadCommitted()) {
                throw new ArchiveStateInvariantException("legacyMetadataReconciled requires every package to be COMMITTED", null, 2, null);
            }
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (ArchivePackageJournalEntry archivePackageJournalEntry : state.getPackages()) {
                requireValidEntry(archivePackageJournalEntry);
                if (!hashSet.add(archivePackageJournalEntry.getPackageId())) {
                    throw new ArchiveStateInvariantException("Duplicate packageId '" + archivePackageJournalEntry.getPackageId() + "' in archive updater state", null, 2, null);
                }
                registerOwnership(hashMap, archivePackageJournalEntry.getPackageId(), OriginalTzArchiveManifestParser.FILES_ROOT, archivePackageJournalEntry.getFiles());
                registerOwnership(hashMap2, archivePackageJournalEntry.getPackageId(), "desiredFiles", archivePackageJournalEntry.getDesiredFiles());
                registerOwnership(hashMap3, archivePackageJournalEntry.getPackageId(), "previousFiles", archivePackageJournalEntry.getPreviousFiles());
            }
            HashSet hashSet2 = new HashSet();
            for (ArchiveFileRetirementRecord archiveFileRetirementRecord : state.getPendingRetirements()) {
                if (!PACKAGE_ID.matches(archiveFileRetirementRecord.getPackageId())) {
                    throw new ArchiveStateInvariantException("pendingRetirements contains invalid packageId '" + archiveFileRetirementRecord.getPackageId() + "'", null, 2, null);
                }
                INSTANCE.requireValidRelativePath(archiveFileRetirementRecord.getPackageId(), "pendingRetirements", archiveFileRetirementRecord.getRelativePath());
                String relativePath = archiveFileRetirementRecord.getRelativePath();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = relativePath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!hashSet2.add(lowerCase)) {
                    throw new ArchiveStateInvariantException("pendingRetirements contains duplicate path '" + archiveFileRetirementRecord.getRelativePath() + "'", null, 2, null);
                } else if (hashMap2.containsKey(lowerCase)) {
                    throw new ArchiveStateInvariantException("pending retirement '" + archiveFileRetirementRecord.getRelativePath() + "' is still desired", null, 2, null);
                }
            }
        }
    }

    private final void requireValidFiles(String str, String str2, List<ArchivePackageFileRecord> list) {
        HashSet hashSet = new HashSet();
        for (ArchivePackageFileRecord archivePackageFileRecord : list) {
            String relativePath = archivePackageFileRecord.getRelativePath();
            INSTANCE.requireValidRelativePath(str, str2, relativePath);
            if (archivePackageFileRecord.getSize() < 0) {
                throw new ArchiveStateInvariantException(str2 + ".size must be >= 0 for '" + relativePath + "' in package '" + str + "'", null, 2, null);
            }
            long crc32 = archivePackageFileRecord.getCrc32();
            if (0 > crc32 || crc32 >= 4294967296L) {
                throw new ArchiveStateInvariantException(str2 + ".crc32 must be unsigned CRC32 for '" + relativePath + "' in package '" + str + "'", null, 2, null);
            }
            if (archivePackageFileRecord.getMd5() != null && !LOWERCASE_MD5.matches(archivePackageFileRecord.getMd5())) {
                throw new ArchiveStateInvariantException(str2 + ".md5 must be lowercase MD5 for '" + relativePath + "' in package '" + str + "'", null, 2, null);
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!hashSet.add(lowerCase)) {
                throw new ArchiveStateInvariantException(str2 + " contains duplicate path '" + relativePath + "' for package '" + str + "'", null, 2, null);
            }
        }
    }

    private final void requireValidRelativePath(String str, String str2, String str3) {
        String str4 = str3;
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) str4, new char[]{'/'}, false, 0, 6, (Object) null);
        if (!StringsKt.isBlank(str4) && Intrinsics.areEqual(str3, StringsKt.trim((CharSequence) str4).toString()) && !StringsKt.startsWith$default((CharSequence) str4, '/', false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str4, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            while (true) {
                if (i < str4.length()) {
                    if (Character.isISOControl(str4.charAt(i))) {
                        break;
                    }
                    i++;
                } else {
                    List<String> list = split$default;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (String str5 : list) {
                            if (str5.length() == 0) {
                                break;
                            } else if (Intrinsics.areEqual(str5, ".")) {
                                break;
                            } else if (Intrinsics.areEqual(str5, "..")) {
                                break;
                            }
                        }
                    }
                    if (!StringsKt.equals((String) CollectionsKt.first((List<? extends Object>) split$default), ".archive-installing", true)) {
                        return;
                    }
                }
            }
        }
        throw new ArchiveStateInvariantException(str2 + " contains unsafe relativePath '" + str3 + "' for package '" + str + "'", null, 2, null);
    }

    private final void registerOwnership(Map<String, String> map, String str, String str2, List<ArchivePackageFileRecord> list) {
        for (ArchivePackageFileRecord archivePackageFileRecord : list) {
            String relativePath = archivePackageFileRecord.getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String putIfAbsent = map.putIfAbsent(lowerCase, str);
            if (putIfAbsent != null) {
                throw new ArchiveStateInvariantException(str2 + " file '" + archivePackageFileRecord.getRelativePath() + "' is owned by both '" + putIfAbsent + "' and '" + str + "'", null, 2, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean sameFileProofs(List<ArchivePackageFileRecord> list, List<ArchivePackageFileRecord> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        List<ArchivePackageFileRecord> list3 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
        for (Object obj : list3) {
            String relativePath = ((ArchivePackageFileRecord) obj).getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        List<ArchivePackageFileRecord> list4 = list2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list4, 10)), 16));
        for (Object obj2 : list4) {
            String relativePath2 = ((ArchivePackageFileRecord) obj2).getRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = relativePath2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            linkedHashMap2.put(lowerCase2, obj2);
        }
        if (Intrinsics.areEqual(linkedHashMap.keySet(), linkedHashMap2.keySet())) {
            if (linkedHashMap.isEmpty()) {
                return true;
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) entry.getValue();
                ArchivePackageFileRecord archivePackageFileRecord2 = (ArchivePackageFileRecord) linkedHashMap2.get((String) entry.getKey());
                if (archivePackageFileRecord2 == null || archivePackageFileRecord2.getSize() != archivePackageFileRecord.getSize() || archivePackageFileRecord2.getCrc32() != archivePackageFileRecord.getCrc32()) {
                    return false;
                }
                while (r8.hasNext()) {
                }
            }
            return true;
        }
        return false;
    }
}
