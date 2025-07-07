package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/metadata/KmConstructorVisitor;", "", "delegate", "(Lkotlinx/metadata/KmConstructorVisitor;)V", "visitEnd", "", "visitExtensions", "Lkotlinx/metadata/KmConstructorExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitValueParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmConstructorVisitor {
    private final KmConstructorVisitor delegate;

    public KmConstructorVisitor() {
        this(null, 1, null);
    }

    public KmConstructorVisitor(KmConstructorVisitor kmConstructorVisitor) {
        this.delegate = kmConstructorVisitor;
    }

    public /* synthetic */ KmConstructorVisitor(KmConstructorVisitor kmConstructorVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmConstructorVisitor);
    }

    public KmValueParameterVisitor visitValueParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmConstructorVisitor kmConstructorVisitor = this.delegate;
        if (kmConstructorVisitor != null) {
            return kmConstructorVisitor.visitValueParameter(i, name);
        }
        return null;
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmConstructorVisitor kmConstructorVisitor = this.delegate;
        if (kmConstructorVisitor != null) {
            return kmConstructorVisitor.visitVersionRequirement();
        }
        return null;
    }

    public KmConstructorExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmConstructorVisitor kmConstructorVisitor = this.delegate;
        if (kmConstructorVisitor != null) {
            return kmConstructorVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmConstructorVisitor kmConstructorVisitor = this.delegate;
        if (kmConstructorVisitor != null) {
            kmConstructorVisitor.visitEnd();
        }
    }
}
