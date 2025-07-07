package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, d2 = {"Lkotlinx/metadata/KmDeclarationContainerVisitor;", "", "delegate", "(Lkotlinx/metadata/KmDeclarationContainerVisitor;)V", "getDelegate", "()Lkotlinx/metadata/KmDeclarationContainerVisitor;", "visitExtensions", "Lkotlinx/metadata/KmDeclarationContainerExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitFunction", "Lkotlinx/metadata/KmFunctionVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "visitProperty", "Lkotlinx/metadata/KmPropertyVisitor;", "getterFlags", "setterFlags", "visitTypeAlias", "Lkotlinx/metadata/KmTypeAliasVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmDeclarationContainerVisitor {
    private final KmDeclarationContainerVisitor delegate;

    public KmDeclarationContainerVisitor() {
        this(null, 1, null);
    }

    public KmDeclarationContainerVisitor(KmDeclarationContainerVisitor kmDeclarationContainerVisitor) {
        this.delegate = kmDeclarationContainerVisitor;
    }

    public /* synthetic */ KmDeclarationContainerVisitor(KmDeclarationContainerVisitor kmDeclarationContainerVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmDeclarationContainerVisitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KmDeclarationContainerVisitor getDelegate() {
        return this.delegate;
    }

    public KmFunctionVisitor visitFunction(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmDeclarationContainerVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitFunction(i, name);
        }
        return null;
    }

    public KmPropertyVisitor visitProperty(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmDeclarationContainerVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitProperty(i, name, i2, i3);
        }
        return null;
    }

    public KmTypeAliasVisitor visitTypeAlias(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmDeclarationContainerVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitTypeAlias(i, name);
        }
        return null;
    }

    public KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmDeclarationContainerVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitExtensions(type);
        }
        return null;
    }
}
