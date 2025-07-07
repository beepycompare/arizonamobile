package kotlinx.metadata.internal.common;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassVisitor;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmPackageVisitor;
import kotlinx.metadata.NodesKt;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmModuleFragmentExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: KotlinCommonMetadata.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0007J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkotlinx/metadata/internal/common/KmModuleFragment;", "Lkotlinx/metadata/internal/common/KmModuleFragmentVisitor;", "()V", "classes", "", "Lkotlinx/metadata/KmClass;", "getClasses", "()Ljava/util/List;", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmModuleFragmentExtension;", "getExtensions$kotlinx_metadata", "pkg", "Lkotlinx/metadata/KmPackage;", "getPkg", "()Lkotlinx/metadata/KmPackage;", "setPkg", "(Lkotlinx/metadata/KmPackage;)V", "accept", "", "visitor", "visitClass", "Lkotlinx/metadata/KmClassVisitor;", "visitExtensions", "Lkotlinx/metadata/internal/common/KmModuleFragmentExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitPackage", "Lkotlinx/metadata/KmPackageVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmModuleFragment extends KmModuleFragmentVisitor {
    private final List<KmClass> classes;
    private final List<KmModuleFragmentExtension> extensions;
    private KmPackage pkg;

    public KmModuleFragment() {
        super(null, 1, null);
        this.classes = new ArrayList();
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createModuleFragmentExtensions());
        }
        this.extensions = arrayList;
    }

    public final KmPackage getPkg() {
        return this.pkg;
    }

    public final void setPkg(KmPackage kmPackage) {
        this.pkg = kmPackage;
    }

    public final List<KmClass> getClasses() {
        return this.classes;
    }

    public final List<KmModuleFragmentExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.internal.common.KmModuleFragmentVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmPackageVisitor visitPackage() {
        KmPackage kmPackage = new KmPackage();
        this.pkg = kmPackage;
        return kmPackage;
    }

    @Override // kotlinx.metadata.internal.common.KmModuleFragmentVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmModuleFragmentExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmModuleFragmentExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Override // kotlinx.metadata.internal.common.KmModuleFragmentVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmClassVisitor visitClass() {
        return (KmClassVisitor) NodesKt.addTo(new KmClass(), this.classes);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmModuleFragmentVisitor visitor) {
        KmPackageVisitor visitPackage;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        KmPackage kmPackage = this.pkg;
        if (kmPackage != null && (visitPackage = visitor.visitPackage()) != null) {
            kmPackage.accept(visitPackage);
        }
        for (KmClass kmClass : this.classes) {
            KmClassVisitor visitClass = visitor.visitClass();
            if (visitClass != null) {
                kmClass.accept(visitClass);
            }
        }
        for (KmModuleFragmentExtension kmModuleFragmentExtension : this.extensions) {
            KmModuleFragmentExtensionVisitor visitExtensions = visitor.visitExtensions(kmModuleFragmentExtension.getType());
            if (visitExtensions != null) {
                kmModuleFragmentExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
