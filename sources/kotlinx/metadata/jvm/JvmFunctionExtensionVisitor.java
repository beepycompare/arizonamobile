package kotlinx.metadata.jvm;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmFunctionExtensionVisitor;
/* compiled from: JvmExtensionVisitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/jvm/JvmFunctionExtensionVisitor;", "Lkotlinx/metadata/KmFunctionExtensionVisitor;", "delegate", "(Lkotlinx/metadata/jvm/JvmFunctionExtensionVisitor;)V", "type", "Lkotlinx/metadata/KmExtensionType;", "getType", "()Lkotlinx/metadata/KmExtensionType;", "visit", "", "signature", "Lkotlinx/metadata/jvm/JvmMethodSignature;", "visitEnd", "visitLambdaClassOriginName", "internalName", "", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JvmFunctionExtensionVisitor implements KmFunctionExtensionVisitor {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmFunctionExtensionVisitor.class));
    private final JvmFunctionExtensionVisitor delegate;

    public JvmFunctionExtensionVisitor() {
        this(null, 1, null);
    }

    public JvmFunctionExtensionVisitor(JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor) {
        this.delegate = jvmFunctionExtensionVisitor;
    }

    public /* synthetic */ JvmFunctionExtensionVisitor(JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmFunctionExtensionVisitor);
    }

    @Override // kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visit(JvmMethodSignature jvmMethodSignature) {
        JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor = this.delegate;
        if (jvmFunctionExtensionVisitor != null) {
            jvmFunctionExtensionVisitor.visit(jvmMethodSignature);
        }
    }

    public void visitLambdaClassOriginName(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor = this.delegate;
        if (jvmFunctionExtensionVisitor != null) {
            jvmFunctionExtensionVisitor.visitLambdaClassOriginName(internalName);
        }
    }

    public void visitEnd() {
        JvmFunctionExtensionVisitor jvmFunctionExtensionVisitor = this.delegate;
        if (jvmFunctionExtensionVisitor != null) {
            jvmFunctionExtensionVisitor.visitEnd();
        }
    }

    /* compiled from: JvmExtensionVisitors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/jvm/JvmFunctionExtensionVisitor$Companion;", "", "()V", "TYPE", "Lkotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
