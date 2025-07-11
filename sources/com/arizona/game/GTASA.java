package com.arizona.game;

import android.app.GameManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.preference.PreferenceManager;
import com.arizona.launcher.data.repository.settings.NotifyChecker;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import com.arizona.launcher.data.repository.settings.SoundChecker;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.arizona.launcher.util.FlavorUtilKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementFactory;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.core.UIElementStore;
import ru.mrlargha.commonui.elements.ArizonaSnackbar;
import ru.mrlargha.commonui.elements.CommonElementsFactory;
import ru.mrlargha.commonui.elements.CustomKeyboard;
import ru.mrlargha.commonui.elements.EmptyScreen;
import ru.mrlargha.commonui.elements.InputPopup;
import ru.mrlargha.commonui.elements.InputStorage;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceSettings;
import ru.mrlargha.commonui.elements.azvoice.AzVoiceUserSettings;
import ru.mrlargha.commonui.elements.azvoice.SoundSliderData;
import ru.mrlargha.commonui.elements.binder.CommandBinder;
import ru.mrlargha.commonui.elements.dialogs.DialogFactory;
import ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider;
import ru.mrlargha.commonui.elements.dialogs.playerlist.Player;
import ru.mrlargha.commonui.elements.dialogs.playerlist.PlayerListDialog;
import ru.mrlargha.commonui.elements.hud.presentation.Hud;
import ru.mrlargha.commonui.elements.video.StreamVideo;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.UtilsKt;
/* loaded from: classes3.dex */
public class GTASA extends GTASAInternal implements CustomKeyboard.InputListener, CommandBinder.BinderListener, IBackendNotifier, IAutocompleteStateProvider, ArizonaSnackbar.SnackBarListener, Hud.HudListener {
    private static final String TAG = "GTASAMainClass";
    SharedPreferences settings;
    public SettingsRepository settingsRepository;
    private final UIElementStore uiElementStore;
    private InputPopup inputPopup = null;
    private InputStorage inputStorage = null;
    private boolean show_fps = false;
    private boolean full_screen = true;
    private boolean isKeyboadInstalled = false;
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
    @Deprecated
    private final ConcurrentHashMap<Integer, SAMPUIElement> uiElements = new ConcurrentHashMap<>();

    private native void InitSetting(boolean is_new_interface, int show_fps, boolean is_new_keyboard, boolean is_streamer, String version, int interfaces_count, String model, String notify_hash, String channels_state);

    private native void OnInputEnd(String str);

    private native void OnKeyboardClosed();

    private native void OnKeyboardShowed();

    private native void clicked(int viewBackendID, int elementID, int subID, byte[] payload);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$OnPlayerState$32() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$PlayVibration$29() {
    }

    private native void onDialogResponse(int dialogID, int responseButtonID, int listItemID, byte[] inputText);

    private native void sliderValueChanged(int viewBackendID, int elementID, int value);

    private native void switchStatusChanged(int viewBackendID, int elementID, boolean state);

    private native void viewShownStatusChanged(int viewBackendID, boolean shown);

    public void SetDonateJsonURL(String text) {
    }

    public native void initSAMP();

    public void removePLayerFromList(int id) {
    }

    public void updatePlayerInList(int id, byte[] name, int level, int ping, int color) {
    }

    public GTASA() {
        UIElementStore uIElementStore = new UIElementStore(this);
        this.uiElementStore = uIElementStore;
        uIElementStore.addFactory(new CommonElementsFactory());
        try {
            uIElementStore.addFactory((UIElementFactory) Class.forName("ru.mrlargha.arizonaui.ArizonaUIElementFactory").newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            Log.i(TAG, "Unable to create ArizonaUIElement factory, maybe this is Rodina build");
        }
        try {
            this.uiElementStore.addFactory((UIElementFactory) Class.forName("ru.mrlargha.rodina_ui.RodinaUIElementsFactory").newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused2) {
            Log.i(TAG, "Unable to create RodinaUIElementsFactory factory, maybe this is Arizona build");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        Log.w("MemoryTrim", "onTrimMemory called with level: " + level);
        if (level == 5) {
            Log.w("MemoryTrim", "Memory running moderate. Consider freeing non-critical resources.");
        } else if (level == 10) {
            Log.w("MemoryTrim", "Memory running low. Free non-essential resources.");
            lowMemoryEvent();
        } else if (level == 15) {
            Log.w("MemoryTrim", "Memory running critically low. Free as many resources as possible.");
            lowMemoryEvent();
        } else if (level == 20) {
            Log.w("MemoryTrim", "UI is now hidden. Freeing UI-related resources.");
        } else if (level == 40) {
            Log.w("MemoryTrim", "App in background. Release background resources if possible.");
        } else if (level == 60) {
            Log.w("MemoryTrim", "Moderate memory usage while backgrounded. Release some resources.");
        } else if (level == 80) {
            Log.w("MemoryTrim", "App not a priority. Release as many resources as possible.");
            lowMemoryEvent();
        } else {
            Log.w("MemoryTrim", "Unknown memory trim level: " + level);
        }
        super.onTrimMemory(level);
    }

    @Override // com.arizona.game.GTASAInternal, com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarGamepad, com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.w("PhoneInfo", "Manufacturer:" + Build.MANUFACTURER);
        Log.w("PhoneInfo", "Model:" + Build.MODEL);
        Log.w("PhoneInfo", "ABI:" + Build.CPU_ABI);
        Log.w("PhoneInfo", "Total Memory (RAM):" + Runtime.getRuntime().totalMemory());
        this.soundChecker = new SoundChecker(this);
        this.notifyChecker = new NotifyChecker(this);
        hideSystemUI();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda28
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                GTASA.this.lambda$onCreate$0(i);
            }
        });
        EmojiCompat.init(new BundledEmojiCompatConfig(this));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.settingsRepository = new SettingsRepository(defaultSharedPreferences);
        this.full_screen = defaultSharedPreferences.getBoolean(SettingsConstants.USE_FULLSCREEN, this.full_screen);
        FullScreenCall();
        this.show_fps = defaultSharedPreferences.getBoolean(SettingsConstants.SHOW_FPS, this.show_fps);
        initSAMPWrapper();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(int i) {
        if ((i & 2) != 0) {
            if (this.isKeyboadInstalled && !((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).getUniqueState()) {
                CloseAll();
            }
            hideSystemUI();
        }
        if ((i & 4) == 0) {
            hideSystemUI();
        }
    }

    public String GetReferrerString() {
        SharedPreferences sharedPreferences = getSharedPreferences("SP_NAME", 0);
        this.settings = sharedPreferences;
        return sharedPreferences.getString("referrerUrl", "");
    }

    private void hideSystemUIver2() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT > 29) {
            decorView.setSystemUiVisibility(6150);
        } else {
            decorView.setSystemUiVisibility(6662);
        }
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity
    public void hideSystemUI() {
        hideSystemUIver2();
        getWindow().getDecorView().setSystemUiVisibility(7942);
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
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$destroyDialog$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroyDialog$1() {
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
    public void requestRemoveUIElement(SAMPUIElement element) {
        this.uiElementStore.removeElement(element);
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

    private void OnInputEndWrapper(final String str) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnInputEndWrapper$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnInputEndWrapper$2(String str) {
        try {
            OnInputEnd(str);
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    private void InitSettingWrapper(int show_fps) {
        try {
            String channelsState = FirebaseConfigHelper.INSTANCE.getChannelsState();
            String str = Build.MANUFACTURER + StringUtils.PROCESS_POSTFIX_DELIMITER + Build.MODEL + StringUtils.PROCESS_POSTFIX_DELIMITER + getUniqueID() + StringUtils.PROCESS_POSTFIX_DELIMITER + (this.notifyChecker.isNotificationEnabled() ? "notify_on" : "notify_off");
            Log.i("InitSettingWrapper", "InitSetting called with the following arguments:\n1. Boolean flag 1: true\n2. show_fps: " + show_fps + "\n3. Boolean flag 2: true\n4. Streamer mode: " + PreferenceManager.getDefaultSharedPreferences(this).getBoolean(SettingsConstants.STREAMER_MODE, false) + "\n5. Version: (release_web) 2.1 - v16.4.0\n6. Last element ID: " + UIElementID.getLastUIElementID() + "\n7. Device name: " + str + "\n8. Token: " + getSettingsPreferences().getString("token", "") + "\n9. Channels state: " + channelsState);
            InitSetting(true, show_fps, true, PreferenceManager.getDefaultSharedPreferences(this).getBoolean(SettingsConstants.STREAMER_MODE, false), "(release_web) 2.1 - v16.4.0", UIElementID.getLastUIElementID(), str, getSettingsPreferences().getString("token", ""), channelsState);
            FirebaseCrashlytics.getInstance().setUserId(getUniqueID());
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public void initSAMPWrapper() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$initSAMPWrapper$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSAMPWrapper$3() {
        try {
            initSAMP();
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public void OnKeyboardShowedWrapper() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnKeyboardShowedWrapper$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnKeyboardShowedWrapper$4() {
        try {
            OnKeyboardShowed();
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    public void OnOnKeyboardClosedWrapper() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnOnKeyboardClosedWrapper$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnOnKeyboardClosedWrapper$5() {
        try {
            OnKeyboardClosed();
        } catch (LinkageError e) {
            Log.w(TAG, "Unable to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void sliderValueChangedWrapper(final int viewBackendID, final int elementID, final int value) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$sliderValueChangedWrapper$6(viewBackendID, elementID, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sliderValueChangedWrapper$6(int i, int i2, int i3) {
        try {
            sliderValueChanged(i, i2, i3);
        } catch (LinkageError e) {
            Log.w(TAG, "sliderValueChangedWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void onDialogResponseWrapper(final int dialogID, final int responseButtonID, final int listItemID, final byte[] inputText) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$onDialogResponseWrapper$7(dialogID, responseButtonID, listItemID, inputText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDialogResponseWrapper$7(int i, int i2, int i3, byte[] bArr) {
        try {
            onDialogResponse(i, i2, i3, bArr);
        } catch (LinkageError e) {
            Log.w(TAG, "onDialogResponseWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void clickedWrapper(final int viewBackendID, final int elementID, final int subID, final byte[] payload) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$clickedWrapper$8(payload, viewBackendID, elementID, subID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickedWrapper$8(byte[] bArr, int i, int i2, int i3) {
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
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$clickedWrapper$9(viewBackendID, elementID, subID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickedWrapper$9(int i, int i2, int i3) {
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
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$switchStatusChangedWrapper$10(viewBackendID, elementID, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchStatusChangedWrapper$10(int i, int i2, boolean z) {
        try {
            switchStatusChanged(i, i2, z);
        } catch (Exception e) {
            Log.w(TAG, "switchStatusChangedWrapper: failed to call native method", e);
        }
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void viewShownStatusChangedWrapper(final int viewBackendID, final boolean shown) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$viewShownStatusChangedWrapper$11(viewBackendID, shown);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$viewShownStatusChangedWrapper$11(int i, boolean z) {
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
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                linkedList.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPlayerToList$12(int i, byte[] bArr, int i2, int i3, int i4) {
        this.playerLinkedList.add(new Player(i, new String(bArr), i2, i3, i4));
    }

    public void addPlayerToList(final int id, final byte[] name, final int level, final int ping, final int color) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addPlayerToList$12(id, name, level, ping, color);
            }
        });
    }

    public void submitPlayersList(final byte[] serverName) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$submitPlayersList$13(serverName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitPlayersList$13(byte[] bArr) {
        ((PlayerListDialog) this.uiElementStore.getOrCreateDefault(UIElementID.PLAYER_LIST)).submitPlayersList(this.playerLinkedList);
        setPlayerListDialogServerName(bArr);
    }

    public void setPlayerListDialogServerName(final byte[] serverName) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setPlayerListDialogServerName$14(serverName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlayerListDialogServerName$14(byte[] bArr) {
        ((PlayerListDialog) this.uiElementStore.getOrCreateDefault(UIElementID.PLAYER_LIST)).setServerName(new String(bArr));
    }

    @Override // com.wardrumstudios.utils.WarMedia, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isInit) {
            hideSystemUI();
        }
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarBase, android.app.Activity
    public void onStart() {
        if (UtilsKt.getZipFileIcons() == null) {
            com.arizona.launcher.util.UtilsKt.initZip(this);
        }
        super.onStart();
    }

    @Override // com.wardrumstudios.utils.WarMedia, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void notifySubscribe(final boolean subscribe, final byte[] topic) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$notifySubscribe$17(subscribe, topic);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$notifySubscribe$17(boolean z, byte[] bArr) {
        if (z) {
            FirebaseMessaging.getInstance().subscribeToTopic(new String(bArr)).addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda5
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Log.d("notifySubscribe", r1.isSuccessful() ? "successfully" : "not successful");
                }
            });
        } else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(new String(bArr)).addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda6
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Log.d("unsubscribeFromTopic", r1.isSuccessful() ? "successfully" : "not successful");
                }
            });
        }
    }

    public void sendAnalytics(final byte[] data, final int type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$sendAnalytics$18(data, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAnalytics$18(byte[] bArr, int i) {
        UtilsKt.sendDataAnalytics(this, new String(bArr), i);
    }

    public void updateLocation(final byte[] location) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$updateLocation$19(location);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateLocation$19(byte[] bArr) {
        if (FlavorUtilKt.isArizona()) {
            try {
                ((Hud) this.uiElementStore.getOrCreateDefault(UIElementID.HUD)).setPlayerLocation(new String(bArr));
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "Location: cannot access uielement " + UIElementID.HUD, e);
            }
            Log.w(HttpHeaders.LOCATION, new String(bArr));
        }
    }

    public void OnUpdateData(final int data, final int value) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$OnUpdateData$20(data, value);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnUpdateData$20(int i, int i2) {
        if (PlayerData.HEALTH.getId() == i) {
            Log.d("OnUpdateData", "Health was updated to " + i2);
            ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(i, i2);
            this.uiElementStore.getOrCreateDefault(UIElementID.INVENTORY).onBackendMessage("" + i2, 10);
        } else if (PlayerData.ARMOR.getId() == i) {
            Log.d("OnUpdateData", "Armour was updated to " + i2);
            ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(i, i2);
            this.uiElementStore.getOrCreateDefault(UIElementID.INVENTORY).onBackendMessage("" + i2, 11);
        } else if (PlayerData.SATIETY.getId() == i) {
            Log.d("OnUpdateData", "Satiety was updated to " + i2);
            ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(i, i2);
            this.uiElementStore.getOrCreateDefault(UIElementID.INVENTORY).onBackendMessage("" + i2, 12);
        } else if (FlavorUtilKt.isArizona()) {
        } else {
            Log.d("OnUpdateData", "Money was updated to " + i2);
            ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(i, i2);
        }
    }

    public void SetInputLayout(final int type, final boolean is_chat) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SetInputLayout$21(type, is_chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SetInputLayout$21(int i, boolean z) {
        if (i != 0) {
            if (!this.isKeyboadInstalled) {
                this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
                CustomKeyboard customKeyboard = (CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())));
                customKeyboard.setInputLayout(this.tagChatType, true, z, this.lastHeight);
                String str = this.lastString;
                if (str != null) {
                    customKeyboard.setString(str);
                }
                this.isKeyboadInstalled = true;
                OnKeyboardShowedWrapper();
                return;
            }
            CloseAll();
            return;
        }
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void showCustomKeyboardForEditText(CustomKeyboard.InputListener inputListener, String text) {
        if (!this.isKeyboadInstalled) {
            this.isKeyboadInstalled = true;
            this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
            CustomKeyboard customKeyboard = (CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())));
            customKeyboard.setString(text);
            customKeyboard.setInputLayoutForEditText(inputListener);
            customKeyboard.showKeyboard();
            return;
        }
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void openMessengerByNewMessage(int messageId) {
        SAMPUIElement orCreateDefault = this.uiElementStore.getOrCreateDefault(UIElementID.ARIZONA_MOBILE_PHONE);
        if (orCreateDefault.isOnScreen()) {
            return;
        }
        orCreateDefault.setVisibility(true);
        orCreateDefault.onBackendMessage(String.valueOf(messageId), 50);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void removeKeyboardListener() {
        if (this.isKeyboadInstalled) {
            this.uiElements.put(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()), new CustomKeyboard(this, UIElementID.INPUT_LAYOUT.getId()));
            ((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).removeListener();
            CloseAll();
        }
    }

    public void InitGui() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InitGui$22();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InitGui$22() {
        InitSettingWrapper(this.show_fps ? 1 : 0);
        this.isInit = true;
    }

    public void setBinderState(final int index_binder, final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setBinderState$23(index_binder, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBinderState$23(int i, boolean z) {
        this.inputStorage.setBinderState(i, z);
        ((CommandBinder) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.COMMAND_BINDER.getId())))).setBinderState(i, z);
    }

    public void setBinderName(final int index_binder, final byte[] name) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setBinderName$24(index_binder, name);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBinderName$24(int i, byte[] bArr) {
        this.inputStorage.setBinderName(i, new String(bArr));
        ((CommandBinder) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.COMMAND_BINDER.getId())))).setBinderName(i, new String(bArr));
    }

    public void ShowMobileToolTip(final byte[] name, final int type) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$ShowMobileToolTip$25(name, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ShowMobileToolTip$25(byte[] bArr, int i) {
        Toast.makeText(this, new String(bArr), i).show();
    }

    public void addKeyboardHistory(final byte[] str) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addKeyboardHistory$26(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addKeyboardHistory$26(byte[] bArr) {
        this.inputStorage.AddKeyboardHistory(new String(bArr));
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public void t_OnInputEnd(String str) {
        OnInputEndWrapper(str);
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public void closeKeyboard() {
        CloseAll();
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public void t_SetChatType(int type) {
        this.tagChatType = type;
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public void t_SetLastString(String str) {
        if (Objects.equals(str, "") || str == null) {
            this.lastString = null;
        } else {
            this.lastString = str;
        }
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public void t_SetChatHeight(int height) {
        this.lastHeight = height;
    }

    @Override // ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener
    public void b_setBinderLayout() {
        if (this.isKeyboadInstalled) {
            ((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).showKeyboard();
            OnKeyboardShowedWrapper();
        }
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.Hud.HudListener
    public void hudUpdateMoney(long money) {
        Log.d("OnUpdateData", "Money was updated to " + money);
        ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INVENTORY.getId())))).onUpdateData(PlayerData.MONEY.getId(), money);
    }

    @Override // ru.mrlargha.commonui.elements.ArizonaSnackbar.SnackBarListener
    public void asDestroy() {
        if (this.arizonaSnackbar == null) {
            return;
        }
        Log.i(TAG, "snack-bar try to hide");
        this.arizonaSnackbar.setVisibility(false);
        this.arizonaSnackbar = null;
        this.snackbarJson = "";
        viewShownStatusChangedWrapper(UIElementID.SNACKBAR.getId(), false);
        Log.i(TAG, "snack-bar try to hided");
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public boolean t_BinderIsEmpty() {
        InputStorage inputStorage = this.inputStorage;
        if (inputStorage == null) {
            return true;
        }
        return inputStorage.isEmptyButtons();
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void setUIElementVisible(final int elementId, final boolean visibility) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setUIElementVisible$27(elementId, visibility);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUIElementVisible$27(int i, boolean z) {
        UIElementID uIElementID = UIElementID.getUIElementID(i, FlavorUtilKt.getProjectType());
        if (uIElementID.getId() == UIElementID.INVENTORY_VEHICLE_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_WAREHOUSE.getId() || uIElementID.getId() == UIElementID.INVENTORY_WALLET_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_SECURITY_SCREEN.getId()) {
            this.uiElementStore.getOrCreateDefault(UIElementID.INVENTORY).onBackendMessage("" + z, uIElementID.getId());
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
                    return;
                }
                return;
            }
            asDestroy();
        } else if (i != UIElementID.STREAM_VIDEO.getId()) {
            if (this.uiElements.containsKey(Integer.valueOf(i))) {
                ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(i)))).setVisibility(z);
            } else if (uIElementID != UIElementID.DIALOG) {
                try {
                    this.uiElementStore.getOrCreateDefault(uIElementID).setVisibility(z);
                } catch (IllegalArgumentException e2) {
                    Log.w(TAG, "setUIElementVisible: cannot access element " + uIElementID, e2);
                }
            }
        } else if (z) {
            if (this.streamVideo == null) {
                this.streamVideo = new StreamVideo(this, UIElementID.STREAM_VIDEO.getId());
                viewShownStatusChangedWrapper(UIElementID.STREAM_VIDEO.getId(), true);
            }
        } else {
            StreamVideo streamVideo = this.streamVideo;
            if (streamVideo != null) {
                streamVideo.destroy();
                this.streamVideo = null;
                viewShownStatusChangedWrapper(UIElementID.STREAM_VIDEO.getId(), false);
            }
        }
    }

    public void InstallHud(final int playerId, final int serverId, final int serverType, final int isStreamerMode) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InstallHud$28(playerId, serverId, serverType, isStreamerMode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InstallHud$28(int i, int i2, int i3, int i4) {
        ((Hud) this.uiElementStore.getOrCreateDefault(UIElementID.HUD)).installHud(i, i2, i3, i4);
    }

    public void PlayVibration(long duration) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$PlayVibration$29();
            }
        });
    }

    public void InstallAuthorization() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$InstallAuthorization$30();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InstallAuthorization$30() {
        this.uiElementStore.getOrCreateDefault(UIElementID.AUTHORIZATION).onBackendMessage(FlavorUtilKt.isArizona() ? BuildConfig.FLAVOR : "rodina", 9);
    }

    public void UpdateOnline(final int currentOnline) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$UpdateOnline$31(currentOnline);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$UpdateOnline$31(int i) {
        ((Hud) this.uiElementStore.getOrCreateDefault(UIElementID.HUD)).updateOnline(i);
    }

    public void OnPlayerState(int currentState, int oldState) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.lambda$OnPlayerState$32();
            }
        });
    }

    public void UpdateMoney(final int money) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$UpdateMoney$33(money);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$UpdateMoney$33(int i) {
        if (FlavorUtilKt.isArizona()) {
            return;
        }
        ((Hud) this.uiElementStore.getOrCreateDefault(UIElementID.HUD)).updateMoney(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SetAuthAwaitText$34(String str) {
        this.uiElementStore.getOrCreateDefault(UIElementID.AUTHORIZATION).onBackendMessage(str, 10);
    }

    public void SetAuthAwaitText(final String text) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$SetAuthAwaitText$34(text);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAutocompleteState$35(boolean z) {
        this.isAutocompleteEnabled = z;
    }

    public void setAutocompleteState(final boolean state) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setAutocompleteState$35(state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSliderToAzVoiceSettings$36(byte[] bArr, int i, int i2, int i3) {
        ((AzVoiceSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_SETTINGS)).addSlider(new SoundSliderData(new String(bArr), i, i2, i3, -1, -1));
    }

    public int addSliderToAzVoiceSettings(final int minValue, final int maxValue, final int currentValue, final byte[] name) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addSliderToAzVoiceSettings$36(name, maxValue, minValue, currentValue);
            }
        });
        int i = this.voiceSettingPagination;
        this.voiceSettingPagination = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllSlidersFormPlayersVoiceSettings$37() {
        ((AzVoiceUserSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_PLAYERS_SETTINGS)).clearSliders();
    }

    public void removeAllSlidersFormPlayersVoiceSettings() {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeAllSlidersFormPlayersVoiceSettings$37();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSliderToAzVoicePlayersSettings$38(byte[] bArr, int i, int i2, int i3, int i4) {
        ((AzVoiceUserSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_PLAYERS_SETTINGS)).addSlider(new SoundSliderData(new String(bArr), i, i2, i3, i4, -1));
    }

    public void addSliderToAzVoicePlayersSettings(final int minValue, final int maxValue, final int currentValue, final byte[] playerName, final int playerId) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$addSliderToAzVoicePlayersSettings$38(playerName, maxValue, minValue, currentValue, playerId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSliderFromAzVoicePlayerSettingsByPlayerId$39(int i) {
        ((AzVoiceUserSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_PLAYERS_SETTINGS)).removeSliderByPlayerId(i);
    }

    public void removeSliderFromAzVoicePlayerSettingsByPlayerId(final int id) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeSliderFromAzVoicePlayerSettingsByPlayerId$39(id);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSliderFromAzVoiceSettingsBySliderId$40(int i) {
        ((AzVoiceSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_SETTINGS)).removeSlider(i);
    }

    public void removeSliderFromAzVoiceSettingsBySliderId(final int id) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$removeSliderFromAzVoiceSettingsBySliderId$40(id);
            }
        });
    }

    public void setAzVoiceUserSliders(final byte[][] names, final int[] playerIDs, final int[] values, final int maxVal, final int minVal) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$setAzVoiceUserSliders$41(names, playerIDs, values, maxVal, minVal);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAzVoiceUserSliders$41(byte[][] bArr, int[] iArr, int[] iArr2, int i, int i2) {
        if (bArr.length != iArr.length || iArr.length != iArr2.length) {
            throw new IllegalArgumentException("Arrays must have same size");
        }
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < bArr.length; i3++) {
            linkedList.add(new SoundSliderData(new String(bArr[i3]), i, i2, iArr2[i3], iArr[i3], -1));
        }
        ((AzVoiceUserSettings) this.uiElementStore.getOrCreate(UIElementID.VOICE_PLAYERS_SETTINGS)).setSliders(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMessageFromNotification$42(Integer num) {
        this.uiElementStore.getOrCreateDefault(UIElementID.ARIZONA_MOBILE_PHONE).onBackendMessage(num.toString(), 50);
    }

    public void showMessageFromNotification(final Integer notificationId) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$showMessageFromNotification$42(notificationId);
            }
        });
    }

    public void showPlayerDialog(final int sampDialogID, final int style, final byte[] caption, final byte[] infoText, final byte[] leftButton, final byte[] rightButton) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$showPlayerDialog$43(sampDialogID, style, caption, infoText, leftButton, rightButton);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPlayerDialog$43(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        destroyDialog();
        this.uiElements.put(Integer.valueOf(UIElementID.DIALOG.getId()), DialogFactory.INSTANCE.createDialog(this, i, i2, new String(bArr), new String(bArr2), new String(bArr3), new String(bArr4), UIElementID.DIALOG.getId()));
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void removeMainScreen() {
        this.uiElementStore.removeElement(UIElementID.MAIN_BATTLE_PASS);
    }

    @Override // ru.mrlargha.commonui.core.IBackendNotifier
    public void onSaveLogToFile(String tag, String message) {
        Log.v(tag, message);
    }

    public void sendFrontendMessage(final int frontendID, final int subID, final String message) {
        runOnUiThread(new Runnable() { // from class: com.arizona.game.GTASA$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GTASA.this.lambda$sendFrontendMessage$44(frontendID, subID, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFrontendMessage$44(int i, int i2, String str) {
        UIElementID uIElementID = UIElementID.getUIElementID(i, FlavorUtilKt.getProjectType());
        Log.i(TAG, "sendFrontendMessage: name:" + uIElementID.name() + ", id:" + i + ", subID:" + i2 + "\nJSON: " + str);
        FirebaseCrashlytics.getInstance().setCustomKeys(new CustomKeysAndValues.Builder().putInt("sendFrontendMessage_frontendID", i).putInt("sendFrontendMessage_subID", i2).putString("sendFrontendMessage_message", str).build());
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
        } else {
            try {
                this.uiElementStore.getOrCreateDefault(uIElementID).onBackendMessage(str, i2);
                if (uIElementID.getId() == UIElementID.INVENTORY_SECURITY_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_VEHICLE_SCREEN.getId() || uIElementID.getId() == UIElementID.INVENTORY_WAREHOUSE.getId() || uIElementID.getId() == UIElementID.INVENTORY_WALLET_SCREEN.getId()) {
                    this.uiElementStore.getOrCreateDefault(UIElementID.INVENTORY).onBackendMessage(str, i2);
                }
                if (uIElementID.getId() == UIElementID.INVENTORY.getId() && i2 == 2 && this.uiElementStore.isElementExist(UIElementID.TRADE)) {
                    this.uiElementStore.getOrCreateDefault(UIElementID.TRADE).onBackendMessage(str, UIElementID.INVENTORY.getId());
                } else if (uIElementID.getId() == UIElementID.INVENTORY.getId() && i2 == 2 && this.uiElementStore.isElementExist(UIElementID.ARIZONA_GLOVO)) {
                    this.uiElementStore.getOrCreateDefault(UIElementID.ARIZONA_GLOVO).onBackendMessage(str, UIElementID.INVENTORY.getId());
                } else if (uIElementID.getId() == UIElementID.INVENTORY.getId() && i2 == 2 && this.uiElementStore.isElementExist(UIElementID.WORKSHOP)) {
                    this.uiElementStore.getOrCreateDefault(UIElementID.WORKSHOP).onBackendMessage(str, UIElementID.INVENTORY.getId());
                }
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "sendFrontendMessage: cannot access uielement " + uIElementID, e);
            }
        }
    }

    public void setChatPageSize(int pageSize) {
        getSettingsPreferences().edit().putInt(SettingsConstants.CHAT_PAGE_SIZE, pageSize).apply();
    }

    public void setChatFontSize(float fontSize) {
        getSettingsPreferences().edit().putFloat(SettingsConstants.CHAT_FONT_SIZE, fontSize).apply();
    }

    public void setChatPrintTimestamp(boolean needPrintTimestamp) {
        getSettingsPreferences().edit().putBoolean(SettingsConstants.CHAT_PRINT_TIMESTAMP, needPrintTimestamp).apply();
    }

    public void setStreamerMode(boolean streamerMode) {
        getSettingsPreferences().edit().putBoolean(SettingsConstants.STREAMER_MODE, streamerMode).apply();
    }

    public void setIsHeadMoving(boolean isHeadMoving) {
        getSettingsPreferences().edit().putBoolean(SettingsConstants.IS_HEAD_MOVING, isHeadMoving).apply();
    }

    private SharedPreferences getSettingsPreferences() {
        return getSharedPreferences("myAppPreference", 0);
    }

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
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

    @Override // ru.mrlargha.commonui.elements.CustomKeyboard.InputListener
    public String t_GetKeyboardHistoryText(int index) {
        return this.inputStorage.GetKeyboardHistoryText(index);
    }

    public void exitGame() {
        finish();
    }

    @Override // ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider
    public boolean getAutocompleteState() {
        return this.isAutocompleteEnabled;
    }

    private void CloseAll() {
        if (this.isKeyboadInstalled) {
            ((CustomKeyboard) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).setInputLayout(this.tagChatType, false, false, this.lastHeight);
            if (this.uiElements.containsKey(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())) && this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())) != null) {
                ((SAMPUIElement) Objects.requireNonNull(this.uiElements.get(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId())))).removeFromLayout();
                this.uiElements.remove(Integer.valueOf(UIElementID.INPUT_LAYOUT.getId()));
            }
            setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), false);
            OnOnKeyboardClosedWrapper();
            this.isKeyboadInstalled = false;
        }
    }
}
