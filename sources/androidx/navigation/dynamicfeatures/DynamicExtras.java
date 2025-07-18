package androidx.navigation.dynamicfeatures;

import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DynamicExtras.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicExtras;", "Landroidx/navigation/Navigator$Extras;", "installMonitor", "Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "destinationExtras", "<init>", "(Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;Landroidx/navigation/Navigator$Extras;)V", "getInstallMonitor", "()Landroidx/navigation/dynamicfeatures/DynamicInstallMonitor;", "getDestinationExtras", "()Landroidx/navigation/Navigator$Extras;", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicExtras implements Navigator.Extras {
    private final Navigator.Extras destinationExtras;
    private final DynamicInstallMonitor installMonitor;

    public DynamicExtras() {
        this(null, null, 3, null);
    }

    public DynamicExtras(DynamicInstallMonitor dynamicInstallMonitor) {
        this(dynamicInstallMonitor, null, 2, null);
    }

    public DynamicExtras(DynamicInstallMonitor dynamicInstallMonitor, Navigator.Extras extras) {
        this.installMonitor = dynamicInstallMonitor;
        this.destinationExtras = extras;
    }

    public /* synthetic */ DynamicExtras(DynamicInstallMonitor dynamicInstallMonitor, Navigator.Extras extras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dynamicInstallMonitor, (i & 2) != 0 ? null : extras);
    }

    public final DynamicInstallMonitor getInstallMonitor() {
        return this.installMonitor;
    }

    public final Navigator.Extras getDestinationExtras() {
        return this.destinationExtras;
    }
}
