package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.extensions.ExtensionUtilsKt;
import kotlinx.metadata.internal.extensions.KmValueParameterExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006("}, d2 = {"Lkotlinx/metadata/KmValueParameter;", "Lkotlinx/metadata/KmValueParameterVisitor;", "name", "", "(Ljava/lang/String;)V", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(ILjava/lang/String;)V", "extensions", "", "Lkotlinx/metadata/internal/extensions/KmValueParameterExtension;", "getExtensions$kotlinx_metadata", "()Ljava/util/List;", "getFlags$annotations", "()V", "getFlags", "()I", "setFlags", "(I)V", "getName", "()Ljava/lang/String;", "setName", "type", "Lkotlinx/metadata/KmType;", "getType", "()Lkotlinx/metadata/KmType;", "setType", "(Lkotlinx/metadata/KmType;)V", "varargElementType", "getVarargElementType", "setVarargElementType", "accept", "", "visitor", "visitExtensions", "Lkotlinx/metadata/KmValueParameterExtensionVisitor;", "Lkotlinx/metadata/KmExtensionType;", "visitType", "Lkotlinx/metadata/KmTypeVisitor;", "visitVarargElementType", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmValueParameter extends KmValueParameterVisitor {
    private final List<KmValueParameterExtension> extensions;
    private int flags;
    private String name;
    public KmType type;
    private KmType varargElementType;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flag API is deprecated. Please use corresponding member extensions on KmValueParameter, such as KmValueParameter.declaresDefaultValue")
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
    public KmValueParameter(int i, String name) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = i;
        this.name = name;
        ArrayList arrayList = new ArrayList();
        for (MetadataExtensions metadataExtensions : MetadataExtensions.Companion.getINSTANCES$kotlinx_metadata()) {
            KmValueParameterExtension createValueParameterExtension = metadataExtensions.createValueParameterExtension();
            if (createValueParameterExtension != null) {
                arrayList.add(createValueParameterExtension);
            }
        }
        this.extensions = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmValueParameter(String name) {
        this(0, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final KmType getType() {
        KmType kmType = this.type;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.type = kmType;
    }

    public final KmType getVarargElementType() {
        return this.varargElementType;
    }

    public final void setVarargElementType(KmType kmType) {
        this.varargElementType = kmType;
    }

    public final List<KmValueParameterExtension> getExtensions$kotlinx_metadata() {
        return this.extensions;
    }

    @Override // kotlinx.metadata.KmValueParameterVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitType(int i) {
        KmType kmType = new KmType(i);
        setType(kmType);
        return kmType;
    }

    @Override // kotlinx.metadata.KmValueParameterVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmTypeVisitor visitVarargElementType(int i) {
        KmType kmType = new KmType(i);
        this.varargElementType = kmType;
        return kmType;
    }

    @Override // kotlinx.metadata.KmValueParameterVisitor
    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public KmValueParameterExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (KmValueParameterExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, type);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
    public final void accept(KmValueParameterVisitor visitor) {
        KmTypeVisitor visitVarargElementType;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        KmTypeVisitor visitType = visitor.visitType(getType().getFlags());
        if (visitType != null) {
            getType().accept(visitType);
        }
        KmType kmType = this.varargElementType;
        if (kmType != null && (visitVarargElementType = visitor.visitVarargElementType(kmType.getFlags())) != null) {
            kmType.accept(visitVarargElementType);
        }
        for (KmValueParameterExtension kmValueParameterExtension : this.extensions) {
            KmValueParameterExtensionVisitor visitExtensions = visitor.visitExtensions(kmValueParameterExtension.getType());
            if (visitExtensions != null) {
                kmValueParameterExtension.accept(visitExtensions);
            }
        }
        visitor.visitEnd();
    }
}
