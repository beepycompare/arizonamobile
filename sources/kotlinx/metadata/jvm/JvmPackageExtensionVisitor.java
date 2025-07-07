package kotlinx.metadata.jvm;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmPackageExtensionVisitor;
/* compiled from: JvmExtensionVisitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\u0013\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/metadata/jvm/JvmPackageExtensionVisitor;", "Lkotlinx/metadata/KmPackageExtensionVisitor;", "Lkotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "delegate", "(Lkotlinx/metadata/jvm/JvmPackageExtensionVisitor;)V", "getDelegate", "()Lkotlinx/metadata/jvm/JvmPackageExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "getType", "()Lkotlinx/metadata/KmExtensionType;", "visitEnd", "", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JvmPackageExtensionVisitor extends JvmDeclarationContainerExtensionVisitor implements KmPackageExtensionVisitor {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmPackageExtensionVisitor.class));

    public JvmPackageExtensionVisitor() {
        this(null, 1, null);
    }

    public /* synthetic */ JvmPackageExtensionVisitor(JvmPackageExtensionVisitor jvmPackageExtensionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmPackageExtensionVisitor);
    }

    public JvmPackageExtensionVisitor(JvmPackageExtensionVisitor jvmPackageExtensionVisitor) {
        super(jvmPackageExtensionVisitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public JvmPackageExtensionVisitor getDelegate() {
        return (JvmPackageExtensionVisitor) super.getDelegate();
    }

    @Override // kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visitEnd() {
        JvmPackageExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitEnd();
        }
    }

    /* compiled from: JvmExtensionVisitors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/jvm/JvmPackageExtensionVisitor$Companion;", "", "()V", "TYPE", "Lkotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
