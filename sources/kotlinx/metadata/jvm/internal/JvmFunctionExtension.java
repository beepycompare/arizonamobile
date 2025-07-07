package kotlinx.metadata.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmFunctionExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmFunctionExtension;
import kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import kotlinx.metadata.jvm.JvmMethodSignature;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmFunctionExtension;", "Lkotlinx/metadata/jvm/JvmFunctionExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmFunctionExtension;", "()V", "lambdaClassOriginName", "", "getLambdaClassOriginName", "()Ljava/lang/String;", "setLambdaClassOriginName", "(Ljava/lang/String;)V", "signature", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "getSignature", "()Lkotlinx/metadata/jvm/JvmMethodSignature;", "setSignature", "(Lkotlinx/metadata/jvm/JvmMethodSignature;)V", "accept", "", "visitor", "Lkotlinx/metadata/KmFunctionExtensionVisitor;", "visit", "visitLambdaClassOriginName", "internalName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmFunctionExtension extends JvmFunctionExtensionVisitor implements KmFunctionExtension {
    private String lambdaClassOriginName;
    private JvmMethodSignature signature;

    public JvmFunctionExtension() {
        super(null, 1, null);
    }

    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    public final String getLambdaClassOriginName() {
        return this.lambdaClassOriginName;
    }

    public final void setLambdaClassOriginName(String str) {
        this.lambdaClassOriginName = str;
    }

    @Override // kotlinx.metadata.jvm.JvmFunctionExtensionVisitor
    public void visit(JvmMethodSignature jvmMethodSignature) {
        this.signature = jvmMethodSignature;
    }

    @Override // kotlinx.metadata.jvm.JvmFunctionExtensionVisitor
    public void visitLambdaClassOriginName(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        this.lambdaClassOriginName = internalName;
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmFunctionExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmFunctionExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor = (JvmFunctionExtensionVisitor) visitor;
        jvmFunctionExtensionVisitor.visit(this.signature);
        String str = this.lambdaClassOriginName;
        if (str != null) {
            jvmFunctionExtensionVisitor.visitLambdaClassOriginName(str);
        }
        jvmFunctionExtensionVisitor.visitEnd();
    }
}
