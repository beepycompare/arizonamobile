package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmPackageExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J(\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0017J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006&"}, d2 = {"Lkotlinx/metadata/KmPackage;", "Lkotlinx/metadata/KmPackageVisitor;", "Lkotlinx/metadata/KmDeclarationContainer;", "()V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmPackageExtension;", "getExtensions$kotlinx_metadata", "()Ljava/util/List;", "functions", "", "Lkotlinx/metadata/KmFunction;", "getFunctions", "properties", "Lkotlinx/metadata/KmProperty;", "getProperties", "typeAliases", "Lkotlinx/metadata/KmTypeAlias;", "getTypeAliases", "accept", "", "visitor", "visitExtensions", "Lkotlinx/metadata/KmPackageExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitFunction", "Lkotlinx/metadata/KmFunctionVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "visitProperty", "Lkotlinx/metadata/KmPropertyVisitor;", "getterFlags", "setterFlags", "visitTypeAlias", "Lkotlinx/metadata/KmTypeAliasVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmPackage extends KmPackageVisitor implements KmDeclarationContainer {
    private final List<KmPackageExtension> extensions;
    private final List<KmFunction> functions;
    private final List<KmProperty> properties;
    private final List<KmTypeAlias> typeAliases;

    public KmPackage() {
        super(null, 1, null);
        this.functions = new ArrayList();
        this.properties = new ArrayList();
        this.typeAliases = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createPackageExtension());
        }
        this.extensions = arrayList;
    }

    @Override // kotlinx.metadata.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override // kotlinx.metadata.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override // kotlinx.metadata.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final List<KmPackageExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmDeclarationContainerVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmFunctionVisitor visitFunction(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (KmFunctionVisitor) NodesKt.addTo(new KmFunction(i, name), getFunctions());
    }

    @Override // kotlinx.metadata.KmDeclarationContainerVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmPropertyVisitor visitProperty(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (KmPropertyVisitor) NodesKt.addTo(new KmProperty(i, name, i2, i3), getProperties());
    }

    @Override // kotlinx.metadata.KmDeclarationContainerVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeAliasVisitor visitTypeAlias(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (KmTypeAliasVisitor) NodesKt.addTo(new KmTypeAlias(i, name), getTypeAliases());
    }

    @Override // kotlinx.metadata.KmPackageVisitor, kotlinx.metadata.KmDeclarationContainerVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmPackageExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPackageExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmPackageVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmFunction kmFunction : getFunctions()) {
            KmFunctionVisitor visitFunction = visitor.visitFunction(kmFunction.getFlags(), kmFunction.getName());
            if (visitFunction != null) {
                kmFunction.accept(visitFunction);
            }
        }
        for (KmProperty kmProperty : getProperties()) {
            KmPropertyVisitor visitProperty = visitor.visitProperty(kmProperty.getFlags(), kmProperty.getName(), kmProperty.getGetter().getFlags$kotlinx_metadata(), kmProperty.getSetterFlags());
            if (visitProperty != null) {
                kmProperty.accept(visitProperty);
            }
        }
        for (KmTypeAlias kmTypeAlias : getTypeAliases()) {
            KmTypeAliasVisitor visitTypeAlias = visitor.visitTypeAlias(kmTypeAlias.getFlags(), kmTypeAlias.getName());
            if (visitTypeAlias != null) {
                kmTypeAlias.accept(visitTypeAlias);
            }
        }
        for (KmPackageExtension kmPackageExtension : this.extensions) {
            KmPackageExtensionVisitor visitExtensions = visitor.visitExtensions(kmPackageExtension.getType());
            if (visitExtensions != null) {
                kmPackageExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
