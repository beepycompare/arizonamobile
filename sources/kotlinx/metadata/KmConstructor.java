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
import kotlinx.metadata.internal.extensions.KmConstructorExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0017J\b\u0010!\u001a\u00020\"H\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006#"}, d2 = {"Lkotlinx/metadata/KmConstructor;", "Lkotlinx/metadata/KmConstructorVisitor;", "()V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(I)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmConstructorExtension;", "getExtensions$kotlinx_metadata", "()Ljava/util/List;", "getFlags$annotations", "getFlags", "()I", "setFlags", "valueParameters", "", "Lkotlinx/metadata/KmValueParameter;", "getValueParameters", "versionRequirements", "Lkotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visitExtensions", "Lkotlinx/metadata/KmConstructorExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitValueParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", "name", "", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmConstructor extends KmConstructorVisitor {
    private final List<KmConstructorExtension> extensions;
    private int flags;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmConstructor, such as KmConstructor.visibility")
    public static /* synthetic */ void getFlags$annotations() {
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Constructor with flags is deprecated, use constructor without flags and assign them or corresponding extension properties directly.")
    public KmConstructor(int i) {
        super(null, 1, null);
        this.flags = i;
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createConstructorExtension());
        }
        this.extensions = arrayList;
    }

    public KmConstructor() {
        this(0);
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmConstructorExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmConstructorVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmValueParameterVisitor visitValueParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (KmValueParameterVisitor) NodesKt.addTo(new KmValueParameter(i, name), this.valueParameters);
    }

    @Override // kotlinx.metadata.KmConstructorVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Override // kotlinx.metadata.KmConstructorVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmConstructorExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmConstructorExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmConstructorVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmValueParameter kmValueParameter : this.valueParameters) {
            KmValueParameterVisitor visitValueParameter = visitor.visitValueParameter(kmValueParameter.getFlags(), kmValueParameter.getName());
            if (visitValueParameter != null) {
                kmValueParameter.accept(visitValueParameter);
            }
        }
        for (KmVersionRequirement kmVersionRequirement : this.versionRequirements) {
            KmVersionRequirementVisitor visitVersionRequirement = visitor.visitVersionRequirement();
            if (visitVersionRequirement != null) {
                kmVersionRequirement.accept(visitVersionRequirement);
            }
        }
        for (KmConstructorExtension kmConstructorExtension : this.extensions) {
            KmConstructorExtensionVisitor visitExtensions = visitor.visitExtensions(kmConstructorExtension.getType());
            if (visitExtensions != null) {
                kmConstructorExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
