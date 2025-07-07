package kotlinx.metadata.jvm;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.metadata.KmClassExtensionVisitor;
import kotlinx.metadata.KmExtensionType;
/* compiled from: JvmExtensionVisitors.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Visitor API is deprecated as excessive and cumbersome. Please use nodes (such as KmClass) and their properties.")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/jvm/JvmClassExtensionVisitor;", "Lkotlinx/metadata/KmClassExtensionVisitor;", "Lkotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "delegate", "(Lkotlinx/metadata/jvm/JvmClassExtensionVisitor;)V", "getDelegate", "()Lkotlinx/metadata/jvm/JvmClassExtensionVisitor;", "type", "Lkotlinx/metadata/KmExtensionType;", "getType", "()Lkotlinx/metadata/KmExtensionType;", "visitAnonymousObjectOriginName", "", "internalName", "", "visitEnd", "visitJvmFlags", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "Companion", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JvmClassExtensionVisitor extends JvmDeclarationContainerExtensionVisitor implements KmClassExtensionVisitor {
    public static final Companion Companion = new Companion(null);
    public static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmClassExtensionVisitor.class));

    public JvmClassExtensionVisitor() {
        this(null, 1, null);
    }

    public /* synthetic */ JvmClassExtensionVisitor(JvmClassExtensionVisitor jvmClassExtensionVisitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jvmClassExtensionVisitor);
    }

    public JvmClassExtensionVisitor(JvmClassExtensionVisitor jvmClassExtensionVisitor) {
        super(jvmClassExtensionVisitor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public JvmClassExtensionVisitor getDelegate() {
        return (JvmClassExtensionVisitor) super.getDelegate();
    }

    @Override // kotlinx.metadata.KmExtensionVisitor
    public final KmExtensionType getType() {
        return TYPE;
    }

    public void visitAnonymousObjectOriginName(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        JvmClassExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitAnonymousObjectOriginName(internalName);
        }
    }

    public void visitJvmFlags(int i) {
        JvmClassExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitJvmFlags(i);
        }
    }

    public void visitEnd() {
        JvmClassExtensionVisitor delegate = getDelegate();
        if (delegate != null) {
            delegate.visitEnd();
        }
    }

    /* compiled from: JvmExtensionVisitors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/jvm/JvmClassExtensionVisitor$Companion;", "", "()V", "TYPE", "Lkotlinx/metadata/KmExtensionType;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
