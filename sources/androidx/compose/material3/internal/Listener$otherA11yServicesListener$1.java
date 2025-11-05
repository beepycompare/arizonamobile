package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
/* compiled from: AccessibilityServiceStateProvider.android.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u0013"}, d2 = {"androidx/compose/material3/internal/Listener$otherA11yServicesListener$1", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "<set-?>", "", "switchAccessEnabled", "getSwitchAccessEnabled", "()Z", "setSwitchAccessEnabled", "(Z)V", "switchAccessEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "voiceAccessEnabled", "getVoiceAccessEnabled", "setVoiceAccessEnabled", "voiceAccessEnabled$delegate", "onAccessibilityServicesStateChanged", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Listener$otherA11yServicesListener$1 implements AccessibilityManager.AccessibilityServicesStateChangeListener {
    private final MutableState switchAccessEnabled$delegate;
    final /* synthetic */ Listener this$0;
    private final MutableState voiceAccessEnabled$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Listener$otherA11yServicesListener$1(Listener listener) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.this$0 = listener;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.switchAccessEnabled$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.voiceAccessEnabled$delegate = mutableStateOf$default2;
    }

    public final boolean getSwitchAccessEnabled() {
        return ((Boolean) this.switchAccessEnabled$delegate.getValue()).booleanValue();
    }

    public final void setSwitchAccessEnabled(boolean z) {
        this.switchAccessEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getVoiceAccessEnabled() {
        return ((Boolean) this.voiceAccessEnabled$delegate.getValue()).booleanValue();
    }

    public final void setVoiceAccessEnabled(boolean z) {
        this.voiceAccessEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    public void onAccessibilityServicesStateChanged(AccessibilityManager accessibilityManager) {
        boolean switchAccessEnabled;
        boolean voiceAccessEnabled;
        switchAccessEnabled = this.this$0.getSwitchAccessEnabled(accessibilityManager);
        setSwitchAccessEnabled(switchAccessEnabled);
        voiceAccessEnabled = this.this$0.getVoiceAccessEnabled(accessibilityManager);
        setVoiceAccessEnabled(voiceAccessEnabled);
    }
}
