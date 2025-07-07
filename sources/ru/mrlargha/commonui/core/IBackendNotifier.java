package ru.mrlargha.commonui.core;

import androidx.autofill.HintConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import ru.mrlargha.commonui.elements.CustomKeyboard;
/* compiled from: IBackendNotifier.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH&J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0018H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\fH&J\b\u0010#\u001a\u00020\u0018H&J\b\u0010$\u001a\u00020\u0003H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H&J\b\u0010(\u001a\u00020\u0003H&J\u001a\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0005H&J\b\u0010/\u001a\u00020\u0003H&¨\u00060"}, d2 = {"Lru/mrlargha/commonui/core/IBackendNotifier;", "", "clickedWrapper", "", "viewBackendID", "", "elementID", "subID", "byte", "", "viewShownStatusChangedWrapper", "shown", "", "sliderValueChangedWrapper", "value", "switchStatusChangedWrapper", RemoteConfigConstants.ResponseFieldKey.STATE, "onDialogResponseWrapper", "dialogID", "responseButtonID", "listItemID", "inputText", "inputFinished", "input", "", "destinationElementID", "requestInput", HintConstants.AUTOFILL_HINT_PASSWORD, "bindText", "requestRemoveUIElement", "element", "Lru/mrlargha/commonui/core/SAMPUIElement;", "setUIElementVisible", "elementId", "visibility", "getPlayerNickname", "destroyDialog", "onSaveLogToFile", "tag", "message", "removeMainScreen", "showCustomKeyboardForEditText", "inputListener", "Lru/mrlargha/commonui/elements/CustomKeyboard$InputListener;", "text", "openMessengerByNewMessage", "messageId", "removeKeyboardListener", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IBackendNotifier {
    void clickedWrapper(int i, int i2, int i3);

    void clickedWrapper(int i, int i2, int i3, byte[] bArr);

    void destroyDialog();

    String getPlayerNickname();

    void inputFinished(String str, int i);

    void onDialogResponseWrapper(int i, int i2, int i3, byte[] bArr);

    void onSaveLogToFile(String str, String str2);

    void openMessengerByNewMessage(int i);

    void removeKeyboardListener();

    void removeMainScreen();

    void requestInput(int i, boolean z, String str);

    void requestRemoveUIElement(SAMPUIElement sAMPUIElement);

    void setUIElementVisible(int i, boolean z);

    void showCustomKeyboardForEditText(CustomKeyboard.InputListener inputListener, String str);

    void sliderValueChangedWrapper(int i, int i2, int i3);

    void switchStatusChangedWrapper(int i, int i2, boolean z);

    void viewShownStatusChangedWrapper(int i, boolean z);
}
