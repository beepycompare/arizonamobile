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
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: ArchivePackageFileRecord.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001b\u0002\b.¢\u0006\u0002\b-R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0017R,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012Ê\u0001\u0002\b2Ê\u0001\f\b3\u0012\b\b4\u0012\u0004\b\u0003\u0010\u0002¨\u00061"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "", "relativePath", "", "size", "", "crc32", "md5", "<init>", "(Ljava/lang/String;JJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRelativePath$annotations", "()V", "getRelativePath", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "getSize$annotations", "getSize", "()J", "getCrc32$annotations", "getCrc32", "getMd5$annotations", "getMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class ArchivePackageFileRecord {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long crc32;
    private final String md5;
    private final String relativePath;
    private final long size;

    public static /* synthetic */ ArchivePackageFileRecord copy$default(ArchivePackageFileRecord archivePackageFileRecord, String str, long j, long j2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archivePackageFileRecord.relativePath;
        }
        if ((i & 2) != 0) {
            j = archivePackageFileRecord.size;
        }
        if ((i & 4) != 0) {
            j2 = archivePackageFileRecord.crc32;
        }
        if ((i & 8) != 0) {
            str2 = archivePackageFileRecord.md5;
        }
        String str3 = str2;
        return archivePackageFileRecord.copy(str, j, j2, str3);
    }

    @SerialName("crc32")
    public static /* synthetic */ void getCrc32$annotations() {
    }

    @SerialName("md5")
    public static /* synthetic */ void getMd5$annotations() {
    }

    @SerialName("relativePath")
    public static /* synthetic */ void getRelativePath$annotations() {
    }

    @SerialName("size")
    public static /* synthetic */ void getSize$annotations() {
    }

    public final String component1() {
        return this.relativePath;
    }

    public final long component2() {
        return this.size;
    }

    public final long component3() {
        return this.crc32;
    }

    public final String component4() {
        return this.md5;
    }

    public final ArchivePackageFileRecord copy(String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new ArchivePackageFileRecord(relativePath, j, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchivePackageFileRecord) {
            ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) obj;
            return Intrinsics.areEqual(this.relativePath, archivePackageFileRecord.relativePath) && this.size == archivePackageFileRecord.size && this.crc32 == archivePackageFileRecord.crc32 && Intrinsics.areEqual(this.md5, archivePackageFileRecord.md5);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.relativePath.hashCode() * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32)) * 31;
        String str = this.md5;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.relativePath;
        long j = this.size;
        long j2 = this.crc32;
        return "ArchivePackageFileRecord(relativePath=" + str + ", size=" + j + ", crc32=" + j2 + ", md5=" + this.md5 + ")";
    }

    /* compiled from: ArchivePackageFileRecord.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchivePackageFileRecord> serializer() {
            return ArchivePackageFileRecord$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ArchivePackageFileRecord(int i, String str, long j, long j2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, ArchivePackageFileRecord$$serializer.INSTANCE.getDescriptor());
        }
        this.relativePath = str;
        this.size = j;
        this.crc32 = j2;
        if ((i & 8) == 0) {
            this.md5 = null;
        } else {
            this.md5 = str2;
        }
    }

    public ArchivePackageFileRecord(String relativePath, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        this.relativePath = relativePath;
        this.size = j;
        this.crc32 = j2;
        this.md5 = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ArchivePackageFileRecord archivePackageFileRecord, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, archivePackageFileRecord.relativePath);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, archivePackageFileRecord.size);
        compositeEncoder.encodeLongElement(serialDescriptor, 2, archivePackageFileRecord.crc32);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && archivePackageFileRecord.md5 == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, archivePackageFileRecord.md5);
    }

    public /* synthetic */ ArchivePackageFileRecord(String str, long j, long j2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, (i & 8) != 0 ? null : str2);
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final String getMd5() {
        return this.md5;
    }
}
