package kotlinx.metadata.jvm;

import com.facebook.internal.NativeProtocol;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import kotlinx.metadata.internal.metadata.jvm.deserialization.ModuleMapping;
import kotlinx.metadata.internal.metadata.jvm.deserialization.ModuleMappingKt;
import kotlinx.metadata.internal.metadata.jvm.deserialization.PackageParts;
import kotlinx.metadata.jvm.internal.JvmReadUtils;
/* compiled from: KotlinModuleMetadata.kt */
@UnstableMetadataApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0003H\u0007J\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lkotlinx/metadata/jvm/KotlinModuleMetadata;", "", "kmModule", "Lkotlinx/metadata/jvm/KmModule;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "(Lkotlinx/metadata/jvm/KmModule;Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "getKmModule", "()Lkotlinx/metadata/jvm/KmModule;", "setKmModule", "(Lkotlinx/metadata/jvm/KmModule;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "accept", "", "v", "Lkotlinx/metadata/jvm/KmModuleVisitor;", "toKmModule", "write", "", "Companion", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinModuleMetadata {
    public static final Companion Companion = new Companion(null);
    private KmModule kmModule;
    private JvmMetadataVersion version;

    @JvmStatic
    @UnstableMetadataApi
    public static final KotlinModuleMetadata read(byte[] bArr) {
        return Companion.read(bArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinModuleMetadata instance and its write() member function")
    @JvmStatic
    @UnstableMetadataApi
    public static final byte[] write(KmModule kmModule) {
        return Companion.write(kmModule);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinModuleMetadata instance and its write() member function")
    @JvmStatic
    @UnstableMetadataApi
    public static final byte[] write(KmModule kmModule, JvmMetadataVersion jvmMetadataVersion) {
        return Companion.write(kmModule, jvmMetadataVersion);
    }

    public KotlinModuleMetadata(KmModule kmModule, JvmMetadataVersion version) {
        Intrinsics.checkNotNullParameter(kmModule, "kmModule");
        Intrinsics.checkNotNullParameter(version, "version");
        this.kmModule = kmModule;
        this.version = version;
    }

    public final KmModule getKmModule() {
        return this.kmModule;
    }

    public final void setKmModule(KmModule kmModule) {
        Intrinsics.checkNotNullParameter(kmModule, "<set-?>");
        this.kmModule = kmModule;
    }

    public final JvmMetadataVersion getVersion() {
        return this.version;
    }

    public final void setVersion(JvmMetadataVersion jvmMetadataVersion) {
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
        this.version = jvmMetadataVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmModule property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmModule", imports = {}))
    public final KmModule toKmModule() {
        KmModule kmModule = new KmModule();
        this.kmModule.accept(kmModule);
        return kmModule;
    }

    public final byte[] write() {
        JvmModuleProtoBuf.Module.Builder newBuilder = JvmModuleProtoBuf.Module.newBuilder();
        for (Map.Entry<String, KmPackageParts> entry : this.kmModule.getPackageParts().entrySet()) {
            KmPackageParts value = entry.getValue();
            PackageParts packageParts = new PackageParts(entry.getKey());
            for (String str : value.getFileFacades()) {
                packageParts.addPart(str, null);
            }
            for (Map.Entry<String, String> entry2 : value.getMultiFileClassParts().entrySet()) {
                packageParts.addPart(entry2.getKey(), entry2.getValue());
            }
            Intrinsics.checkNotNull(newBuilder);
            packageParts.addTo(newBuilder);
        }
        JvmModuleProtoBuf.Module build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return ModuleMappingKt.serializeToByteArray(build, new kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion(this.version.toIntArray(), false), 0);
    }

    /* compiled from: KotlinModuleMetadata.kt */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Writer API is deprecated as excessive and cumbersome. Please use KotlinModuleMetadata.write(kmModule, metadataVersion)")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lkotlinx/metadata/jvm/KotlinModuleMetadata$Writer;", "", "()V", "write", "", "metadataVersion", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Writer {
        public static /* synthetic */ byte[] write$default(Writer writer, int[] iArr, int i, Object obj) {
            if ((i & 1) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            return writer.write(iArr);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Writer API is deprecated as excessive and cumbersome. Please use KotlinModuleMetadata.write(kmModule, metadataVersion)")
        public final byte[] write(int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinModuleMetadata.write.".toString());
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmModuleVisitor v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.kmModule.accept(v);
    }

    /* compiled from: KotlinModuleMetadata.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkotlinx/metadata/jvm/KotlinModuleMetadata$Companion;", "", "()V", "read", "Lkotlinx/metadata/jvm/KotlinModuleMetadata;", "bytes", "", "write", "kmModule", "Lkotlinx/metadata/jvm/KmModule;", "metadataVersion", "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinModuleMetadata instance and its write() member function")
        @JvmStatic
        @UnstableMetadataApi
        public final byte[] write(KmModule kmModule) {
            Intrinsics.checkNotNullParameter(kmModule, "kmModule");
            return write$default(this, kmModule, null, 2, null);
        }

        private Companion() {
        }

        @JvmStatic
        @UnstableMetadataApi
        public final KotlinModuleMetadata read(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            boolean z = true;
            try {
                ModuleMapping loadModuleMapping$default = ModuleMapping.Companion.loadModuleMapping$default(ModuleMapping.Companion, bytes, "KotlinModuleMetadata", false, true, null, new Function1<kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion, Unit>() { // from class: kotlinx.metadata.jvm.KotlinModuleMetadata$Companion$read$1$result$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion jvmMetadataVersion) {
                        invoke2(jvmMetadataVersion);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        JvmReadUtils.INSTANCE.throwIfNotCompatible$kotlinx_metadata_jvm(it, false);
                    }
                }, 16, null);
                if (Intrinsics.areEqual(loadModuleMapping$default, ModuleMapping.EMPTY) ? true : Intrinsics.areEqual(loadModuleMapping$default, ModuleMapping.CORRUPTED)) {
                    throw new IllegalArgumentException("Data is not the content of a .kotlin_module file, or it has been corrupted.");
                }
                return new KotlinModuleMetadata(JvmReadUtils.INSTANCE.readModuleMetadataImpl$kotlinx_metadata_jvm(loadModuleMapping$default), new JvmMetadataVersion(loadModuleMapping$default.getVersion().toArray()));
            } finally {
            }
        }

        public static /* synthetic */ byte[] write$default(Companion companion, KmModule kmModule, JvmMetadataVersion jvmMetadataVersion, int i, Object obj) {
            if ((i & 2) != 0) {
                jvmMetadataVersion = JvmMetadataVersion.LATEST_STABLE_SUPPORTED;
            }
            return companion.write(kmModule, jvmMetadataVersion);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinModuleMetadata instance and its write() member function")
        @JvmStatic
        @UnstableMetadataApi
        public final byte[] write(KmModule kmModule, JvmMetadataVersion metadataVersion) {
            Intrinsics.checkNotNullParameter(kmModule, "kmModule");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            try {
                return new KotlinModuleMetadata(kmModule, metadataVersion).write();
            } finally {
            }
        }
    }
}
