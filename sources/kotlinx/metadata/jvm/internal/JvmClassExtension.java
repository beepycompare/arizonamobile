package kotlinx.metadata.jvm.internal;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClassExtensionVisitor;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmPropertyVisitor;
import kotlinx.metadata.internal.extensions.KmClassExtension;
import kotlinx.metadata.jvm.JvmClassExtensionVisitor;
/* compiled from: JvmExtensionNodes.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J(\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006&"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmClassExtension;", "Lkotlinx/metadata/jvm/JvmClassExtensionVisitor;", "Lkotlinx/metadata/internal/extensions/KmClassExtension;", "()V", "anonymousObjectOriginName", "", "getAnonymousObjectOriginName", "()Ljava/lang/String;", "setAnonymousObjectOriginName", "(Ljava/lang/String;)V", "jvmFlags", "", "getJvmFlags", "()I", "setJvmFlags", "(I)V", "localDelegatedProperties", "", "Lkotlinx/metadata/KmProperty;", "getLocalDelegatedProperties", "()Ljava/util/List;", "moduleName", "getModuleName", "setModuleName", "accept", "", "visitor", "Lkotlinx/metadata/KmClassExtensionVisitor;", "visitAnonymousObjectOriginName", "internalName", "visitJvmFlags", DownloaderServiceMarshaller.PARAMS_FLAGS, "visitLocalDelegatedProperty", "Lkotlinx/metadata/KmPropertyVisitor;", "name", "getterFlags", "setterFlags", "visitModuleName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmClassExtension extends JvmClassExtensionVisitor implements KmClassExtension {
    private String anonymousObjectOriginName;
    private int jvmFlags;
    private final List<KmProperty> localDelegatedProperties;
    private String moduleName;

    public JvmClassExtension() {
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

    public final String getAnonymousObjectOriginName() {
        return this.anonymousObjectOriginName;
    }

    public final void setAnonymousObjectOriginName(String str) {
        this.anonymousObjectOriginName = str;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
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

    @Override // kotlinx.metadata.jvm.JvmClassExtensionVisitor
    public void visitAnonymousObjectOriginName(String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        this.anonymousObjectOriginName = internalName;
    }

    @Override // kotlinx.metadata.jvm.JvmClassExtensionVisitor
    public void visitJvmFlags(int i) {
        this.jvmFlags = i;
    }

    @Override // kotlinx.metadata.internal.extensions.KmExtension
    public void accept(KmClassExtensionVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (!(visitor instanceof JvmClassExtensionVisitor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (KmProperty kmProperty : this.localDelegatedProperties) {
            KmPropertyVisitor visitLocalDelegatedProperty = ((JvmClassExtensionVisitor) visitor).visitLocalDelegatedProperty(kmProperty.getFlags(), kmProperty.getName(), kmProperty.getGetter().getFlags$kotlinx_metadata(), kmProperty.getSetterFlags());
            if (visitLocalDelegatedProperty != null) {
                kmProperty.accept(visitLocalDelegatedProperty);
            }
        }
        String str = this.moduleName;
        if (str != null) {
            ((JvmClassExtensionVisitor) visitor).visitModuleName(str);
        }
        String str2 = this.anonymousObjectOriginName;
        if (str2 != null) {
            ((JvmClassExtensionVisitor) visitor).visitAnonymousObjectOriginName(str2);
        }
        Integer valueOf = Integer.valueOf(this.jvmFlags);
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            ((JvmClassExtensionVisitor) visitor).visitJvmFlags(valueOf.intValue());
        }
        ((JvmClassExtensionVisitor) visitor).visitEnd();
    }
}
