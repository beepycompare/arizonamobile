package com.arizona.launcher.downloader;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: LocalManifestRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J0\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0014¨\u0006,"}, d2 = {"Lcom/arizona/launcher/downloader/FileHashEntry;", "", "md5", "", "size", "", "lastModified", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/String;", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastModified$annotations", "getLastModified", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/arizona/launcher/downloader/FileHashEntry;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_arizonaRelease", "$serializer", "Companion", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class FileHashEntry {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Long lastModified;
    private final String md5;
    private final Long size;

    public static /* synthetic */ FileHashEntry copy$default(FileHashEntry fileHashEntry, String str, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileHashEntry.md5;
        }
        if ((i & 2) != 0) {
            l = fileHashEntry.size;
        }
        if ((i & 4) != 0) {
            l2 = fileHashEntry.lastModified;
        }
        return fileHashEntry.copy(str, l, l2);
    }

    @SerialName("lastModified")
    public static /* synthetic */ void getLastModified$annotations() {
    }

    @SerialName("md5")
    public static /* synthetic */ void getMd5$annotations() {
    }

    @SerialName("size")
    public static /* synthetic */ void getSize$annotations() {
    }

    public final String component1() {
        return this.md5;
    }

    public final Long component2() {
        return this.size;
    }

    public final Long component3() {
        return this.lastModified;
    }

    public final FileHashEntry copy(String md5, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new FileHashEntry(md5, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileHashEntry) {
            FileHashEntry fileHashEntry = (FileHashEntry) obj;
            return Intrinsics.areEqual(this.md5, fileHashEntry.md5) && Intrinsics.areEqual(this.size, fileHashEntry.size) && Intrinsics.areEqual(this.lastModified, fileHashEntry.lastModified);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.md5.hashCode() * 31;
        Long l = this.size;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.lastModified;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        String str = this.md5;
        Long l = this.size;
        return "FileHashEntry(md5=" + str + ", size=" + l + ", lastModified=" + this.lastModified + ")";
    }

    /* compiled from: LocalManifestRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/downloader/FileHashEntry$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/downloader/FileHashEntry;", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FileHashEntry> serializer() {
            return FileHashEntry$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FileHashEntry(int i, String str, Long l, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, FileHashEntry$$serializer.INSTANCE.getDescriptor());
        }
        this.md5 = str;
        if ((i & 2) == 0) {
            this.size = null;
        } else {
            this.size = l;
        }
        if ((i & 4) == 0) {
            this.lastModified = null;
        } else {
            this.lastModified = l2;
        }
    }

    public FileHashEntry(String md5, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.md5 = md5;
        this.size = l;
        this.lastModified = l2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_arizonaRelease(FileHashEntry fileHashEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, fileHashEntry.md5);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || fileHashEntry.size != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, fileHashEntry.size);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && fileHashEntry.lastModified == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, fileHashEntry.lastModified);
    }

    public /* synthetic */ FileHashEntry(String str, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }

    public final String getMd5() {
        return this.md5;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Long getLastModified() {
        return this.lastModified;
    }
}
