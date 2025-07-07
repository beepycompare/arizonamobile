package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmValueParameterVisitor;", "", "delegate", "(Lkotlinx/metadata/KmValueParameterVisitor;)V", "visitEnd", "", "visitExtensions", "Lkotlinx/metadata/KmValueParameterExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitType", "Lkotlinx/metadata/KmTypeVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "visitVarargElementType", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmValueParameterVisitor {
    private final KmValueParameterVisitor delegate;

    public KmValueParameterVisitor() {
        this(null, 1, null);
    }

    public KmValueParameterVisitor(KmValueParameterVisitor kmValueParameterVisitor) {
        this.delegate = kmValueParameterVisitor;
    }

    public /* synthetic */ KmValueParameterVisitor(KmValueParameterVisitor kmValueParameterVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmValueParameterVisitor);
    }

    public KmTypeVisitor visitType(int i) {
        KmValueParameterVisitor kmValueParameterVisitor = this.delegate;
        if (kmValueParameterVisitor != null) {
            return kmValueParameterVisitor.visitType(i);
        }
        return null;
    }

    public KmTypeVisitor visitVarargElementType(int i) {
        KmValueParameterVisitor kmValueParameterVisitor = this.delegate;
        if (kmValueParameterVisitor != null) {
            return kmValueParameterVisitor.visitVarargElementType(i);
        }
        return null;
    }

    public KmValueParameterExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmValueParameterVisitor kmValueParameterVisitor = this.delegate;
        if (kmValueParameterVisitor != null) {
            return kmValueParameterVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmValueParameterVisitor kmValueParameterVisitor = this.delegate;
        if (kmValueParameterVisitor != null) {
            kmValueParameterVisitor.visitEnd();
        }
    }
}
