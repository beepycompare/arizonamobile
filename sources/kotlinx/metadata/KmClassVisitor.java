package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Visitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u0017J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\u001b\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006$"}, d2 = {"Lkotlinx/metadata/KmClassVisitor;", "Lkotlinx/metadata/KmDeclarationContainerVisitor;", "delegate", "(Lkotlinx/metadata/KmClassVisitor;)V", "getDelegate", "()Lkotlinx/metadata/KmClassVisitor;", "visit", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "Lkotlinx/metadata/ClassName;", "visitCompanionObject", "visitConstructor", "Lkotlinx/metadata/KmConstructorVisitor;", "visitContextReceiverType", "Lkotlinx/metadata/KmTypeVisitor;", "visitEnd", "visitEnumEntry", "visitExtensions", "Lkotlinx/metadata/KmClassExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "visitInlineClassUnderlyingPropertyName", "visitInlineClassUnderlyingType", "visitNestedClass", "visitSealedSubclass", "visitSupertype", "visitTypeParameter", "Lkotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Lkotlinx/metadata/KmVariance;", "visitVersionRequirement", "Lkotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmClassVisitor extends KmDeclarationContainerVisitor {
    public KmClassVisitor() {
        this(null, 1, null);
    }

    public KmClassVisitor(KmClassVisitor kmClassVisitor) {
        super(kmClassVisitor);
    }

    public /* synthetic */ KmClassVisitor(KmClassVisitor kmClassVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kmClassVisitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.metadata.KmDeclarationContainerVisitor
    public KmClassVisitor getDelegate() {
        return (KmClassVisitor) super.getDelegate();
    }

    public void visit(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visit(i, name);
        }
    }

    public KmTypeParameterVisitor visitTypeParameter(int i, String name, int i2, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitTypeParameter(i, name, i2, variance);
        }
        return null;
    }

    public KmTypeVisitor visitSupertype(int i) {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitSupertype(i);
        }
        return null;
    }

    public KmConstructorVisitor visitConstructor(int i) {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitConstructor(i);
        }
        return null;
    }

    public void visitCompanionObject(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitCompanionObject(name);
        }
    }

    public void visitNestedClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitNestedClass(name);
        }
    }

    public void visitEnumEntry(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitEnumEntry(name);
        }
    }

    public void visitSealedSubclass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitSealedSubclass(name);
        }
    }

    public void visitInlineClassUnderlyingPropertyName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitInlineClassUnderlyingPropertyName(name);
        }
    }

    public KmTypeVisitor visitInlineClassUnderlyingType(int i) {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitInlineClassUnderlyingType(i);
        }
        return null;
    }

    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int i) {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitContextReceiverType(i);
        }
        return null;
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitVersionRequirement();
        }
        return null;
    }

    @Override // kotlinx.metadata.KmDeclarationContainerVisitor
    public KmClassExtensionVisitor visitExtensions(KmExtensionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitExtensions(type);
        }
        return null;
    }

    public void visitEnd() {
        KmClassVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitEnd();
        }
    }
}
