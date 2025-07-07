package ru.mrlargha.commonui.elements.authorization.presentation;

import android.app.Activity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.News;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.SpawnMenu;
/* compiled from: InterfaceManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceManager;", "", "<init>", "()V", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InterfaceManager {
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Integer, InterfaceController> interfaces = new HashMap<>();

    /* compiled from: InterfaceManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceManager$Companion;", "", "<init>", "()V", "interfaces", "Ljava/util/HashMap;", "", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "Lkotlin/collections/HashMap;", "putInterface", "", "viedId", "controller", "removeInterface", "getOrCreateInterface", "viewId", "targetActivity", "Landroid/app/Activity;", "backendID", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void putInterface(int i, InterfaceController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            InterfaceManager.interfaces.put(Integer.valueOf(i), controller);
        }

        public final InterfaceController removeInterface(int i) {
            return (InterfaceController) InterfaceManager.interfaces.remove(Integer.valueOf(i));
        }

        public final InterfaceController getOrCreateInterface(int i, Activity targetActivity, int i2) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            InterfaceController interfaceController = (InterfaceController) InterfaceManager.interfaces.get(Integer.valueOf(i));
            if (interfaceController == null) {
                HashMap hashMap = InterfaceManager.interfaces;
                if (i == RegistrationInterfaceType.VIDEO_BACKGROUND.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RegistrationVideoBackground(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.AUTH_INIT.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new Authorization(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.REGISTRATION_INIT.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RegistrationAccount(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.REGISTRATION_PED_SETTINGS.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RegistrationPedSettings(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.RECOVERY_HANDLER.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RecoveryHandler(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.RECOVERY_METHOD.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RecoveryMethod(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.RECOVERY_FINAL.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new RecoveryFinal(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.SPAWN_SELECTOR.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new SpawnMenu(targetActivity, i2));
                } else if (i == RegistrationInterfaceType.AUTHORIZATION_NEWS.getId()) {
                    InterfaceManager.interfaces.put(Integer.valueOf(i), new News(targetActivity, i2));
                }
                Object obj = hashMap.get(Integer.valueOf(i));
                Intrinsics.checkNotNull(obj);
                return (InterfaceController) obj;
            }
            return interfaceController;
        }
    }
}
