package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/metadata/KmFunctionVisitor;", "", "delegate", "(Lkotlinx/metadata/KmFunctionVisitor;)V", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "visitContract", "Lkotlinx/metadata/KmContractVisitor;", "visitEnd", "", "visitExtensions", "Lkotlinx/metadata/KmFunctionExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitReceiverParameterType", "visitReturnType", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "name", "", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitValueParameter", "Lkotlinx/metadata/KmValueParameterVisitor;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmFunctionVisitor {
    private final KmFunctionVisitor delegate;

    public KmFunctionVisitor() {
        this(null, 1, null);
    }

    public KmFunctionVisitor(KmFunctionVisitor kmFunctionVisitor) {
        this.delegate = kmFunctionVisitor;
    }

    public /* synthetic */ KmFunctionVisitor(KmFunctionVisitor kmFunctionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmFunctionVisitor);
    }

    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitTypeParameter(i, name, i2, variance);
        }
        return null;
    }

    public KmTypeVisitor visitReceiverParameterType(int i) {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitReceiverParameterType(i);
        }
        return null;
    }

    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitContextReceiverType(i);
        }
        return null;
    }

    public KmValueParameterVisitor visitValueParameter(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitValueParameter(i, name);
        }
        return null;
    }

    public KmTypeVisitor visitReturnType(int i) {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitReturnType(i);
        }
        return null;
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitVersionRequirement();
        }
        return null;
    }

    public KmContractVisitor visitContract() {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitContract();
        }
        return null;
    }

    public KmFunctionExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            return kmFunctionVisitor.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmFunctionVisitor kmFunctionVisitor = this.delegate;
        if (kmFunctionVisitor != null) {
            kmFunctionVisitor.visitEnd();
        }
    }
}
