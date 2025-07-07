package kotlinx.metadata.jvm;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmDeclarationContainerExtensionVisitor;
import kotlinx.metadata.KmPropertyVisitor;
/* compiled from: JvmExtensionVisitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J*\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "Lkotlinx/metadata/KmDeclarationContainerExtensionVisitor;", "delegate", "(Lkotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;)V", "getDelegate", "()Lkotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "visitLocalDelegatedProperty", "Lkotlinx/metadata/KmPropertyVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "", "getterFlags", "setterFlags", "visitModuleName", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class JvmDeclarationContainerExtensionVisitor implements KmDeclarationContainerExtensionVisitor {
    private final JvmDeclarationContainerExtensionVisitor delegate;

    public JvmDeclarationContainerExtensionVisitor() {
        this(null, 1, null);
    }

    public JvmDeclarationContainerExtensionVisitor(JvmDeclarationContainerExtensionVisitor jvmDeclarationContainerExtensionVisitor) {
        this.delegate = jvmDeclarationContainerExtensionVisitor;
    }

    public /* synthetic */ JvmDeclarationContainerExtensionVisitor(JvmDeclarationContainerExtensionVisitor jvmDeclarationContainerExtensionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmDeclarationContainerExtensionVisitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JvmDeclarationContainerExtensionVisitor getDelegate() {
        return this.delegate;
    }

    public KmPropertyVisitor visitLocalDelegatedProperty(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        JvmDeclarationContainerExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            return delegate.visitLocalDelegatedProperty(i, name, i2, i3);
        }
        return null;
    }

    public void visitModuleName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        JvmDeclarationContainerExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitModuleName(name);
        }
    }
}
