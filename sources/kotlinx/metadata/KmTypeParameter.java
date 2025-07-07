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
import kotlinx.metadata.internal.extensions.KmTypeParameterExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J\u0010\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\u0005H\u0017R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lkotlinx/metadata/KmTypeParameter;", "Lkotlinx/metadata/KmTypeParameterVisitor;", "name", "", "id", "", "variance", "Lkotlinx/metadata/KmVariance;", "(Ljava/lang/String;ILkotlinx/metadata/KmVariance;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "(ILjava/lang/String;ILkotlinx/metadata/KmVariance;)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmTypeParameterExtension;", "getExtensions$kotlinx_metadata", "()Ljava/util/List;", "getFlags$annotations", "()V", "getFlags", "()I", "setFlags", "(I)V", "getId", "setId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "upperBounds", "", "Lkotlinx/metadata/KmType;", "getUpperBounds", "getVariance", "()Lkotlinx/metadata/KmVariance;", "setVariance", "(Lkotlinx/metadata/KmVariance;)V", "accept", "", "visitor", "visitExtensions", "Lkotlinx/metadata/KmTypeParameterExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitUpperBound", "Lkotlinx/metadata/KmTypeVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmTypeParameter extends KmTypeParameterVisitor {
    private final List<KmTypeParameterExtension> extensions;
    private int flags;
    private int id;
    private String name;
    private final List<KmType> upperBounds;
    private KmVariance variance;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmTypeParameter, such as KmTypeParameter.isReified")
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

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public final void setVariance(KmVariance kmVariance) {
        Intrinsics.checkNotNullParameter(kmVariance, "<set-?>");
        this.variance = kmVariance;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Constructor with flags is deprecated, use constructor without flags and assign them or corresponding extension properties directly.")
    public KmTypeParameter(int i, String name, int i2, KmVariance variance) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.flags = i;
        this.name = name;
        this.id = i2;
        this.variance = variance;
        this.upperBounds = new ArrayList(1);
        List<MetadataExtensions> iNSTANCES$kotlinx_metadata = MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iNSTANCES$kotlinx_metadata, 10));
        for (MetadataExtensions metadataExtensions : iNSTANCES$kotlinx_metadata) {
            arrayList.add(metadataExtensions.createTypeParameterExtension());
        }
        this.extensions = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmTypeParameter(String name, int i, KmVariance variance) {
        this(0, name, i, variance);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
    }

    public final List<KmType> getUpperBounds() {
        return this.upperBounds;
    }

    public final List<KmTypeParameterExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmTypeParameterVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitUpperBound(int i) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(i), this.upperBounds);
    }

    @Override // kotlinx.metadata.KmTypeParameterVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeParameterExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmTypeParameterExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmTypeParameterVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        for (KmType kmType : this.upperBounds) {
            KmTypeVisitor visitUpperBound = visitor.visitUpperBound(kmType.getFlags());
            if (visitUpperBound != null) {
                kmType.accept(visitUpperBound);
            }
        }
        for (KmTypeParameterExtension kmTypeParameterExtension : this.extensions) {
            KmTypeParameterExtensionVisitor visitExtensions = visitor.visitExtensions(kmTypeParameterExtension.getType());
            if (visitExtensions != null) {
                kmTypeParameterExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
