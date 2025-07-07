package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.metadata.internal.BooleanFlagDelegate;
import kotlinx.metadata.internal.FlagDelegatesImplKt;
import kotlinx.metadata.internal.FlagImpl;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmPropertyExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0001H\u0007J\u0010\u0010Q\u001a\u00020R2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0017J\u0010\u0010W\u001a\u00020R2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010X\u001a\u00020R2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010Y\u001a\u00020Z2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0017J(\u0010[\u001a\u00020\\2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_H\u0017J\b\u0010`\u001a\u00020aH\u0017R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R(\u0010;\u001a\u0004\u0018\u00010(2\b\u0010:\u001a\u0004\u0018\u00010(@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010>R,\u0010\b\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001dR\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u0018¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001d¨\u0006b"}, d2 = {"Lkotlinx/metadata/KmProperty;", "Lkotlinx/metadata/KmPropertyVisitor;", "name", "", "(Ljava/lang/String;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "getterFlags", "setterFlags", "(ILjava/lang/String;II)V", "<set-?>", "", "_hasGetter", "get_hasGetter", "()Z", "set_hasGetter", "(Z)V", "_hasGetter$delegate", "Lkotlinx/metadata/internal/BooleanFlagDelegate;", "_hasSetter", "get_hasSetter", "set_hasSetter", "_hasSetter$delegate", "contextReceiverTypes", "", "Lkotlinx/metadata/KmType;", "getContextReceiverTypes$annotations", "()V", "getContextReceiverTypes", "()Ljava/util/List;", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmPropertyExtension;", "getExtensions$kotlinx_metadata", "getFlags$annotations", "getFlags", "()I", "setFlags", "(I)V", "getter", "Lkotlinx/metadata/KmPropertyAccessorAttributes;", "getGetter", "()Lkotlinx/metadata/KmPropertyAccessorAttributes;", "value", "getGetterFlags$annotations", "getGetterFlags", "setGetterFlags", "getName", "()Ljava/lang/String;", "setName", "receiverParameterType", "getReceiverParameterType", "()Lkotlinx/metadata/KmType;", "setReceiverParameterType", "(Lkotlinx/metadata/KmType;)V", "returnType", "getReturnType", "setReturnType", "new", "setter", "getSetter", "setSetter", "(Lkotlinx/metadata/KmPropertyAccessorAttributes;)V", "getSetterFlags$annotations", "getSetterFlags", "setSetterFlags", "setterParameter", "Lkotlinx/metadata/KmValueParameter;", "getSetterParameter", "()Lkotlinx/metadata/KmValueParameter;", "setSetterParameter", "(Lkotlinx/metadata/KmValueParameter;)V", "typeParameters", "Lkotlinx/metadata/KmTypeParameter;", "getTypeParameters", "versionRequirements", "Lkotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", "visitExtensions", "Lkotlinx/metadata/KmPropertyExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitSetterParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmProperty extends KmPropertyVisitor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(KmProperty.class), "_hasSetter", "get_hasSetter()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(KmProperty.class), "_hasGetter", "get_hasGetter()Z"))};
    private final BooleanFlagDelegate _hasGetter$delegate;
    private final BooleanFlagDelegate _hasSetter$delegate;
    private final List<KmType> contextReceiverTypes;
    private final List<KmPropertyExtension> extensions;
    private int flags;
    private final KmPropertyAccessorAttributes getter;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private KmPropertyAccessorAttributes setter;
    private int setterFlags;
    private KmValueParameter setterParameter;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmProperty, such as KmProperty.visibility")
    public static /* synthetic */ void getFlags$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmProperty.getter, such as KmProperty.getter.isNotDefault")
    public static /* synthetic */ void getGetterFlags$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmProperty.setter, such as KmProperty.setter.isNotDefault")
    public static /* synthetic */ void getSetterFlags$annotations() {
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
    public KmProperty(int i, String name, int i2, int i3) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        Flags.BooleanFlagField HAS_SETTER = Flags.HAS_SETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_SETTER, "HAS_SETTER");
        this._hasSetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_SETTER));
        Flags.BooleanFlagField HAS_GETTER = Flags.HAS_GETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_GETTER, "HAS_GETTER");
        this._hasGetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_GETTER));
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = new KmPropertyAccessorAttributes(i2);
        set_hasGetter(true);
        this.getter = kmPropertyAccessorAttributes;
        this.setter = get_hasSetter() ? new KmPropertyAccessorAttributes(i3) : null;
        this.setterFlags = i3;
        this.typeParameters = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createPropertyExtension());
        }
        this.extensions = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmProperty(String name) {
        this(0, name, 0, 0);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    private final boolean get_hasSetter() {
        return this._hasSetter$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_hasSetter(boolean z) {
        this._hasSetter$delegate.setValue(this, $$delegatedProperties[0], z);
    }

    private final boolean get_hasGetter() {
        return this._hasGetter$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final void set_hasGetter(boolean z) {
        this._hasGetter$delegate.setValue(this, $$delegatedProperties[1], z);
    }

    public final KmPropertyAccessorAttributes getGetter() {
        return this.getter;
    }

    public final KmPropertyAccessorAttributes getSetter() {
        return this.setter;
    }

    public final void setSetter(KmPropertyAccessorAttributes kmPropertyAccessorAttributes) {
        set_hasSetter(kmPropertyAccessorAttributes != null);
        this.setter = kmPropertyAccessorAttributes;
    }

    public final int getGetterFlags() {
        return this.getter.getFlags$kotlinx_metadata();
    }

    public final void setGetterFlags(int i) {
        this.getter.setFlags$kotlinx_metadata(i);
    }

    public final int getSetterFlags() {
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = this.setter;
        return kmPropertyAccessorAttributes != null ? kmPropertyAccessorAttributes.getFlags$kotlinx_metadata() : this.setterFlags;
    }

    public final void setSetterFlags(int i) {
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = this.setter;
        if (kmPropertyAccessorAttributes != null) {
            kmPropertyAccessorAttributes.setFlags$kotlinx_metadata(i);
        }
        this.setterFlags = i;
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

    public final KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final void setSetterParameter(KmValueParameter kmValueParameter) {
        this.setterParameter = kmValueParameter;
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

    public final List<KmPropertyExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(i, name, i2, variance), this.typeParameters);
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitReceiverParameterType(int i) {
        KmType kmType = new KmType(i);
        this.receiverParameterType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(i), this.contextReceiverTypes);
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmValueParameterVisitor visitSetterParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmValueParameter kmValueParameter = new KmValueParameter(i, name);
        this.setterParameter = kmValueParameter;
        return kmValueParameter;
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitReturnType(int i) {
        KmType kmType = new KmType(i);
        setReturnType(kmType);
        return kmType;
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Override // kotlinx.metadata.KmPropertyVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmPropertyExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmPropertyExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmPropertyVisitor visitor) {
        KmValueParameterVisitor visitSetterParameter;
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
        KmValueParameter kmValueParameter = this.setterParameter;
        if (kmValueParameter != null && (visitSetterParameter = visitor.visitSetterParameter(kmValueParameter.getFlags(), kmValueParameter.getName())) != null) {
            kmValueParameter.accept(visitSetterParameter);
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
        for (KmPropertyExtension kmPropertyExtension : this.extensions) {
            KmPropertyExtensionVisitor visitExtensions = visitor.visitExtensions(kmPropertyExtension.getType());
            if (visitExtensions != null) {
                kmPropertyExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
