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
import kotlinx.metadata.internal.extensions.KmClassExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0001H\u0007J\u001c\u0010D\u001a\u00020B2\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010+\u001a\u00060\u0005j\u0002`,H\u0017J\u0010\u0010E\u001a\u00020B2\u0006\u0010+\u001a\u00020\u0005H\u0017J\u0010\u0010F\u001a\u00020G2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010H\u001a\u00020I2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010J\u001a\u00020B2\u0006\u0010+\u001a\u00020\u0005H\u0017J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0017J\u0018\u0010O\u001a\u00020P2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0005H\u0017J\u0010\u0010Q\u001a\u00020B2\u0006\u0010+\u001a\u00020\u0005H\u0017J\u0010\u0010R\u001a\u00020I2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010S\u001a\u00020B2\u0006\u0010+\u001a\u00020\u0005H\u0017J(\u0010T\u001a\u00020U2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020\u001aH\u0017J\u0014\u0010X\u001a\u00020B2\n\u0010+\u001a\u00060\u0005j\u0002`,H\u0017J\u0010\u0010Y\u001a\u00020I2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0005H\u0017J(\u0010\\\u001a\u00020]2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020`H\u0017J\b\u0010a\u001a\u00020bH\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR$\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000eR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001c\u0010&\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00060\u0005j\u0002`,X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000eR\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000eR\u001b\u00104\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`,0\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000eR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000eR\u001a\u00108\u001a\b\u0012\u0004\u0012\u0002090\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000eR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000eR\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000e¨\u0006c"}, d2 = {"Lkotlinx/metadata/KmClass;", "Lkotlinx/metadata/KmClassVisitor;", "Lkotlinx/metadata/KmDeclarationContainer;", "()V", "companionObject", "", "getCompanionObject", "()Ljava/lang/String;", "setCompanionObject", "(Ljava/lang/String;)V", "constructors", "", "Lkotlinx/metadata/KmConstructor;", "getConstructors", "()Ljava/util/List;", "contextReceiverTypes", "Lkotlinx/metadata/KmType;", "getContextReceiverTypes$annotations", "getContextReceiverTypes", "enumEntries", "getEnumEntries", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmClassExtension;", "getExtensions$kotlinx_metadata", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "getFlags$annotations", "getFlags", "()I", "setFlags", "(I)V", "functions", "Lkotlinx/metadata/KmFunction;", "getFunctions", "inlineClassUnderlyingPropertyName", "getInlineClassUnderlyingPropertyName", "setInlineClassUnderlyingPropertyName", "inlineClassUnderlyingType", "getInlineClassUnderlyingType", "()Lkotlinx/metadata/KmType;", "setInlineClassUnderlyingType", "(Lkotlinx/metadata/KmType;)V", "name", "Lkotlinx/metadata/ClassName;", "getName", "setName", "nestedClasses", "getNestedClasses", "properties", "Lkotlinx/metadata/KmProperty;", "getProperties", "sealedSubclasses", "getSealedSubclasses", "supertypes", "getSupertypes", "typeAliases", "Lkotlinx/metadata/KmTypeAlias;", "getTypeAliases", "typeParameters", "Lkotlinx/metadata/KmTypeParameter;", "getTypeParameters", "versionRequirements", "Lkotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visit", "visitCompanionObject", "visitConstructor", "Lkotlinx/metadata/KmConstructorVisitor;", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", "visitEnumEntry", "visitExtensions", "Lkotlinx/metadata/KmClassExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitFunction", "Lkotlinx/metadata/KmFunctionVisitor;", "visitInlineClassUnderlyingPropertyName", "visitInlineClassUnderlyingType", "visitNestedClass", "visitProperty", "Lkotlinx/metadata/KmPropertyVisitor;", "getterFlags", "setterFlags", "visitSealedSubclass", "visitSupertype", "visitTypeAlias", "Lkotlinx/metadata/KmTypeAliasVisitor;", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmClass extends KmClassVisitor implements KmDeclarationContainer {
    private String companionObject;
    private final List<KmConstructor> constructors;
    private final List<KmType> contextReceiverTypes;
    private final List<String> enumEntries;
    private final List<KmClassExtension> extensions;
    private int flags;
    private final List<KmFunction> functions;
    private String inlineClassUnderlyingPropertyName;
    private KmType inlineClassUnderlyingType;
    public String name;
    private final List<String> nestedClasses;
    private final List<KmProperty> properties;
    private final List<String> sealedSubclasses;
    private final List<KmType> supertypes;
    private final List<KmTypeAlias> typeAliases;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmClass, such as KmClass.visibility")
    public static /* synthetic */ void getFlags$annotations() {
    }

    public KmClass() {
        super(null, 1, null);
        this.typeParameters = new ArrayList(0);
        this.supertypes = new ArrayList(1);
        this.functions = new ArrayList();
        this.properties = new ArrayList();
        this.typeAliases = new ArrayList(0);
        this.constructors = new ArrayList(1);
        this.nestedClasses = new ArrayList(0);
        this.enumEntries = new ArrayList(0);
        this.sealedSubclasses = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createClassExtension());
        }
        this.extensions = arrayList;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmType> getSupertypes() {
        return this.supertypes;
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

    public final List<KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final String getCompanionObject() {
        return this.companionObject;
    }

    public final void setCompanionObject(String str) {
        this.companionObject = str;
    }

    public final List<String> getNestedClasses() {
        return this.nestedClasses;
    }

    public final List<String> getEnumEntries() {
        return this.enumEntries;
    }

    public final List<String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final String getInlineClassUnderlyingPropertyName() {
        return this.inlineClassUnderlyingPropertyName;
    }

    public final void setInlineClassUnderlyingPropertyName(String str) {
        this.inlineClassUnderlyingPropertyName = str;
    }

    public final KmType getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType;
    }

    public final void setInlineClassUnderlyingType(KmType kmType) {
        this.inlineClassUnderlyingType = kmType;
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmClassExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visit(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        setName(name);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(i, name, i2, variance), this.typeParameters);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitSupertype(int i) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(i), this.supertypes);
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

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmConstructorVisitor visitConstructor(int i) {
        return (KmConstructorVisitor) NodesKt.addTo(new KmConstructor(i), this.constructors);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitCompanionObject(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.companionObject = name;
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitNestedClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nestedClasses.add(name);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitEnumEntry(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.enumEntries.add(name);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitSealedSubclass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.sealedSubclasses.add(name);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitInlineClassUnderlyingPropertyName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.inlineClassUnderlyingPropertyName = name;
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitInlineClassUnderlyingType(int i) {
        KmType kmType = new KmType(i);
        this.inlineClassUnderlyingType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(i), this.contextReceiverTypes);
    }

    @Override // kotlinx.metadata.KmClassVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Override // kotlinx.metadata.KmClassVisitor, kotlinx.metadata.KmDeclarationContainerVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmClassExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmClassExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmClassVisitor visitor) {
        KmTypeVisitor visitInlineClassUnderlyingType;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        visitor.visit(this.flags, getName());
        for (KmTypeParameter kmTypeParameter : this.typeParameters) {
            KmTypeParameterVisitor visitTypeParameter = visitor.visitTypeParameter(kmTypeParameter.getFlags(), kmTypeParameter.getName(), kmTypeParameter.getId(), kmTypeParameter.getVariance());
            if (visitTypeParameter != null) {
                kmTypeParameter.accept(visitTypeParameter);
            }
        }
        for (KmType kmType : this.supertypes) {
            KmTypeVisitor visitSupertype = visitor.visitSupertype(kmType.getFlags());
            if (visitSupertype != null) {
                kmType.accept(visitSupertype);
            }
        }
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
        for (KmConstructor kmConstructor : this.constructors) {
            KmConstructorVisitor visitConstructor = visitor.visitConstructor(kmConstructor.getFlags());
            if (visitConstructor != null) {
                kmConstructor.accept(visitConstructor);
            }
        }
        String str = this.companionObject;
        if (str != null) {
            visitor.visitCompanionObject(str);
        }
        for (String str2 : this.nestedClasses) {
            visitor.visitNestedClass(str2);
        }
        for (String str3 : this.enumEntries) {
            visitor.visitEnumEntry(str3);
        }
        for (String str4 : this.sealedSubclasses) {
            visitor.visitSealedSubclass(str4);
        }
        String str5 = this.inlineClassUnderlyingPropertyName;
        if (str5 != null) {
            visitor.visitInlineClassUnderlyingPropertyName(str5);
        }
        KmType kmType2 = this.inlineClassUnderlyingType;
        if (kmType2 != null && (visitInlineClassUnderlyingType = visitor.visitInlineClassUnderlyingType(kmType2.getFlags())) != null) {
            kmType2.accept(visitInlineClassUnderlyingType);
        }
        for (KmType kmType3 : this.contextReceiverTypes) {
            KmTypeVisitor visitContextReceiverType = visitor.visitContextReceiverType(kmType3.getFlags());
            if (visitContextReceiverType != null) {
                kmType3.accept(visitContextReceiverType);
            }
        }
        for (KmVersionRequirement kmVersionRequirement : this.versionRequirements) {
            KmVersionRequirementVisitor visitVersionRequirement = visitor.visitVersionRequirement();
            if (visitVersionRequirement != null) {
                kmVersionRequirement.accept(visitVersionRequirement);
            }
        }
        for (KmClassExtension kmClassExtension : this.extensions) {
            KmClassExtensionVisitor visitExtensions = visitor.visitExtensions(kmClassExtension.getType());
            if (visitExtensions != null) {
                kmClassExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
