package kotlinx.metadata.jvm.internal;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmPackageExtensionVisitor;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmPropertyVisitor;
import kotlinx.metadata.internal.extensions.KmPackageExtension;
import kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmPackageExtension;", "Lkotlinx/metadata/jvm/JvmPackageExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmPackageExtension;", "()V", "localDelegatedProperties", "", "Lkotlinx/metadata/KmProperty;", "getLocalDelegatedProperties", "()Ljava/util/List;", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "setModuleName", "(Ljava/lang/String;)V", "accept", "", "visitor", "Lkotlinx/metadata/KmPackageExtensionVisitor;", "visitLocalDelegatedProperty", "Lkotlinx/metadata/KmPropertyVisitor;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "name", "getterFlags", "setterFlags", "visitModuleName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmPackageExtension extends JvmPackageExtensionVisitor implements KmPackageExtension {
    private final List<KmProperty> localDelegatedProperties;
    private String moduleName;

    public JvmPackageExtension() {
        super(null, 1, null);
        this.localDelegatedProperties = new ArrayList(0);
    }

    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }

    @Override // kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public KmPropertyVisitor visitLocalDelegatedProperty(int i, String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        KmProperty kmProperty = new KmProperty(i, name, i2, i3);
        this.localDelegatedProperties.add(kmProperty);
        return kmProperty;
    }

    @Override // kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public void visitModuleName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.moduleName = name;
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmPackageExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmPackageExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (KmProperty kmProperty : this.localDelegatedProperties) {
            KmPropertyVisitor visitLocalDelegatedProperty = ((JvmPackageExtensionVisitor) visitor).visitLocalDelegatedProperty(kmProperty.getFlags(), kmProperty.getName(), kmProperty.getGetter().getFlags$kotlinx_metadata(), kmProperty.getSetterFlags());
            if (visitLocalDelegatedProperty != null) {
                kmProperty.accept(visitLocalDelegatedProperty);
            }
        }
        String str = this.moduleName;
        if (str != null) {
            ((JvmPackageExtensionVisitor) visitor).visitModuleName(str);
        }
        ((JvmPackageExtensionVisitor) visitor).visitEnd();
    }
}
