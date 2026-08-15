package com.arizona.launcher.updater.archive.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveManifest.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "", "schemaVersion", "", "manifestVersion", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "<init>", "(ILjava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/util/List;)V", "getSchemaVersion", "()I", "getManifestVersion", "()Ljava/lang/String;", "getSelectedGpu", "()Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "getPackages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifest {
    public static final int $stable = 8;
    private final String manifestVersion;
    private final List<ArchivePackage> packages;
    private final int schemaVersion;
    private final ArchiveGpu selectedGpu;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveManifest copy$default(ArchiveManifest archiveManifest, int i, String str, ArchiveGpu archiveGpu, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = archiveManifest.schemaVersion;
        }
        if ((i2 & 2) != 0) {
            str = archiveManifest.manifestVersion;
        }
        if ((i2 & 4) != 0) {
            archiveGpu = archiveManifest.selectedGpu;
        }
        if ((i2 & 8) != 0) {
            list = archiveManifest.packages;
        }
        return archiveManifest.copy(i, str, archiveGpu, list);
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.manifestVersion;
    }

    public final ArchiveGpu component3() {
        return this.selectedGpu;
    }

    public final List<ArchivePackage> component4() {
        return this.packages;
    }

    public final ArchiveManifest copy(int i, String manifestVersion, ArchiveGpu selectedGpu, List<ArchivePackage> packages) {
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(packages, "packages");
        return new ArchiveManifest(i, manifestVersion, selectedGpu, packages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveManifest) {
            ArchiveManifest archiveManifest = (ArchiveManifest) obj;
            return this.schemaVersion == archiveManifest.schemaVersion && Intrinsics.areEqual(this.manifestVersion, archiveManifest.manifestVersion) && this.selectedGpu == archiveManifest.selectedGpu && Intrinsics.areEqual(this.packages, archiveManifest.packages);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.schemaVersion) * 31) + this.manifestVersion.hashCode()) * 31) + this.selectedGpu.hashCode()) * 31) + this.packages.hashCode();
    }

    public String toString() {
        int i = this.schemaVersion;
        String str = this.manifestVersion;
        ArchiveGpu archiveGpu = this.selectedGpu;
        return "ArchiveManifest(schemaVersion=" + i + ", manifestVersion=" + str + ", selectedGpu=" + archiveGpu + ", packages=" + this.packages + ")";
    }

    public ArchiveManifest(int i, String manifestVersion, ArchiveGpu selectedGpu, List<ArchivePackage> packages) {
        Object obj;
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(packages, "packages");
        this.schemaVersion = i;
        this.manifestVersion = manifestVersion;
        this.selectedGpu = selectedGpu;
        this.packages = packages;
        if (i != 2) {
            throw new IllegalArgumentException(("unsupported archive schemaVersion: " + i).toString());
        }
        ArchiveModelRules.INSTANCE.requireManifestVersion(manifestVersion);
        if (packages.isEmpty()) {
            throw new IllegalArgumentException("selected GPU package set must not be empty".toString());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ArchivePackage archivePackage : packages) {
            if (!linkedHashSet.add(archivePackage.getId())) {
                throw new IllegalArgumentException(("duplicate archive package id: " + archivePackage.getId()).toString());
            }
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries != null) {
                for (ArchiveEntryMetadata archiveEntryMetadata : entries) {
                    String targetRelativePath = archiveEntryMetadata.getTargetRelativePath();
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = targetRelativePath.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String str = (String) linkedHashMap.get(lowerCase);
                    if (str != null) {
                        throw new IllegalArgumentException(("entry target " + archiveEntryMetadata.getTargetRelativePath() + " is owned by both " + str + " and " + archivePackage.getId()).toString());
                    }
                    List split$default = StringsKt.split$default((CharSequence) lowerCase, new char[]{'/'}, false, 0, 6, (Object) null);
                    int size = split$default.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(split$default, i2), "/", null, null, 0, null, null, 62, null);
                        if (linkedHashMap.get(joinToString$default) != null) {
                            throw new IllegalArgumentException(("entry target " + archiveEntryMetadata.getTargetRelativePath() + " is below file target " + joinToString$default).toString());
                        }
                    }
                    Iterator it = linkedHashMap.keySet().iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (StringsKt.startsWith$default((String) next, lowerCase + "/", false, 2, (Object) null)) {
                            obj = next;
                            break;
                        }
                    }
                    String str2 = (String) obj;
                    if (str2 != null) {
                        throw new IllegalArgumentException(("entry target " + archiveEntryMetadata.getTargetRelativePath() + " conflicts with descendant " + str2).toString());
                    }
                    linkedHashMap.put(lowerCase, archivePackage.getId());
                }
                continue;
            }
        }
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final ArchiveGpu getSelectedGpu() {
        return this.selectedGpu;
    }

    public final List<ArchivePackage> getPackages() {
        return this.packages;
    }
}
