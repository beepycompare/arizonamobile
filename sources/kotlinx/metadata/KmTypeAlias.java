package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmTypeAliasExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0001H\u0007J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\nH\u0017J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0017J(\u00104\u001a\u0002052\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u000208H\u0017J\u0010\u00109\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010:\u001a\u00020;H\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0004R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\f¨\u0006<"}, d2 = {"Lkotlinx/metadata/KmTypeAlias;", "Lkotlinx/metadata/KmTypeAliasVisitor;", "name", "", "(Ljava/lang/String;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(ILjava/lang/String;)V", "annotations", "", "Lkotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "expandedType", "Lkotlinx/metadata/KmType;", "getExpandedType", "()Lkotlinx/metadata/KmType;", "setExpandedType", "(Lkotlinx/metadata/KmType;)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmTypeAliasExtension;", "getExtensions$kotlinx_metadata", "getFlags$annotations", "()V", "getFlags", "()I", "setFlags", "(I)V", "getName", "()Ljava/lang/String;", "setName", "typeParameters", "Lkotlinx/metadata/KmTypeParameter;", "getTypeParameters", "underlyingType", "getUnderlyingType", "setUnderlyingType", "versionRequirements", "Lkotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visitAnnotation", "annotation", "visitExpandedType", "Lkotlinx/metadata/KmTypeVisitor;", "visitExtensions", "Lkotlinx/metadata/KmTypeAliasExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitUnderlyingType", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmTypeAlias extends KmTypeAliasVisitor {
    private final List<KmAnnotation> annotations;
    public KmType expandedType;
    private final List<KmTypeAliasExtension> extensions;
    private int flags;
    private String name;
    private final List<KmTypeParameter> typeParameters;
    public KmType underlyingType;
    private final List<KmVersionRequirement> versionRequirements;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmTypeAlias, such as KmTypeAlias.visibility")
    public static /* synthetic */ void getFlags$annotations() {
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Constructor with flags is deprecated, use constructor without flags and assign them or corresponding extension properties directly.")
    public KmTypeAlias(int i, String name) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        ArrayList arrayList = new ArrayList();
        for (MetadataExtensions metadataExtensions : MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata()) {
            KmTypeAliasExtension createTypeAliasExtension = metadataExtensions.createTypeAliasExtension();
            if (createTypeAliasExtension != null) {
                arrayList.add(createTypeAliasExtension);
            }
        }
        this.extensions = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmTypeAlias(String name) {
        this(0, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final KmType getUnderlyingType() {
        KmType kmType = this.underlyingType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        return null;
    }

    public final void setUnderlyingType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.underlyingType = kmType;
    }

    public final KmType getExpandedType() {
        KmType kmType = this.expandedType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        return null;
    }

    public final void setExpandedType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.expandedType = kmType;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmTypeAliasExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(i, name, i2, variance), this.typeParameters);
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitUnderlyingType(int i) {
        KmType kmType = new KmType(i);
        setUnderlyingType(kmType);
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitExpandedType(int i) {
        KmType kmType = new KmType(i);
        setExpandedType(kmType);
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitAnnotation(KmAnnotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotations.add(annotation);
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeAliasExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeAliasExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Override // kotlinx.metadata.KmTypeAliasVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmTypeAliasVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmTypeParameter kmTypeParameter : this.typeParameters) {
            KmTypeParameterVisitor visitTypeParameter = visitor.visitTypeParameter(kmTypeParameter.getFlags(), kmTypeParameter.getName(), kmTypeParameter.getId(), kmTypeParameter.getVariance());
            if (visitTypeParameter != null) {
                kmTypeParameter.accept(visitTypeParameter);
            }
        }
        KmTypeVisitor visitUnderlyingType = visitor.visitUnderlyingType(getUnderlyingType().getFlags());
        if (visitUnderlyingType != null) {
            getUnderlyingType().accept(visitUnderlyingType);
        }
        KmTypeVisitor visitExpandedType = visitor.visitExpandedType(getExpandedType().getFlags());
        if (visitExpandedType != null) {
            getExpandedType().accept(visitExpandedType);
        }
        for (KmAnnotation kmAnnotation : this.annotations) {
            visitor.visitAnnotation(kmAnnotation);
        }
        for (KmVersionRequirement kmVersionRequirement : this.versionRequirements) {
            KmVersionRequirementVisitor visitVersionRequirement = visitor.visitVersionRequirement();
            if (visitVersionRequirement != null) {
                kmVersionRequirement.accept(visitVersionRequirement);
            }
        }
        for (KmTypeAliasExtension kmTypeAliasExtension : this.extensions) {
            KmTypeAliasExtensionVisitor visitExtensions = visitor.visitExtensions(kmTypeAliasExtension.getType());
            if (visitExtensions != null) {
                kmTypeAliasExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
