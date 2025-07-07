package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/metadata/KmPropertyVisitor;", "", "delegate", "(Lkotlinx/metadata/KmPropertyVisitor;)V", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "visitEnd", "", "visitExtensions", "Lkotlinx/metadata/KmPropertyExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitSetterParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", "name", "", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmPropertyVisitor {
    private final KmPropertyVisitor delegate;

    public KmPropertyVisitor() {
        this(null, 1, null);
    }

    public KmPropertyVisitor(KmPropertyVisitor kmPropertyVisitor) {
        this.delegate = kmPropertyVisitor;
    }

    public /* synthetic */ KmPropertyVisitor(KmPropertyVisitor kmPropertyVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmPropertyVisitor);
    }

    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitTypeParameter(i, name, i2, variance);
        }
        return null;
    }

    public KmTypeVisitor visitReceiverParameterType(int i) {
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitReceiverParameterType(i);
        }
        return null;
    }

    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitContextReceiverType(i);
        }
        return null;
    }

    public KmValueParameterVisitor visitSetterParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitSetterParameter(i, name);
        }
        return null;
    }

    public KmTypeVisitor visitReturnType(int i) {
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitReturnType(i);
        }
        return null;
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitVersionRequirement();
        }
        return null;
    }

    public KmPropertyExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            return kmPropertyVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmPropertyVisitor kmPropertyVisitor = this.delegate;
        if (kmPropertyVisitor != null) {
            kmPropertyVisitor.visitEnd();
        }
    }
}
