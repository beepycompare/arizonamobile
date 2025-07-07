package kotlinx.metadata.internal.metadata.jvm.deserialization;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.NameResolverImpl;
import kotlinx.metadata.internal.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import kotlinx.metadata.internal.protobuf.ProtocolStringList;
/* compiled from: ModuleMapping.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "packageFqName2Parts", "", "", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/PackageParts;", "moduleData", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "debugName", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMetadataVersion;Ljava/util/Map;Lorg/jetbrains/kotlin/metadata/jvm/deserialization/BinaryModuleData;Ljava/lang/String;)V", "getVersion", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMetadataVersion;", "getPackageFqName2Parts", "()Ljava/util/Map;", "getModuleData", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/BinaryModuleData;", "findPackageParts", "packageFqName", "toString", "Companion", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class ModuleMapping {
    public static final ModuleMapping CORRUPTED;
    public static final Companion Companion;
    public static final ModuleMapping EMPTY;
    public static final String MAPPING_FILE_EXT = "kotlin_module";
    public static final int STRICT_METADATA_VERSION_SEMANTICS_FLAG = 1;
    private final String debugName;
    private final BinaryModuleData moduleData;
    private final Map<String, PackageParts> packageFqName2Parts;
    private final JvmMetadataVersion version;

    public /* synthetic */ ModuleMapping(JvmMetadataVersion jvmMetadataVersion, Map map, BinaryModuleData binaryModuleData, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(jvmMetadataVersion, map, binaryModuleData, str);
    }

    private ModuleMapping(JvmMetadataVersion jvmMetadataVersion, Map<String, PackageParts> map, BinaryModuleData binaryModuleData, String str) {
        this.version = jvmMetadataVersion;
        this.packageFqName2Parts = map;
        this.moduleData = binaryModuleData;
        this.debugName = str;
    }

    public final JvmMetadataVersion getVersion() {
        return this.version;
    }

    public final Map<String, PackageParts> getPackageFqName2Parts() {
        return this.packageFqName2Parts;
    }

    public final BinaryModuleData getModuleData() {
        return this.moduleData;
    }

    public final PackageParts findPackageParts(String packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return this.packageFqName2Parts.get(packageFqName);
    }

    public String toString() {
        return this.debugName;
    }

    /* compiled from: ModuleMapping.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJF\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a0\u0019J6\u0010\u001b\u001a\u0004\u0018\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping$Companion;", "", "<init>", "()V", "MAPPING_FILE_EXT", "", "EMPTY", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "CORRUPTED", "STRICT_METADATA_VERSION_SEMANTICS_FLAG", "", "readVersionNumber", "", "stream", "Ljava/io/DataInputStream;", "loadModuleMapping", "bytes", "", "debugName", "skipMetadataVersionCheck", "", "isJvmPackageNameSupported", "metadataVersionFromLanguageVersion", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "reportIncompatibleVersionError", "Lkotlin/Function1;", "", "loadMultiFileFacadeInternalName", "multifileFacadeIds", "", "multifileFacadeShortNames", FirebaseAnalytics.Param.INDEX, "packageFqName", "emptyBinaryData", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] readVersionNumber(DataInputStream stream) {
            Intrinsics.checkNotNullParameter(stream, "stream");
            try {
                int readInt = stream.readInt();
                if (readInt >= 0 && readInt <= 1024) {
                    int[] iArr = new int[readInt];
                    for (int i = 0; i < readInt; i++) {
                        iArr[i] = stream.readInt();
                    }
                    return iArr;
                }
            } catch (IOException unused) {
            }
            return null;
        }

        public static /* synthetic */ ModuleMapping loadModuleMapping$default(Companion companion, byte[] bArr, String str, boolean z, boolean z2, JvmMetadataVersion jvmMetadataVersion, Function1 function1, int i, Object obj) {
            if ((i & 16) != 0) {
                jvmMetadataVersion = JvmMetadataVersion.INSTANCE;
            }
            return companion.loadModuleMapping(bArr, str, z, z2, jvmMetadataVersion, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ModuleMapping loadModuleMapping(byte[] bArr, String debugName, boolean z, boolean z2, JvmMetadataVersion metadataVersionFromLanguageVersion, Function1<? super JvmMetadataVersion, Unit> reportIncompatibleVersionError) {
            int i;
            int i2;
            int i3;
            String internalNameOf;
            String internalNameOf2;
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
            Intrinsics.checkNotNullParameter(reportIncompatibleVersionError, "reportIncompatibleVersionError");
            if (bArr == null) {
                return ModuleMapping.EMPTY;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            int[] readVersionNumber = readVersionNumber(dataInputStream);
            if (readVersionNumber == null) {
                return ModuleMapping.CORRUPTED;
            }
            JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(Arrays.copyOf(readVersionNumber, readVersionNumber.length));
            if (!z && !jvmMetadataVersion.isCompatible(metadataVersionFromLanguageVersion)) {
                reportIncompatibleVersionError.invoke(jvmMetadataVersion);
                return ModuleMapping.EMPTY;
            }
            if (VersionSpecificBehaviorKt.isKotlin1Dot4OrLater(jvmMetadataVersion)) {
                i = dataInputStream.readInt();
                i2 = 0;
            } else {
                i = 0;
                i2 = 0;
            }
            JvmMetadataVersion jvmMetadataVersion2 = new JvmMetadataVersion(readVersionNumber, (i & 1) == 0 ? i2 : 1);
            if (!z && !jvmMetadataVersion2.isCompatible(metadataVersionFromLanguageVersion)) {
                reportIncompatibleVersionError.invoke(jvmMetadataVersion2);
                return ModuleMapping.EMPTY;
            }
            ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
            BuiltInsProtoBuf.registerAllExtensions(newInstance);
            JvmModuleProtoBuf.Module parseFrom = JvmModuleProtoBuf.Module.parseFrom(dataInputStream, newInstance);
            if (parseFrom == null) {
                return ModuleMapping.EMPTY;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (JvmModuleProtoBuf.PackageParts packageParts : parseFrom.getPackagePartsList()) {
                String packageFqName = packageParts.getPackageFqName();
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                Object obj = linkedHashMap2.get(packageFqName);
                if (obj == null) {
                    Intrinsics.checkNotNull(packageFqName);
                    obj = new PackageParts(packageFqName);
                    linkedHashMap2.put(packageFqName, obj);
                }
                PackageParts packageParts2 = (PackageParts) obj;
                int i4 = i2;
                for (String str : packageParts.getShortClassNameList()) {
                    Intrinsics.checkNotNull(packageFqName);
                    Intrinsics.checkNotNull(str);
                    internalNameOf2 = ModuleMappingKt.internalNameOf(packageFqName, str);
                    List<Integer> multifileFacadeShortNameIdList = packageParts.getMultifileFacadeShortNameIdList();
                    Intrinsics.checkNotNullExpressionValue(multifileFacadeShortNameIdList, "getMultifileFacadeShortNameIdList(...)");
                    ProtocolStringList multifileFacadeShortNameList = packageParts.getMultifileFacadeShortNameList();
                    Intrinsics.checkNotNullExpressionValue(multifileFacadeShortNameList, "getMultifileFacadeShortNameList(...)");
                    packageParts2.addPart(internalNameOf2, loadMultiFileFacadeInternalName(multifileFacadeShortNameIdList, multifileFacadeShortNameList, i4, packageFqName));
                    i4++;
                }
                if (z2) {
                    for (String str2 : packageParts.getClassWithJvmPackageNameShortNameList()) {
                        int i5 = i3 + 1;
                        List<Integer> classWithJvmPackageNamePackageIdList = packageParts.getClassWithJvmPackageNamePackageIdList();
                        Intrinsics.checkNotNullExpressionValue(classWithJvmPackageNamePackageIdList, "getClassWithJvmPackageNamePackageIdList(...)");
                        Integer num = (Integer) CollectionsKt.getOrNull(classWithJvmPackageNamePackageIdList, i3);
                        if (num == null) {
                            List<Integer> classWithJvmPackageNamePackageIdList2 = packageParts.getClassWithJvmPackageNamePackageIdList();
                            Intrinsics.checkNotNullExpressionValue(classWithJvmPackageNamePackageIdList2, "getClassWithJvmPackageNamePackageIdList(...)");
                            num = (Integer) CollectionsKt.lastOrNull((List<? extends Object>) classWithJvmPackageNamePackageIdList2);
                            i3 = num == null ? i5 : 0;
                        }
                        int intValue = num.intValue();
                        ProtocolStringList jvmPackageNameList = parseFrom.getJvmPackageNameList();
                        Intrinsics.checkNotNullExpressionValue(jvmPackageNameList, "getJvmPackageNameList(...)");
                        String str3 = (String) CollectionsKt.getOrNull(jvmPackageNameList, intValue);
                        if (str3 != null) {
                            Intrinsics.checkNotNull(str2);
                            internalNameOf = ModuleMappingKt.internalNameOf(str3, str2);
                            List<Integer> classWithJvmPackageNameMultifileFacadeShortNameIdList = packageParts.getClassWithJvmPackageNameMultifileFacadeShortNameIdList();
                            Intrinsics.checkNotNullExpressionValue(classWithJvmPackageNameMultifileFacadeShortNameIdList, "getClassWithJvmPackageNa…acadeShortNameIdList(...)");
                            ProtocolStringList multifileFacadeShortNameList2 = packageParts.getMultifileFacadeShortNameList();
                            Intrinsics.checkNotNullExpressionValue(multifileFacadeShortNameList2, "getMultifileFacadeShortNameList(...)");
                            packageParts2.addPart(internalNameOf, loadMultiFileFacadeInternalName(classWithJvmPackageNameMultifileFacadeShortNameIdList, multifileFacadeShortNameList2, i3, str3));
                        }
                    }
                }
                i2 = 0;
            }
            for (JvmModuleProtoBuf.PackageParts packageParts3 : parseFrom.getMetadataPartsList()) {
                LinkedHashMap linkedHashMap3 = linkedHashMap;
                String packageFqName2 = packageParts3.getPackageFqName();
                Object obj2 = linkedHashMap3.get(packageFqName2);
                if (obj2 == null) {
                    String packageFqName3 = packageParts3.getPackageFqName();
                    Intrinsics.checkNotNullExpressionValue(packageFqName3, "getPackageFqName(...)");
                    obj2 = new PackageParts(packageFqName3);
                    linkedHashMap3.put(packageFqName2, obj2);
                }
                PackageParts packageParts4 = (PackageParts) obj2;
                ProtocolStringList<String> shortClassNameList = packageParts3.getShortClassNameList();
                Intrinsics.checkNotNullExpressionValue(shortClassNameList, "getShortClassNameList(...)");
                for (String str4 : shortClassNameList) {
                    packageParts4.addMetadataPart(str4);
                }
            }
            ProtoBuf.StringTable stringTable = parseFrom.getStringTable();
            Intrinsics.checkNotNullExpressionValue(stringTable, "getStringTable(...)");
            ProtoBuf.QualifiedNameTable qualifiedNameTable = parseFrom.getQualifiedNameTable();
            Intrinsics.checkNotNullExpressionValue(qualifiedNameTable, "getQualifiedNameTable(...)");
            NameResolverImpl nameResolverImpl = new NameResolverImpl(stringTable, qualifiedNameTable);
            List<ProtoBuf.Annotation> annotationList = parseFrom.getAnnotationList();
            Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
            List<ProtoBuf.Annotation> list = annotationList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf.Annotation annotation : list) {
                arrayList.add(nameResolverImpl.getQualifiedClassName(annotation.getId()));
            }
            List<ProtoBuf.Class> optionalAnnotationClassList = parseFrom.getOptionalAnnotationClassList();
            Intrinsics.checkNotNullExpressionValue(optionalAnnotationClassList, "getOptionalAnnotationClassList(...)");
            return new ModuleMapping(jvmMetadataVersion2, linkedHashMap, new BinaryModuleData(arrayList, optionalAnnotationClassList, nameResolverImpl), debugName, null);
        }

        private final String loadMultiFileFacadeInternalName(List<Integer> list, List<String> list2, int i, String str) {
            String internalNameOf;
            Integer num = (Integer) CollectionsKt.getOrNull(list, i);
            Integer valueOf = num != null ? Integer.valueOf(num.intValue() - 1) : null;
            String str2 = valueOf != null ? (String) CollectionsKt.getOrNull(list2, valueOf.intValue()) : null;
            if (str2 != null) {
                internalNameOf = ModuleMappingKt.internalNameOf(str, str2);
                return internalNameOf;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BinaryModuleData emptyBinaryData() {
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            ProtoBuf.StringTable defaultInstance = ProtoBuf.StringTable.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
            ProtoBuf.QualifiedNameTable defaultInstance2 = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance2, "getDefaultInstance(...)");
            return new BinaryModuleData(emptyList, emptyList2, new NameResolverImpl(defaultInstance, defaultInstance2));
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = new ModuleMapping(JvmMetadataVersion.INSTANCE, MapsKt.emptyMap(), companion.emptyBinaryData(), "EMPTY");
        CORRUPTED = new ModuleMapping(JvmMetadataVersion.INSTANCE, MapsKt.emptyMap(), companion.emptyBinaryData(), "CORRUPTED");
    }
}
