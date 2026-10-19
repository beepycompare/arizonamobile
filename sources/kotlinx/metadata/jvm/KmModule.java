package kotlinx.metadata.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassVisitor;
/* compiled from: KotlinModuleMetadata.kt */
@UnstableMetadataApi
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0017J\b\u0010\u0017\u001a\u00020\nH\u0017J2\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001dH\u0017R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkotlinx/metadata/jvm/KmModule;", "Lkotlinx/metadata/jvm/KmModuleVisitor;", "()V", "annotations", "", "Lkotlinx/metadata/KmAnnotation;", "getAnnotations$annotations", "getAnnotations", "()Ljava/util/List;", "optionalAnnotationClasses", "Lkotlinx/metadata/KmClass;", "getOptionalAnnotationClasses", "packageParts", "", "", "Lkotlinx/metadata/jvm/KmPackageParts;", "getPackageParts", "()Ljava/util/Map;", "accept", "", "visitor", "visitAnnotation", "annotation", "visitOptionalAnnotationClass", "visitPackageParts", "fqName", "fileFacades", "", "multiFileClassParts", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmModule extends KmModuleVisitor {
    private final List<KmAnnotation> annotations;
    private final List<KmClass> optionalAnnotationClasses;
    private final Map<String, KmPackageParts> packageParts;

    @Deprecated(level = DeprecationLevel.ERROR, message = "This list is always empty and will be removed")
    public static /* synthetic */ void getAnnotations$annotations() {
    }

    public KmModule() {
        super(null, 1, null);
        this.packageParts = new LinkedHashMap();
        this.annotations = new ArrayList(0);
        this.optionalAnnotationClasses = new ArrayList(0);
    }

    public final Map<String, KmPackageParts> getPackageParts() {
        return this.packageParts;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmClass> getOptionalAnnotationClasses() {
        return this.optionalAnnotationClasses;
    }

    @Override // kotlinx.metadata.jvm.KmModuleVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitPackageParts(String fqName, List<String> fileFacades, Map<String, String> multiFileClassParts) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(fileFacades, "fileFacades");
        Intrinsics.checkNotNullParameter(multiFileClassParts, "multiFileClassParts");
        this.packageParts.put(fqName, new KmPackageParts(CollectionsKt.toMutableList((Collection) fileFacades), MapsKt.toMutableMap(multiFileClassParts)));
    }

    @Override // kotlinx.metadata.jvm.KmModuleVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotations.add(annotation);
    }

    @Override // kotlinx.metadata.jvm.KmModuleVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmClass visitOptionalAnnotationClass() {
        KmClass kmClass = new KmClass();
        this.optionalAnnotationClasses.add(kmClass);
        return kmClass;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmModuleVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (Map.Entry<String, KmPackageParts> entry : this.packageParts.entrySet()) {
            KmPackageParts value = entry.getValue();
            visitor.visitPackageParts(entry.getKey(), value.getFileFacades(), value.getMultiFileClassParts());
        }
        for (KmAnnotation kmAnnotation : this.annotations) {
            visitor.visitAnnotation(kmAnnotation);
        }
        for (KmClass kmClass : this.optionalAnnotationClasses) {
            KmClassVisitor visitOptionalAnnotationClass = visitor.visitOptionalAnnotationClass();
            if (visitOptionalAnnotationClass != null) {
                kmClass.accept(visitOptionalAnnotationClass);
            }
        }
    }
}
