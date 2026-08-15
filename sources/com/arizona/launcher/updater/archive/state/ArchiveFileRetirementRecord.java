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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001b\u0002\b$¢\u0006\u0002\b#R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\u0002\b(Ê\u0001\f\b)\u0012\b\b*\u0012\u0004\b\u0003\u0010\u0002¨\u0006'"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveFileRetirementRecord;", "", "packageId", "", "relativePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPackageId$annotations", "()V", "getPackageId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getRelativePath$annotations", "getRelativePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchiveFileRetirementRecord {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String packageId;
    private final String relativePath;

    public static /* synthetic */ ArchiveFileRetirementRecord copy$default(ArchiveFileRetirementRecord archiveFileRetirementRecord, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveFileRetirementRecord.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveFileRetirementRecord.relativePath;
        }
        return archiveFileRetirementRecord.copy(str, str2);
    }

    @SerialName("packageId")
    public static /* synthetic */ void getPackageId$annotations() {
    }

    @SerialName("relativePath")
    public static /* synthetic */ void getRelativePath$annotations() {
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final ArchiveFileRetirementRecord copy(String packageId, String relativePath) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new ArchiveFileRetirementRecord(packageId, relativePath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveFileRetirementRecord) {
            ArchiveFileRetirementRecord archiveFileRetirementRecord = (ArchiveFileRetirementRecord) obj;
            return Intrinsics.areEqual(this.packageId, archiveFileRetirementRecord.packageId) && Intrinsics.areEqual(this.relativePath, archiveFileRetirementRecord.relativePath);
        }
        return false;
    }

    public int hashCode() {
        return (this.packageId.hashCode() * 31) + this.relativePath.hashCode();
    }

    public String toString() {
        String str = this.packageId;
        return "ArchiveFileRetirementRecord(packageId=" + str + ", relativePath=" + this.relativePath + ")";
    }

    /* compiled from: ArchiveStateModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchiveFileRetirementRecord$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchiveFileRetirementRecord;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchiveFileRetirementRecord> serializer() {
            return ArchiveFileRetirementRecord$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArchiveFileRetirementRecord(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ArchiveFileRetirementRecord$$serializer.INSTANCE.getDescriptor());
        }
        this.packageId = str;
        this.relativePath = str2;
    }

    public ArchiveFileRetirementRecord(String packageId, String relativePath) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        this.packageId = packageId;
        this.relativePath = relativePath;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ArchiveFileRetirementRecord archiveFileRetirementRecord, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, archiveFileRetirementRecord.packageId);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, archiveFileRetirementRecord.relativePath);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }
}
