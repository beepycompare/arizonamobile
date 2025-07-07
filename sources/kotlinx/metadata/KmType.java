package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClassifier;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmTypeExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0001H\u0007J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0017J\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-H\u0017J\u0014\u0010.\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1H\u0017J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0017J\u001a\u00106\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u000100H\u0017J\u0010\u00108\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u00109\u001a\u00020(H\u0017J\u0014\u0010:\u001a\u00020(2\n\u0010/\u001a\u000600j\u0002`1H\u0017J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0004H\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0005R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\n¨\u0006="}, d2 = {"Lkotlinx/metadata/KmType;", "Lkotlinx/metadata/KmTypeVisitor;", "()V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(I)V", "abbreviatedType", "getAbbreviatedType", "()Lkotlinx/metadata/KmType;", "setAbbreviatedType", "(Lkotlinx/metadata/KmType;)V", "arguments", "", "Lkotlinx/metadata/KmTypeProjection;", "getArguments", "()Ljava/util/List;", "classifier", "Lkotlinx/metadata/KmClassifier;", "getClassifier", "()Lkotlinx/metadata/KmClassifier;", "setClassifier", "(Lkotlinx/metadata/KmClassifier;)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmTypeExtension;", "getExtensions$kotlinx_metadata", "getFlags$annotations", "getFlags", "()I", "setFlags", "flexibleTypeUpperBound", "Lkotlinx/metadata/KmFlexibleTypeUpperBound;", "getFlexibleTypeUpperBound", "()Lkotlinx/metadata/KmFlexibleTypeUpperBound;", "setFlexibleTypeUpperBound", "(Lkotlinx/metadata/KmFlexibleTypeUpperBound;)V", "outerType", "getOuterType", "setOuterType", "accept", "", "visitor", "visitAbbreviatedType", "visitArgument", "variance", "Lkotlinx/metadata/KmVariance;", "visitClass", "name", "", "Lkotlinx/metadata/ClassName;", "visitExtensions", "Lkotlinx/metadata/KmTypeExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitFlexibleTypeUpperBound", "typeFlexibilityId", "visitOuterType", "visitStarProjection", "visitTypeAlias", "visitTypeParameter", "id", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmType extends KmTypeVisitor {
    private KmType abbreviatedType;
    private final List<KmTypeProjection> arguments;
    public KmClassifier classifier;
    private final List<KmTypeExtension> extensions;
    private int flags;
    private KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    private KmType outerType;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmType, such as KmType.isNullable")
    public static /* synthetic */ void getFlags$annotations() {
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Constructor with flags is deprecated, use constructor without flags and assign them or corresponding extension properties directly.")
    public KmType(int i) {
        super(null, 1, null);
        this.flags = i;
        this.arguments = new ArrayList(0);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createTypeExtension());
        }
        this.extensions = arrayList;
    }

    public KmType() {
        this(0);
    }

    public final KmClassifier getClassifier() {
        KmClassifier kmClassifier = this.classifier;
        if (kmClassifier != null) {
            return kmClassifier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final void setClassifier(KmClassifier kmClassifier) {
        Intrinsics.checkNotNullParameter(kmClassifier, "<set-?>");
        this.classifier = kmClassifier;
    }

    public final List<KmTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final void setAbbreviatedType(KmType kmType) {
        this.abbreviatedType = kmType;
    }

    public final KmType getOuterType() {
        return this.outerType;
    }

    public final void setOuterType(KmType kmType) {
        this.outerType = kmType;
    }

    public final KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final void setFlexibleTypeUpperBound(KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound) {
        this.flexibleTypeUpperBound = kmFlexibleTypeUpperBound;
    }

    public final List<KmTypeExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        setClassifier(new KmClassifier.Class(name));
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitTypeAlias(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        setClassifier(new KmClassifier.TypeAlias(name));
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitTypeParameter(int i) {
        setClassifier(new KmClassifier.TypeParameter(i));
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitArgument(int i, KmVariance variance) {
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmType kmType = new KmType(i);
        this.arguments.add(new KmTypeProjection(variance, kmType));
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public void visitStarProjection() {
        this.arguments.add(KmTypeProjection.STAR);
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitAbbreviatedType(int i) {
        KmType kmType = new KmType(i);
        this.abbreviatedType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitOuterType(int i) {
        KmType kmType = new KmType(i);
        this.outerType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitFlexibleTypeUpperBound(int i, String str) {
        KmType kmType = new KmType(i);
        this.flexibleTypeUpperBound = new KmFlexibleTypeUpperBound(kmType, str);
        return kmType;
    }

    @Override // kotlinx.metadata.KmTypeVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmTypeVisitor visitor) {
        KmTypeVisitor visitFlexibleTypeUpperBound;
        KmTypeVisitor visitOuterType;
        KmTypeVisitor visitAbbreviatedType;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        KmClassifier classifier = getClassifier();
        if (classifier instanceof KmClassifier.Class) {
            visitor.visitClass(((KmClassifier.Class) classifier).getName());
        } else if (classifier instanceof KmClassifier.TypeParameter) {
            visitor.visitTypeParameter(((KmClassifier.TypeParameter) classifier).getId());
        } else if (classifier instanceof KmClassifier.TypeAlias) {
            visitor.visitTypeAlias(((KmClassifier.TypeAlias) classifier).getName());
        }
        for (KmTypeProjection kmTypeProjection : this.arguments) {
            if (Intrinsics.areEqual(kmTypeProjection, KmTypeProjection.STAR)) {
                visitor.visitStarProjection();
            } else {
                KmVariance component1 = kmTypeProjection.component1();
                KmType component2 = kmTypeProjection.component2();
                if (component1 == null || component2 == null) {
                    throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
                }
                KmTypeVisitor visitArgument = visitor.visitArgument(component2.flags, component1);
                if (visitArgument != null) {
                    component2.accept(visitArgument);
                }
            }
        }
        KmType kmType = this.abbreviatedType;
        if (kmType != null && (visitAbbreviatedType = visitor.visitAbbreviatedType(kmType.flags)) != null) {
            kmType.accept(visitAbbreviatedType);
        }
        KmType kmType2 = this.outerType;
        if (kmType2 != null && (visitOuterType = visitor.visitOuterType(kmType2.flags)) != null) {
            kmType2.accept(visitOuterType);
        }
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = this.flexibleTypeUpperBound;
        if (kmFlexibleTypeUpperBound != null && (visitFlexibleTypeUpperBound = visitor.visitFlexibleTypeUpperBound(kmFlexibleTypeUpperBound.getType().flags, kmFlexibleTypeUpperBound.getTypeFlexibilityId())) != null) {
            kmFlexibleTypeUpperBound.getType().accept(visitFlexibleTypeUpperBound);
        }
        for (KmTypeExtension kmTypeExtension : this.extensions) {
            KmTypeExtensionVisitor visitExtensions = visitor.visitExtensions(kmTypeExtension.getType());
            if (visitExtensions != null) {
                kmTypeExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
