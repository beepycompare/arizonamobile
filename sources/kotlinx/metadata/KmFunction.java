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
import kotlinx.metadata.internal.extensions.KmFunctionExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0001H\u0007J\u0010\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u00108\u001a\u000209H\u0017J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0017J\u0010\u0010>\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010?\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J(\u0010@\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020DH\u0017J\u0018\u0010E\u001a\u00020F2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010G\u001a\u00020HH\u0017R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000eR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000eR\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000e¨\u0006I"}, d2 = {"Lkotlinx/metadata/KmFunction;", "Lkotlinx/metadata/KmFunctionVisitor;", "name", "", "(Ljava/lang/String;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(ILjava/lang/String;)V", "contextReceiverTypes", "", "Lkotlinx/metadata/KmType;", "getContextReceiverTypes$annotations", "()V", "getContextReceiverTypes", "()Ljava/util/List;", "contract", "Lkotlinx/metadata/KmContract;", "getContract$annotations", "getContract", "()Lkotlinx/metadata/KmContract;", "setContract", "(Lkotlinx/metadata/KmContract;)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmFunctionExtension;", "getExtensions$kotlinx_metadata", "getFlags$annotations", "getFlags", "()I", "setFlags", "(I)V", "getName", "()Ljava/lang/String;", "setName", "receiverParameterType", "getReceiverParameterType", "()Lkotlinx/metadata/KmType;", "setReceiverParameterType", "(Lkotlinx/metadata/KmType;)V", "returnType", "getReturnType", "setReturnType", "typeParameters", "Lkotlinx/metadata/KmTypeParameter;", "getTypeParameters", "valueParameters", "Lkotlinx/metadata/KmValueParameter;", "getValueParameters", "versionRequirements", "Lkotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", "visitContract", "Lkotlinx/metadata/KmContractVisitor;", "visitExtensions", "Lkotlinx/metadata/KmFunctionExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitValueParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmFunction extends KmFunctionVisitor {
    private final List<KmType> contextReceiverTypes;
    private KmContract contract;
    private final List<KmFunctionExtension> extensions;
    private int flags;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    public static /* synthetic */ void getContract$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmFunction, such as KmFunction.visibility")
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
    public KmFunction(int i, String name) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createFunctionExtension());
        }
        this.extensions = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmFunction(String name) {
        this(0, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final KmType getReceiverParameterType() {
        return this.receiverParameterType;
    }

    public final void setReceiverParameterType(KmType kmType) {
        this.receiverParameterType = kmType;
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final KmType getReturnType() {
        KmType kmType = this.returnType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final void setReturnType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final KmContract getContract() {
        return this.contract;
    }

    public final void setContract(KmContract kmContract) {
        this.contract = kmContract;
    }

    public final List<KmFunctionExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(i, name, i2, variance), this.typeParameters);
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitReceiverParameterType(int i) {
        KmType kmType = new KmType(i);
        this.receiverParameterType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(i), this.contextReceiverTypes);
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmValueParameterVisitor visitValueParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (KmValueParameterVisitor) NodesKt.addTo(new KmValueParameter(i, name), this.valueParameters);
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitReturnType(int i) {
        KmType kmType = new KmType(i);
        setReturnType(kmType);
        return kmType;
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmContractVisitor visitContract() {
        KmContract kmContract = new KmContract();
        this.contract = kmContract;
        return kmContract;
    }

    @Override // kotlinx.metadata.KmFunctionVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmFunctionExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmFunctionExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmFunctionVisitor visitor) {
        KmContractVisitor visitContract;
        KmTypeVisitor visitReceiverParameterType;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmTypeParameter kmTypeParameter : this.typeParameters) {
            KmTypeParameterVisitor visitTypeParameter = visitor.visitTypeParameter(kmTypeParameter.getFlags(), kmTypeParameter.getName(), kmTypeParameter.getId(), kmTypeParameter.getVariance());
            if (visitTypeParameter != null) {
                kmTypeParameter.accept(visitTypeParameter);
            }
        }
        KmType kmType = this.receiverParameterType;
        if (kmType != null && (visitReceiverParameterType = visitor.visitReceiverParameterType(kmType.getFlags())) != null) {
            kmType.accept(visitReceiverParameterType);
        }
        for (KmType kmType2 : this.contextReceiverTypes) {
            KmTypeVisitor visitContextReceiverType = visitor.visitContextReceiverType(kmType2.getFlags());
            if (visitContextReceiverType != null) {
                kmType2.accept(visitContextReceiverType);
            }
        }
        for (KmValueParameter kmValueParameter : this.valueParameters) {
            KmValueParameterVisitor visitValueParameter = visitor.visitValueParameter(kmValueParameter.getFlags(), kmValueParameter.getName());
            if (visitValueParameter != null) {
                kmValueParameter.accept(visitValueParameter);
            }
        }
        KmTypeVisitor visitReturnType = visitor.visitReturnType(getReturnType().getFlags());
        if (visitReturnType != null) {
            getReturnType().accept(visitReturnType);
        }
        for (KmVersionRequirement kmVersionRequirement : this.versionRequirements) {
            KmVersionRequirementVisitor visitVersionRequirement = visitor.visitVersionRequirement();
            if (visitVersionRequirement != null) {
                kmVersionRequirement.accept(visitVersionRequirement);
            }
        }
        KmContract kmContract = this.contract;
        if (kmContract != null && (visitContract = visitor.visitContract()) != null) {
            kmContract.accept(visitContract);
        }
        for (KmFunctionExtension kmFunctionExtension : this.extensions) {
            KmFunctionExtensionVisitor visitExtensions = visitor.visitExtensions(kmFunctionExtension.getType());
            if (visitExtensions != null) {
                kmFunctionExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
