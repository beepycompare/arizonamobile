package kotlinx.metadata.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmConstructorExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmConstructorExtension;
import kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import kotlinx.metadata.jvm.JvmMethodSignature;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmConstructorExtension;", "Lkotlinx/metadata/jvm/JvmConstructorExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmConstructorExtension;", "()V", "signature", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "getSignature", "()Lkotlinx/metadata/jvm/JvmMethodSignature;", "setSignature", "(Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "accept", "", "visitor", "Lkotlinx/metadata/KmConstructorExtensionVisitor;", "visit", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmConstructorExtension extends JvmConstructorExtensionVisitor implements KmConstructorExtension {
    private JvmMethodSignature signature;

    public JvmConstructorExtension() {
        super(null, 1, null);
    }

    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.jvm.JvmConstructorExtensionVisitor
    public void visit(JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmConstructorExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmConstructorExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ((JvmConstructorExtensionVisitor) visitor).visit(this.signature);
    }
}
