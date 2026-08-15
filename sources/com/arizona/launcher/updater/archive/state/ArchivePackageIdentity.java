package com.arizona.launcher.updater.archive.state;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: ArchiveStateModels.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\nHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001b\u0002\b*¢\u0006\u0002\b)R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0016Ê\u0001\u0002\b.Ê\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0003\u0010\u0002¨\u0006-"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "", "packageId", "", "archiveSize", "", "archiveCrc32", "<init>", "(Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPackageId$annotations", "()V", "getPackageId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getArchiveSize$annotations", "getArchiveSize", "()J", "getArchiveCrc32$annotations", "getArchiveCrc32", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchivePackageIdentity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long archiveCrc32;
    private final long archiveSize;
    private final String packageId;

    public static /* synthetic */ ArchivePackageIdentity copy$default(ArchivePackageIdentity archivePackageIdentity, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archivePackageIdentity.packageId;
        }
        if ((i & 2) != 0) {
            j = archivePackageIdentity.archiveSize;
        }
        if ((i & 4) != 0) {
            j2 = archivePackageIdentity.archiveCrc32;
        }
        return archivePackageIdentity.copy(str, j, j2);
    }

    @SerialName("archiveCrc32")
    public static /* synthetic */ void getArchiveCrc32$annotations() {
    }

    @SerialName("archiveSize")
    public static /* synthetic */ void getArchiveSize$annotations() {
    }

    @SerialName("packageId")
    public static /* synthetic */ void getPackageId$annotations() {
    }

    public final String component1() {
        return this.packageId;
    }

    public final long component2() {
        return this.archiveSize;
    }

    public final long component3() {
        return this.archiveCrc32;
    }

    public final ArchivePackageIdentity copy(String packageId, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        return new ArchivePackageIdentity(packageId, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackageIdentity) {
            ArchivePackageIdentity archivePackageIdentity = (ArchivePackageIdentity) obj;
            return Intrinsics.areEqual(this.packageId, archivePackageIdentity.packageId) && this.archiveSize == archivePackageIdentity.archiveSize && this.archiveCrc32 == archivePackageIdentity.archiveCrc32;
        }
        return false;
    }

    public int hashCode() {
        return (((this.packageId.hashCode() * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.archiveCrc32);
    }

    public String toString() {
        String str = this.packageId;
        long j = this.archiveSize;
        return "ArchivePackageIdentity(packageId=" + str + ", archiveSize=" + j + ", archiveCrc32=" + this.archiveCrc32 + ")";
    }

    /* compiled from: ArchiveStateModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchivePackageIdentity> serializer() {
            return ArchivePackageIdentity$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArchivePackageIdentity(int i, String str, long j, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, ArchivePackageIdentity$$serializer.INSTANCE.getDescriptor());
        }
        this.packageId = str;
        this.archiveSize = j;
        this.archiveCrc32 = j2;
    }

    public ArchivePackageIdentity(String packageId, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        this.packageId = packageId;
        this.archiveSize = j;
        this.archiveCrc32 = j2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ArchivePackageIdentity archivePackageIdentity, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, archivePackageIdentity.packageId);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, archivePackageIdentity.archiveSize);
        compositeEncoder.encodeLongElement(serialDescriptor, 2, archivePackageIdentity.archiveCrc32);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getArchiveCrc32() {
        return this.archiveCrc32;
    }
}
