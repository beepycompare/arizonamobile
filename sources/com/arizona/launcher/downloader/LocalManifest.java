package com.arizona.launcher.downloader;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: LocalManifestRepository.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0004HÖ\u0081\u0004J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001b\u0002\b\u001e¢\u0006\u0002\b\u001dR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eÊ\u0001\u0002\b\"Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006!"}, d2 = {"Lcom/arizona/launcher/downloader/LocalManifest;", "", "files", "", "", "Lcom/arizona/launcher/downloader/FileHashEntry;", "<init>", "(Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFiles", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class LocalManifest {
    private final Map<String, FileHashEntry> files;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.arizona.launcher.downloader.LocalManifest$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = LocalManifest._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public LocalManifest() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, FileHashEntry$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalManifest copy$default(LocalManifest localManifest, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = localManifest.files;
        }
        return localManifest.copy(map);
    }

    public final Map<String, FileHashEntry> component1() {
        return this.files;
    }

    public final LocalManifest copy(Map<String, FileHashEntry> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        return new LocalManifest(files);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalManifest) && Intrinsics.areEqual(this.files, ((LocalManifest) obj).files);
    }

    public int hashCode() {
        return this.files.hashCode();
    }

    public String toString() {
        return "LocalManifest(files=" + this.files + ")";
    }

    /* compiled from: LocalManifestRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/downloader/LocalManifest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arizona/launcher/downloader/LocalManifest;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalManifest> serializer() {
            return LocalManifest$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LocalManifest(int i, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.files = new LinkedHashMap();
        } else {
            this.files = map;
        }
    }

    public LocalManifest(Map<String, FileHashEntry> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.files = files;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(LocalManifest localManifest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && Intrinsics.areEqual(localManifest.files, new LinkedHashMap())) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, lazyArr[0].getValue(), localManifest.files);
    }

    public /* synthetic */ LocalManifest(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final Map<String, FileHashEntry> getFiles() {
        return this.files;
    }
}
