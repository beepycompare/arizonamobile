package com.arizona.launcher.updater.archive.transaction;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002R\u000e\u0010\u0016\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipDiffPlanner;", "", "<init>", "()V", "diff", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipDiff;", "oldOwnership", "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "desiredOwnership", "validatedOwnership", "", "", "ownership", Constants.ScionAnalytics.PARAM_LABEL, "validateRelativePath", "", "relativePath", "validatePackageId", "packageId", "normalize", "path", "RESERVED_WORK_ROOT", "PACKAGE_ID", "Lkotlin/text/Regex;", "WINDOWS_ABSOLUTE_PATH", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnershipDiffPlanner {
    public static final int $stable = 0;
    private static final String RESERVED_WORK_ROOT = ".archive-installing";
    public static final ArchiveOwnershipDiffPlanner INSTANCE = new ArchiveOwnershipDiffPlanner();
    private static final Regex PACKAGE_ID = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}");
    private static final Regex WINDOWS_ABSOLUTE_PATH = new Regex("^[A-Za-z]:/.*");

    private ArchiveOwnershipDiffPlanner() {
    }

    public final ArchiveOwnershipDiff diff(Iterable<ArchiveOwnedPath> oldOwnership, Iterable<ArchiveOwnedPath> desiredOwnership) {
        Intrinsics.checkNotNullParameter(oldOwnership, "oldOwnership");
        Intrinsics.checkNotNullParameter(desiredOwnership, "desiredOwnership");
        Map<String, ArchiveOwnedPath> validatedOwnership = validatedOwnership(oldOwnership, "old");
        Map<String, ArchiveOwnedPath> validatedOwnership2 = validatedOwnership(desiredOwnership, "desired");
        List<String> sorted = CollectionsKt.sorted(SetsKt.minus((Set) validatedOwnership.keySet(), (Iterable) validatedOwnership2.keySet()));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sorted, 10));
        for (String str : sorted) {
            arrayList.add((ArchiveOwnedPath) MapsKt.getValue(validatedOwnership, str));
        }
        ArrayList arrayList2 = arrayList;
        List<String> sorted2 = CollectionsKt.sorted(SetsKt.minus((Set) validatedOwnership2.keySet(), (Iterable) validatedOwnership.keySet()));
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sorted2, 10));
        for (String str2 : sorted2) {
            arrayList3.add((ArchiveOwnedPath) MapsKt.getValue(validatedOwnership2, str2));
        }
        ArrayList arrayList4 = arrayList3;
        List<String> sorted3 = CollectionsKt.sorted(CollectionsKt.intersect(validatedOwnership.keySet(), validatedOwnership2.keySet()));
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sorted3, 10));
        for (String str3 : sorted3) {
            arrayList5.add(new ArchiveOwnershipTransition((ArchiveOwnedPath) MapsKt.getValue(validatedOwnership, str3), (ArchiveOwnedPath) MapsKt.getValue(validatedOwnership2, str3)));
        }
        return new ArchiveOwnershipDiff(arrayList2, arrayList4, arrayList5);
    }

    public static /* synthetic */ Map validatedOwnership$default(ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner, Iterable iterable, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "ownership";
        }
        return archiveOwnershipDiffPlanner.validatedOwnership(iterable, str);
    }

    public final Map<String, ArchiveOwnedPath> validatedOwnership(Iterable<ArchiveOwnedPath> ownership, String label) {
        Intrinsics.checkNotNullParameter(ownership, "ownership");
        Intrinsics.checkNotNullParameter(label, "label");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ArchiveOwnedPath archiveOwnedPath : ownership) {
            ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner = INSTANCE;
            archiveOwnershipDiffPlanner.validatePackageId(archiveOwnedPath.getPackageId(), label);
            archiveOwnershipDiffPlanner.validateRelativePath(archiveOwnedPath.getRelativePath(), label);
            ArchiveOwnedPath archiveOwnedPath2 = (ArchiveOwnedPath) linkedHashMap.putIfAbsent(archiveOwnershipDiffPlanner.normalize(archiveOwnedPath.getRelativePath()), archiveOwnedPath);
            if (archiveOwnedPath2 != null) {
                ArchiveOwnershipErrorCode archiveOwnershipErrorCode = ArchiveOwnershipErrorCode.DUPLICATE_PATH;
                String relativePath = archiveOwnedPath.getRelativePath();
                String relativePath2 = archiveOwnedPath2.getRelativePath();
                String relativePath3 = archiveOwnedPath.getRelativePath();
                String packageId = archiveOwnedPath2.getPackageId();
                throw new ArchiveOwnershipException(archiveOwnershipErrorCode, relativePath, relativePath2, label + " has more than one owner for '" + relativePath3 + "': '" + packageId + "' and '" + archiveOwnedPath.getPackageId() + "'");
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            String str = (String) entry.getKey();
            ArchiveOwnedPath archiveOwnedPath3 = (ArchiveOwnedPath) entry.getValue();
            String str2 = str;
            for (int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, '/', 0, false, 6, (Object) null); indexOf$default >= 0; indexOf$default = StringsKt.indexOf$default((CharSequence) str2, '/', indexOf$default + 1, false, 4, (Object) null)) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                ArchiveOwnedPath archiveOwnedPath4 = (ArchiveOwnedPath) linkedHashMap.get(substring);
                if (archiveOwnedPath4 != null) {
                    ArchiveOwnershipErrorCode archiveOwnershipErrorCode2 = ArchiveOwnershipErrorCode.FILE_DESCENDANT_COLLISION;
                    String relativePath4 = archiveOwnedPath3.getRelativePath();
                    String relativePath5 = archiveOwnedPath4.getRelativePath();
                    String relativePath6 = archiveOwnedPath4.getRelativePath();
                    throw new ArchiveOwnershipException(archiveOwnershipErrorCode2, relativePath4, relativePath5, label + " contains file/descendant collision between '" + relativePath6 + "' and '" + archiveOwnedPath3.getRelativePath() + "'");
                }
            }
        }
        return MapsKt.toSortedMap(linkedHashMap2);
    }

    public static /* synthetic */ void validateRelativePath$default(ArchiveOwnershipDiffPlanner archiveOwnershipDiffPlanner, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "ownership";
        }
        archiveOwnershipDiffPlanner.validateRelativePath(str, str2);
    }

    public final void validateRelativePath(String relativePath, String label) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(label, "label");
        String str = relativePath;
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        if (!StringsKt.isBlank(str) && Intrinsics.areEqual(relativePath, StringsKt.trim((CharSequence) str).toString()) && !StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null) && !WINDOWS_ABSOLUTE_PATH.matches(str) && !StringsKt.contains$default((CharSequence) str, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            while (true) {
                if (i < str.length()) {
                    if (Character.isISOControl(str.charAt(i))) {
                        break;
                    }
                    i++;
                } else {
                    List<String> list = split$default;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (String str2 : list) {
                            if (str2.length() != 0) {
                                if (!Intrinsics.areEqual(str2, ".")) {
                                    if (Intrinsics.areEqual(str2, "..")) {
                                    }
                                }
                            }
                        }
                    }
                    if (StringsKt.equals((String) CollectionsKt.first((List<? extends Object>) split$default), ".archive-installing", true)) {
                        throw new ArchiveOwnershipException(ArchiveOwnershipErrorCode.RESERVED_UPDATER_PATH, relativePath, null, label + " attempts to own reserved updater path '" + relativePath + "'", 4, null);
                    }
                    return;
                }
            }
        }
        throw new ArchiveOwnershipException(ArchiveOwnershipErrorCode.UNSAFE_RELATIVE_PATH, relativePath, null, label + " contains unsafe relative path '" + relativePath + "'", 4, null);
    }

    private final void validatePackageId(String str, String str2) {
        if (!PACKAGE_ID.matches(str)) {
            throw new ArchiveOwnershipException(ArchiveOwnershipErrorCode.INVALID_PACKAGE_ID, null, null, str2 + " contains invalid package id '" + str + "'", 6, null);
        }
    }

    private final String normalize(String str) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
