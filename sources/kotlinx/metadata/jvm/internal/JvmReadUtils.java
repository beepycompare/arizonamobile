package kotlinx.metadata.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmLambda;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.internal.ReadersKt;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmNameResolver;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlinx.metadata.internal.metadata.jvm.deserialization.ModuleMapping;
import kotlinx.metadata.internal.metadata.jvm.deserialization.PackageParts;
import kotlinx.metadata.jvm.JvmMetadataVersion;
import kotlinx.metadata.jvm.KmModule;
import kotlinx.metadata.jvm.KmPackageParts;
import kotlinx.metadata.jvm.KotlinClassMetadata;
import kotlinx.metadata.jvm.UnstableMetadataApi;
/* compiled from: JvmReadUtils.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJ\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmReadUtils;", "", "()V", "checkMetadataVersionForRead", "", "annotationData", "Lkotlin/Metadata;", "lenient", "", "isLessThan14", "readKmClass", "Lkotlinx/metadata/KmClass;", "readKmClass$kotlinx_metadata_jvm", "readKmLambda", "Lkotlinx/metadata/KmLambda;", "readKmLambda$kotlinx_metadata_jvm", "readKmPackage", "Lkotlinx/metadata/KmPackage;", "readKmPackage$kotlinx_metadata_jvm", "readMetadataImpl", "Lkotlinx/metadata/jvm/KotlinClassMetadata;", "readMetadataImpl$kotlinx_metadata_jvm", "readModuleMetadataImpl", "Lkotlinx/metadata/jvm/KmModule;", "data", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/ModuleMapping;", "readModuleMetadataImpl$kotlinx_metadata_jvm", "throwIfNotCompatible", "jvmMetadataVersion", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmMetadataVersion;", "throwIfNotCompatible$kotlinx_metadata_jvm", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmReadUtils {
    public static final JvmReadUtils INSTANCE = new JvmReadUtils();

    private JvmReadUtils() {
    }

    private final boolean isLessThan14(Metadata metadata) {
        return new JvmMetadataVersion(metadata.mv()).compareTo(new JvmMetadataVersion(1, 4, 0)) < 0;
    }

    public final KmClass readKmClass$kotlinx_metadata_jvm(Metadata annotationData) {
        Intrinsics.checkNotNullParameter(annotationData, "annotationData");
        Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom = JvmProtoBufUtil.readClassDataFrom(JvmExceptionUtilsKt.requireNotEmpty(annotationData), annotationData.d2());
        return ReadersKt.toKmClass$default(readClassDataFrom.component2(), readClassDataFrom.component1(), isLessThan14(annotationData), null, 4, null);
    }

    public final KmPackage readKmPackage$kotlinx_metadata_jvm(Metadata annotationData) {
        Intrinsics.checkNotNullParameter(annotationData, "annotationData");
        Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(JvmExceptionUtilsKt.requireNotEmpty(annotationData), annotationData.d2());
        return ReadersKt.toKmPackage$default(readPackageDataFrom.component2(), readPackageDataFrom.component1(), isLessThan14(annotationData), null, 4, null);
    }

    public final KmLambda readKmLambda$kotlinx_metadata_jvm(Metadata annotationData) {
        Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom;
        Intrinsics.checkNotNullParameter(annotationData, "annotationData");
        String[] d1 = annotationData.d1();
        if (d1.length == 0) {
            d1 = null;
        }
        if (d1 == null || (readFunctionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(d1, annotationData.d2())) == null) {
            return null;
        }
        return ReadersKt.toKmLambda(readFunctionDataFrom.component2(), readFunctionDataFrom.component1(), isLessThan14(annotationData));
    }

    public final KotlinClassMetadata readMetadataImpl$kotlinx_metadata_jvm(Metadata annotationData, boolean z) {
        Intrinsics.checkNotNullParameter(annotationData, "annotationData");
        checkMetadataVersionForRead(annotationData, z);
        boolean z2 = true;
        try {
            int k = annotationData.k();
            if (k != 1) {
                if (k != 2) {
                    if (k != 3) {
                        if (k != 4) {
                            if (k == 5) {
                                return new KotlinClassMetadata.MultiFileClassPart(annotationData, z);
                            }
                            return new KotlinClassMetadata.Unknown(annotationData, z);
                        }
                        return new KotlinClassMetadata.MultiFileClassFacade(annotationData, z);
                    }
                    return new KotlinClassMetadata.SyntheticClass(annotationData, z);
                }
                return new KotlinClassMetadata.FileFacade(annotationData, z);
            }
            return new KotlinClassMetadata.Class(annotationData, z);
        } finally {
        }
    }

    @UnstableMetadataApi
    public final KmModule readModuleMetadataImpl$kotlinx_metadata_jvm(ModuleMapping data) {
        Intrinsics.checkNotNullParameter(data, "data");
        KmModule kmModule = new KmModule();
        for (Map.Entry<String, PackageParts> entry : data.getPackageFqName2Parts().entrySet()) {
            String key = entry.getKey();
            PackageParts value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value.getParts()) {
                if (value.getMultifileFacadeName((String) obj) == null) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            Map<String, KmPackageParts> packageParts = kmModule.getPackageParts();
            List mutableList = CollectionsKt.toMutableList((Collection) ((List) pair.component1()));
            List list = (List) pair.component2();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj2 : list) {
                String multifileFacadeName = value.getMultifileFacadeName((String) obj2);
                Intrinsics.checkNotNull(multifileFacadeName);
                linkedHashMap.put(obj2, multifileFacadeName);
            }
            packageParts.put(key, new KmPackageParts(mutableList, MapsKt.toMutableMap(linkedHashMap)));
        }
        for (String str : data.getModuleData().getAnnotations()) {
            kmModule.getAnnotations().add(new KmAnnotation(str, MapsKt.emptyMap()));
        }
        for (ProtoBuf.Class r3 : data.getModuleData().getOptionalAnnotations()) {
            kmModule.getOptionalAnnotationClasses().add(ReadersKt.toKmClass$default(r3, data.getModuleData().getNameResolver(), false, null, 4, null));
        }
        return kmModule;
    }

    private final void checkMetadataVersionForRead(Metadata metadata, boolean z) {
        if (metadata.mv().length == 0) {
            throw new IllegalArgumentException("Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.");
        }
        throwIfNotCompatible$kotlinx_metadata_jvm(new kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion(metadata.mv(), (metadata.xi() & 8) != 0), z);
    }

    public final void throwIfNotCompatible$kotlinx_metadata_jvm(kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion jvmMetadataVersion, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "jvmMetadataVersion");
        boolean isAtLeast = jvmMetadataVersion.isAtLeast(1, 1, 0);
        if (z ? isAtLeast : jvmMetadataVersion.isCompatibleWithCurrentCompilerVersion()) {
            return;
        }
        if (isAtLeast) {
            str = "while maximum supported version is " + (jvmMetadataVersion.isStrictSemantics() ? kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion.INSTANCE : kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMetadataVersion.INSTANCE_NEXT) + ". To support newer versions, update the kotlinx-metadata-jvm library.";
        } else {
            str = "while minimum supported version is 1.1.0 (Kotlin 1.0).";
        }
        throw new IllegalArgumentException("Provided Metadata instance has version " + jvmMetadataVersion + ", " + str);
    }
}
