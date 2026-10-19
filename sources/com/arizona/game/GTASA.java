package com.arizona.game;

import android.app.Activity;
import android.app.GameManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.preference.PreferenceManager;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arizona.game.core.GameSettingsProvider;
import com.arizona.game.core.JNIActivity;
import com.arizona.game.diagnostics.CrashReportingController;
import com.arizona.launcher.data.repository.settings.NotifyChecker;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import com.arizona.launcher.data.repository.settings.SoundChecker;
import com.arizona.launcher.util.FlavorUtilKt;
import com.arizona.launcher.util.ProjectLocale;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.miami.game.core.settings.SettingsMenuDefaults;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import org.json.JSONException;
import org.json.JSONObject;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementFactory;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.core.UIElementStore;
import ru.mrlargha.commonui.core.cache.UIElementEvictionReason;
import ru.mrlargha.commonui.elements.ArizonaSnackbar;
import ru.mrlargha.commonui.elements.EmptyScreen;
import ru.mrlargha.commonui.elements.InputPopup;
import ru.mrlargha.commonui.elements.InputStorage;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationServerResponse;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings;
import ru.mrlargha.commonui.elements.azvoice.SoundSliderData;
import ru.mrlargha.commonui.elements.binder.CommandBinder;
import ru.mrlargha.commonui.elements.dialogs.AbstractDialog;
import ru.mrlargha.commonui.elements.dialogs.DialogFactory;
import ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider;
import ru.mrlargha.commonui.elements.dialogs.playerlist.Player;
import ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog;
import ru.mrlargha.commonui.elements.hud.presentation.Hud;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener;
import ru.mrlargha.commonui.elements.items3d.ItemScene;
import ru.mrlargha.commonui.elements.items3d.ListenerKt;
import ru.mrlargha.commonui.elements.items3d.Position;
import ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.KeyboardKeeper;
import ru.mrlargha.commonui.elements.video.StreamVideo;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.metrics.MetricsFunsKt;
import ru.mrlargha.feature.common_factory.CommonElementsFactory;
/* loaded from: classes3.dex */
public class GTASA extends JNIActivity implements GameSettingsProvider, CustomKeyboard.InputListener, CommandBinder.BinderListener, IBackendNotifier, IAutocompleteStateProvider, ArizonaSnackbar.SnackBarListener, HudListener, ItemScene {
    private static final String BROKEN_ANDROID_ID = "9774d56d682e549c";
    private static final int GUN_WORKSHOP_INVENTORY_TYPE = 28;
    private static final int STANDARD_WORKSHOP_INVENTORY_TYPE = 5;
    private static final String TAG = "GTASAMainClass";
    private static GTASA _instance;
    private boolean _isSimple;
    private CrashReportingController crashReportingController;
    private OnBackInvokedCallback gameBackCallback;
    private ModsOverlayController modsOverlayController;
    private ModsStartupController modsStartupController;
    SharedPreferences settings;
    public SettingsRepository settingsRepository;
    private final UIElementStore uiElementStore;
    private WebViewHandler webViewHandler;
    private volatile String resourceOverlayConfig = "{}";
    private InputPopup inputPopup = null;
    private InputStorage inputStorage = null;
    private RequestQueue preflightRequestQueue = null;
    private boolean full_screen = true;
    private boolean isKeyboardInstalled = false;
    private boolean isInGameKeyboard = false;
    private boolean wasImeVisible = false;
    private int voiceSettingPagination = 0;
    private boolean isInit = false;
    private boolean isAutocompleteEnabled = true;
    private final LinkedList<Player> playerLinkedList = new LinkedList<>();
    private int tagChatType = 0;
    private String lastString = null;
    private int lastHeight = 0;
    SoundChecker soundChecker = null;
    NotifyChecker notifyChecker = null;
    private StreamVideo streamVideo = null;
    private ArizonaSnackbar arizonaSnackbar = null;
    private String snackbarJson = "";
    private GameTestBackendHarnessController gameTestBackendHarness = null;
    private Boolean isHudEnabled = true;
    @Deprecated
    private final ConcurrentHashMap<Integer, SAMPUIElement> uiElements = new ConcurrentHashMap<>();

    private native void InitSetting(boolean utf8_supported, int interface_count, String model_name, String notify_hash, String channels_type, String device_id);

    private native void OnInputEnd(String str);

    private native void OnKeyboardClosed();

    private native void OnKeyboardShowed();

    private native void RequestHudLayout();

    private native void TrimMemory(int level);

    private native void clicked(int viewBackendID, int elementID, int subID, byte[] payload);

    private native float getLocalVehicleSpeed();

    public native int getModificationSources();

    public static /* synthetic */ void lambda$OnPlayerState$47() {
    }

    public static /* synthetic */ void lambda$PlayVibration$44() {
    }

    private native void onDialogResponse(int dialogID, int responseButtonID, int listItemID, byte[] inputText);

    private native void sliderValueChanged(int viewBackendID, int elementID, int value);

    private native void switchStatusChanged(int viewBackendID, int elementID, boolean state);

    private native void viewShownStatusChanged(int viewBackendID, boolean shown);

    public native void Cef3DAddModel(int model, boolean isSimple);

    public native void Cef3DRemoveModels();

    public native void Cef3DRotateModel(int model, boolean isSimple, float x, float y, float z);

    public native void Cef3DScaleModel(int model, boolean isSimple, float scale);

    public native void Cef3DSetBackground(String txd, String texture, int x, int y, int width, int height);

    public native void Cef3DSetDirty(int model, boolean isSimple, byte dirty);

    public native void Cef3DSetVehicleColors(int model, byte main, byte second);

    public native void Cef3DSetVehicleComponent(int model, int component, boolean isSimple, boolean remove);

    public native void Cef3DSetVehicleWear(int model, byte wear);

    public native void Cef3DSetupScene(int x, int y, int width, int height, int frameRate, byte red, byte green, byte blue);

    public void SetDonateJsonURL(String text) {
    }

    native void SetHudScale(float hud, float speedometer);

    /* renamed from: SetHudTimer */
    public native void lambda$hudSetTimer$69(int seconds);

    /* renamed from: SetHudTimer2 */
    public native void lambda$hudSetTimer2$70(int seconds, int maxTime, int type);

    @Override // com.arizona.game.core.JNIActivity
    protected boolean deferGameSurfaceCreation() {
        return true;
    }

    public void removePLayerFromList(int id) {
    }

    public void updatePlayerInList(int id, byte[] name, int level, int ping, int color) {
    }

    public GTASA() {
        UIElementStore uIElementStore = new UIElementStore(this);
        this.uiElementStore = uIElementStore;
        this.webViewHandler = null;
        initializeProjectRuntimeFlags();
        uIElementStore.addFactory(new CommonElementsFactory());
        try {
            if (UtilsKt.isArizonaType()) {
                uIElementStore.addFactory((UIElementFactory) Class.forName("ru.mrlargha.arizonaui.ArizonaUIElementFactory").newInstance());
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            Log.i(TAG, "Unable to create ArizonaUIElement factory, maybe this is Rodina build");
        }
        try {
            if (!UtilsKt.isArizonaType()) {
                Log.i(TAG, "Unable to create ArizonaUIElement factory, maybe this is Rodina build");
                this.uiElementStore.addFactory((UIElementFactory) Class.forName("ru.mrlargha.rodina_ui.RodinaUIElementsFactory").newInstance());
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused2) {
            Log.i(TAG, "Unable to create RodinaUIElementsFactory factory, maybe this is Arizona build");
        }
        this._isSimple = false;
    }

    static {
        try {
            System.loadLibrary("ag-client");
        } catch (Throwable th) {
            Log.e(TAG, "Failed to preload ag-client", th);
        }
        _instance = null;
    }

    @Override // com.arizona.game.core.GameSettingsProvider
    public String getResourceOverlayConfigJson() {
        return this.resourceOverlayConfig;
    }

    /* loaded from: classes3.dex */
    public enum PlayerData {
        HEALTH(0),
        ARMOR(1),
        SATIETY(2),
        MONEY(3);
        
        private final int id;

        PlayerData(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ProjectLocale.wrap(newBase));
    }

    private void initializeProjectRuntimeFlags() {
        UtilsKt.set_isArizonaType(FlavorUtilKt.isArizona());
        UtilsKt.set_isBrazilType(FlavorUtilKt.isBrazil());
        UtilsKt.set_isDebug(false);
    }

    public FrameLayout getRootView() {
        return this.mRootView;
    }

    public void onJsonReceived(final String json) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA.1
            {
                GTASA.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GTASA.this.webViewHandler.onJsonDataIncoming(json);
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        Log.w("MemoryTrim", "onTrimMemory called with level: " + level);
        if (level == 5) {
            Log.w("MemoryTrim", "Memory running moderate. Consider freeing non-critical resources.");
        } else if (level == 10) {
            Log.w("MemoryTrim", "Memory running low. Free non-essential resources.");
        } else if (level == 15) {
            Log.w("MemoryTrim", "Memory running critically low. Free as many resources as possible.");
        } else if (level == 20) {
            Log.w("MemoryTrim", "UI is now hidden. Freeing UI-related resources.");
        } else if (level == 40) {
            Log.w("MemoryTrim", "App in background. Release background resources if possible.");
        } else if (level == 60) {
            Log.w("MemoryTrim", "Moderate memory usage while backgrounded. Release some resources.");
        } else if (level == 80) {
            Log.w("MemoryTrim", "App not a priority. Release as many resources as possible.");
        } else {
            Log.w("MemoryTrim", "Unknown memory trim level: " + level);
        }
        if (level >= 5 && level != 20) {
            this.uiElementStore.trimHiddenElements();
        }
        try {
            TrimMemory(level);
        } catch (LinkageError e) {
            Log.e("MemoryTrim", "Unable to call native TrimMemory method", e);
        }
        super.onTrimMemory(level);
    }

    @Override // com.arizona.game.core.JNIActivity, android.app.Activity
    public void onCreate(Bundle paramBundle) {
        ProjectLocale.applyDefault();
        super.onCreate(paramBundle);
        initializeProjectRuntimeFlags();
        Log.w("PhoneInfo", "Manufacturer:" + Build.MANUFACTURER);
        Log.w("PhoneInfo", "Model:" + Build.MODEL);
        Log.w("PhoneInfo", "ABI:" + Build.CPU_ABI);
        Log.w("PhoneInfo", "Total Memory (RAM):" + Runtime.getRuntime().totalMemory());
        _instance = this;
        this.webViewHandler = new WebViewHandler(this);
        this.soundChecker = new SoundChecker(this);
        this.notifyChecker = new NotifyChecker(this);
        syncKeyboardTypeFromSettings();
        hideSystemUI();
        installWindowInsetsListener();
        EmojiCompat.init(new BundledEmojiCompatConfig(this));
        SharedPreferences prefs = SettingsMenuDefaults.prefs(this);
        this.settingsRepository = new SettingsRepository();
        this.full_screen = prefs.getBoolean(SettingsMenuDefaults.KEY_FULL_SCREEN, true);
        FullScreenCall();
        if (Build.VERSION.SDK_INT >= 31) {
            Log.d(TAG, "onCreate: gameMode" + ((GameManager) getSystemService(GameManager.class)).getGameMode());
        }
        this.inputStorage = new InputStorage(this);
        InputPopup inputPopup = new InputPopup(this, -1);
        this.inputPopup = inputPopup;
        inputPopup.setVisibility(false);
        this.uiElements.put(Integer.valueOf(UIElementID.COMMAND_BINDER.getId()), new CommandBinder(this, UIElementID.COMMAND_BINDER.getId()));
        FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putString("Version:", BuildConfig.VERSION_NAME).putString("Package:", BuildConfig.APPLICATION_ID).build());
        this.uiElements.put(Integer.valueOf(UIElementID.INVENTORY.getId()), new EmptyScreen(this, UIElementID.INVENTORY.getId()));
        this.gameTestBackendHarness = GameTestBackendHarnessController.create(this);
        getWindow().getDecorView().post(new GTASA$$ExternalSyntheticLambda29(this));
        if (Build.VERSION.SDK_INT >= 33) {
            this.gameBackCallback = new OnBackInvokedCallback() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda50
                public final void onBackInvoked() {
                    GTASA.this.handleGameBack();
                }
            };
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.gameBackCallback);
        }
        CrashReportingController crashReportingController = new CrashReportingController(this, new IntSupplier() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda51
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                int modificationSources;
                modificationSources = GTASA.this.getModificationSources();
                return modificationSources;
            }
        });
        this.crashReportingController = crashReportingController;
        crashReportingController.start(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$onCreate$2();
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$2() {
        this.modsStartupController = ModsStartupController.create(this, this.mRootView, new Consumer() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda70
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GTASA.this.lambda$onCreate$1((String) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$1(String str) {
        this.resourceOverlayConfig = str;
        if (!"{}".equals(str)) {
            this.modsOverlayController = ModsOverlayController.create(this, str);
        }
        CrashReportingController crashReportingController = this.crashReportingController;
        if (crashReportingController != null) {
            crashReportingController.start(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    GTASA.this.startGameSurface();
                }
            });
        }
    }

    @Override // com.arizona.game.core.JNIActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.uiElementStore.onDisplayConfigurationChanged();
        this.uiElements.values().forEach(new Consumer() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda16
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((SAMPUIElement) obj).onDisplayConfigurationChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arizona.game.core.JNIActivity, android.app.Activity
    public void onDestroy() {
        CrashReportingController crashReportingController = this.crashReportingController;
        if (crashReportingController != null) {
            crashReportingController.destroy();
            this.crashReportingController = null;
        }
        ModsOverlayController modsOverlayController = this.modsOverlayController;
        if (modsOverlayController != null) {
            modsOverlayController.destroy();
            this.modsOverlayController = null;
        }
        ModsStartupController modsStartupController = this.modsStartupController;
        if (modsStartupController != null) {
            modsStartupController.destroy();
            this.modsStartupController = null;
        }
        if (Build.VERSION.SDK_INT >= 33 && this.gameBackCallback != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.gameBackCallback);
            this.gameBackCallback = null;
        }
        GameTestBackendHarnessController gameTestBackendHarnessController = this.gameTestBackendHarness;
        if (gameTestBackendHarnessController != null) {
            gameTestBackendHarnessController.destroy();
        }
        StreamVideo streamVideo = this.streamVideo;
        if (streamVideo != null) {
            streamVideo.destroy();
            this.streamVideo = null;
        }
        ArizonaSnackbar arizonaSnackbar = this.arizonaSnackbar;
        if (arizonaSnackbar != null) {
            arizonaSnackbar.destroy();
            this.arizonaSnackbar = null;
        }
        this.uiElements.values().forEach(new Consumer() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda75
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GTASA.lambda$onDestroy$3((SAMPUIElement) obj);
            }
        });
        this.uiElements.clear();
        this.uiElementStore.clearForHostDestroy();
        super.onDestroy();
    }

    public static /* synthetic */ void lambda$onDestroy$3(SAMPUIElement sAMPUIElement) {
        try {
            sAMPUIElement.onRemovedFromStore(UIElementEvictionReason.HOST_DESTROY);
        } catch (Exception e) {
            Log.w(TAG, "Unable to dispose legacy UI element", e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        handleGameBack();
    }

    public void handleGameBack() {
        ModsOverlayController modsOverlayController = this.modsOverlayController;
        if ((modsOverlayController == null || !modsOverlayController.isModalOpen()) && this.isKeyboardInstalled && this.isInGameKeyboard) {
            CloseAll();
        }
    }

    public String GetReferrerString() {
        SharedPreferences sharedPreferences = getSharedPreferences("SP_NAME", 0);
        this.settings = sharedPreferences;
        return MetricsFunsKt.toNormalReferrer(sharedPreferences.getString("referrerUrl", ""));
    }

    public String GetAbstractionVersion() {
        return "(engine) 2.1 - v17.8.8";
    }

    public void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
    }

    private void installWindowInsetsListener() {
        View decorView = getWindow().getDecorView();
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda27
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat lambda$installWindowInsetsListener$5;
                lambda$installWindowInsetsListener$5 = GTASA.this.lambda$installWindowInsetsListener$5(view, windowInsetsCompat);
                return lambda$installWindowInsetsListener$5;
            }
        });
        ViewCompat.requestApplyInsets(decorView);
    }

    public /* synthetic */ WindowInsetsCompat lambda$installWindowInsetsListener$5(final View view, WindowInsetsCompat windowInsetsCompat) {
        boolean isVisible = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime());
        if (this.wasImeVisible && !isVisible) {
            view.post(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda61
                @Override // java.lang.Runnable
                public final void run() {
                    GTASA.this.lambda$installWindowInsetsListener$4(view);
                }
            });
        }
        this.wasImeVisible = isVisible;
        return windowInsetsCompat;
    }

    /* renamed from: closeCustomKeyboardAfterImeDismissal */
    public void lambda$installWindowInsetsListener$4(View view) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if ((rootWindowInsets == null || !rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) && this.isKeyboardInstalled && !this.isInGameKeyboard) {
            SAMPUIElement sAMPUIElement = this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()));
            if (!(sAMPUIElement instanceof CustomKeyboard) || ((CustomKeyboard) sAMPUIElement).getUniqueState()) {
                return;
            }
            CloseAll();
        }
    }

    public void FullScreenCall() {
        if (this.full_screen) {
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().getAttributes().layoutInDisplayCutoutMode = 3;
            } else if (Build.VERSION.SDK_INT >= 28) {
                getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public String getPlayerNickname() {
        return this.settingsRepository.getNickname();
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void destroyDialog() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda74
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$destroyDialog$6();
            }
        });
    }

    public /* synthetic */ void lambda$destroyDialog$6() {
        setUIElementVisible(UIElementID.DIALOG.getId(), false);
        if (!this.uiElements.containsKey(Integer.valueOf(UIElementID.DIALOG.getId())) || this.uiElements.get(Integer.valueOf(UIElementID.DIALOG.getId())) == null) {
            return;
        }
        ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.DIALOG.getId())))).removeFromLayout();
        this.uiElements.remove(Integer.valueOf(UIElementID.DIALOG.getId()));
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void inputFinished(String input, int destinationElementID) {
        if (destinationElementID <= 0 || !this.uiElements.containsKey(Integer.valueOf(destinationElementID))) {
            return;
        }
        ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(destinationElementID)))).consumeUserInput(input);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void requestInput(int elementID, boolean password, String bindText) {
        this.inputPopup.bindID(elementID, password, bindText);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void requestRemoveUIElement(final SAMPUIElement element) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$requestRemoveUIElement$7(element);
            }
        });
    }

    public /* synthetic */ void lambda$requestRemoveUIElement$7(SAMPUIElement sAMPUIElement) {
        if (this.uiElementStore.isHostActive()) {
            this.uiElementStore.removeElement(sAMPUIElement);
        }
    }

    private void OnInputEndWrapper(final String str) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnInputEndWrapper$8(str);
            }
        });
    }

    public /* synthetic */ void lambda$OnInputEndWrapper$8(String str) {
        try {
            OnInputEnd(str);
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    private String getUniqueID() {
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
        String string = sharedPreferences.getString("uniqueID", null);
        if (string == null) {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("uniqueID", uuid);
            edit.apply();
            return uuid;
        }
        return string;
    }

    private String getHwidSourceId() {
        try {
            String string = Settings.Secure.getString(getContentResolver(), "android_id");
            if (string != null && !string.trim().isEmpty()) {
                if (!string.equals("9774d56d682e549c")) {
                    return string;
                }
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Unable to get Android ID", e);
        }
        return getUniqueID();
    }

    public void preflightServer(final String host) {
        if (host == null || !host.matches("[A-Za-z0-9.-]{1,32}")) {
            Log.w(TAG, "Ignoring invalid preflight host");
        } else {
            runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    GTASA.this.lambda$preflightServer$12(host);
                }
            });
        }
    }

    public /* synthetic */ void lambda$preflightServer$12(String str) {
        if (this.preflightRequestQueue == null) {
            this.preflightRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        final String str2 = "Arizona Mobile: " + FlavorUtilKt.isArizona();
        for (int i = 0; i < 5; i++) {
            long j = i * 300;
            int[] iArr = {80, 825};
            for (int i2 = 0; i2 < 2; i2++) {
                final String str3 = "http://" + str + StringUtils.PROCESS_POSTFIX_DELIMITER + iArr[i2] + "/";
                getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda37
                    @Override // java.lang.Runnable
                    public final void run() {
                        GTASA.this.lambda$preflightServer$11(str3, str2);
                    }
                }, j);
            }
        }
    }

    public /* synthetic */ void lambda$preflightServer$11(String str, final String str2) {
        StringRequest stringRequest = new StringRequest(0, str, new Response.Listener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda63
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                String str3 = (String) obj;
                Log.d(GTASA.TAG, "Server preflight succeeded");
            }
        }, new Response.ErrorListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda64
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                Log.d(GTASA.TAG, "Server preflight failed");
            }
        }) { // from class: com.arizona.game.GTASA.2
            {
                GTASA.this = this;
            }

            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                return Collections.singletonMap(HttpHeaders.USER_AGENT, str2);
            }
        };
        stringRequest.setShouldCache(false);
        this.preflightRequestQueue.add(stringRequest);
    }

    private void InitSettingWrapper() {
        try {
            String channelsState = FirebaseConfigHelper.INSTANCE.getChannelsState();
            String str = Build.MANUFACTURER + StringUtils.PROCESS_POSTFIX_DELIMITER + Build.MODEL + StringUtils.PROCESS_POSTFIX_DELIMITER + getUniqueID() + StringUtils.PROCESS_POSTFIX_DELIMITER + (this.notifyChecker.isNotificationEnabled() ? "notify_on" : "notify_off");
            String hwidSourceId = getHwidSourceId();
            String string = PreferenceManager.getDefaultSharedPreferences(this).getString("token", "");
            Log.i("InitSettingWrapper", "InitSetting called with the following arguments:\n1. Utf8 support: false\n2. Version: (release) 2.1 - v17.8.8\n3. Last element ID: " + UIElementID.getLastUIElementID() + "\n4. Device name: " + str + "\n5. Token: " + string + "\n6. Channels state: " + channelsState);
            InitSetting(false, UIElementID.getLastUIElementID(), str, string, channelsState, hwidSourceId);
            FirebaseCrashlytics.getInstance().setUserId(getUniqueID());
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public void OnKeyboardShowedWrapper() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnKeyboardShowedWrapper$13();
            }
        });
    }

    public /* synthetic */ void lambda$OnKeyboardShowedWrapper$13() {
        try {
            OnKeyboardShowed();
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public void OnOnKeyboardClosedWrapper() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnOnKeyboardClosedWrapper$14();
            }
        });
    }

    public /* synthetic */ void lambda$OnOnKeyboardClosedWrapper$14() {
        try {
            OnKeyboardClosed();
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public static GTASA getInstance() {
        return _instance;
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void sliderValueChangedWrapper(final int viewBackendID, final int elementID, final int value) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$sliderValueChangedWrapper$15(viewBackendID, elementID, value);
            }
        });
    }

    public /* synthetic */ void lambda$sliderValueChangedWrapper$15(int i, int i2, int i3) {
        try {
            sliderValueChanged(i, i2, i3);
        } catch (LinkageError e) {
            Log.w(TAG, "sliderValueChangedWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void onDialogResponseWrapper(final int dialogID, final int responseButtonID, final int listItemID, final byte[] inputText) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda73
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$onDialogResponseWrapper$16(dialogID, responseButtonID, listItemID, inputText);
            }
        });
    }

    public /* synthetic */ void lambda$onDialogResponseWrapper$16(int i, int i2, int i3, byte[] bArr) {
        try {
            onDialogResponse(i, i2, i3, bArr);
        } catch (LinkageError e) {
            Log.w(TAG, "onDialogResponseWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void clickedWrapper(final int viewBackendID, final int elementID, final int subID, final byte[] payload) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda77
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$clickedWrapper$17(payload, viewBackendID, elementID, subID);
            }
        });
    }

    public /* synthetic */ void lambda$clickedWrapper$17(byte[] bArr, int i, int i2, int i3) {
        try {
            try {
                FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putInt("clickedWrapper_viewBackendID", i).putInt("clickedWrapper_elementID", i2).putInt("clickedWrapper_subID", i3).putString("clickedWrapper_payload", new String(bArr).contains(HintConstants.AUTOFILL_HINT_PASSWORD) ? "" : new String(bArr)).build());
            } catch (IllegalStateException e) {
                Log.w(TAG, "clickedWrapper: we couldn't find instance from crashlytics " + e);
            }
            clicked(i, i2, i3, bArr);
        } catch (LinkageError e2) {
            Log.w(TAG, "Exception during call clicked, uiID:" + i + ", buttonID: " + i2 + ", subID" + i3 + ", payload:" + new String(bArr), e2);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void clickedWrapper(final int viewBackendID, final int elementID, final int subID) {
        if (FlavorUtilKt.isDebug()) {
            Log.d(TAG, "Frontend click:" + viewBackendID + ", id: " + elementID + ", subID" + subID);
        }
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$clickedWrapper$18(viewBackendID, elementID, subID);
            }
        });
    }

    public /* synthetic */ void lambda$clickedWrapper$18(int i, int i2, int i3) {
        try {
            try {
                FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putInt("clickedWrapper_viewBackendID", i).putInt("clickedWrapper_elementID", i2).putInt("clickedWrapper_subID", i3).build());
            } catch (IllegalStateException e) {
                Log.w(TAG, "clickedWrapper: we couldn't find instance from crashlytics " + e);
            }
            clicked(i, i2, i3, "".getBytes(StandardCharsets.UTF_8));
        } catch (LinkageError e2) {
            Log.w(TAG, "Exception during call clicked, uiID:" + i + ", buttonID: " + i2 + ", subID" + i3, e2);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void switchStatusChangedWrapper(final int viewBackendID, final int elementID, final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$switchStatusChangedWrapper$19(viewBackendID, elementID, state);
            }
        });
    }

    public /* synthetic */ void lambda$switchStatusChangedWrapper$19(int i, int i2, boolean z) {
        try {
            switchStatusChanged(i, i2, z);
        } catch (Exception e) {
            Log.w(TAG, "switchStatusChangedWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void viewShownStatusChangedWrapper(final int viewBackendID, final boolean shown) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$viewShownStatusChangedWrapper$20(viewBackendID, shown);
            }
        });
    }

    public /* synthetic */ void lambda$viewShownStatusChangedWrapper$20(int i, boolean z) {
        try {
            viewShownStatusChanged(i, z);
        } catch (LinkageError e) {
            Log.w(TAG, "viewShownStatusChangedWrapper: failed to call native method", e);
        }
    }

    public boolean hasPermission() {
        if (!this.soundChecker.isRecordAudioPermissionGranted()) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 1);
        }
        return this.soundChecker.isRecordAudioPermissionGranted();
    }

    public void clearPlayersList() {
        final LinkedList<Player> linkedList = this.playerLinkedList;
        Objects.requireNonNull(linkedList);
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                linkedList.clear();
            }
        });
    }

    public /* synthetic */ void lambda$addPlayerToList$21(int i, byte[] bArr, int i2, int i3, int i4) {
        this.playerLinkedList.add(new Player(i, new String(bArr), i2, i3, i4));
    }

    public void addPlayerToList(final int id, final byte[] name, final int level, final int ping, final int color) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addPlayerToList$21(id, name, level, ping, color);
            }
        });
    }

    public void submitPlayersList(final byte[] serverName) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$submitPlayersList$22(serverName);
            }
        });
    }

    public /* synthetic */ void lambda$submitPlayersList$22(byte[] bArr) {
        PlayerListDialog playerListDialog = (PlayerListDialog) this.uiElementStore.getForBackendMessage(UIElementID.PLAYER_LIST);
        if (playerListDialog == null) {
            return;
        }
        playerListDialog.submitPlayersList(this.playerLinkedList);
        setPlayerListDialogServerName(bArr);
    }

    public void setPlayerListDialogServerName(final byte[] serverName) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setPlayerListDialogServerName$23(serverName);
            }
        });
    }

    public /* synthetic */ void lambda$setPlayerListDialogServerName$23(byte[] bArr) {
        PlayerListDialog playerListDialog = (PlayerListDialog) this.uiElementStore.getForBackendMessage(UIElementID.PLAYER_LIST);
        if (playerListDialog == null) {
            return;
        }
        playerListDialog.setServerName(new String(bArr));
    }

    @Override // com.arizona.game.core.JNIActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    @Override // com.arizona.game.core.JNIActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        CrashReportingController crashReportingController = this.crashReportingController;
        if (crashReportingController != null) {
            crashReportingController.onResume();
        }
        this.uiElementStore.onHostResumed();
        if (this.isInit) {
            hideSystemUI();
            getWindow().getDecorView().post(new GTASA$$ExternalSyntheticLambda29(this));
        }
    }

    @Override // com.arizona.game.core.JNIActivity, android.app.Activity
    public void onPause() {
        CrashReportingController crashReportingController = this.crashReportingController;
        if (crashReportingController != null) {
            crashReportingController.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onStart() {
        if (UtilsKt.getZipFileIcons() == null) {
            com.arizona.launcher.util.UtilsKt.initZip(this);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        GameTestBackendHarnessController gameTestBackendHarnessController = this.gameTestBackendHarness;
        if (gameTestBackendHarnessController != null) {
            gameTestBackendHarnessController.stop();
        }
        super.onStop();
    }

    public void armDebugGameTestHarness() {
        GameTestBackendHarnessController gameTestBackendHarnessController = this.gameTestBackendHarness;
        if (gameTestBackendHarnessController != null) {
            gameTestBackendHarnessController.armIfEnabled();
        }
    }

    public SAMPUIElement getOrCreateUiElement(UIElementID uiElementID) {
        return this.uiElementStore.getOrCreateDefault(uiElementID);
    }

    void performBackendClickForGameTest(int backendId, int elementId, int subId, String message) {
        clickedWrapper(backendId, elementId, subId, message.getBytes(StandardCharsets.UTF_8));
    }

    void performChatForGameTest(String message) {
        t_OnInputEnd(message);
    }

    void dispatchFrontendMessageForGameTest(int frontendId, int subId, String message) {
        dispatchFrontendMessageInternal(frontendId, subId, message, false, false);
    }

    void closeAllForGameTest() {
        CloseAll();
    }

    public void notifySubscribe(final boolean subscribe, final byte[] topic) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$notifySubscribe$26(subscribe, topic);
            }
        });
    }

    public static /* synthetic */ void lambda$notifySubscribe$26(boolean z, byte[] bArr) {
        if (z) {
            FirebaseMessaging.getInstance().subscribeToTopic(new String(bArr)).addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda53
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Log.d("notifySubscribe", r1.isSuccessful() ? "successfully" : "not successful");
                }
            });
        } else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(new String(bArr)).addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda54
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Log.d("unsubscribeFromTopic", r1.isSuccessful() ? "successfully" : "not successful");
                }
            });
        }
    }

    public void sendAnalytics(final byte[] data, final int type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$sendAnalytics$27(data, type);
            }
        });
    }

    public /* synthetic */ void lambda$sendAnalytics$27(byte[] bArr, int i) {
        if (FlavorUtilKt.isDebug() || FlavorUtilKt.isStaging()) {
            Log.i("sendDataAnalyticsDebug", new String(bArr));
            Log.i("sendDataAnalyticsDebugType", String.valueOf(i));
            return;
        }
        MetricsFunsKt.sendDataAnalytics(this, new String(bArr), i);
    }

    public void updateLocation(final byte[] location) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$updateLocation$28(location);
            }
        });
    }

    public /* synthetic */ void lambda$updateLocation$28(byte[] bArr) {
        Hud hud;
        if (FlavorUtilKt.isArizona()) {
            try {
                hud = (Hud) this.uiElementStore.getForBackendMessage(UIElementID.HUD);
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "Location: cannot access uielement " + UIElementID.HUD, e);
            }
            if (hud == null) {
                return;
            }
            hud.setPlayerLocation(new String(bArr));
            Log.w("Location", new String(bArr));
        }
    }

    public void OnUpdateData(final int data, final int value) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnUpdateData$29(data, value);
            }
        });
    }

    public /* synthetic */ void lambda$OnUpdateData$29(int i, int i2) {
        SAMPUIElement forBackendMessage;
        SAMPUIElement forBackendMessage2;
        SAMPUIElement forBackendMessage3;
        if (this.uiElementStore.isHostActive()) {
            if (PlayerData.HEALTH.getId() == i) {
                Log.d("OnUpdateData", "Health was updated to " + i2);
                ConstantsKt.setHealthBar(i2);
                if (!this.uiElementStore.isElementExist(UIElementID.INVENTORY) || (forBackendMessage3 = this.uiElementStore.getForBackendMessage(UIElementID.INVENTORY)) == null) {
                    return;
                }
                forBackendMessage3.onBackendMessage("" + i2, 10);
            } else if (PlayerData.ARMOR.getId() == i) {
                Log.d("OnUpdateData", "Armour was updated to " + i2);
                ConstantsKt.setShieldBar(i2);
                if (!this.uiElementStore.isElementExist(UIElementID.INVENTORY) || (forBackendMessage2 = this.uiElementStore.getForBackendMessage(UIElementID.INVENTORY)) == null) {
                    return;
                }
                forBackendMessage2.onBackendMessage("" + i2, 11);
            } else if (PlayerData.SATIETY.getId() == i) {
                Log.d("OnUpdateData", "Satiety was updated to " + i2);
                ConstantsKt.setSatietyBar(i2);
                if (!this.uiElementStore.isElementExist(UIElementID.INVENTORY) || (forBackendMessage = this.uiElementStore.getForBackendMessage(UIElementID.INVENTORY)) == null) {
                    return;
                }
                forBackendMessage.onBackendMessage("" + i2, 12);
            } else if (FlavorUtilKt.isArizona()) {
            } else {
                Log.d("OnUpdateData", "Money was updated to " + i2);
                ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(i, i2);
            }
        }
    }

    public void SetInputLayout(final int type, final boolean is_chat) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SetInputLayout$30(type, is_chat);
            }
        });
    }

    public /* synthetic */ void lambda$SetInputLayout$30(int i, boolean z) {
        if (this.uiElementStore.isHostActive()) {
            syncKeyboardTypeFromSettings();
            if (i != 0) {
                if (!this.isKeyboardInstalled) {
                    if (this.isInGameKeyboard) {
                        enableTypeAndBindersInGameKeyboard();
                        setUIElementVisible(UIElementID.IN_GAME_KEYBOARD.getId(), true);
                    } else {
                        this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
                        CustomKeyboard customKeyboard = (CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())));
                        customKeyboard.setInputLayout(this.tagChatType, true, z, this.lastHeight);
                        String str = this.lastString;
                        if (str != null) {
                            customKeyboard.setString(str);
                        }
                    }
                    this.isKeyboardInstalled = true;
                    OnKeyboardShowedWrapper();
                    return;
                }
                CloseAll();
                return;
            }
            CloseAll();
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void showCustomKeyboardForEditText(CustomKeyboard.InputListener inputListener, String text) {
        if (this.uiElementStore.isHostActive()) {
            if (!this.isKeyboardInstalled) {
                this.isKeyboardInstalled = true;
                this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
                CustomKeyboard customKeyboard = (CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())));
                customKeyboard.setString(text);
                customKeyboard.setInputLayoutForEditText(inputListener);
                customKeyboard.showKeyboard();
                return;
            }
            CloseAll();
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void openMessengerByNewMessage(final int messageId) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$openMessengerByNewMessage$31(messageId);
            }
        });
    }

    public /* synthetic */ void lambda$openMessengerByNewMessage$31(int i) {
        SAMPUIElement forBackendMessage = this.uiElementStore.getForBackendMessage(UIElementID.ARIZONA_MOBILE_PHONE);
        if (forBackendMessage == null || forBackendMessage.isOnScreen()) {
            return;
        }
        forBackendMessage.setVisibility(true);
        forBackendMessage.onBackendMessage(String.valueOf(i), 50);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void removeKeyboardListener() {
        if (this.uiElementStore.isHostActive() && this.isKeyboardInstalled) {
            this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
            ((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).removeListener();
            CloseAll();
        }
    }

    public void InitGui() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InitGui$32();
            }
        });
    }

    public /* synthetic */ void lambda$InitGui$32() {
        InitSettingWrapper();
        this.isInit = true;
    }

    public void setBinderState(final int index_binder, final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setBinderState$33(index_binder, state);
            }
        });
    }

    public /* synthetic */ void lambda$setBinderState$33(int i, boolean z) {
        if (this.uiElementStore.isHostActive()) {
            this.inputStorage.setBinderState(i, z);
            if (this.isInGameKeyboard) {
                Keyboard keyboard = (Keyboard) this.uiElementStore.getForBackendMessage(UIElementID.IN_GAME_KEYBOARD);
                if (keyboard != null) {
                    keyboard.setBinderState(i, z);
                    return;
                }
                return;
            }
            ((CommandBinder) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.COMMAND_BINDER.getId())))).setBinderState(i, z);
        }
    }

    public void setBinderName(final int index_binder, final byte[] name) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setBinderName$34(index_binder, name);
            }
        });
    }

    public /* synthetic */ void lambda$setBinderName$34(int i, byte[] bArr) {
        if (this.uiElementStore.isHostActive()) {
            this.inputStorage.setBinderName(i, new String(bArr));
            if (this.isInGameKeyboard) {
                Keyboard keyboard = (Keyboard) this.uiElementStore.getForBackendMessage(UIElementID.IN_GAME_KEYBOARD);
                if (keyboard != null) {
                    keyboard.setBinderName(i, new String(bArr));
                    return;
                }
                return;
            }
            ((CommandBinder) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.COMMAND_BINDER.getId())))).setBinderName(i, new String(bArr));
        }
    }

    public void ShowMobileToolTip(final byte[] name, final int type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda76
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$ShowMobileToolTip$35(name, type);
            }
        });
    }

    public /* synthetic */ void lambda$ShowMobileToolTip$35(byte[] bArr, int i) {
        Toast.makeText(this, new String(bArr), i).show();
    }

    public void addKeyboardHistory(final byte[] str) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addKeyboardHistory$36(str);
            }
        });
    }

    public /* synthetic */ void lambda$addKeyboardHistory$36(byte[] bArr) {
        this.inputStorage.AddKeyboardHistory(new String(bArr));
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public void t_OnInputEnd(String str) {
        OnInputEndWrapper(str);
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public void closeKeyboard() {
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public void t_SetChatType(int type) {
        this.tagChatType = type;
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public void t_SetLastString(String str) {
        if (Objects.equals(str, "") || str == null) {
            this.lastString = null;
        } else {
            this.lastString = str;
        }
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public void t_SetChatHeight(int height) {
        this.lastHeight = height;
    }

    @Override // ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener
    public void b_setBinderLayout() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$b_setBinderLayout$37();
            }
        });
    }

    public /* synthetic */ void lambda$b_setBinderLayout$37() {
        if (this.uiElementStore.isHostActive() && this.isKeyboardInstalled) {
            SAMPUIElement sAMPUIElement = this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()));
            if (!this.isInGameKeyboard && (sAMPUIElement instanceof CustomKeyboard)) {
                ((CustomKeyboard) sAMPUIElement).showKeyboard();
            }
            OnKeyboardShowedWrapper();
        }
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener
    public void hudUpdateMoney(final long money) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$hudUpdateMoney$38(money);
            }
        });
    }

    public /* synthetic */ void lambda$hudUpdateMoney$38(long j) {
        if (this.uiElementStore.isHostActive()) {
            Log.d("OnUpdateData", "Money was updated to " + j);
            SAMPUIElement sAMPUIElement = this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId()));
            if (sAMPUIElement != null) {
                sAMPUIElement.onUpdateData(PlayerData.MONEY.getId(), j);
            }
        }
    }

    @Override // ru.mrlargha.commonui.elements.ArizonaSnackbar.SnackBarListener
    public void asDestroy() {
        if (this.arizonaSnackbar == null) {
            return;
        }
        Log.i(TAG, "snack-bar try to hide");
        this.arizonaSnackbar.destroy();
        this.arizonaSnackbar = null;
        this.snackbarJson = "";
        viewShownStatusChangedWrapper(UIElementID.SNACKBAR.getId(), false);
        Log.i(TAG, "snack-bar try to hided");
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public boolean t_BinderIsEmpty() {
        InputStorage inputStorage = this.inputStorage;
        if (inputStorage == null) {
            return true;
        }
        return inputStorage.isEmptyButtons();
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void setUIElementVisible(final int elementId, final boolean visibility) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setUIElementVisible$39(elementId, visibility);
            }
        });
    }

    public /* synthetic */ void lambda$setUIElementVisible$39(int i, boolean z) {
        SAMPUIElement existing;
        if (this.uiElementStore.isHostActive()) {
            UIElementID uIElementID = UIElementID.getUIElementID(i, FlavorUtilKt.getProjectType());
            if (this.isInGameKeyboard && uIElementID == UIElementID.COMMAND_BINDER) {
                return;
            }
            GameTestBackendHarnessController gameTestBackendHarnessController = this.gameTestBackendHarness;
            if (gameTestBackendHarnessController == null || !gameTestBackendHarnessController.shouldSuppressVisibilityChange(uIElementID, z)) {
                if (uIElementID.getId() == UIElementID.INVENTORY_VEHICLE_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_WAREHOUSE.getId() || uIElementID.getId() == UIElementID.INVENTORY_WALLET_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_SECURITY_SCREEN.getId()) {
                    UIElementStore uIElementStore = this.uiElementStore;
                    if (z) {
                        existing = uIElementStore.getForBackendMessage(UIElementID.INVENTORY);
                    } else {
                        existing = uIElementStore.getExisting(UIElementID.INVENTORY);
                    }
                    if (existing != null) {
                        existing.onBackendMessage("" + z, uIElementID.getId());
                    }
                }
                try {
                    FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putInt("setUIElementVisible_elementId", i).putBoolean("setUIElementVisible_visibility", z).build());
                } catch (IllegalStateException e) {
                    Log.w(TAG, "setUIElementVisible: we couldn't find instance from crashlytics " + e);
                }
                if (uIElementID.getId() == UIElementID.INVENTORY.getId() && !z) {
                    if (uIElementID.getId() != UIElementID.INVENTORY_SECURITY_SCREEN.getId()) {
                        setUIElementVisible(UIElementID.INVENTORY_SECURITY_SCREEN.getId(), false);
                    }
                    if (uIElementID.getId() != UIElementID.INVENTORY_WAREHOUSE.getId()) {
                        setUIElementVisible(UIElementID.INVENTORY_WAREHOUSE.getId(), false);
                    }
                    if (uIElementID.getId() != UIElementID.INVENTORY_VEHICLE_SCREEN.getId()) {
                        setUIElementVisible(UIElementID.INVENTORY_VEHICLE_SCREEN.getId(), false);
                    }
                    if (uIElementID.getId() != UIElementID.INVENTORY_WALLET_SCREEN.getId()) {
                        setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
                    }
                }
                if (i == UIElementID.SNACKBAR.getId()) {
                    if (z) {
                        if (this.arizonaSnackbar == null) {
                            Log.i(TAG, "snack-bar try to show");
                            this.arizonaSnackbar = new ArizonaSnackbar(this.snackbarJson, this, UIElementID.SNACKBAR.getId());
                            viewShownStatusChangedWrapper(UIElementID.SNACKBAR.getId(), true);
                            Log.i(TAG, "snack-bar try to showed");
                        }
                    } else {
                        asDestroy();
                    }
                    GameTestBackendHarnessController gameTestBackendHarnessController2 = this.gameTestBackendHarness;
                    if (gameTestBackendHarnessController2 != null) {
                        gameTestBackendHarnessController2.onVisibilityApplied(uIElementID, z);
                    }
                } else if (i == UIElementID.STREAM_VIDEO.getId()) {
                    StreamVideo streamVideo = this.streamVideo;
                    if (z) {
                        if (streamVideo == null) {
                            this.streamVideo = new StreamVideo(this, UIElementID.STREAM_VIDEO.getId());
                            viewShownStatusChangedWrapper(UIElementID.STREAM_VIDEO.getId(), true);
                        }
                    } else if (streamVideo != null) {
                        streamVideo.destroy();
                        this.streamVideo = null;
                        viewShownStatusChangedWrapper(UIElementID.STREAM_VIDEO.getId(), false);
                    }
                    GameTestBackendHarnessController gameTestBackendHarnessController3 = this.gameTestBackendHarness;
                    if (gameTestBackendHarnessController3 != null) {
                        gameTestBackendHarnessController3.onVisibilityApplied(uIElementID, z);
                    }
                } else if (uIElementID.getId() == UIElementID.INPUT_LAYOUT.getId() && this.isInGameKeyboard) {
                    this.uiElementStore.getOrCreateDefault(UIElementID.IN_GAME_KEYBOARD).setVisibility(z);
                } else {
                    if (this.uiElements.containsKey(Integer.valueOf(i))) {
                        ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(i)))).setVisibility(z);
                    } else if (uIElementID != UIElementID.DIALOG) {
                        try {
                            this.uiElementStore.setElementVisibility(uIElementID, z);
                        } catch (IllegalArgumentException e2) {
                            Log.w(TAG, "setUIElementVisible: cannot access element " + uIElementID, e2);
                        }
                    }
                    GameTestBackendHarnessController gameTestBackendHarnessController4 = this.gameTestBackendHarness;
                    if (gameTestBackendHarnessController4 != null) {
                        gameTestBackendHarnessController4.onVisibilityApplied(uIElementID, z);
                    }
                }
            }
        }
    }

    public void SwitchStreamerState(final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SwitchStreamerState$40(state);
            }
        });
    }

    public /* synthetic */ void lambda$SwitchStreamerState$40(boolean z) {
        Hud hud = (Hud) this.uiElementStore.getForBackendMessage(UIElementID.HUD);
        if (hud != null) {
            hud.switchStreamerState(z);
        }
    }

    public void SwitchKeyboardType(final boolean type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SwitchKeyboardType$41(type);
            }
        });
    }

    public /* synthetic */ void lambda$SwitchKeyboardType$41(boolean z) {
        this.isInGameKeyboard = z;
        KeyboardKeeper.INSTANCE.setInGameKeyboard(this.isInGameKeyboard);
        KeyboardKeeper.INSTANCE.setNotifier(new WeakReference<>(this));
    }

    public void InstallHud(final int playerId, final int serverId, final int serverType) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda66
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InstallHud$42(playerId, serverId, serverType);
            }
        });
    }

    public /* synthetic */ void lambda$InstallHud$42(int i, int i2, int i3) {
        Hud hud = (Hud) this.uiElementStore.getForBackendMessage(UIElementID.HUD);
        if (hud == null) {
            return;
        }
        hud.installHud(i, i2, i3);
    }

    public void updateHudLayout(final float left, final float bottom, final float width) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda71
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$updateHudLayout$43(left, bottom, width);
            }
        });
    }

    public /* synthetic */ void lambda$updateHudLayout$43(float f, float f2, float f3) {
        Hud hud = (Hud) this.uiElementStore.getExisting(UIElementID.HUD);
        if (hud != null) {
            hud.updateNativeHudLayout(f, f2, f3);
        }
    }

    private void syncKeyboardTypeFromSettings() {
        this.isInGameKeyboard = SettingsMenuDefaults.prefs(this).getInt(SettingsMenuDefaults.KEY_KEYBOARD_TYPE, 0) != 0;
        KeyboardKeeper.INSTANCE.setInGameKeyboard(this.isInGameKeyboard);
        KeyboardKeeper.INSTANCE.setNotifier(new WeakReference<>(this));
    }

    public void PlayVibration(long duration) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$PlayVibration$44();
            }
        });
    }

    public void InstallAuthorization() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InstallAuthorization$45();
            }
        });
    }

    public /* synthetic */ void lambda$InstallAuthorization$45() {
        SAMPUIElement forBackendMessage = this.uiElementStore.getForBackendMessage(UIElementID.AUTHORIZATION);
        if (forBackendMessage != null) {
            forBackendMessage.onBackendMessage(FlavorUtilKt.isArizona() ? BuildConfig.FLAVOR : "rodina", 9);
        }
    }

    public void UpdateOnline(final int currentOnline) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$UpdateOnline$46(currentOnline);
            }
        });
    }

    public /* synthetic */ void lambda$UpdateOnline$46(int i) {
        Hud hud = (Hud) this.uiElementStore.getForBackendMessage(UIElementID.HUD);
        if (hud == null) {
            return;
        }
        hud.updateOnline(i);
    }

    public void OnPlayerState(int currentState, int oldState) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$OnPlayerState$47();
            }
        });
    }

    public void UpdateMoney(final int money) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda60
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$UpdateMoney$48(money);
            }
        });
    }

    public /* synthetic */ void lambda$UpdateMoney$48(int i) {
        Hud hud;
        if (FlavorUtilKt.isArizona() || (hud = (Hud) this.uiElementStore.getForBackendMessage(UIElementID.HUD)) == null) {
            return;
        }
        hud.updateMoney(i);
    }

    public void SetAuthAwaitText(final String text) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda72
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SetAuthAwaitText$49(text);
            }
        });
    }

    public /* synthetic */ void lambda$SetAuthAwaitText$49(String str) {
        SAMPUIElement forPassiveBackendMessage = this.uiElementStore.getForPassiveBackendMessage(UIElementID.AUTHORIZATION);
        if (forPassiveBackendMessage != null) {
            forPassiveBackendMessage.onBackendMessage(str, RegistrationServerResponse.AUTH_AWAIT_TEXT.getId());
        }
    }

    public /* synthetic */ void lambda$setAutocompleteState$50(boolean z) {
        this.isAutocompleteEnabled = z;
    }

    public void setAutocompleteState(final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setAutocompleteState$50(state);
            }
        });
    }

    public int addSliderToAzVoiceSettings(final int minValue, final int maxValue, final int currentValue, final byte[] name) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addSliderToAzVoiceSettings$51(name, maxValue, minValue, currentValue);
            }
        });
        int i = this.voiceSettingPagination;
        this.voiceSettingPagination = i + 1;
        return i;
    }

    public /* synthetic */ void lambda$addSliderToAzVoiceSettings$51(byte[] bArr, int i, int i2, int i3) {
        AzVoiceSettings azVoiceSettings = (AzVoiceSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_SETTINGS);
        if (azVoiceSettings != null) {
            azVoiceSettings.addSlider(new SoundSliderData(new String(bArr), i, i2, i3, -1, -1));
        }
    }

    public void removeAllSlidersFormPlayersVoiceSettings() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeAllSlidersFormPlayersVoiceSettings$52();
            }
        });
    }

    public /* synthetic */ void lambda$removeAllSlidersFormPlayersVoiceSettings$52() {
        AzVoiceUserSettings azVoiceUserSettings = (AzVoiceUserSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_PLAYERS_SETTINGS);
        if (azVoiceUserSettings != null) {
            azVoiceUserSettings.clearSliders();
        }
    }

    public void addSliderToAzVoicePlayersSettings(final int minValue, final int maxValue, final int currentValue, final byte[] playerName, final int playerId) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addSliderToAzVoicePlayersSettings$53(playerName, maxValue, minValue, currentValue, playerId);
            }
        });
    }

    public /* synthetic */ void lambda$addSliderToAzVoicePlayersSettings$53(byte[] bArr, int i, int i2, int i3, int i4) {
        AzVoiceUserSettings azVoiceUserSettings = (AzVoiceUserSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_PLAYERS_SETTINGS);
        if (azVoiceUserSettings != null) {
            azVoiceUserSettings.addSlider(new SoundSliderData(new String(bArr), i, i2, i3, i4, -1));
        }
    }

    public void removeSliderFromAzVoicePlayerSettingsByPlayerId(final int id) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeSliderFromAzVoicePlayerSettingsByPlayerId$54(id);
            }
        });
    }

    public /* synthetic */ void lambda$removeSliderFromAzVoicePlayerSettingsByPlayerId$54(int i) {
        AzVoiceUserSettings azVoiceUserSettings = (AzVoiceUserSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_PLAYERS_SETTINGS);
        if (azVoiceUserSettings != null) {
            azVoiceUserSettings.removeSliderByPlayerId(i);
        }
    }

    public void removeSliderFromAzVoiceSettingsBySliderId(final int id) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeSliderFromAzVoiceSettingsBySliderId$55(id);
            }
        });
    }

    public /* synthetic */ void lambda$removeSliderFromAzVoiceSettingsBySliderId$55(int i) {
        AzVoiceSettings azVoiceSettings = (AzVoiceSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_SETTINGS);
        if (azVoiceSettings != null) {
            azVoiceSettings.removeSlider(i);
        }
    }

    public void setAzVoiceUserSliders(final byte[][] names, final int[] playerIDs, final int[] values, final int maxVal, final int minVal) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setAzVoiceUserSliders$56(names, playerIDs, values, maxVal, minVal);
            }
        });
    }

    public /* synthetic */ void lambda$setAzVoiceUserSliders$56(byte[][] bArr, int[] iArr, int[] iArr2, int i, int i2) {
        if (bArr.length != iArr.length || iArr.length != iArr2.length) {
            throw new IllegalArgumentException("Arrays must have same size");
        }
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < bArr.length; i3++) {
            linkedList.add(new SoundSliderData(new String(bArr[i3]), i, i2, iArr2[i3], iArr[i3], -1));
        }
        AzVoiceUserSettings azVoiceUserSettings = (AzVoiceUserSettings) this.uiElementStore.getForBackendMessage(UIElementID.VOICE_PLAYERS_SETTINGS);
        if (azVoiceUserSettings != null) {
            azVoiceUserSettings.setSliders(linkedList);
        }
    }

    public void showMessageFromNotification(final Integer notificationId) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$showMessageFromNotification$57(notificationId);
            }
        });
    }

    public /* synthetic */ void lambda$showMessageFromNotification$57(Integer num) {
        SAMPUIElement forBackendMessage = this.uiElementStore.getForBackendMessage(UIElementID.ARIZONA_MOBILE_PHONE);
        if (forBackendMessage != null) {
            forBackendMessage.onBackendMessage(num.toString(), 50);
        }
    }

    public void showPlayerDialog(final int sampDialogID, final int style, final byte[] caption, final byte[] infoText, final byte[] leftButton, final byte[] rightButton, final byte[] placeholder) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$showPlayerDialog$58(sampDialogID, style, caption, infoText, leftButton, rightButton, placeholder);
            }
        });
    }

    public /* synthetic */ void lambda$showPlayerDialog$58(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        if (this.uiElementStore.isHostActive()) {
            destroyDialog();
            this.uiElements.put(Integer.valueOf(UIElementID.DIALOG.getId()), DialogFactory.INSTANCE.createDialog(this, i, i2, new String(bArr), new String(bArr2), new String(bArr3), new String(bArr4), UIElementID.DIALOG.getId(), new String(bArr5), this));
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void removeMainScreen() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeMainScreen$59();
            }
        });
    }

    public /* synthetic */ void lambda$removeMainScreen$59() {
        if (this.uiElementStore.isHostActive()) {
            this.uiElementStore.removeElement(UIElementID.MAIN_BATTLE_PASS);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void onSaveLogToFile(String tag, String message) {
        Log.v(tag, message);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void disableTypeAndBindersInGameKeyboard(final boolean enableType, final String text) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$disableTypeAndBindersInGameKeyboard$60(enableType, text);
            }
        });
    }

    public /* synthetic */ void lambda$disableTypeAndBindersInGameKeyboard$60(boolean z, String str) {
        Keyboard keyboard = (Keyboard) this.uiElementStore.getForBackendMessage(UIElementID.IN_GAME_KEYBOARD);
        if (keyboard != null) {
            keyboard.disableTypeAndBinders(z, str);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void enableTypeAndBindersInGameKeyboard() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$enableTypeAndBindersInGameKeyboard$61();
            }
        });
    }

    public /* synthetic */ void lambda$enableTypeAndBindersInGameKeyboard$61() {
        Keyboard keyboard = (Keyboard) this.uiElementStore.getForBackendMessage(UIElementID.IN_GAME_KEYBOARD);
        if (keyboard != null) {
            keyboard.enableTypeAndBinders();
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void setKeyboardInputListener(final Keyboard.KeyboardInputListener listener) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setKeyboardInputListener$62(listener);
            }
        });
    }

    public /* synthetic */ void lambda$setKeyboardInputListener$62(Keyboard.KeyboardInputListener keyboardInputListener) {
        Keyboard keyboard = (Keyboard) this.uiElementStore.getForBackendMessage(UIElementID.IN_GAME_KEYBOARD);
        if (keyboard != null) {
            keyboard.setInputListener(keyboardInputListener);
        }
    }

    private boolean isWorkshopInventoryFlowActive() {
        SAMPUIElement existing = this.uiElementStore.getExisting(UIElementID.WORKSHOP);
        if (existing == null || !existing.isOnScreen()) {
            return false;
        }
        UIElementID inventoryCompanionPayloadTarget = this.uiElementStore.getInventoryCompanionPayloadTarget();
        return inventoryCompanionPayloadTarget == null || inventoryCompanionPayloadTarget == UIElementID.WORKSHOP;
    }

    private boolean isInventoryMessageType(int subID, String message, int inventoryType) {
        if (subID == 0 || subID == 2) {
            try {
                return new JSONObject(message).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, -1) == inventoryType;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    public void sendFrontendMessage(int frontendID, int subID, String message) {
        dispatchFrontendMessageInternal(frontendID, subID, message, true, true);
    }

    private void dispatchFrontendMessageInternal(final int frontendID, final int subID, final String message, final boolean allowDebugLoginStart, final boolean recordTrace) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$dispatchFrontendMessageInternal$63(frontendID, subID, message, allowDebugLoginStart, recordTrace);
            }
        });
    }

    public /* synthetic */ void lambda$dispatchFrontendMessageInternal$63(int i, int i2, String str, boolean z, boolean z2) {
        boolean deliverBackendMessage;
        GameTestBackendHarnessController gameTestBackendHarnessController;
        if (this.uiElementStore.isHostActive()) {
            UIElementID uIElementID = UIElementID.getUIElementID(i, FlavorUtilKt.getProjectType());
            Log.i(TAG, "sendFrontendMessage: name:" + uIElementID.name() + ", id:" + i + ", subID:" + i2 + "\nJSON: " + str);
            FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putInt("sendFrontendMessage_frontendID", i).putInt("sendFrontendMessage_subID", i2).putString("sendFrontendMessage_message", str).build());
            GameTestBackendHarnessController gameTestBackendHarnessController2 = this.gameTestBackendHarness;
            if (gameTestBackendHarnessController2 == null || !gameTestBackendHarnessController2.onLiveFrontendMessage(i, uIElementID, i2, str, z, z2)) {
                if (i == UIElementID.SNACKBAR.getId()) {
                    ArizonaSnackbar arizonaSnackbar = this.arizonaSnackbar;
                    if (arizonaSnackbar != null) {
                        arizonaSnackbar.onBackendMessage(str, i2);
                    } else {
                        this.snackbarJson = str;
                    }
                } else if (i == UIElementID.STREAM_VIDEO.getId()) {
                    StreamVideo streamVideo = this.streamVideo;
                    if (streamVideo != null) {
                        streamVideo.onBackendMessage(str, i2);
                    }
                } else if (uIElementID == UIElementID.INVENTORY && isWorkshopInventoryFlowActive() && (isInventoryMessageType(i2, str, 5) || isInventoryMessageType(i2, str, 28))) {
                    if (this.uiElementStore.deliverBackendMessage(UIElementID.WORKSHOP, str, UIElementID.INVENTORY.getId()) && (gameTestBackendHarnessController = this.gameTestBackendHarness) != null) {
                        gameTestBackendHarnessController.onFrontendMessageDelivered(UIElementID.WORKSHOP);
                    }
                } else {
                    try {
                        if (uIElementID == UIElementID.AUTHORIZATION && i2 == RegistrationServerResponse.AUTH_AWAIT_TEXT.getId()) {
                            deliverBackendMessage = this.uiElementStore.deliverPassiveBackendMessage(uIElementID, str, i2);
                        } else {
                            deliverBackendMessage = this.uiElementStore.deliverBackendMessage(uIElementID, str, i2);
                        }
                        if (deliverBackendMessage) {
                            GameTestBackendHarnessController gameTestBackendHarnessController3 = this.gameTestBackendHarness;
                            if (gameTestBackendHarnessController3 != null) {
                                gameTestBackendHarnessController3.onFrontendMessageDelivered(uIElementID);
                            }
                            if (uIElementID.getId() == UIElementID.INVENTORY_SECURITY_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_VEHICLE_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_WAREHOUSE.getId() || uIElementID.getId() == UIElementID.INVENTORY_WALLET_SCREEN.getId()) {
                                this.uiElementStore.deliverBackendMessage(UIElementID.INVENTORY, str, i2);
                            }
                            if (uIElementID.getId() == UIElementID.INVENTORY.getId() && i2 == 2) {
                                UIElementID inventoryCompanionPayloadTarget = this.uiElementStore.getInventoryCompanionPayloadTarget();
                                if (inventoryCompanionPayloadTarget == null && isWorkshopInventoryFlowActive()) {
                                    inventoryCompanionPayloadTarget = UIElementID.WORKSHOP;
                                }
                                if (inventoryCompanionPayloadTarget != null) {
                                    this.uiElementStore.deliverBackendMessage(inventoryCompanionPayloadTarget, str, UIElementID.INVENTORY.getId());
                                }
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        Log.w(TAG, "sendFrontendMessage: cannot access uielement " + uIElementID, e);
                    }
                }
            }
        }
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public int t_GetKeyboardHistorySize() {
        return this.inputStorage.GetKeyboardHistorySize();
    }

    @Override // ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener
    public boolean b_getBinderState(int index) {
        return this.inputStorage.getIndexState(index);
    }

    @Override // ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener
    public String b_getBinderName(int index) {
        return this.inputStorage.getBinderName(index);
    }

    @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
    public String t_GetKeyboardHistoryText(int index) {
        return this.inputStorage.GetKeyboardHistoryText(index);
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void setupScene() {
        Log.d("setCarModel", "setupScene: ");
        final Position positionModelCentered = ListenerKt.positionModelCentered(this, 1.0f);
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setupScene$64(positionModelCentered);
            }
        });
    }

    public /* synthetic */ void lambda$setupScene$64(Position position) {
        Cef3DSetupScene(position.getX(), position.getY(), position.getW(), position.getH(), 60, (byte) 0, (byte) 0, (byte) 0);
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void setCarModel(final int id, final boolean isSimple, final String bg, final int mainColor, final int secondColor, final String bgPath, final int wear, final boolean isCar) {
        this._isSimple = isSimple;
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setCarModel$65(id, isSimple, isCar, wear, mainColor, secondColor, bgPath, bg);
            }
        });
    }

    public /* synthetic */ void lambda$setCarModel$65(int i, boolean z, boolean z2, int i2, int i3, int i4, String str, String str2) {
        Cef3DRemoveModels();
        Cef3DAddModel(i, z);
        if (z2) {
            Cef3DSetVehicleWear(i, (byte) i2);
            Cef3DSetVehicleColors(i, (byte) i3, (byte) i4);
        }
        Cef3DSetDirty(i, z, (byte) 0);
        Cef3DSetBackground(str, str2, 0, 0, 512, 512);
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void closeScene() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.Cef3DRemoveModels();
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void rotateModel(final int id, final float x, final float y, final float z) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$rotateModel$66(id, x, y, z);
            }
        });
    }

    public /* synthetic */ void lambda$rotateModel$66(int i, float f, float f2, float f3) {
        Cef3DRotateModel(i, this._isSimple, f, f2, f3);
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void scaleModel(final int id, final float scale) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$scaleModel$67(id, scale);
            }
        });
    }

    public /* synthetic */ void lambda$scaleModel$67(int i, float f) {
        Cef3DScaleModel(i, this._isSimple, f);
    }

    @Override // ru.mrlargha.commonui.elements.items3d.ItemScene
    public void setCarModule(final int id, final int module, final boolean isSimple) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setCarModule$68(id, module, isSimple);
            }
        });
    }

    public /* synthetic */ void lambda$setCarModule$68(int i, int i2, boolean z) {
        Cef3DSetVehicleComponent(i, i2, z, false);
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener
    public void requestHudLayout() {
        RequestHudLayout();
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener
    public void hudSetTimer(final int seconds) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$hudSetTimer$69(seconds);
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener
    public void hudSetTimer2(final int seconds, final int maxTime, final int type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$hudSetTimer2$70(seconds, maxTime, type);
            }
        });
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudListener
    public void hudScale(final float scale) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$hudScale$71(scale);
            }
        });
    }

    public /* synthetic */ void lambda$hudScale$71(float f) {
        SetHudScale(f, f);
    }

    public void exitGame() {
        finish();
    }

    @Override // ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider
    public boolean getAutocompleteState() {
        return this.isAutocompleteEnabled;
    }

    private void CloseAll() {
        if (!this.uiElementStore.isHostActive()) {
            this.isKeyboardInstalled = false;
            return;
        }
        SAMPUIElement sAMPUIElement = this.uiElements.get(Integer.valueOf(UIElementID.DIALOG.getId()));
        if (sAMPUIElement instanceof AbstractDialog) {
            onDialogResponseWrapper(((AbstractDialog) sAMPUIElement).getSampDialogId(), 0, -1, new byte[0]);
            destroyDialog();
        } else if (sAMPUIElement != null) {
            destroyDialog();
        }
        if (this.isKeyboardInstalled) {
            if (!this.isInGameKeyboard) {
                ((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).setInputLayout(this.tagChatType, false, false, this.lastHeight);
                setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), false);
            }
            if (this.uiElements.containsKey(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())) && this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())) != null) {
                ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).removeFromLayout();
                this.uiElements.remove(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()));
            }
            setUIElementVisible(UIElementID.IN_GAME_KEYBOARD.getId(), false);
            setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), false);
            OnOnKeyboardClosedWrapper();
            this.isKeyboardInstalled = false;
        }
    }

    public void OpenSettings() {
        setUIElementVisible(UIElementID.SETTINGS.getId(), true);
    }

    @Override // com.arizona.game.core.GameSettingsProvider
    public String getGameSettingsJson() {
        return SettingsMenuDefaults.toJson(this);
    }

    public static String getSettingsJson(Activity activity) {
        return SettingsMenuDefaults.toJson(activity);
    }
}
