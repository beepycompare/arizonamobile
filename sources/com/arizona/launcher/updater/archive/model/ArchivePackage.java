package com.arizona.launcher.updater.archive.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackage.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eÊ\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0000¨\u0006-"}, d2 = {"Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "", TtmlNode.ATTR_ID, "", "type", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "url", "archiveSize", "", "installedSize", "crc32", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;Ljava/lang/String;JJJLjava/util/List;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/arizona/launcher/updater/archive/model/ArchivePackageType;", "getUrl", "getArchiveSize", "()J", "getInstalledSize", "getCrc32", "getEntries", "()Ljava/util/List;", "identity", "Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "getIdentity", "()Lcom/arizona/launcher/updater/archive/model/ArchivePackageIdentity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackage {
    public static final int $stable = 8;
    private final long archiveSize;
    private final long crc32;
    private final List<ArchiveEntryMetadata> entries;
    private final String id;
    private final ArchivePackageIdentity identity;
    private final long installedSize;
    private final ArchivePackageType type;
    private final String url;

    public static /* synthetic */ ArchivePackage copy$default(ArchivePackage archivePackage, String str, ArchivePackageType archivePackageType, String str2, long j, long j2, long j3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archivePackage.id;
        }
        if ((i & 2) != 0) {
            archivePackageType = archivePackage.type;
        }
        if ((i & 4) != 0) {
            str2 = archivePackage.url;
        }
        if ((i & 8) != 0) {
            j = archivePackage.archiveSize;
        }
        if ((i & 16) != 0) {
            j2 = archivePackage.installedSize;
        }
        if ((i & 32) != 0) {
            j3 = archivePackage.crc32;
        }
        List<ArchiveEntryMetadata> list2 = list;
        if ((i & 64) != 0) {
            list2 = archivePackage.entries;
        }
        List list3 = list2;
        long j4 = j3;
        long j5 = j2;
        String str3 = str2;
        return archivePackage.copy(str, archivePackageType, str3, j, j5, j4, list3);
    }

    public final String component1() {
        return this.id;
    }

    public final ArchivePackageType component2() {
        return this.type;
    }

    public final String component3() {
        return this.url;
    }

    public final long component4() {
        return this.archiveSize;
    }

    public final long component5() {
        return this.installedSize;
    }

    public final long component6() {
        return this.crc32;
    }

    public final List<ArchiveEntryMetadata> component7() {
        return this.entries;
    }

    public final ArchivePackage copy(String id, ArchivePackageType type, String url, long j, long j2, long j3, List<ArchiveEntryMetadata> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ArchivePackage(id, type, url, j, j2, j3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackage) {
            ArchivePackage archivePackage = (ArchivePackage) obj;
            return Intrinsics.areEqual(this.id, archivePackage.id) && this.type == archivePackage.type && Intrinsics.areEqual(this.url, archivePackage.url) && this.archiveSize == archivePackage.archiveSize && this.installedSize == archivePackage.installedSize && this.crc32 == archivePackage.crc32 && Intrinsics.areEqual(this.entries, archivePackage.entries);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.installedSize)) * 31) + Long.hashCode(this.crc32)) * 31;
        List<ArchiveEntryMetadata> list = this.entries;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.id;
        ArchivePackageType archivePackageType = this.type;
        String str2 = this.url;
        long j = this.archiveSize;
        long j2 = this.installedSize;
        long j3 = this.crc32;
        return "ArchivePackage(id=" + str + ", type=" + archivePackageType + ", url=" + str2 + ", archiveSize=" + j + ", installedSize=" + j2 + ", crc32=" + j3 + ", entries=" + this.entries + ")";
    }

    public ArchivePackage(String id, ArchivePackageType type, String url, long j, long j2, long j3, List<ArchiveEntryMetadata> list) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.type = type;
        this.url = url;
        this.archiveSize = j;
        this.installedSize = j2;
        this.crc32 = j3;
        this.entries = list;
        this.identity = new ArchivePackageIdentity(id, j, j3);
        ArchiveModelRules.INSTANCE.requirePackageUrl(url);
        if (j2 <= 0) {
            throw new IllegalArgumentException("installed size must be positive".toString());
        }
        if (list != null && list.isEmpty()) {
            throw new IllegalArgumentException("entries must be omitted or contain at least one item".toString());
        }
    }

    public /* synthetic */ ArchivePackage(String str, ArchivePackageType archivePackageType, String str2, long j, long j2, long j3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, archivePackageType, str2, j, j2, j3, (i & 64) != 0 ? null : list);
    }

    public final String getId() {
        return this.id;
    }

    public final ArchivePackageType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getInstalledSize() {
        return this.installedSize;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final List<ArchiveEntryMetadata> getEntries() {
        return this.entries;
    }

    public final ArchivePackageIdentity getIdentity() {
        return this.identity;
    }
}
