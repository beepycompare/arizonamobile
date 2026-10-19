package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import android.content.Context;
import com.miami.game.core.settings.SettingsMenuDefaults;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: KeyboardKeeper.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/KeyboardKeeper;", "", "<init>", "()V", "isInGameKeyboard", "", "()Z", "setInGameKeyboard", "(Z)V", "notifier", "Ljava/lang/ref/WeakReference;", "Lru/mrlargha/commonui/core/IBackendNotifier;", "getNotifier", "()Ljava/lang/ref/WeakReference;", "setNotifier", "(Ljava/lang/ref/WeakReference;)V", "syncFromSettings", "context", "Landroid/content/Context;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeyboardKeeper {
    private static boolean isInGameKeyboard;
    public static final KeyboardKeeper INSTANCE = new KeyboardKeeper();
    private static WeakReference<IBackendNotifier> notifier = new WeakReference<>(null);

    private KeyboardKeeper() {
    }

    public final boolean isInGameKeyboard() {
        return isInGameKeyboard;
    }

    public final void setInGameKeyboard(boolean z) {
        isInGameKeyboard = z;
    }

    public final WeakReference<IBackendNotifier> getNotifier() {
        return notifier;
    }

    public final void setNotifier(WeakReference<IBackendNotifier> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        notifier = weakReference;
    }

    public final boolean syncFromSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = SettingsMenuDefaults.prefs(context).getInt(SettingsMenuDefaults.KEY_KEYBOARD_TYPE, 0) != 0;
        isInGameKeyboard = z;
        return z;
    }
}
