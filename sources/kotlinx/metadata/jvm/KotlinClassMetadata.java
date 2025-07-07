package kotlinx.metadata.jvm;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassVisitor;
import kotlinx.metadata.KmLambda;
import kotlinx.metadata.KmLambdaVisitor;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmPackageVisitor;
import kotlinx.metadata.internal.ClassWriter;
import kotlinx.metadata.internal.LambdaWriter;
import kotlinx.metadata.internal.PackageWriter;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.jvm.serialization.JvmStringTable;
import kotlinx.metadata.jvm.internal.JvmReadUtils;
import kotlinx.metadata.jvm.internal.JvmWriteUtilsKt;
/* compiled from: KotlinClassMetadata.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00182\u00020\u0001:\u0007\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H&R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0001\u0006\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata;", "", "()V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "getFlags", "()I", "setFlags", "(I)V", "isAllowedToWrite", "", "isAllowedToWrite$kotlinx_metadata_jvm", "()Z", "setAllowedToWrite$kotlinx_metadata_jvm", "(Z)V", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "write", "Lkotlin/Metadata;", "Class", "Companion", "FileFacade", "MultiFileClassFacade", "MultiFileClassPart", "SyntheticClass", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lkotlinx/metadata/jvm/KotlinClassMetadata$Class;", "Lkotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "Lkotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "Lkotlinx/metadata/jvm/KotlinClassMetadata$Unknown;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KotlinClassMetadata {
    public static final int CLASS_KIND = 1;
    public static final int[] COMPATIBLE_METADATA_VERSION;
    public static final Companion Companion = new Companion(null);
    public static final int FILE_FACADE_KIND = 2;
    public static final int MULTI_FILE_CLASS_FACADE_KIND = 4;
    public static final int MULTI_FILE_CLASS_PART_KIND = 5;
    public static final int SYNTHETIC_CLASS_KIND = 3;
    private boolean isAllowedToWrite;

    public /* synthetic */ KotlinClassMetadata(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "read() throws an error if metadata version is too high. Use either readStrict() if you want to retain this behavior, or readLenient() if you want to try to read newer metadata.", replaceWith = @ReplaceWith(expression = "KotlinClassMetadata.readStrict(annotationData)", imports = {}))
    @JvmStatic
    public static final KotlinClassMetadata read(Metadata metadata) {
        return Companion.read(metadata);
    }

    @JvmStatic
    public static final KotlinClassMetadata readLenient(Metadata metadata) {
        return Companion.readLenient(metadata);
    }

    @JvmStatic
    public static final KotlinClassMetadata readStrict(Metadata metadata) {
        return Companion.readStrict(metadata);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
    @JvmStatic
    public static final Metadata writeClass(KmClass kmClass) {
        return Companion.writeClass(kmClass);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
    @JvmStatic
    public static final Metadata writeClass(KmClass kmClass, int[] iArr) {
        return Companion.writeClass(kmClass, iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
    @JvmStatic
    public static final Metadata writeClass(KmClass kmClass, int[] iArr, int i) {
        return Companion.writeClass(kmClass, iArr, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeFileFacade(KmPackage kmPackage) {
        return Companion.writeFileFacade(kmPackage);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeFileFacade(KmPackage kmPackage, int[] iArr) {
        return Companion.writeFileFacade(kmPackage, iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeFileFacade(KmPackage kmPackage, int[] iArr, int i) {
        return Companion.writeFileFacade(kmPackage, iArr, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeLambda(KmLambda kmLambda) {
        return Companion.writeLambda(kmLambda);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeLambda(KmLambda kmLambda, int[] iArr) {
        return Companion.writeLambda(kmLambda, iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeLambda(KmLambda kmLambda, int[] iArr, int i) {
        return Companion.writeLambda(kmLambda, iArr, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassFacade(List<String> list) {
        return Companion.writeMultiFileClassFacade(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassFacade(List<String> list, int[] iArr) {
        return Companion.writeMultiFileClassFacade(list, iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassFacade(List<String> list, int[] iArr, int i) {
        return Companion.writeMultiFileClassFacade(list, iArr, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassPart(KmPackage kmPackage, String str) {
        return Companion.writeMultiFileClassPart(kmPackage, str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassPart(KmPackage kmPackage, String str, int[] iArr) {
        return Companion.writeMultiFileClassPart(kmPackage, str, iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
    @JvmStatic
    public static final Metadata writeMultiFileClassPart(KmPackage kmPackage, String str, int[] iArr, int i) {
        return Companion.writeMultiFileClassPart(kmPackage, str, iArr, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeSyntheticClass() {
        return Companion.writeSyntheticClass();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeSyntheticClass(int[] iArr) {
        return Companion.writeSyntheticClass(iArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
    @JvmStatic
    public static final Metadata writeSyntheticClass(int[] iArr, int i) {
        return Companion.writeSyntheticClass(iArr, i);
    }

    public abstract int getFlags();

    public abstract JvmMetadataVersion getVersion();

    public abstract void setFlags(int i);

    public abstract void setVersion(JvmMetadataVersion jvmMetadataVersion);

    public abstract Metadata write();

    private KotlinClassMetadata() {
        this.isAllowedToWrite = true;
    }

    public final boolean isAllowedToWrite$kotlinx_metadata_jvm() {
        return this.isAllowedToWrite;
    }

    public final void setAllowedToWrite$kotlinx_metadata_jvm(boolean z) {
        this.isAllowedToWrite = z;
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$Class;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", "kmClass", "Lkotlinx/metadata/KmClass;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(Lkotlinx/metadata/KmClass;Lkotlinx/metadata/jvm/JvmMetadataVersion;I)V", "getFlags", "()I", "setFlags", "(I)V", "getKmClass", "()Lkotlinx/metadata/KmClass;", "setKmClass", "(Lkotlinx/metadata/KmClass;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "accept", "", "v", "Lkotlinx/metadata/KmClassVisitor;", "toKmClass", "write", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Class extends KotlinClassMetadata {
        private int flags;
        private KmClass kmClass;
        private JvmMetadataVersion version;

        public final KmClass getKmClass() {
            return this.kmClass;
        }

        public final void setKmClass(KmClass kmClass) {
            Intrinsics.checkNotNullParameter(kmClass, "<set-?>");
            this.kmClass = kmClass;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(KmClass kmClass, JvmMetadataVersion version, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(kmClass, "kmClass");
            Intrinsics.checkNotNullParameter(version, "version");
            this.kmClass = kmClass;
            this.version = version;
            this.flags = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Class(Metadata annotationData, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmClass$kotlinx_metadata_jvm(annotationData), new JvmMetadataVersion(annotationData.mv()), annotationData.xi());
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            setAllowedToWrite$kotlinx_metadata_jvm(!z);
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(isAllowedToWrite$kotlinx_metadata_jvm(), "class");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            boolean z = true;
            try {
                ClassWriter classWriter = new ClassWriter(new JvmStringTable(null, 1, null), null, 2, null);
                classWriter.writeClass(this.kmClass);
                ProtoBuf.Class build = classWriter.getT().build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Pair<String[], String[]> writeProtoBufData = JvmWriteUtilsKt.writeProtoBufData(build, classWriter.getC());
                String[] component2 = writeProtoBufData.component2();
                return JvmMetadataUtil.Metadata$default(1, getVersion().toIntArray(), writeProtoBufData.component1(), component2, null, null, Integer.valueOf(getFlags()), 48, null);
            } finally {
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmClass property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmClass", imports = {}))
        public final KmClass toKmClass() {
            KmClass kmClass = new KmClass();
            this.kmClass.accept(kmClass);
            return kmClass;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
        public final void accept(KmClassVisitor v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.kmClass.accept(v);
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeClass(kmClass, metadataVersion, extraInt)")
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$Class$Writer;", "Lkotlinx/metadata/internal/ClassWriter;", "()V", "write", "Lkotlinx/metadata/jvm/KotlinClassMetadata$Class;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Writer extends ClassWriter {
            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeClass(kmClass, metadataVersion, extraInt)")
            public final Class write() {
                return write$default(this, null, 0, 3, null);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeClass(kmClass, metadataVersion, extraInt)")
            public final Class write(int[] metadataVersion) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                return write$default(this, metadataVersion, 0, 2, null);
            }

            public Writer() {
                super(new JvmStringTable(null, 1, null), null, 2, null);
            }

            public static /* synthetic */ Class write$default(Writer writer, int[] iArr, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
                }
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return writer.write(iArr, i);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeClass(kmClass, metadataVersion, extraInt)")
            public final Class write(int[] metadataVersion, int i) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinClassMetadata.writeClass.".toString());
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", "kmPackage", "Lkotlinx/metadata/KmPackage;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(Lkotlinx/metadata/KmPackage;Lkotlinx/metadata/jvm/JvmMetadataVersion;I)V", "getFlags", "()I", "setFlags", "(I)V", "getKmPackage", "()Lkotlinx/metadata/KmPackage;", "setKmPackage", "(Lkotlinx/metadata/KmPackage;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "accept", "", "v", "Lkotlinx/metadata/KmPackageVisitor;", "toKmPackage", "write", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FileFacade extends KotlinClassMetadata {
        private int flags;
        private KmPackage kmPackage;
        private JvmMetadataVersion version;

        public final KmPackage getKmPackage() {
            return this.kmPackage;
        }

        public final void setKmPackage(KmPackage kmPackage) {
            Intrinsics.checkNotNullParameter(kmPackage, "<set-?>");
            this.kmPackage = kmPackage;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileFacade(KmPackage kmPackage, JvmMetadataVersion version, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(version, "version");
            this.kmPackage = kmPackage;
            this.version = version;
            this.flags = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FileFacade(Metadata annotationData, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmPackage$kotlinx_metadata_jvm(annotationData), new JvmMetadataVersion(annotationData.mv()), annotationData.xi());
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            setAllowedToWrite$kotlinx_metadata_jvm(!z);
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(isAllowedToWrite$kotlinx_metadata_jvm(), "file facade");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            boolean z = true;
            try {
                PackageWriter packageWriter = new PackageWriter(new JvmStringTable(null, 1, null), null, 2, null);
                packageWriter.writePackage(this.kmPackage);
                ProtoBuf.Package build = packageWriter.getT().build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Pair<String[], String[]> writeProtoBufData = JvmWriteUtilsKt.writeProtoBufData(build, packageWriter.getC());
                String[] component2 = writeProtoBufData.component2();
                return JvmMetadataUtil.Metadata$default(2, getVersion().toIntArray(), writeProtoBufData.component1(), component2, null, null, Integer.valueOf(getFlags()), 48, null);
            } finally {
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmPackage property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmPackage", imports = {}))
        public final KmPackage toKmPackage() {
            KmPackage kmPackage = new KmPackage();
            this.kmPackage.accept(kmPackage);
            return kmPackage;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
        public final void accept(KmPackageVisitor v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.kmPackage.accept(v);
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeFileFacade(kmPackage, metadataVersion, extraInt)")
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$FileFacade$Writer;", "Lkotlinx/metadata/internal/PackageWriter;", "()V", "write", "Lkotlinx/metadata/jvm/KotlinClassMetadata$FileFacade;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Writer extends PackageWriter {
            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeFileFacade(kmPackage, metadataVersion, extraInt)")
            public final FileFacade write() {
                return write$default(this, null, 0, 3, null);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeFileFacade(kmPackage, metadataVersion, extraInt)")
            public final FileFacade write(int[] metadataVersion) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                return write$default(this, metadataVersion, 0, 2, null);
            }

            public Writer() {
                super(new JvmStringTable(null, 1, null), null, 2, null);
            }

            public static /* synthetic */ FileFacade write$default(Writer writer, int[] iArr, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
                }
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return writer.write(iArr, i);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeFileFacade(kmPackage, metadataVersion, extraInt)")
            public final FileFacade write(int[] metadataVersion, int i) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinClassMetadata.writeFileFacade.".toString());
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\bH\u0007J\b\u0010!\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", "kmLambda", "Lkotlinx/metadata/KmLambda;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(Lkotlinx/metadata/KmLambda;Lkotlinx/metadata/jvm/JvmMetadataVersion;I)V", "getFlags", "()I", "setFlags", "(I)V", "isLambda", "()Z", "getKmLambda", "()Lkotlinx/metadata/KmLambda;", "setKmLambda", "(Lkotlinx/metadata/KmLambda;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "accept", "", "v", "Lkotlinx/metadata/KmLambdaVisitor;", "toKmLambda", "write", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SyntheticClass extends KotlinClassMetadata {
        private int flags;
        private KmLambda kmLambda;
        private JvmMetadataVersion version;

        public final KmLambda getKmLambda() {
            return this.kmLambda;
        }

        public final void setKmLambda(KmLambda kmLambda) {
            this.kmLambda = kmLambda;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SyntheticClass(KmLambda kmLambda, JvmMetadataVersion version, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(version, "version");
            this.kmLambda = kmLambda;
            this.version = version;
            this.flags = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SyntheticClass(Metadata annotationData, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmLambda$kotlinx_metadata_jvm(annotationData), new JvmMetadataVersion(annotationData.mv()), annotationData.xi());
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            setAllowedToWrite$kotlinx_metadata_jvm(!z);
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            Pair<String[], String[]> pair;
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(isAllowedToWrite$kotlinx_metadata_jvm(), isLambda() ? "lambda" : "synthetic class");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            if (isLambda()) {
                boolean z = true;
                try {
                    LambdaWriter lambdaWriter = new LambdaWriter(new JvmStringTable(null, 1, null));
                    KmLambda kmLambda = this.kmLambda;
                    Intrinsics.checkNotNull(kmLambda);
                    lambdaWriter.writeLambda(kmLambda);
                    ProtoBuf.Function.Builder t = lambdaWriter.getT();
                    ProtoBuf.Function build = t != null ? t.build() : null;
                    if (build != null) {
                        pair = JvmWriteUtilsKt.writeProtoBufData(build, lambdaWriter.getC());
                    } else {
                        pair = new Pair<>(new String[0], new String[0]);
                    }
                    return JvmMetadataUtil.Metadata$default(3, getVersion().toIntArray(), pair.component1(), pair.component2(), null, null, Integer.valueOf(getFlags()), 48, null);
                } finally {
                }
            } else {
                return JvmMetadataUtil.Metadata$default(3, getVersion().toIntArray(), new String[0], new String[0], null, null, Integer.valueOf(getFlags()), 48, null);
            }
        }

        public final boolean isLambda() {
            return this.kmLambda != null;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmLambda property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmLambda", imports = {}))
        public final KmLambda toKmLambda() {
            if (isLambda()) {
                KmLambda kmLambda = new KmLambda();
                accept(kmLambda);
                return kmLambda;
            }
            return null;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
        public final void accept(KmLambdaVisitor v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!isLambda()) {
                throw new IllegalArgumentException("accept(KmLambdaVisitor) is only possible for synthetic classes which are lambdas (isLambda = true)");
            }
            KmLambda kmLambda = this.kmLambda;
            Intrinsics.checkNotNull(kmLambda);
            kmLambda.accept(v);
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion: KotlinClassMetadata.writeLambda(kmLambda, metadataVersion, extraInt) or KotlinClassMetadata.writeSyntheticClass(metadataVersion, extraInt) for a non-lambda synthetic class")
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass$Writer;", "Lkotlinx/metadata/internal/LambdaWriter;", "()V", "write", "Lkotlinx/metadata/jvm/KotlinClassMetadata$SyntheticClass;", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Writer extends LambdaWriter {
            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion: KotlinClassMetadata.writeLambda(kmLambda, metadataVersion, extraInt) or KotlinClassMetadata.writeSyntheticClass(metadataVersion, extraInt) for a non-lambda synthetic class")
            public final SyntheticClass write() {
                return write$default(this, null, 0, 3, null);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion: KotlinClassMetadata.writeLambda(kmLambda, metadataVersion, extraInt) or KotlinClassMetadata.writeSyntheticClass(metadataVersion, extraInt) for a non-lambda synthetic class")
            public final SyntheticClass write(int[] metadataVersion) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                return write$default(this, metadataVersion, 0, 2, null);
            }

            public Writer() {
                super(new JvmStringTable(null, 1, null));
            }

            public static /* synthetic */ SyntheticClass write$default(Writer writer, int[] iArr, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
                }
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return writer.write(iArr, i);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion: KotlinClassMetadata.writeLambda(kmLambda, metadataVersion, extraInt) or KotlinClassMetadata.writeSyntheticClass(metadataVersion, extraInt) for a non-lambda synthetic class")
            public final SyntheticClass write(int[] metadataVersion, int i) {
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinClassMetadata.writeLambda or KotlinClassMetadata.writeSyntheticClass.".toString());
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", "partClassNames", "", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(Ljava/util/List;Lkotlinx/metadata/jvm/JvmMetadataVersion;I)V", "getFlags", "()I", "setFlags", "(I)V", "getPartClassNames", "()Ljava/util/List;", "setPartClassNames", "(Ljava/util/List;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "write", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MultiFileClassFacade extends KotlinClassMetadata {
        private int flags;
        private List<String> partClassNames;
        private JvmMetadataVersion version;

        public final List<String> getPartClassNames() {
            return this.partClassNames;
        }

        public final void setPartClassNames(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.partClassNames = list;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiFileClassFacade(List<String> partClassNames, JvmMetadataVersion version, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
            Intrinsics.checkNotNullParameter(version, "version");
            this.partClassNames = partClassNames;
            this.version = version;
            this.flags = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MultiFileClassFacade(Metadata annotationData, boolean z) {
            this(ArraysKt.asList(annotationData.d1()), new JvmMetadataVersion(annotationData.mv()), annotationData.xi());
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            setAllowedToWrite$kotlinx_metadata_jvm(!z);
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(isAllowedToWrite$kotlinx_metadata_jvm(), "multi-file class facade");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            return JvmMetadataUtil.Metadata$default(4, getVersion().toIntArray(), (String[]) this.partClassNames.toArray(new String[0]), null, null, null, Integer.valueOf(getFlags()), 56, null);
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassFacade(partClassNames, metadataVersion, extraInt)")
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade$Writer;", "", "()V", "write", "Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassFacade;", "partClassNames", "", "", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Writer {
            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassFacade(partClassNames, metadataVersion, extraInt)")
            public final MultiFileClassFacade write(List<String> partClassNames) {
                Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
                return write$default(this, partClassNames, null, 0, 6, null);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassFacade(partClassNames, metadataVersion, extraInt)")
            public final MultiFileClassFacade write(List<String> partClassNames, int[] metadataVersion) {
                Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                return write$default(this, partClassNames, metadataVersion, 0, 4, null);
            }

            public static /* synthetic */ MultiFileClassFacade write$default(Writer writer, List list, int[] iArr, int i, int i2, Object obj) {
                if ((i2 & 2) != 0) {
                    iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
                }
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return writer.write(list, iArr, i);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassFacade(partClassNames, metadataVersion, extraInt)")
            public final MultiFileClassFacade write(List<String> partClassNames, int[] metadataVersion, int i) {
                Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinClassMetadata.writeMultiFileClassFacade.".toString());
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001&B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\u0003H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", "kmPackage", "Lkotlinx/metadata/KmPackage;", "facadeClassName", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(Lkotlinx/metadata/KmPackage;Ljava/lang/String;Lkotlinx/metadata/jvm/JvmMetadataVersion;I)V", "getFacadeClassName", "()Ljava/lang/String;", "setFacadeClassName", "(Ljava/lang/String;)V", "getFlags", "()I", "setFlags", "(I)V", "getKmPackage", "()Lkotlinx/metadata/KmPackage;", "setKmPackage", "(Lkotlinx/metadata/KmPackage;)V", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "accept", "", "v", "Lkotlinx/metadata/KmPackageVisitor;", "toKmPackage", "write", "Writer", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MultiFileClassPart extends KotlinClassMetadata {
        private String facadeClassName;
        private int flags;
        private KmPackage kmPackage;
        private JvmMetadataVersion version;

        public final KmPackage getKmPackage() {
            return this.kmPackage;
        }

        public final void setKmPackage(KmPackage kmPackage) {
            Intrinsics.checkNotNullParameter(kmPackage, "<set-?>");
            this.kmPackage = kmPackage;
        }

        public final String getFacadeClassName() {
            return this.facadeClassName;
        }

        public final void setFacadeClassName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.facadeClassName = str;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiFileClassPart(KmPackage kmPackage, String facadeClassName, JvmMetadataVersion version, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
            Intrinsics.checkNotNullParameter(version, "version");
            this.kmPackage = kmPackage;
            this.facadeClassName = facadeClassName;
            this.version = version;
            this.flags = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MultiFileClassPart(Metadata annotationData, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmPackage$kotlinx_metadata_jvm(annotationData), annotationData.xs(), new JvmMetadataVersion(annotationData.mv()), annotationData.xi());
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            setAllowedToWrite$kotlinx_metadata_jvm(!z);
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(isAllowedToWrite$kotlinx_metadata_jvm(), "multi-file class part");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            boolean z = true;
            try {
                PackageWriter packageWriter = new PackageWriter(new JvmStringTable(null, 1, null), null, 2, null);
                packageWriter.writePackage(this.kmPackage);
                ProtoBuf.Package build = packageWriter.getT().build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                Pair<String[], String[]> writeProtoBufData = JvmWriteUtilsKt.writeProtoBufData(build, packageWriter.getC());
                String[] component2 = writeProtoBufData.component2();
                return JvmMetadataUtil.Metadata$default(5, getVersion().toIntArray(), writeProtoBufData.component1(), component2, this.facadeClassName, null, Integer.valueOf(getFlags()), 32, null);
            } finally {
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "To avoid excessive copying, use .kmPackage property instead. Note that it returns a view and not a copy.", replaceWith = @ReplaceWith(expression = "kmPackage", imports = {}))
        public final KmPackage toKmPackage() {
            KmPackage kmPackage = new KmPackage();
            this.kmPackage.accept(kmPackage);
            return kmPackage;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
        public final void accept(KmPackageVisitor v) {
            Intrinsics.checkNotNullParameter(v, "v");
            this.kmPackage.accept(v);
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassPart(kmPackage, facadeClassName, metadataVersion, extraInt)")
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart$Writer;", "Lkotlinx/metadata/internal/PackageWriter;", "()V", "write", "Lkotlinx/metadata/jvm/KotlinClassMetadata$MultiFileClassPart;", "facadeClassName", "", "metadataVersion", "", "extraInt", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Writer extends PackageWriter {
            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassPart(kmPackage, facadeClassName, metadataVersion, extraInt)")
            public final MultiFileClassPart write(String facadeClassName) {
                Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
                return write$default(this, facadeClassName, null, 0, 6, null);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassPart(kmPackage, facadeClassName, metadataVersion, extraInt)")
            public final MultiFileClassPart write(String facadeClassName, int[] metadataVersion) {
                Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                return write$default(this, facadeClassName, metadataVersion, 0, 4, null);
            }

            public Writer() {
                super(new JvmStringTable(null, 1, null), null, 2, null);
            }

            public static /* synthetic */ MultiFileClassPart write$default(Writer writer, String str, int[] iArr, int i, int i2, Object obj) {
                if ((i2 & 2) != 0) {
                    iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
                }
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                return writer.write(str, iArr, i);
            }

            @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor Writer API is deprecated as excessive and cumbersome. Please use member functions of KotlinClassMetadata.Companion, such as KotlinClassMetadata.writeMultiFileClassPart(kmPackage, facadeClassName, metadataVersion, extraInt)")
            public final MultiFileClassPart write(String facadeClassName, int[] metadataVersion, int i) {
                Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
                Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
                throw new IllegalStateException("This method is no longer implemented. Migrate to KotlinClassMetadata.writeMultifileClassPart.".toString());
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$Unknown;", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "original", "Lkotlin/Metadata;", "lenient", "", "(Lkotlin/Metadata;Z)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "getFlags", "()I", "setFlags", "(I)V", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "getVersion", "()Lkotlinx/metadata/jvm/JvmMetadataVersion;", "setVersion", "(Lkotlinx/metadata/jvm/JvmMetadataVersion;)V", "write", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Unknown extends KotlinClassMetadata {
        public static final Companion Companion = new Companion(null);
        public static final Unknown INSTANCE = new Unknown(JvmMetadataUtil.Metadata$default(99, JvmMetadataVersion.LATEST_STABLE_SUPPORTED.toIntArray(), null, null, null, null, null, 124, null), true);
        private int flags;
        private final boolean lenient;
        private final Metadata original;
        private JvmMetadataVersion version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unknown(Metadata original, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(original, "original");
            this.original = original;
            this.lenient = z;
            this.version = new JvmMetadataVersion(original.mv());
            this.flags = original.xi();
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public JvmMetadataVersion getVersion() {
            return this.version;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setVersion(JvmMetadataVersion jvmMetadataVersion) {
            Intrinsics.checkNotNullParameter(jvmMetadataVersion, "<set-?>");
            this.version = jvmMetadataVersion;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public int getFlags() {
            return this.flags;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public void setFlags(int i) {
            this.flags = i;
        }

        @Override // kotlinx.metadata.jvm.KotlinClassMetadata
        public Metadata write() {
            KotlinClassMetadata.Companion.throwIfNotWriteable$kotlinx_metadata_jvm(!this.lenient, "unknown kind");
            KotlinClassMetadata.Companion.checkMetadataVersionForWrite(getVersion());
            return JvmMetadataUtil.Metadata(Integer.valueOf(this.original.k()), getVersion().toIntArray(), this.original.d1(), this.original.d2(), this.original.xs(), this.original.pn(), Integer.valueOf(getFlags()));
        }

        /* compiled from: KotlinClassMetadata.kt */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This declaration is intended for binary compatibility only")
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$Unknown$Companion;", "", "()V", "INSTANCE", "Lkotlinx/metadata/jvm/KotlinClassMetadata$Unknown;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: KotlinClassMetadata.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001d\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\"\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u001fJ$\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J$\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J$\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J*\u0010+\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0-2\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J,\u0010.\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007J\u001c\u00100\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lkotlinx/metadata/jvm/KotlinClassMetadata$Companion;", "", "()V", "CLASS_KIND", "", "COMPATIBLE_METADATA_VERSION", "", "getCOMPATIBLE_METADATA_VERSION$annotations", "FILE_FACADE_KIND", "MULTI_FILE_CLASS_FACADE_KIND", "MULTI_FILE_CLASS_PART_KIND", "SYNTHETIC_CLASS_KIND", "checkMetadataVersionForWrite", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/jvm/JvmMetadataVersion;", "read", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "annotationData", "Lkotlin/Metadata;", "readLenient", "readStrict", "throwIfNotWriteable", "writeable", "", "name", "", "throwIfNotWriteable$kotlinx_metadata_jvm", "transform", TtmlNode.TAG_METADATA, "transformer", "Lkotlin/Function1;", "writeClass", "kmClass", "Lkotlinx/metadata/KmClass;", "metadataVersion", "extraInt", "writeFileFacade", "kmPackage", "Lkotlinx/metadata/KmPackage;", "writeLambda", "kmLambda", "Lkotlinx/metadata/KmLambda;", "writeMultiFileClassFacade", "partClassNames", "", "writeMultiFileClassPart", "facadeClassName", "writeSyntheticClass", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use JvmMetadataVersion.LATEST_STABLE_SUPPORTED instead", replaceWith = @ReplaceWith(expression = "JvmMetadataVersion.LATEST_STABLE_SUPPORTED", imports = {}))
        public static /* synthetic */ void getCOMPATIBLE_METADATA_VERSION$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
        @JvmStatic
        public final Metadata writeClass(KmClass kmClass) {
            Intrinsics.checkNotNullParameter(kmClass, "kmClass");
            return writeClass$default(this, kmClass, null, 0, 6, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
        @JvmStatic
        public final Metadata writeClass(KmClass kmClass, int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(kmClass, "kmClass");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeClass$default(this, kmClass, metadataVersion, 0, 4, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeFileFacade(KmPackage kmPackage) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            return writeFileFacade$default(this, kmPackage, null, 0, 6, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeFileFacade(KmPackage kmPackage, int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeFileFacade$default(this, kmPackage, metadataVersion, 0, 4, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeLambda(KmLambda kmLambda) {
            Intrinsics.checkNotNullParameter(kmLambda, "kmLambda");
            return writeLambda$default(this, kmLambda, null, 0, 6, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeLambda(KmLambda kmLambda, int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(kmLambda, "kmLambda");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeLambda$default(this, kmLambda, metadataVersion, 0, 4, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassFacade(List<String> partClassNames) {
            Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
            return writeMultiFileClassFacade$default(this, partClassNames, null, 0, 6, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassFacade(List<String> partClassNames, int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeMultiFileClassFacade$default(this, partClassNames, metadataVersion, 0, 4, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassPart(KmPackage kmPackage, String facadeClassName) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
            return writeMultiFileClassPart$default(this, kmPackage, facadeClassName, null, 0, 12, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassPart(KmPackage kmPackage, String facadeClassName, int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeMultiFileClassPart$default(this, kmPackage, facadeClassName, metadataVersion, 0, 8, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeSyntheticClass() {
            return writeSyntheticClass$default(this, null, 0, 3, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeSyntheticClass(int[] metadataVersion) {
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return writeSyntheticClass$default(this, metadataVersion, 0, 2, null);
        }

        private Companion() {
        }

        public final Metadata transform(Metadata metadata, Function1<? super KotlinClassMetadata, Unit> transformer) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            Intrinsics.checkNotNullParameter(transformer, "transformer");
            KotlinClassMetadata readStrict = readStrict(metadata);
            transformer.invoke(readStrict);
            return readStrict.write();
        }

        public static /* synthetic */ Metadata writeClass$default(Companion companion, KmClass kmClass, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.writeClass(kmClass, iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.Class instance and its write() member function")
        @JvmStatic
        public final Metadata writeClass(KmClass kmClass, int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(kmClass, "kmClass");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new Class(kmClass, new JvmMetadataVersion(metadataVersion), i).write();
        }

        public static /* synthetic */ Metadata writeFileFacade$default(Companion companion, KmPackage kmPackage, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.writeFileFacade(kmPackage, iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.FileFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeFileFacade(KmPackage kmPackage, int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new FileFacade(kmPackage, new JvmMetadataVersion(metadataVersion), i).write();
        }

        public static /* synthetic */ Metadata writeLambda$default(Companion companion, KmLambda kmLambda, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.writeLambda(kmLambda, iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeLambda(KmLambda kmLambda, int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(kmLambda, "kmLambda");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new SyntheticClass(kmLambda, new JvmMetadataVersion(metadataVersion), i).write();
        }

        public static /* synthetic */ Metadata writeSyntheticClass$default(Companion companion, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.writeSyntheticClass(iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.SyntheticClass instance and its write() member function")
        @JvmStatic
        public final Metadata writeSyntheticClass(int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new SyntheticClass(null, new JvmMetadataVersion(metadataVersion), i).write();
        }

        public static /* synthetic */ Metadata writeMultiFileClassFacade$default(Companion companion, List list, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.writeMultiFileClassFacade(list, iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassFacade instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassFacade(List<String> partClassNames, int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(partClassNames, "partClassNames");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new MultiFileClassFacade(partClassNames, new JvmMetadataVersion(metadataVersion), i).write();
        }

        public static /* synthetic */ Metadata writeMultiFileClassPart$default(Companion companion, KmPackage kmPackage, String str, int[] iArr, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                iArr = KotlinClassMetadata.COMPATIBLE_METADATA_VERSION;
            }
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return companion.writeMultiFileClassPart(kmPackage, str, iArr, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use a KotlinClassMetadata.MultiFileClassPart instance and its write() member function")
        @JvmStatic
        public final Metadata writeMultiFileClassPart(KmPackage kmPackage, String facadeClassName, int[] metadataVersion, int i) {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(facadeClassName, "facadeClassName");
            Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            return new MultiFileClassPart(kmPackage, facadeClassName, new JvmMetadataVersion(metadataVersion), i).write();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "read() throws an error if metadata version is too high. Use either readStrict() if you want to retain this behavior, or readLenient() if you want to try to read newer metadata.", replaceWith = @ReplaceWith(expression = "KotlinClassMetadata.readStrict(annotationData)", imports = {}))
        @JvmStatic
        public final KotlinClassMetadata read(Metadata annotationData) {
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            return JvmReadUtils.INSTANCE.readMetadataImpl$kotlinx_metadata_jvm(annotationData, false);
        }

        @JvmStatic
        public final KotlinClassMetadata readStrict(Metadata annotationData) {
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            return JvmReadUtils.INSTANCE.readMetadataImpl$kotlinx_metadata_jvm(annotationData, false);
        }

        @JvmStatic
        public final KotlinClassMetadata readLenient(Metadata annotationData) {
            Intrinsics.checkNotNullParameter(annotationData, "annotationData");
            return JvmReadUtils.INSTANCE.readMetadataImpl$kotlinx_metadata_jvm(annotationData, true);
        }

        public final void throwIfNotWriteable$kotlinx_metadata_jvm(boolean z, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (!z) {
                throw new IllegalArgumentException("This " + name + " cannot be written because it represents metadata read in lenient mode");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkMetadataVersionForWrite(JvmMetadataVersion jvmMetadataVersion) {
            if (jvmMetadataVersion.getMajor() < 1 || (jvmMetadataVersion.getMajor() <= 1 && jvmMetadataVersion.getMinor() < 4)) {
                throw new IllegalArgumentException(("This version of kotlinx-metadata-jvm doesn't support writing Kotlin metadata of version earlier than 1.4. Please change the version from " + jvmMetadataVersion + " to at least [1, 4].").toString());
            }
            if (jvmMetadataVersion.compareTo(JvmMetadataVersion.HIGHEST_ALLOWED_TO_WRITE) > 0) {
                throw new IllegalArgumentException(("kotlinx-metadata-jvm cannot write metadata for future compiler versions. Requested to write version " + jvmMetadataVersion + ", but highest known version is " + JvmMetadataVersion.HIGHEST_ALLOWED_TO_WRITE).toString());
            }
        }
    }

    static {
        int[] array = kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion.INSTANCE.toArray();
        int[] copyOf = Arrays.copyOf(array, array.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        COMPATIBLE_METADATA_VERSION = copyOf;
    }
}
